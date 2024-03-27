package fr.univamu.fakeapisutilplatmenus;

import com.google.gson.Gson;
import jakarta.json.JsonArray;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
public class UserRessource {
    @GET
    @Path("{userID}")
    @Produces("application/json")
    public String hello(@PathParam("userID") String userID) {
        Map<String, Object> rep = new HashMap<>();
        ArrayList<Integer> listeplats = new ArrayList<>();
        listeplats.add(1);
        listeplats.add(2);
        rep.put("userID", Integer.parseInt(userID));
        rep.put("userName","Henry");
        Gson gson = new Gson();
        return gson.toJson(rep);
    }
}
