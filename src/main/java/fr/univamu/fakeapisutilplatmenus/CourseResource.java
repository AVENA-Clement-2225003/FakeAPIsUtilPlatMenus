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

@Path("/course")
public class CourseResource {
    @GET
    @Path("{courseID}")
    @Produces("application/json")
    public String hello(@PathParam("courseID") String courseID) {
        Map<String, Object> rep = new HashMap<>();
        rep.put("courseID", Integer.parseInt(courseID));
        rep.put("courseName", "GPA2NON");
        rep.put("coursePrice", 29.99);
        rep.put("courseDescription", "JEAN N'EST PAS");
        Gson gson = new Gson();
        return gson.toJson(rep);
    }
    @GET
    @Path("/createFakeCommand")
    @Produces("application/json")
    public String createFakeCommand() {
        Map<String, Object> rep = new HashMap<>();
        rep.put("test", "test");
        Gson gson = new Gson();
        return gson.toJson(rep);
    }
}
