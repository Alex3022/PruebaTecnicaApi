package co.com.sofka.stepdefinition;

import co.com.sofka.model.RenponseAddpet;
import co.com.sofka.questions.InformacionConsultarM;
import co.com.sofka.questions.ValidateAgregarM;
import co.com.sofka.task.ActualizarMascotas;
import co.com.sofka.utils.Constants;
import co.com.sofka.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.HashMap;

import static co.com.sofka.stepdefinition.HooksAPI.actor;
import static co.com.sofka.stepdefinition.HooksAPI.environmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ActualizarMascotasSteps {


    private RenponseAddpet body;

    @Dado("que quiero actualizar la informaion de la mascoota")
    public void queQuieroActualizarLaInformaionDeLaMascoota() {
        body = DataManager.getDataPet();
    }
    @Cuando("haga un llamado a la api de actualizar")
    public void hagaUnLlamadoALaApiDeActualizar() {
       actor.attemptsTo(
               ActualizarMascotas.call(environmentVariables.getProperty("api.post"),body)
       );
    }
    @Entonces("recibo la informacion actualizada")
    public void reciboLaInformacionActualizada() {
        actor.should(
                seeThat(InformacionConsultarM.verifyWith(body.getId(), body), is(true))
        );
    }
}
