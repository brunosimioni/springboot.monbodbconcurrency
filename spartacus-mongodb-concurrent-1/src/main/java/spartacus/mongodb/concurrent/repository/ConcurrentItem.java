package spartacus.mongodb.concurrent.repository;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ConcurrentItem {

	public ConcurrentItem() {
	};

	@Id
	private String id;

	private long counter1;

	private List<Long> counters1;
	
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

	public long getCounter1() {
		return counter1;
	}

	public void setCounter1(long counter1) {
		this.counter1 = counter1;
	}

	public List<Long> getCounters1() {
		return counters1;
	}

	public void setCounters1(List<Long> counters1) {
		this.counters1 = counters1;
	}
}