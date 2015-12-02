package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.Account;
import com.domain.DBObject;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * Created by M-Sem on 28/11/2015.
 */
@Component
public class DBAccessAccount extends DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessAccount.class);

    private static DBAccessAccount dbAccessAccountInstance = null;

    public static DBAccessAccount getInstance() {
        if (dbAccessAccountInstance == null) {
            dbAccessAccountInstance = new DBAccessAccount();
        }
        return dbAccessAccountInstance;
    }



    @Override
    public DBObject getObjectById(long id) throws CoreException {
        try{
            logger.info("Loading: Account: "+ id);

            Session session = DBAccess.getSession();
            DBObject returnObject = (DBObject) session.get(Account.class, id);
            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: Account: "+ returnObject);

            return (Account) returnObject;
        } catch (Exception e) {
            logger.error("Error Loading Account: " + id + ". Exception:" + e);
            throw new CoreException("Error Loading Account: " + id + ". Exception:" + e);
        }
    }

}
