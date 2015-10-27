package bpo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StudentBPOUtil {

	public static StudentBPOLocal getLocal() throws NamingException {
		StudentBPOLocal result = null;
		InitialContext ic = new InitialContext();
		try {
			ic = new InitialContext();
			result = (StudentBPOLocal) ic.lookup(StudentBPOLocal.JNDI_NAME);
		} finally {
			ic.close();
		}
		return result;
	}
	
}
