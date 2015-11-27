package com.Controller;


import com.domain.Reason;
import com.hibernate.HibernateTest;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/getReasons", method = RequestMethod.GET)
    public String[] getPerson(@RequestParam(value = "name", defaultValue = "default user", required = false) String name) throws Exception {

        //HibernateTest.mainMethod();


        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Query q = (Query) session.createQuery("From Reason");
        List<Object> resultList = q.list();


        System.out.println("num of reasons:" + resultList.size());

        for (Object next : resultList){
            if(next instanceof Reason) {
                System.out.println("next reason: " + next);

            }
        }
        session.close();
        /*
        if (resultList.size() > 0)
            return (Employee) resultList.get(0);
        */
        String[] string=new String[3];
        string[0]="Primera Opcion";
        string[1]="Segunda Opcion";
        string[2]="Tercera Opcion";
        return string;

    }
}