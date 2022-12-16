package co.com.sofka.task;

import co.com.sofka.interactions.servicios.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class ConsultarMascotas implements Task {

    private final String resource;
    private final long id;

    private  final Map<String,String> header;

    public ConsultarMascotas( String resource, long id, Map<String, String> header){
        this.resource = resource;
        this.id = id;
        this.header = header;
    }
    public static ConsultarMascotas call (String resource, long id, Map<String, String> header){
        return new ConsultarMascotas ( resource, id, header);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restGet(String.format(resource,id),header)
        );

    }
}
