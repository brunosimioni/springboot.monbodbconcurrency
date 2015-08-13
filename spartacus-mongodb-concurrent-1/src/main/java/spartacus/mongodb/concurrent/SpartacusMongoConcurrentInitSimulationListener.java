package spartacus.mongodb.concurrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import spartacus.mongodb.concurrent.repository.ConcurrentChildItem;
import spartacus.mongodb.concurrent.repository.ConcurrentItem;
import spartacus.mongodb.concurrent.repository.ConcurrentRepository;


@Configuration
public class SpartacusMongoConcurrentInitSimulationListener implements
		ApplicationListener<EmbeddedServletContainerInitializedEvent> {

	@Autowired
	private ConcurrentRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
		
		long total = 10000;
		
		for (long i = 0; i < total; i++) 
		{
			ConcurrentItem item = repository.findOne("1");

			mongoTemplate.findAndModify(
				new Query(Criteria.where("_id").is("1")), 
				Update.update("counter1", (item.getCounter1()+1)),
				ConcurrentItem.class
			);

			
			item.getCounters1().add(i);
			mongoTemplate.findAndModify(
				new Query(Criteria.where("_id").is("1")), 
				Update.update("counters1", item.getCounters1()),
				ConcurrentItem.class
			);

			
			Update childrenUpdate = new Update();
			childrenUpdate.push("children", new ConcurrentChildItem(i));
			
			mongoTemplate.findAndModify(
				new Query(Criteria.where("_id").is("1")),
				childrenUpdate,
				ConcurrentItem.class
			);
			
			if (i%10 == 0) {
				System.out.println((100 * i / total) + "%");
			}
		}
	}
}
