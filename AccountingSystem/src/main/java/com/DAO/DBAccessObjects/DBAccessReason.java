package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.DBObject;
import com.domain.Reason;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by M-Sem on 28/11/2015.
 */
public class DBAccessReason implements DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessReason.class);

    private static DBAccessReason dbAccessReasonInstance = null;

    public static DBAccessReason getInstance(){
        if (dbAccessReasonInstance  == null){
            dbAccessReasonInstance  =new DBAccessReason();
        }
        return dbAccessReasonInstance ;
    }

    @Override
    public DBObject getObjectById(long id) {
        logger.info("Loading: Reason: "+ id);

        Session session = DBAccess.getSession();
        DBObject returnObject = (DBObject) session.get(Reason.class, id);
        DBAccess.closeSession(session);
        logger.info("Successfully Loaded: Reason: "+ returnObject);

        return (Reason) returnObject;

    }


}
