package fr.univamu.fakeapisutilplatmenus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/menus")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Bonjour! Je suis Gabin FALFERI.";
    }
}