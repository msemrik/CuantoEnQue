package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.DBObject;
import com.domain.Movement;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by M-Sem on 28/11/2015.
 */
public class DBAccessMovement implements DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessMovement.class);

    private static DBAccessMovement dbAccessMovementInstance = null;

    public static DBAccessMovement getInstance(){
        if (dbAccessMovementInstance == null){
            dbAccessMovementInstance =new DBAccessMovement();
        }
        return dbAccessMovementInstance ;
    }


    @Override
    public Movement getObjectById(long id){

        logger.info("Loading: Movement: "+ id);

        Session session = DBAccess.getSession();
        DBObject returnObject = (DBObject) session.get(Movement.class, id);
        DBAccess.closeSession(session);
        logger.info("Successfully Loaded: Movement: "+ returnObject);

        return (Movement) returnObject;


    }


}
