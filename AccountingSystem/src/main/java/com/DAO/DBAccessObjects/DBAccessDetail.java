package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.*;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by M-Sem on 28/11/2015.
 */
@Component
public class DBAccessDetail extends DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessDetail.class);

    private static DBAccessDetail dbAccessDetailInstance = null;

    public static DBAccessDetail getInstance() {
        if (dbAccessDetailInstance == null) {
            dbAccessDetailInstance = new DBAccessDetail();
        }
        return dbAccessDetailInstance;
    }

    private DBAccessDetail (){
        this.classObject = Detail.class;
    }

    @Override
    public DBObject getObjectById(long id) throws CoreException {
        try {
            logger.info("Loading: Detail: " + id);
            Session session = DBAccess.getSession();
            DBObject returnObject = (DBObject) session.get(Detail.class, id);
            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: Detail: " + returnObject);
            return (Account) returnObject;
        } catch (Exception e) {
            logger.error("Error Loading Detail: " + id + ". Exception:" + e);
            throw new CoreException("Error Loading Detail: " + id + ". Exception:" + e);
        }
    }


    public List<Detail> getDetailsForCategory(Category category) throws CoreException {
        try {
            logger.info("Loading: Detail for category: " + category);
            Session session = DBAccess.getSession();

            List <Detail> details = (List<Detail>) session.createCriteria(Detail.class)
                    .add(Restrictions.eq("category", category));

            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: Details for " + category +". Row Count: "+details.size());
            return details;
        } catch (Exception e) {
            logger.error("Error Loading Details for: " + category+ ". Exception:" + e);
            throw new CoreException("Error Loading Details for: " + category+ ". Exception:" + e);
        }
    }


}
