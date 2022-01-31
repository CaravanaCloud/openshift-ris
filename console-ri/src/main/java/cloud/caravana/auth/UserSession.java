package cloud.caravana.auth;

public interface UserSession {
    boolean isLoggedIn();
    String getIdToken();
    String getAccessToken();
    String getRefreshToken();
    String getUserInfo();
    
}
