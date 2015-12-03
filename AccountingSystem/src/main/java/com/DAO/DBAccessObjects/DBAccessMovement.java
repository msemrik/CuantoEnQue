package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.AccountSadder;
import com.domain.DBObject;
import com.domain.Movement;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by M-Sem on 28/11/2015.
 */
public class DBAccessMovement extends DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessMovement.class);

    private static DBAccessMovement dbAccessMovementInstance = null;

    public static DBAccessMovement getInstance() {
        if (dbAccessMovementInstance == null) {
            dbAccessMovementInstance = new DBAccessMovement();
        }
        return dbAccessMovementInstance;
    }


    @Override
    public Movement getObjectById(long id) throws CoreException {
        try {
            logger.info("Loading: Movement: " + id);
            Session session = DBAccess.getSession();
            DBObject returnObject = (DBObject) session.get(Movement.class, id);
            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: Movement: " + returnObject);
            return (Movement) returnObject;
        } catch (Exception e) {
            logger.error("Error Loading Account: " + id + ". Exception:" + e);
            throw new CoreException("Error Loading Account: " + id + ". Exception:" + e);
        }
    }

    public void saveObject(DBObject dbObject) throws CoreException {
        try {
            Movement movement = (Movement) dbObject;
            //checkNotNull(getObjectById(movement.getId()));

        } catch (Exception e) {
            logger.error("Error Loading Movment: " + dbObject + ". to Save a new Movement you need to create AccountSadder before. Exception:" + e);
            throw new CoreException("Error Loading Movment: " + dbObject + ". to Save Movement you need to create AccountSadder before. Exception:" + e);
        }

        try {

            logger.info("Updating: Movement" + dbObject.getClass().getSimpleName() + " " + dbObject);
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


    public void saveMovement(Movement movement, AccountSadder origAccountSadder, AccountSadder destAccountSadder) throws CoreException {

        try {
            logger.info("Saving: " + movement.getClass().getSimpleName() + " " + movement);
            Session session = DBAccess.getSession();
            session.getTransaction().begin();
            session.save(movement);
            session.save(origAccountSadder);
            session.save(destAccountSadder);
            session.getTransaction().commit();
            DBAccess.closeSession(session);
            logger.info("Successfully Saved Movement: " + movement);
        } catch (Exception e) {
            logger.error("Error Saving Movement: " + movement + ". Exception:" + e);
            throw new CoreException("Error Saving Movement: " + movement + ". Exception:" + e);
        }
    }


}
