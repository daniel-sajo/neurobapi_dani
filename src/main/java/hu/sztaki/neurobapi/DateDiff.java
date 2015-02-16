package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("datediff")
public class DateDiff {

    private final DbHandler dbHandler;

    public DateDiff() {
        this.dbHandler = new DbHandler();
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @param measurementId
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDiff(@QueryParam("measurementId") int measurementId) {
        Gson gson = new Gson();
        int ret = this.dbHandler.dateDiff(measurementId);
        return gson.toJson(ret);
    }

    @GET
    @Path("/patient")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public String getDiffPatient(@QueryParam("patientId") int patientId) {
        Gson gson = new Gson();
        int ret = this.dbHandler.dateDiffPatient(patientId);
        return gson.toJson(ret);
    }

}
