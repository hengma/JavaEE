package ejb3;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import beo.StudentVO;
import facades.StatefulFacadSessionRemote;
import facades.StatelessFacadSessionBean;
import facades.StatelessFacadSessionRemote;
import facades.StudentFacadeSessionRemote;

public class JunitTest {

	@Test
	public void testJavaEE6() {
		Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        env.put("jboss.naming.client.ejb.context", true);
        env.put("org.jboss.ejb.client.scoped.context", "true");
        
        try {
			InitialContext context = new InitialContext(env);
			
			StudentFacadeSessionRemote result = (StudentFacadeSessionRemote) context.lookup("/jee/jee-ejb/StudentFacadeSessionBean!facades.StudentFacadeSessionRemote");
			
			if(result != null) {
				StudentVO studentVO= result.findById("1");
				System.out.println("===================");
				System.out.println("      Student:    ");
				System.out.println("===================");
				System.out.println("Id: " + studentVO.getId());
				System.out.println("Name: " + studentVO.getName());
				System.out.println("Gender: " + studentVO.getGender());
			}
			
			System.out.println("===================");
			System.out.println("      Stateless:    ");
			System.out.println("===================");
			StatelessFacadSessionRemote statelessRemote = (StatelessFacadSessionRemote) context.lookup("/jee/jee-ejb/StatelessFacadSessionBean!facades.StatelessFacadSessionRemote");
			statelessRemote.increment();
			statelessRemote.increment();
			System.out.println(statelessRemote.count());
			
			System.out.println("===================");
			System.out.println("      Stateful:    ");
			System.out.println("===================");
			StatefulFacadSessionRemote statefulRemote = (StatefulFacadSessionRemote) context.lookup("/jee/jee-ejb/StatefulFacadSessionBean!facades.StatefulFacadSessionRemote");
			statefulRemote.increment();
			statefulRemote.increment();
			System.out.println(statefulRemote.count());
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
        
	}

}
