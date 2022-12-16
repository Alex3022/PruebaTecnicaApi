package co.com.sofka.questions;


import co.com.sofka.model.RenponseAddpet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class InformacionBuscarSM implements Question<Boolean> {

    private final RenponseAddpet data;

    public static InformacionBuscarSM  verifyWith (RenponseAddpet data ){return new InformacionBuscarSM( data);}


    public InformacionBuscarSM ( RenponseAddpet data){
        this.data = data;
    }

    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {
        RenponseAddpet res = null;
        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<RenponseAddpet> myObjects = mapper.readValue(response, new TypeReference<List<RenponseAddpet>>(){});
        for (RenponseAddpet respuesta: myObjects) {
            if (respuesta.getId().equals(data.getId())){
                res=respuesta;
            }
        }
        actor.attemptsTo(
                Ensure.that(res.getId()).isNotNull()
        );

        return true;
    }
}
