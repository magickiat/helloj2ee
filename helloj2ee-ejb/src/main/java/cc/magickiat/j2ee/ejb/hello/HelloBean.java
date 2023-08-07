package cc.magickiat.j2ee.ejb.hello;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * XDoclet-based session bean. The class must be declared
 * public according to the EJB specification.
 *
 * To generate the EJB related files to this EJB:
 * - Add Standard EJB module to XDoclet project properties
 * - Customize XDoclet configuration for your appserver
 * - Run XDoclet
 *
 * Below are the xdoclet-related tags needed for this EJB.
 *
 * @ejb.bean name="Hello"
 *           description="Say hello to user"
 *           jndi-name="ejb/Hello"
 *           local-jndi-name="ejb/HelloLocal"
 *           type="Stateless"
 *           view-type="local"
 * 
 */
public class HelloBean implements SessionBean {

    /**
     * Say hello to user, if no name it will default to 'World'
     * 
     * @ejb.interface-method view-type="local"
     */
    public String sayHello(String name) {
        String who = name;
        if (who == null || who.trim().length() == 0) {
            who = "world";
        }

        return "Hello " + who;
    }

    /**
     * Not part of the SessionBean interface. This method exists because the
     * home interface defined a method called create( ).
     * 
     * @ejb.create-method view-type="local"
     */
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext arg0) {
    }
}
