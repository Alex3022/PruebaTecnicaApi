package co.com.sofka.questions;

import co.com.sofka.model.RenponseAddpet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class InformacionConsultarM implements Question<Boolean> {

    private final long id ;
    private final RenponseAddpet data;

    public static InformacionConsultarM verifyWith (long id, RenponseAddpet data ){return new InformacionConsultarM(id, data);}


    public InformacionConsultarM ( long id, RenponseAddpet data){
        this.id = id;
        this.data = data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(SerenityRest.lastResponse().as(RenponseAddpet.class).getId()).isEqualTo(id),
                Ensure.that(SerenityRest.lastResponse().as(RenponseAddpet.class).getName()).isEqualTo(data.getName()),
                Ensure.that(SerenityRest.lastResponse().as(RenponseAddpet.class).getStatus()).isEqualTo(data.getStatus())
        );
        System.out.println(SerenityRest.lastResponse().as(RenponseAddpet.class).getId());
        return true;
    }
}
