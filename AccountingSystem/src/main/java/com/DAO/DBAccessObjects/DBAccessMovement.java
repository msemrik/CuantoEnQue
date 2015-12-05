package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.*;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import static com.google.common.base.Preconditions.checkNotNull;


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

    private DBAccessMovement (){
        this.classObject = Movement.class;
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
            checkNotNull(getObjectById(movement.getId()));

        } catch (NullPointerException e) {
            logger.error("Error saving Movment: " + dbObject + ". to Save a new Movement you need to create AccountSadder before, invoking other method. Exception:" + e);
            throw new CoreException("Error saving Movment: " + dbObject + ". to Save a new Movement you need to create AccountSadder before, invoking other method. Exception:" + e);
        } catch (Exception e) {
            logger.error("Error Loading Movement: " + dbObject + ". Exception:" + e);
            throw new CoreException("Error Loading Movement: " + dbObject + ". Exception:" + e);
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


    public void saveMovement(Movement movement) throws CoreException {

        try {
            logger.info("Saving new Movement: " + movement);

            movement.hasMissingParameters();

            AccountSadder origAccountSadder = new AccountSadder(movement,movement.getOrigAccount());
            AccountSadder destAccountSadder = new AccountSadder(movement,movement.getDestAccount());

            Session session = DBAccess.getSession();
            session.getTransaction().begin();
            session.save(movement);
            session.save(origAccountSadder);
            session.save(destAccountSadder);
            session.getTransaction().commit();
            DBAccess.closeSession(session);
            logger.info("Successfully Saved new Movement: " + movement + ". Orig Account Sadder: " + origAccountSadder + ". Dest Account Sadder: " + destAccountSadder);
        } catch (Exception e) {
            logger.error("Error Saving new Movement: " + movement + ". Exception:" + e);
            throw new CoreException("Error Saving new Movement: " + movement + ". Exception:" + e);
        }
    }


}
