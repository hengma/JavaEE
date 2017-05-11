package facades.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Singleton;

@Singleton
@Local(SingletonFacadSessionLocal.class)
//@LocalBean use LocalBean if no interface local and remote
public class SingletonlFacadSessionBean implements SingletonFacadSessionLocal {
	private String mail = null;

	@PostConstruct
	public void init() {
		mail = "mao.heng2005@gmail.com";
	}

	@Override
	public String getMail() {
		return mail;
	}

   /** 
	* 	Callbacks
	*   ----------------------------------------------------------------
	* 	PostConstruct - is invoked when the bean is first created, after any dependency injection is done.
	*/
	@PostConstruct
	public void postConstructCallback() {
		System.out.println("==============================");
		System.out.println("          singleton           ");
		System.out.println("==============================");
		System.out.println("1===============PostConstruct is called! ===============");
	}

	/**
	 * PreDestroy is invoked when the bean is removed from the pool or destroyed.
	 */
	@PreDestroy
	public void preDestroyCallback() {
		System.out.println("2===============PreDestroy is called! ===============");
	}
}
