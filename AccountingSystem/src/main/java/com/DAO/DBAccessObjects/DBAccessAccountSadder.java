package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.Account;
import com.domain.AccountSadder;
import com.domain.DBObject;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Created by M-Sem on 01/12/2015.
 */
public class DBAccessAccountSadder extends DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessAccountSadder.class);

    private static DBAccessAccountSadder dbAccessAccountSadderInstance = null;

    public static DBAccessAccountSadder getInstance() {
        if (dbAccessAccountSadderInstance == null) {
            dbAccessAccountSadderInstance = new DBAccessAccountSadder();
        }
        return dbAccessAccountSadderInstance;
    }

    private DBAccessAccountSadder (){
        this.classObject = AccountSadder.class;
    }

    @Override
    public DBObject getObjectById(long id) throws CoreException {
        try {
            logger.info("Loading: AccountSadder: " + id);
            Session session = DBAccess.getSession();
            DBObject returnObject = (DBObject) session.get(AccountSadder.class, id);
            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: AccountSadder: " + returnObject);
            return (AccountSadder) returnObject;
        } catch (Exception e) {
            logger.error("Error Loading AccountSadder: " + id + ". Exception:" + e);
            throw new CoreException("Error Loading AccountSadder: " + id + ". Exception:" + e);
        }
    }

    public Long getAccountSadder(Account account) throws CoreException {
        try {
            logger.info("Loading: AccountSadder: " + account);
            Session session = DBAccess.getSession();
            AccountSadder accountSadder = (AccountSadder) session.createCriteria(AccountSadder.class)
                    .add(Restrictions.eq("account", account))
                    .addOrder(Order.desc("id"))
                    .setMaxResults(1)
                    .uniqueResult();

            if (accountSadder == null) {
                logger.info("Error, no Sadder for Account: " + account);
                return Long.valueOf(0);
            }
            logger.info("Successfully Loaded: AccountSadder: " + account);
            return accountSadder.getSadderAfterMovement();
        } catch (Exception e) {
            logger.error("Error Loading AccountSadder: " + account + ". Exception:" + e);
            throw new CoreException("Error Loading AccountSadder: " + account + ". Exception:" + e);
        }
    }

}