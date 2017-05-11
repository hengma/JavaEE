package facades.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless																																												
@Remote(StatelessFacadSessionRemote.class)
public class StatelessFacadSessionBean implements StatelessFacadSessionRemote {

	private int count = 0;

	@Override
	public int count() {
		return count;
	}

	@Override
	public int increment() {
		return ++count;
	}

	@Override
	public int reset() {
		return (count = 0);
	}

	// Callbacks
	// ----------------------------------------------------------------
	//PostConstruct - is invoked when the bean is first created, after any dependency injection is done.
	@PostConstruct
	public void postConstructCallback() {
		System.out.println("==============================");
		System.out.println("          Stateless           ");
		System.out.println("==============================");
		System.out.println("1===============PostConstruct is called! ===============");
	}

	//is invoked when the bean is removed from the pool or destroyed.
	@PreDestroy
	public void preDestroyCallback() {
		System.out.println("2===============PreDestroy is called! ===============");
	}

}
