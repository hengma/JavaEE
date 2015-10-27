package facades;

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

	@Remove
	public void checkOut() {
		System.out.println("Remove stateful bean intance from container!");
	}

	// Callbacks
	// ----------------------------------------------------------------
	@PostConstruct
	public void postConstructCallback() {
		System.out
				.println("===============PostConstruct is called! ===============");
	}

	@PreDestroy
	public void preDestroyCallback() {
		System.out
				.println("===============PreDestroy is called! ===============");
	}

	@PrePassivate
	public void prePassivateCallback() {
		System.out
				.println("===============PrePassivate is called! ===============");
	}

	@PostActivate
	public void postActivateCallback() {
		System.out
				.println("===============PostActivate is called! ===============");
	}

	@Init
	public void initCallback() {
		System.out.println("===============Init is called! ===============");
	}
}
