package com.DAO.DBAccessObjects;

import com.domain.DBObject;
import com.util.CoreException;

/**
 * Created by M-Sem on 28/11/2015.
 */
public interface DBAccessObject {

    public DBObject getObjectById(long id) throws CoreException;
}
