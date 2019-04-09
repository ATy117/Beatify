package DAO;

import object.Notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAODB implements NotificationDAO {
    Connection connection = dbConnection.getInstance();

    @Override
    public boolean addNotification(String notification, int user_id) {
        String query = "INSERT INTO notification VALUES(NULL,?,?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, notification);
            statement.setInt(2, user_id);
            LocalDate date = LocalDate.now();
            statement.setString(3, date.toString());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getNotifID(String notification, int user_id) {
        String query = "SELECT notification.notif_id FROM notification " +
                "WHERE notification.notification = ? AND notification.user_id = ?";
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, notification);
            statement.setInt(2, user_id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                int notifID = rs.getInt("notification.notif_id");
                statement.close();
                rs.close();
                return notifID;
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean addToNotifMapping(int notif_id, int follower_id) {
        String query = "INSERT INTO notif_mapping VALUES(?,?)";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, notif_id);
            statement.setInt(2, follower_id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Notification> getUnviewedNotifications(int follower_id) {
        String query = "SELECT notification.notif_id, notification.notification, notification.date_created, user.first_name, user.last_name FROM \n" +
                "notification INNER JOIN user ON notification.user_id = user.user_id\n" +
                "INNER JOIN notif_mapping ON notif_mapping.notif_id = notification.notif_id\n" +
                "WHERE notif_mapping.follower_id = ? AND notif_mapping.is_viewed = 0";

        List<Notification> notificationList = new ArrayList<>();
        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, follower_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                notificationList.add(toNotif(rs));
            }
            statement.close();
            rs.close();
            return notificationList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notificationList;
    }

    @Override
    public boolean viewNotification(int notif_id, int follower_id) {
        String query = "UPDATE notif_mapping SET notif_mapping.is_viewed = 1\n" +
                "WHERE notif_mapping.notif_id = ? AND notif_mapping.follower_id = ?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, notif_id);
            statement.setInt(2, follower_id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deleteNotifMapping(int notif_id, int follower_id) {
        return false;
    }

    @Override
    public boolean deleteNotification(int notif_id) {
        return false;
    }

    private Notification toNotif(ResultSet rs) throws SQLException {
        Notification notification = new Notification();
        notification.setFirstName(rs.getString("user.first_name"));
        notification.setLastName(rs.getString("user.last_name"));
        notification.setMessage(rs.getString("notification.notification"));
        String date = rs.getString("notification.date_created");
        notification.setDate_created(LocalDate.parse(date));
        return notification;
    }
}
