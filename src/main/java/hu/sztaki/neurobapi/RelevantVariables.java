package hu.sztaki.neurobapi;

import com.google.gson.Gson;
import hu.sztaki.neurobapi.db.DbHandler;
import hu.sztaki.neurobapi.db.entities.Allowedvalue;
import hu.sztaki.neurobapi.db.entities.Variable;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("relevant")
public class RelevantVariables {

    private final DbHandler dbHandler;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RelevantVariables() {
        this.dbHandler = new DbHandler();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    public String getDiff(@QueryParam("day") int day, @QueryParam("groupId") int gid) {
        logger.info("retrieving relevant variables for variable group:"+gid);
        Gson gson = new Gson();
        List<Variable> ret = this.dbHandler.getRelevantVariablesInGroup(day,gid);
        for (Variable v:ret) {
            logger.info("relevant variable id:"+v.getId()+" name:"+v.getName());
        }
        return gson.toJson(ret);
    }

    @Path("/allowedvalue")
    @GET
    @Produces(MediaType.APPLICATION_JSON+ ";charset=UTF-8")
    public String getAllowedValues(@QueryParam("id") int id) {
        logger.info("retrieving allowed values for variable:"+id);
        Gson gson = new Gson();
        List<Allowedvalue> ret = this.dbHandler.getAllowedvalues(id);
        for (Allowedvalue v:ret) {
            logger.info("relevant variable id:"+v.getId()+" value:"+v.getValue());
        }
        return gson.toJson(ret);
    }
    
}
