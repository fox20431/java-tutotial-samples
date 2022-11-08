import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.*;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import java.io.File;
import java.io.IOException;

/**
 * tomcat contains multiple servers;
 * server contains multiple services;
 *
 * engine is top level `container` in a Catalina hierarchy;
 * engine contains multiple hosts;
 * host contains multiple context;
 * context contains multiple wraps;
 */
public class TomcatEmbedApplication {
    public static void main(String[] args) throws LifecycleException, IOException {

        // create a server
        Server server = new StandardServer();
        /**
         * os.version              :  OS Version  
         * os.name                 :  OS Name
         * os.arch                 :  OS Architecture    
         * java.compiler           :  Name of the compiler you are using
         * java.ext.dirs           :  Extension directory path
         * java.library.path       :  Paths to search libraries whenever loading
         * path.separator          :  Path separator
         * file.separator          :  File separator
         * user.dir                :  Current working directory of User
         * user.name               :  Account name of User
         * java.vm.version         :  JVM implementation version
         * java.vm.name            :  JVM implementation name
         * java.home               :  Java installation directory
         * java.runtime.version    :  JVM version
         */
        File catalinaHome = new File(System.getProperty("user.dir") + "/catalina-home");
        if (!catalinaHome.exists()) {
            catalinaHome.mkdir();
        }
        server.setCatalinaHome(catalinaHome);

        // create a service
        Service service = new StandardService();

        // create a connector
        Connector connector = new Connector("HTTP/1.1");
        connector.setPort(8080);

        // create an engine
        Engine engine = new StandardEngine();
        // must set default host for engine
        engine.setDefaultHost("host-01");

        // create a host
        Host host = new StandardHost();
        host.setName("host-01");

        // create a context
        Context context = new StandardContext();
        context.setPath("");
        File docBase = new File(System.getProperty("user.dir") + "/doc-base");
        if (!docBase.exists()) {
            docBase.mkdir();
        }
        context.setDocBase(docBase.getAbsolutePath());
        context.addLifecycleListener(new Tomcat.FixContextListener());

        // create filter
        FilterDef filterDef = new FilterDef();
        filterDef.setFilterName(IndexFilter.class.getSimpleName());
        filterDef.setFilterClass(IndexFilter.class.getName());
        FilterMap filterMap = new FilterMap();
        filterMap.setFilterName(IndexFilter.class.getSimpleName());
        filterMap.addURLPattern("/servlet");
        context.addFilterDef(filterDef);
        context.addFilterMap(filterMap);

        // create servlet
        Wrapper wrapper = new Tomcat.ExistingStandardWrapper(new IndexServlet());
        wrapper.setName("servlet");
        context.addChild(wrapper);
        context.addServletMappingDecoded("/servlet", "servlet");

        // build up
        host.addChild(context);
        engine.addChild(host);
        service.setContainer(engine);
        service.addConnector(connector);
        server.addService(service);

        // start
        server.start();
        // await
        server.await();
    }
}
