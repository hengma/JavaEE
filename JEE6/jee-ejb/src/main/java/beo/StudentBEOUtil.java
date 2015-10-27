package beo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StudentBEOUtil {
    public static StudentBEOLocal getLocal() throws NamingException {
        StudentBEOLocal result = null;
        InitialContext ic = new InitialContext();
        try {
            ic = new InitialContext();
            //java:global/<applicationName>/<ejbModuleName>/beanName!interfaceClass.getName()
            result =  (StudentBEOLocal) ic.lookup("java:global/jee/jee-ejb/StudentBEOBean!StudentBEOLocal");
        } finally {
            ic.close();
        }
        return result;
    }
}