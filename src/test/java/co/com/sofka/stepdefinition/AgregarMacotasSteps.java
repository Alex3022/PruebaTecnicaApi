package co.com.sofka.stepdefinition;

import co.com.sofka.model.RenponseAddpet;
import co.com.sofka.questions.ValidateAgregarM;
import co.com.sofka.task.AgregarMascotas;
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

public class AgregarMacotasSteps {


    private RenponseAddpet body;
    private HashMap<String, String> headers;

    @Dado("que quiero agregar una mascota a la tienda")
    public void queQuieroAgregarUnaMascotaALaTienda() {
        body = DataManager.getDataPet();
        headers = (HashMap<String, String>) Constants.getHeader();
    }
    @Cuando("haga un llamado a la api")
    public void hagaUnLlamadoALaApi() {
        actor.attemptsTo(
                AgregarMascotas.call(environmentVariables.getProperty("api.post"),body,headers)
        );
    }


    @Entonces("recibo un status {int} y su id")
    public void reciboUnStatusYSuId(int arg0) {
        actor.should(
                seeThat(ValidateAgregarM.verifyWith(body), is(true))
        );
    }
}
