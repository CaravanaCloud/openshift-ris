package cloud.caravana.openshift.provider.rs;


import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.cache.NoCache;
import io.quarkus.security.identity.SecurityIdentity;

@Path("/user")
public class WhoAmIResource {

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("/whoami")
    @RolesAllowed("user")
    @NoCache
    public String getWhoAmI() {
        return securityIdentity
            .getPrincipal()
            .getName();
    }

}