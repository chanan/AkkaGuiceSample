package actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import com.google.inject.Inject;
import services.Service;

public class CapitalizeActor extends AbstractActor {
    private final Service service;

    @Inject
    public CapitalizeActor(Service service) {
        this.service = service;
        receive(
                ReceiveBuilder.match(String.class, s -> {
                    sender().tell(service.capitalize(s), self());
                }).build()
        );
    }
}