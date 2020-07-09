package com.jaygibran;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessProbe implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    Client client = ClientBuilder.newClient();
    Response response = client.target("https://www.google.com/").request().get();

    if(response.getStatus() == 200){
      return HealthCheckResponse.up("estou pronto");
    }else{
      return HealthCheckResponse.down("nao estou pronto");
    }
  }

  
}