package com.DAO;

import com.DAO.DBAccessObjects.*;
import com.domain.*;
import com.util.CoreException;
import com.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by x217204 on 11/17/2015.
 */
public final class DBAccess {

    final static Logger logger = Logger.getLogger(DBAccess.class);

    public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }

    private DBAccess(){};


    public static  DBAccessObject getDBAccessObject(Class<?> classType){

        if (classType == Account.class)
            return DBAccessAccount.getInstance();
        if (classType == Movement.class)
            return DBAccessMovement.getInstance();
        if (classType ==Category.class)
            return DBAccessCategory.getInstance();
        if (classType == Currency.class)
            return DBAccessCurrency.getInstance();
        if (classType == AccountSadder.class)
            return DBAccessAccountSadder.getInstance();
        if (classType ==Detail.class)
            return DBAccessDetail.getInstance();

        return null;
    }



    public static DBAccessObject getDBAccessObject(DBObject dbAccessObject) {
        if (dbAccessObject instanceof Account)
            return DBAccessAccount.getInstance();
        if (dbAccessObject instanceof Movement)
            return DBAccessMovement.getInstance();
        if (dbAccessObject instanceof Category)
            return DBAccessCategory.getInstance();
        if (dbAccessObject instanceof Currency)
            return DBAccessCurrency.getInstance();
        if (dbAccessObject instanceof AccountSadder)
            return DBAccessAccountSadder.getInstance();
        if (dbAccessObject instanceof Detail)
            return DBAccessDetail.getInstance();

        return null;
    }
    /*
    public static void saveObject(DBObject object) throws CoreException {
        DBAccessObject dbAccessObject = getDBAccessObject(object);
        try {
            dbAccessObject.saveObject(object);
        } catch (Exception e) {
            throw new CoreException("Error Saving: " + object.getClass().getSimpleName() + " " + object + ". Exception:" + e);
        }
    }


    public static DBObject loadObject(DBObject object) throws CoreException {
        DBAccessObject dbAccessObject = getDBAccessObject(object);
       try {
            logger.info("Loading: " + object.getClass().getSimpleName() + " " + object);
            Session session = getSession();
            DBObject returnObject = (DBObject) session.get(object.getClass(), object.getId());
            closeSession(session);
            return returnObject;
        } catch (Exception e) {
            logger.error("Error Loading: " + object.getClass().getSimpleName() + " " + object + ". Exception:" + e);
            throw new CoreException("Error Loading: " + object.getClass().getSimpleName() + " " + object + ". Exception:" + e);
        }
    }

    public static List<Object> loadEveryRow(Class<?> object) throws CoreException {
        List<Object> list = null;
        try {
            logger.info("Loading: " + object.getSimpleName());

            Session session = getSession();
            Criteria cr = session.createCriteria(object);
            list = cr.list();
            closeSession(session);
            logger.info("Successfully Loaded: " + object.getSimpleName() + ". Row count: " + list.size());
            return list;
        } catch (Exception e) {
            logger.error("Error Loading Table: " + object.getSimpleName() + " " + object + ". Exception:" + e);
            throw new CoreException("Error Loading Table: " + object.getSimpleName() + " " + object + ". Exception:" + e);
        }
    }
*/
}
