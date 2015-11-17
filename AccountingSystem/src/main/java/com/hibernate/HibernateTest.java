package com.hibernate;

import java.util.Date;
import java.util.List;


import com.DAO.MovementDBAccess;
import com.domain.Account;
import com.domain.BankAccount;
import com.domain.Movement;
import com.domain.Reason;
import com.util.*;

import org.hibernate.*;


public class HibernateTest {

    public static void main(String[] args) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
/*
        BankAccount bankAccount=new BankAccount("Bnco Cordoba Debito",new Long(1000),"$",new Date("17/11/2015"),null,"Banco de Córdoba","11110002223334445566");

        session.save(bankAccount);
*/

        Reason reason=new Reason("Impuestos");
        Reason reason2=new Reason("Compras");
        Reason reason3=new Reason("Sueldo");

        MovementDBAccess.saveReason(reason);
        MovementDBAccess.saveReason(reason2);
        MovementDBAccess.saveReason(reason3);

/*
        q = session.createQuery("From Employee ");

        resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Object next : resultList){
            if(next instanceof Movement)
                  System.out.println("next employee: " + next);
        }
*/
    }


}