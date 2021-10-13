package dao;

import models.UserDetails;
import models.UserPassword;

public class PasswordDao {
    public static void savePassword(UserPassword pswd)
    {
        DbConnector.save(pswd);
    }
}
