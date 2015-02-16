package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import hu.sztaki.neurobapi.db.entities.Variable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("updatevar")
public class UpdateVars {
private final DbHandler dbHandler;

    public UpdateVars() {
        this.dbHandler = new DbHandler();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    public String updateVar(@QueryParam("measurementId") int measurementId, @QueryParam("variableId") int variableId,@QueryParam("value") String value) {
        
        Variable v = dbHandler.getVariable(variableId);
        if (v.getFreevalue().equals("Y")) {
            dbHandler.insertOrUpdateFree(measurementId,variableId,value);
        }
        else {
            dbHandler.insertOrUpdateAllowed(measurementId,variableId,Integer.parseInt(value));
        }
        Gson gson = new Gson();
        return gson.toJson("saved");
    }
    
    @Path("/textual")
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    public String updateText(@QueryParam("measurementId") int measurementId,@QueryParam("textualrepresentation") String text) {
        dbHandler.updateTextualRepresentation(measurementId,text);
        Gson gson = new Gson();
        return gson.toJson("saved");
    }
    
}
