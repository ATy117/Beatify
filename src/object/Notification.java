package object;

public class Notification {
    private int notif_id;
    private String message;
    private String firstName;
    private String lastName;

    public int getNotif_id() {
        return notif_id;
    }

    public void setNotif_id(int notif_id) {
        this.notif_id = notif_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
