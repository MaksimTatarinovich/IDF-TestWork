package API;


public class RegInfo {
    private String userName;
    private String password;

    public RegInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
