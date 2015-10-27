package util;

public class JEENamingUtil {

    private static final String APPLICATION_NAME="jee";
    private static final String EJB_MODULE_NAME="jee-ejb";

    public static JEENamingUtil getInstance() {
        return new JEENamingUtil();
    }

    public String getApplicationName() {
        return APPLICATION_NAME;
    }

    public String getEjbModuleName() {
        return EJB_MODULE_NAME;
    }

    /**
     * generates a global jndi name for Local ejb calls. java:global/<applicationName>/<ejbModuleName>/beanName!interfaceClass.getName()
     * @param beanName Name of the ejb bean
     * @param interfaceClass Local interface class
     * @return jndi name
     */
     public String getLocalJndiName(String beanName, Class<?> interfaceClass){
         String JndiPrefix = "java:global/";
         return JndiPrefix + getApplicationName() + "/" + getEjbModuleName()
                 + "/" + beanName + "!" + interfaceClass.getName() ;
      }
     
     
     /**
      * generates a global jndi name for Remote ejb calls. java:global/<applicationName>/<ejbModuleName>/beanName!interfaceClass.getName()
      * @param beanName Name of the ejb bean
      * @param interfaceClass Remote interface class
      * @return jndi name
      */
     public String getRemoteJndiName(String beanName, Class<?> interfaceClass){
         String JndiPrefix = "java:global/";
          return JndiPrefix + getApplicationName() + "/" + getEjbModuleName()
                  + "/" + beanName + "!" + interfaceClass.getName() ;
      }
     
     /**
      * Generates a jboss global jndi name for Remote ejb calls. <applicationName>/<ejbModuleName>/beanName!interfaceClass.getName()
      * The JBOSS remote naming does not respect the EJB 3 remote naming.
      * We remove the prefix java:global/ for JBOSS EAP 6 Remote call.
      * @param beanName Name of the ejb bean
      * @param interfaceClass Remote interface class
      * @return jndi name
      */
     public String getJbossRemoteJndiName(String beanName, Class<?> interfaceClass){
          return "/" + getApplicationName() + "/" + getEjbModuleName()
                  + "/" + beanName + "!" + interfaceClass.getName() ;
      }
     
}
