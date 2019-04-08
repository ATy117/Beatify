package DAO;

import object.Notification;

import java.util.List;

public interface NotificationDAO {
    boolean addNotification(String notification, int user_id);
    boolean addToNotifMapping(int notif_id, int follower_id);
    List<Notification> getUnviewedNotifications(int follower_id);
    boolean viewNotification(int notif_id, int follower_id);
    boolean deleteNotifMapping(int notif_id, int follower_id);
    boolean deleteNotification(int notif_id);
}
