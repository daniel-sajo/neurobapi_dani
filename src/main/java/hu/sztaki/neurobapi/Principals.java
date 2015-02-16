package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import hu.sztaki.neurobapi.db.entities.Principal;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("principals")
public class Principals {
private final DbHandler dbHandler;

    public Principals() {
        this.dbHandler = new DbHandler();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    public String getPrinciplas() {
        Gson gson = new Gson();
        List<Principal> ret = this.dbHandler.getPrincipals();
        return gson.toJson(ret);
    }
    
}
