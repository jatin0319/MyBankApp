package dao;

import models.UserDetails;

public class UserDao {
    public static void saveUser(UserDetails user)
    {
        DbConnector.save(user);
    }

    public static void updateUser(UserDetails userDetails)
    {
        DbConnector.update(userDetails);
    }
}
