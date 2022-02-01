package cloud.caravana.service;

import javax.ws.rs.GET;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import cloud.caravana.client.AuthClientHeader;

@RegisterRestClient(configKey = "whoami")
@RegisterClientHeaders(AuthClientHeader.class)
public interface WhoAmIService {
    
    @GET
    String whoami();
}
