package apps.arusoft.com.followme.models;

/**
 * Created by jose.ramos on 25/02/2016.
 */
public class User {
    private String username;
    private String mail;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
