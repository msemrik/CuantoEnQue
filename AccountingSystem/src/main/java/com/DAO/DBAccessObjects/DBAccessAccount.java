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

    private DBAccessAccount (){
        this.classObject = Account.class;
    }


    @Override
    public DBObject getObjectById(long id) throws CoreException {
       throw new CoreException("Error! For loading Accounts use getObjectById(long id, Class<?> classType)");

    }


    public DBObject getObjectById(long id, Class<?> classType) throws CoreException {
        try{
            logger.info("Loading:" + classType.getSimpleName() + "Id: " + id);
            Session session = DBAccess.getSession();
            DBObject returnObject = (DBObject) session.get(classType, id);
            DBAccess .closeSession(session);
            logger.info("Successfully Loaded: " + classType.getSimpleName() + ": "+ returnObject);
            return returnObject;
        } catch (Exception e) {
            logger.error("Error Loading: " + classType.getSimpleName() + ". Id: "+ id +". Exception:" + e);
            throw new CoreException("Error Loading: " + classType.getSimpleName() + ". Id: "+ id +". Exception:" + e);
        }
    }

}
