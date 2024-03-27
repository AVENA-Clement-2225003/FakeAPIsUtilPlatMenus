package fr.univamu.fakeapisutilplatmenus;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Path("/menu")
public class MenuResource {
    @GET
    @Path("{menuID}")
    @Produces("application/json")
    public String hello(@PathParam("menuID") String menuID) {
        Map<String, Object> rep = new HashMap<>();
        ArrayList<Integer> listeplats = new ArrayList<>();
        listeplats.add(1);
        listeplats.add(2);
        rep.put("clientID", Integer.parseInt(menuID));
        rep.put("menuName", "GPA2NON");
        rep.put("courseList", listeplats);
        rep.put("courseCreatorID",1);
        Gson gson = new Gson();
        return gson.toJson(rep);
    }
}
