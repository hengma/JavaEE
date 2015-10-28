package facades.stateful;


public interface StatefulFacadSessionRemote {
	
	public abstract int count();
	public abstract int increment();
	public abstract int reset();
}
