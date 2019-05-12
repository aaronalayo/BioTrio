package dk.kea.dat18i.team8.biotrio.demo;

public class Admin {

    private String admin_id;
    private String username;
    private String password;


    public Admin() {
    }

    public Admin(String admin_id, String username, String password) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdminId(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + admin_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}