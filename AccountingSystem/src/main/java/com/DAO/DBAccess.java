package com.DAO;

import com.DAO.DBAccessObjects.DBAccessAccount;
import com.DAO.DBAccessObjects.DBAccessCurrency;
import com.DAO.DBAccessObjects.DBAccessMovement;
import com.DAO.DBAccessObjects.DBAccessReason;
import com.domain.DBObject;
import com.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by x217204 on 11/17/2015.
 */
public class DBAccess {

    final static Logger logger = Logger.getLogger(DBAccess.class);

    public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }


    public static void saveObject(DBObject object) {

        try {
            logger.info("Saving: " + object.getClass().getSimpleName() + " " + object);
            Session session = getSession();
            session.getTransaction().begin();
            session.save(object);
            session.getTransaction().commit();
            closeSession(session);
            logger.info("Successfully Saved: " + object.getClass().getSimpleName() + " " + object);
        } catch (Exception e) {
            logger.error("Error Saving: " + object.getClass().getSimpleName() + " " + object + ". Exception:" + e);
        }
    }

    public static DBObject loadObject(DBObject object) {
        logger.info("Loading: " + object.getClass().getSimpleName() + " " + object);

        Session session = getSession();
        DBObject returnObject = (DBObject) session.get(object.getClass(), object.getId());
        closeSession(session);

        return returnObject;
    }

    public static List<Object> loadEveryRow(Class<?> object) {
        List<Object> list = null;
        try {
            logger.info("Loading: " + object.getSimpleName());

            Session session = getSession();
            Criteria cr = session.createCriteria(object);
            list = cr.list();
            closeSession(session);
            logger.info("Successfully Loaded: " + object.getClass().getSimpleName() + ". Row count: " + list.size());

        } catch (Exception e) {
            logger.error("Error Loading: " + object.getSimpleName() + " " + object + ". Exception:" + e);
        }
        return list;
    }


    public static DBAccessAccount getDBAccessAccount(){
        return DBAccessAccount.getInstance();
    }

    public static DBAccessMovement getDBAccessMovement(){
        return DBAccessMovement.getInstance();
    }

    public static DBAccessReason getDBAccessReason(){
        return DBAccessReason.getInstance();
    }

    public static DBAccessCurrency getDBAccessCurrency(){
        return DBAccessCurrency.getInstance();
    }
}
