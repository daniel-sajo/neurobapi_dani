package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import hu.sztaki.neurobapi.db.entities.Patient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("patientInfo")
public class PatientInfo {

    private final DbHandler dbHandler;

    public PatientInfo() {
        this.dbHandler = new DbHandler();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getMeasurement(@QueryParam("patientId") int patientId) {
        Gson gson = new Gson();
        Patient ret = this.dbHandler.getPatient(patientId);
        return gson.toJson(ret);
    }
}
