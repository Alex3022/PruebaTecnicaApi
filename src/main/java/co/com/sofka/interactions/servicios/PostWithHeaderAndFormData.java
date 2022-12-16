package co.com.sofka.interactions.servicios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostWithHeaderAndFormData extends RestInteraction {
    private String resource;
    private Map<String, Object> header;
    private List<String> formdata;

    public PostWithHeaderAndFormData(String resource, List<String> formdata, Map<String, Object> header) {
        this.resource = resource;
        this.formdata = formdata;
        this.header = header;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType("multipart/form-data")
                .relaxedHTTPSValidation()
                .headers(header)
                .formParam("client_id", formdata.get(0))
                .formParam("scope", formdata.get(1))
                .formParam("grant_type", "refresh_token")
                .formParam("client_info", "1")
                .formParam("client-request-id", formdata.get(2))
                .formParam("refresh_token", formdata.get(3))
                .when()
                .post(as(actor).resolve(resource));
    }
}
