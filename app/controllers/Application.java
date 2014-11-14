package controllers;

import akka.actor.ActorRef;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

import static akka.pattern.Patterns.ask;
import static play.libs.F.Promise.wrap;

public class Application extends Controller {
    private final ActorRef actor;

    @Inject
    public Application(@Named("CapitalizeActor") ActorRef actor) {
        this.actor = actor;
    }

    public F.Promise<Result> index() {
        return wrap(ask(actor, "Make me upper case", 10000)).map(obj -> ok(obj.toString()));
    }
}