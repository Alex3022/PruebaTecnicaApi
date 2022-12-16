package co.com.sofka.task;

import co.com.sofka.interactions.servicios.CallService;
import co.com.sofka.model.RenponseAddpet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class BuscarStatusMascotas implements Task {
    private final String resource;
    private final String status;


    public BuscarStatusMascotas(String resource, String status) {
        this.resource = resource;
        this.status = status;

    }

    public static BuscarStatusMascotas call(String resource, String status) {
        return new BuscarStatusMascotas(resource, status);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restGet(String.format(resource,status))
        );

    }
}
