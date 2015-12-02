package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.Account;
import com.domain.DBObject;
import com.domain.Detail;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * Created by M-Sem on 28/11/2015.
 */
@Component
public class DBAccessDetail extends DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessDetail.class);

    private static DBAccessDetail dbAccessDetailInstance = null;

    public static DBAccessDetail getInstance(){
        if (dbAccessDetailInstance == null){
            dbAccessDetailInstance=new DBAccessDetail();
        }
        return dbAccessDetailInstance;
    }

    @Override
    public DBObject getObjectById(long id) throws CoreException {
        try{
        logger.info("Loading: Detail: "+ id);

        Session session = DBAccess.getSession();
        DBObject returnObject = (DBObject) session.get(Detail.class, id);
        DBAccess.closeSession(session);
        logger.info("Successfully Loaded: Detail: "+ returnObject);

        return (Account) returnObject;
        } catch (Exception e) {
            logger.error("Error Loading Detail: " + id + ". Exception:" + e);
            throw new CoreException("Error Loading Detail: " + id + ". Exception:" + e);
        }
    }


}
