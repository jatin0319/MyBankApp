package dao;

import io.ebean.*;

public class DbConnector {
    public static ExpressionFactory expression() {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.getExpressionFactory();
    }

    public static <T> Query<T> find(java.lang.Class<T> beanType) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.find(beanType);
    }

    public static <T> Query<T> createQuery(Class<T> beanType) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.createQuery(beanType);
    }

    public static <T> SqlQuery createSqlQuery(String sql) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.createSqlQuery(sql);
    }

    public static void save(java.lang.Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.save(bean);
    }

    public static void update(java.lang.Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.update(bean);
    }

    public static void delete(java.lang.Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.delete(bean);
    }

    public static void refresh(java.lang.Object bean) {
        EbeanServer defaultDB = Ebean.getServer("default");
        defaultDB.refresh(bean);
    }

    public static SqlUpdate createUpdateQuery(String s) {
        EbeanServer defaultDB = Ebean.getServer("default");
        return defaultDB.createSqlUpdate(s);
    }

    public static EbeanServer getServer(String serverName) {
        return Ebean.getServer(serverName);
    }
}

