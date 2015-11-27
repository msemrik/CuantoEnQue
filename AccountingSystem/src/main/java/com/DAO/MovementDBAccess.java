package com.DAO;

import com.domain.BankAccount;
import com.domain.Movement;
import com.domain.Reason;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * Created by x217204 on 11/17/2015.
 */
public class MovementDBAccess {

    public static void saveReason(Reason reason){

        Session session =  HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From Reason");

        List<Object> resultList = q.list();

        System.out.println("num of reason:" + resultList.size());

        for (Object next : resultList){
            if(next instanceof Reason)
                if (((Reason) next).getName().equals(reason.getName()))
                    return;
        }

        session =  HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        BankAccount bankAccount=new BankAccount();
        session.save(bankAccount);
        session.save(reason);

        session.getTransaction().commit();

        session.close();

        session =  HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        Movement movement = new Movement(bankAccount,bankAccount, (long) 10,new Date(),reason);
        session.save(movement);

        session.getTransaction().commit();

        session.close();    }
}
