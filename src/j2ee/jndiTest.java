package j2ee;

import javax.naming.CompositeName;
import javax.naming.InitialContext;
import javax.naming.InvalidNameException;
import javax.naming.Name;
import javax.naming.NamingException;
import java.util.Enumeration;

/**
 * Ref: https://www.baeldung.com/jndi
 */
public class jndiTest {
    public static void main(String[] args) throws NamingException {
        // Name interface.
        Name objectName = new CompositeName("java:comp/env/jdbc");
        Enumeration<String> elements = objectName.getAll();
        while(elements.hasMoreElements()) {
            // Java:comp
            // env
            // jdbc
            System.out.println(elements.nextElement());
        }

        // ObjectName itself is mutable.
        objectName.add("example");


        // Context interface
        InitialContext ctx = new InitialContext();


        // JNDI Object Binding
        ctx.bind("java:jdbc/prod/mysql", "testJDBCcredential");

        // Then later in your application to retrieve it with:
        // Cast always required, as all data stored in the form of Object.
        String ds = (String) ctx.lookup("java:jdbc/prod/mysql");

    }
}
