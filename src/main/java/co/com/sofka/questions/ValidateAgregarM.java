package co.com.sofka.questions;

import co.com.sofka.model.RenponseAddpet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidateAgregarM implements Question<Boolean> {


    private final RenponseAddpet body;

    public static ValidateAgregarM verifyWith(RenponseAddpet body) {
        return new ValidateAgregarM(body);
    }

    public ValidateAgregarM(RenponseAddpet body) {
        this.body = body;

    }

    @Override
    public Boolean answeredBy(Actor actor) {
        RenponseAddpet data = SerenityRest.lastResponse().as(RenponseAddpet.class);
        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                Ensure.that(SerenityRest.lastResponse().as(RenponseAddpet.class).getId()).isNotNull(),
                Ensure.that(SerenityRest.lastResponse().as(RenponseAddpet.class).getName()).isEqualTo(body.getName())
        );
        System.out.println(SerenityRest.lastResponse().as(RenponseAddpet.class).getId());
        return true;
    }
}