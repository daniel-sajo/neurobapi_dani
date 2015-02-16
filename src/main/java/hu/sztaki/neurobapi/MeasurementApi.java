package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import hu.sztaki.neurobapi.db.entities.Measurement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("measurement")
public class MeasurementApi {

    private final DbHandler dbHandler;

    public MeasurementApi() {
        this.dbHandler = new DbHandler();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getMeasurement(@QueryParam("measurementId") int measurementId) {
        Gson gson = new Gson();
        Measurement ret = this.dbHandler.getMeasurement(measurementId);
        return gson.toJson(ret);
    }

    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String createMeasurement(@QueryParam("type") int type, @QueryParam("patient") int patient, @QueryParam("principal") int principal, @QueryParam("recordingUser") int recordingUser) {
        Gson gson = new Gson();
        int ret = this.dbHandler.createMeasurement(type, patient, principal, recordingUser);
        return gson.toJson(ret);
    }

}
