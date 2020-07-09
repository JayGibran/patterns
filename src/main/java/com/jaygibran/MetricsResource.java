package com.jaygibran;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/mymetrics")
public class MetricsResource {

  @Counted
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/timed")
  public String getCounted(){
    return "counted";
  }

  @Timed
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/counted")
  public String getTimed(){
    return "Timed";
  }
  
}