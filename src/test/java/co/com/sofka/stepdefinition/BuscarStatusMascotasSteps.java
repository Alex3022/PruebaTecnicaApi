package co.com.sofka.stepdefinition;

import co.com.sofka.model.RenponseAddpet;
import co.com.sofka.questions.InformacionBuscarSM;
import co.com.sofka.questions.InformacionConsultarM;
import co.com.sofka.task.BuscarStatusMascotas;
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

public class BuscarStatusMascotasSteps {

   private String status;
   private RenponseAddpet data;
    @Dado("que quiero buscar una mascota por sus status")
    public void queQuieroBuscarUnaMascotaPorSusStatus() {
      status = DataManager.getStatus();
      data = DataManager.getDataPet();
      data.setStatus(status);
    }
    @Cuando("haga un llamado  a la api buscar")
    public void hagaUnLlamadoALaApiBuscar() {
     actor.attemptsTo(

             BuscarStatusMascotas.call(environmentVariables.getProperty("api.get"), status)
     );

    }
    @Entonces("recibio la lista de las mascotas por su status")
    public void recibioLaListaDeLasMascotasPorSuStatus() {
     actor.should(
             seeThat(
                     InformacionBuscarSM.verifyWith(data), is(true)
             )
     );

    }
}
