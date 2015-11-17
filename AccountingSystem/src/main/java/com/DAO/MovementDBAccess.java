package com.DAO;

import com.com.util.HibernateUtil;
import com.domain.Reason;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by x217204 on 11/17/2015.
 */
public class MovementDBAccess {

    public static void saveReason(Reason reason){

        Session session = DBAccess.getSession();

        Query q = session.createQuery("From Reason");

        List<Object> resultList = q.list();

        System.out.println("num of reason:" + resultList.size());

        for (Object next : resultList){
            if(next instanceof Reason)
                if (((Reason) next).getName().equals(reason.getName()))
                    return;
        }

        session.save(reason);

        session.getTransaction().commit();

    }
}
