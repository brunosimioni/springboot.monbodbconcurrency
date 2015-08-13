package spartacus.mongodb.concurrent.repository;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class ConcurrentChildItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ConcurrentChildItem() {
	};

	public ConcurrentChildItem(long count) {
		this.id = "conc1_" + count;
		this.count = ""+count;
	};
	
	@Id
	private String id;

	private String count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}