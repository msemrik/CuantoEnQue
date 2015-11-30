package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.Currency;
import com.domain.DBObject;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by M-Sem on 28/11/2015.
 */
public class DBAccessCurrency implements DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessCurrency.class);

    private static DBAccessCurrency dbAccessCurrencyInstance = null;

    public static DBAccessCurrency getInstance(){
        if (dbAccessCurrencyInstance  == null){
            dbAccessCurrencyInstance  =new DBAccessCurrency();
        }
        return dbAccessCurrencyInstance;
    }

    @Override
    public DBObject getObjectById(long id) {

        logger.info("Loading: Currency: "+ id);

        Session session = DBAccess.getSession();
        DBObject returnObject = (DBObject) session.get(Currency.class, id);
        DBAccess.closeSession(session);
        logger.info("Successfully Loaded: Currency: "+ returnObject);

        return (Currency) returnObject;
    }

}
