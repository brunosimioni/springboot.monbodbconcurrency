package spartacus.mongodb.concurrent.repository;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ConcurrentItem {

	public ConcurrentItem() {
	};

	@Id
	private String id;

	private long counter2;

	private List<Long> counters2;
	
	private List<ConcurrentChildItem> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ConcurrentChildItem> getChildren() {
		return children;
	}

	public void setChildren(List<ConcurrentChildItem> children) {
		this.children = children;
	}

	public long getCounter2() {
		return counter2;
	}

	public void setCounter2(long counter2) {
		this.counter2 = counter2;
	}

	public List<Long> getCounters2() {
		return counters2;
	}

	public void setCounters2(List<Long> counters2) {
		this.counters2 = counters2;
	}

}