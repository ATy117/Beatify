package model;

import object.Notification;

import java.util.*;

public class NotificationModel extends Model {
    private List<Notification> notifications= new ArrayList<>();

    public Iterator<Notification> getNotifications() {
        return notifications.iterator();
    }

    public void setNotifications(List<Notification> notifications) {
        Collections.sort(notifications, new Comparator<Notification>() {
            @Override
            public int compare(Notification o1, Notification o2) {
                return o2.getNotif_id() - o1.getNotif_id();
            }
        });
        this.notifications = notifications;
    }
}
