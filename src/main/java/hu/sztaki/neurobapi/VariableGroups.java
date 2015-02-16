package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import hu.sztaki.neurobapi.db.entities.Variablegroup;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("variableGroups")
public class VariableGroups {
private final DbHandler dbHandler;

    public VariableGroups() {
        this.dbHandler = new DbHandler();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    public String getGroups() {
        Gson gson = new Gson();
        List<Variablegroup> ret = this.dbHandler.getVariableGroups();
        return gson.toJson(ret);
    }
    
}
