package ifpb.ads.sse.exemplo;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 03/06/2016, 08:18:03
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ifpb.ads.sse.exemplo.BroadcasterResource.class);
        resources.add(ifpb.ads.sse.exemplo.SSEResource.class);
    }

}
