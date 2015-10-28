package facades.singleton;

import javax.annotation.PostConstruct;
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

}
