package simple_connector.connectors;

import simple_connector.security.SecurityChecker;
import simple_connector.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    SimpleConnector simpleConnector;
    SecurityChecker securityChecker = new SecurityCheckerImpl();

    @Override
    public void connect() {
        System.out.println("Performing security check...");
        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        } else {
            System.out.println("FAILED SECURITY CHECK, WON'T CONNECT!");
        }
    }

    public SecurityProxyConnector(String resourceString) {
        this.simpleConnector = new SimpleConnector(resourceString);
    }
}
