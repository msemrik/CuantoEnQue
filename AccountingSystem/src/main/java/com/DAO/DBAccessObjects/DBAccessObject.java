package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.Account;
import com.domain.DBObject;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by M-Sem on 28/11/2015.
 */
public abstract class DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessObject.class);

    public DBObject getObjectById(long id) throws CoreException {return null;};

    public DBObject getObjectById(long id, Class<?> classType) throws CoreException {return null;};

    protected Class<?> classObject;

    public void saveObject(DBObject dbObject) throws CoreException {
        try {
            logger.info("Saving: " + dbObject.getClass().getSimpleName() + " " + dbObject);
            Session session = DBAccess.getSession();
            session.getTransaction().begin();
            session.save(dbObject);
            session.getTransaction().commit();
            DBAccess.closeSession(session);
            logger.info("Successfully Saved: " + dbObject.getClass().getSimpleName() + " " + dbObject);
        } catch (Exception e) {
            logger.error("Error Saving: " + dbObject.getClass().getSimpleName() + " " + dbObject + ". Exception:" + e);
            throw new CoreException("Error Saving: " + dbObject.getClass().getSimpleName() + " " + dbObject + ". Exception:" + e);
        }
    }

    public List<Object> loadEveryRow() throws CoreException {
        List<Object> list = null;
        try {
            logger.info("Loading Table: " + classObject.getSimpleName());
            Session session = DBAccess.getSession();
            Criteria cr = session.createCriteria(classObject);
            list = cr.list();
            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: " + classObject.getSimpleName() + ". Row count: " + list.size());
            return list;
        } catch (Exception e) {
            logger.error("Error Loading Table: " + classObject.getSimpleName() + " " + classObject.getSimpleName() + ". Exception:" + e);
            throw new CoreException("Error Loading Table: " + classObject.getSimpleName() + " " + classObject.getSimpleName() + ". Exception:" + e);
        }
    }


}
