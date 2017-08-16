package ch.simas.demo;

import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DemoClient {

    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "simon");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "simon");
        final Context context = new InitialContext(jndiProperties);

        NewSession newSession = (NewSession) context.lookup("demo-ear-0.0.1-SNAPSHOT/demo-ejb-0.0.1-SNAPSHOT/NewSessionBean!ch.simas.demo.NewSession");

        System.out.println("Caller Principal " + newSession.getPrincipalName());
    }

}
