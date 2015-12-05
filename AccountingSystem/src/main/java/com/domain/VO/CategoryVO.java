package com.domain.VO;

import com.DAO.DBAccess;
import com.DAO.DBAccessObjects.DBAccessAccount;
import com.DAO.DBAccessObjects.DBAccessCategory;
import com.DAO.DBAccessObjects.DBAccessCurrency;
import com.domain.*;
import com.util.CoreException;

import java.util.Date;

/**
 * Created by M-Sem on 29/11/2015.
 */
public class CategoryVO {

    private Long id;
    private String name;

    public CategoryVO() {
    }

    public CategoryVO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category createCategoryfromVO() throws CoreException {

       return ((Category) DBAccess.getDBAccessObject(Category.class).getObjectById(this.id));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
