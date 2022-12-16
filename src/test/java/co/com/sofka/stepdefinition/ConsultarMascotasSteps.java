package co.com.sofka.stepdefinition;

import co.com.sofka.model.RenponseAddpet;
import co.com.sofka.questions.InformacionConsultarM;
import co.com.sofka.task.ConsultarMascotas;
import co.com.sofka.utils.DataManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.sofka.stepdefinition.HooksAPI.actor;
import static co.com.sofka.stepdefinition.HooksAPI.environmentVariables;
import static co.com.sofka.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ConsultarMascotasSteps {

    private long id;
    private RenponseAddpet data;

    @Dado("que deseo consultar una mascota por id")
    public void queDeseoConsultarUnaMascotaPorId() {
        id = DataManager.getIdPet();
        data = DataManager.getDataPet();
    }
    @Cuando("haga un llamado a la apis")
    public void hagaUnLlamadoALaApis() {
        actor.attemptsTo(
                ConsultarMascotas.call(environmentVariables.getProperty("api.consulta_id"), id ,getHeader())
        );


    }
    @Entonces("recibo el id de la mascota con su informacion")
    public void reciboElIdDeLaMascotaConSuInformacion() {
        actor.should(
                seeThat(
                        InformacionConsultarM.verifyWith(id, data), is(true)
                )
        );

    }

}
