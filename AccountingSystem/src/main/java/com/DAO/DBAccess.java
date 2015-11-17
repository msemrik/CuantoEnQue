package com.DAO;

import com.com.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by x217204 on 11/17/2015.
 */
public class DBAccess {

    private static Session session = HibernateUtil.getSessionFactory().openSession();

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        DBAccess.session = session;
    }



}
