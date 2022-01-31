package cloud.caravana.auth;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.oidc.IdToken;
import io.quarkus.oidc.RefreshToken;

@Dependent
public class KeycloakSession 
    implements UserSession {
    @Inject
    @IdToken
    JsonWebToken idToken;

    @Inject
    JsonWebToken accessToken;

    @Inject
    RefreshToken refreshToken;

    public String getUserInfo() {
        return idToken.getName(); 
    }

    public boolean isLoggedIn() {
        return accessToken != null 
            && idToken != null;
    }

    @Override
    public String getIdToken() {
        return idToken.toString();
    }

    @Override
    public String getAccessToken() {
        return accessToken.toString();
    }

    @Override
    public String getRefreshToken() {
        return refreshToken.toString();
    }
    
}
