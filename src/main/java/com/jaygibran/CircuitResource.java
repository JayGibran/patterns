package com.jaygibran;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("/circuit")
public class CircuitResource {

  @Timeout(unit = ChronoUnit.MILLIS, value= 500)
  @Fallback(fallbackMethod = "fallback")
  @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 2000, successThreshold = 2)

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getCircuit() throws InterruptedException {
    Thread.sleep(600);
    return "Circuit \n";
  }

  private String fallback(){
    return "sou um fallback";
  }
  
}