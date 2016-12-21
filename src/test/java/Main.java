import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        // Handler for multiple web apps
        HandlerCollection handlers = new HandlerCollection();

        // Creating the first web application context
        WebAppContext webapp = new WebAppContext();
        webapp.setResourceBase("src/main/webapp");
        //webapp.setContextPath("/webapp");
        webapp.setDefaultsDescriptor("src/main/webapp/WEB-INF/web.xml");
        handlers.addHandler(webapp);

        // Adding the handlers to the server
        server.setHandler(handlers);
        // Starting the Server
        server.start();
        System.out.println("Started!");
        server.join();
    }


}