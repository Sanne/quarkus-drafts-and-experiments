package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.lang.management.ManagementFactory;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/flags")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJvmFlags() {
        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        String joined = String.join(", ", inputArguments);
        System.out.println(joined);
        return joined;
    }

}
