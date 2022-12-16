package co.com.sofka.task;

import co.com.sofka.interactions.servicios.CallService;
import co.com.sofka.model.RenponseAddpet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class AgregarMascotas implements Task {
    private final String resource;
    private final RenponseAddpet body;
    private final Map<String, String> header;

    public AgregarMascotas(String resource, RenponseAddpet body, Map<String, String> header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    public static AgregarMascotas call(String resource, RenponseAddpet body, Map<String, String> header) {
        return new AgregarMascotas(resource, body, header);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPost(resource, body, header)
        );
    }
}
