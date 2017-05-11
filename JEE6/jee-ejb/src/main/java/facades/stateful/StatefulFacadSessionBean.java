package facades.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(StatefulFacadSessionRemote.class)
public class StatefulFacadSessionBean implements StatefulFacadSessionRemote {

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

	/**
	 * When a passivated bean instance times out or when a client invokes the method marked with @Remove,
	 * the container may destroy the bean. Before destroying, the container will invoke the method annotated with @PreDestroy
	 *  
	 */
	@Remove
	public void checkOut() {
		System.out.println("Remove stateful bean intance from container!");
	}

	/**
	 * 
	 * Callbacks
	 *	----------------------------------------------------------------
	 *	PostConstruct - is invoked when the bean is first created, after any dependency injection is done.
	 * 
	 */
	@PostConstruct
	public void postConstructCallback() {
		System.out.println("==============================");
		System.out.println("          Stateful           ");
		System.out.println("==============================");
		System.out.println("===============PostConstruct is called! ===============");
	}

	/**
	 * PreDestroy is invoked when the bean is removed from the pool or destroyed.
	 */
	@PreDestroy
	public void preDestroyCallback() {
		System.out.println("===============PreDestroy is called! ===============");
	}

	
	/**
	 * 
	 * When the bean is idle for some period of time, the container may decide to 
	 * passivate the bean. Before passivation, the container will invoke the method marked with @PrePassivate
	 * 
	 */
	@PrePassivate
	public void prePassivateCallback() {
		System.out.println("===============PrePassivate is called! ===============");
	}

	/**
	 * When a client request access to the bean, the container may create a new bean or activate a passivated bean.
	 * When it activates the bean, the container will invoke the method marked with @PostActivate,
	 */
	@PostActivate
	public void postActivateCallback() {
		System.out.println("===============PostActivate is called! ===============");
	}

	@Init
	public void initCallback() {
		System.out.println("===============Init is called! ===============");
	}
}
