package user;

public class UserDTO {

    private String userID;
    private String userPassword;
    private String userName;
    private String userGender;
    private String userEmail;
    private String userEmailHash;
    private String userIP;
    private boolean userEmailChecked;

    public UserDTO() {

    }

    public UserDTO(String userID, String userPassword, String userName, String userGender, String userEmail,
                   String userEmailHash, boolean userEmailChecked, String userIP) {
        super();
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userGender = userGender;
        this.userEmail = userEmail;
        this.userEmailHash = userEmailHash;
        this.userEmailChecked = userEmailChecked;
        this.userIP = userIP;
    }

    public String getUserEmailHash() {
        return userEmailHash;
    }

    public void setUserEmailHash(String userEmailHash) {
        this.userEmailHash = userEmailHash;
    }


    public boolean isUserEmailChecked() {
        return userEmailChecked;
    }

    public void setUserEmailChecked(boolean userEmailChecked) {
        this.userEmailChecked = userEmailChecked;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

}