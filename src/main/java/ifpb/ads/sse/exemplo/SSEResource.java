package ifpb.ads.sse.exemplo;


import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 03/06/2016, 08:12:41
 */
@Path("events")
public class SSEResource {

    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() {
        final EventOutput eventOutput = new EventOutput();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        // ... code that waits 1 second
                        final OutboundEvent.Builder eventBuilder
                                = new OutboundEvent.Builder();
                        eventBuilder.name("message-to-client");
                        eventBuilder.data(String.class,
                                "Hello world " + i + "!");
                        final OutboundEvent event = eventBuilder.build();
                        eventOutput.write(event);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(
                            "Error when writing the event.", e);
                } finally {
                    try {
                        eventOutput.close();
                    } catch (IOException ioClose) {
                        throw new RuntimeException(
                                "Error when closing the event output.", ioClose);
                    }
                }
            }
        }).start();
        return eventOutput;
    }
}
