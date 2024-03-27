package fr.univamu.fakeapisutilplatmenus;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

        Client client = ClientBuilder.newClient();

        // Set the URL to send the JSON data
        WebTarget target = client.target("http://localhost:8080/FakeAPIsUtilPlatMenus-1.0-SNAPSHOT/api/command/new");

        String jsonData = gson.toJson(rep);

        // Send the POST request with JSON data
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.json(jsonData));

        // Check the response status
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            client.close();
            return "JSON data sent successfully";
        } else {
            client.close();
            return "Failed to send JSON data. Response status: " + response.getStatus();
        }
    }
}
