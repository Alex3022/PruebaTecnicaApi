package co.com.sofka.interactions.servicios;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostWithHeader extends RestInteraction {
    private String resource;
    private Object body;
    private Map<String, Object> header;

    public PostWithHeader(String resource, Object body, Map<String, Object> header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .relaxedHTTPSValidation()
                .headers(header)
                .header("content-type", "application/json")
                .accept(ContentType.JSON)
                .body(body)
                .log()
                .all()
                .when()
                .post(as(actor).resolve(resource));
    }
}
