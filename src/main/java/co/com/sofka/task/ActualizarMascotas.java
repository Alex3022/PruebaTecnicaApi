package co.com.sofka.task;

import co.com.sofka.interactions.servicios.CallService;
import co.com.sofka.model.RenponseAddpet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class ActualizarMascotas implements Task {

    private final String resource;
    private final RenponseAddpet body;


    public ActualizarMascotas(String resource, RenponseAddpet body) {
        this.resource = resource;
        this.body = body;
    }

    public static ActualizarMascotas call(String resource, RenponseAddpet body) {
        return new ActualizarMascotas(resource, body);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPut(resource, body)
        );

    }
}
