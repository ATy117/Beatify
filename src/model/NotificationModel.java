package model;

import object.Notification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationModel extends Model {
    private List<Notification> notifications= new ArrayList<>();

    public Iterator<Notification> getNotifications() {
        return notifications.iterator();
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
