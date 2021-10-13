package dao;

import models.UserDetails;

public class ActivateDeactivateDao {
    public static void activateDeactivateUser(UserDetails userDetails)
    {
        DbConnector.update(userDetails);
    }
}
