package com.DAO.DBAccessObjects;

import com.DAO.DBAccess;
import com.domain.Category;
import com.domain.DBObject;
import com.util.CoreException;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * Created by M-Sem on 28/11/2015.
 */
public class DBAccessCategory implements DBAccessObject {

    final static Logger logger = Logger.getLogger(DBAccessCategory.class);

    private static DBAccessCategory dbAccessCategoryInstance = null;

    public static DBAccessCategory getInstance(){
        if (dbAccessCategoryInstance == null){
            dbAccessCategoryInstance =new DBAccessCategory();
        }
        return dbAccessCategoryInstance;
    }

    @Override
    public DBObject getObjectById(long id) throws CoreException {
        try {
            logger.info("Loading: Category: " + id);

            Session session = DBAccess.getSession();
            DBObject returnObject = (DBObject) session.get(Category.class, id);
            DBAccess.closeSession(session);
            logger.info("Successfully Loaded: Category: " + returnObject);

            return (Category) returnObject;
        } catch (Exception e) {
            logger.error("Error Loading Category: " + id + ". Exception:" + e);
            throw new CoreException("Error Loading Category: " + id + ". Exception:" + e);
        }
    }


}
