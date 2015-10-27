package facades;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StudentFacadeSessionUtil {

	public static StudentFacadeSessionLocal getLocal() throws NamingException {
		StudentFacadeSessionLocal result = null;
		InitialContext ic = new InitialContext();
		try {
			ic = new InitialContext();
			result = (StudentFacadeSessionLocal) ic.lookup(StudentFacadeSessionLocal.JNDI_NAME);
		} finally {
			ic.close();
		}
		return result;
	}
	
	/*public static StudentFacadeSessionRemote getRemote(String initialContextFactory, String urlProvider) throws NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
		env.put(Context.PROVIDER_URL, urlProvider);
		//env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		//env.put("jboss.naming.client.ejb.context", true);
		//env.put("org.jboss.ejb.client.scoped.context", "true");
		InitialContext initialContext = new InitialContext(env);
		
		StudentFacadeSessionRemote result = null;
		try {
			result = (StudentFacadeSessionRemote) initialContext.lookup(StudentFacadeSessionRemote.JBOSS_JNDI_NAME);
		} finally {
			initialContext.close();
		}
		
		return result;
	}*/
}
