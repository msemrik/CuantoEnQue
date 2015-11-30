package com.hibernate;

import com.DAO.DBAccess;
import com.domain.*;
import org.apache.log4j.Logger;

import java.util.Date;

public class HibernateTest {

    private static Logger logger = Logger.getLogger(HibernateTest.class);
    public static void maina(String[] args) throws Exception {

        Currency peso=new Currency("peso","$",1);
        Currency dolar=new Currency("dolar","u$d",15);
        DBAccess.saveObject(peso);
        DBAccess.saveObject(dolar);

        BankAccount bankAccount1=new BankAccount("Cordoba Debito",new Long(1000),peso,"Debito",new Date("17/11/2015"),null,"Banco de Córdoba","11110002223334445566");
        BankAccount bankAccount2=new BankAccount("Frances Debito",new Long(900),peso,"Debito",new Date("17/11/2015"),null,"Banco Frances","11110002223334445566");
        BankAccount bankAccount3=new BankAccount("Frances Credito",new Long(800),peso,"Credito",new Date("17/11/2015"),null,"Banco Frances","11110002223334445566");
        BankAccount bankAccount4=new BankAccount("Santander Debito",new Long(700),peso,"Debito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount5=new BankAccount("Santander Debito",new Long(600),dolar,"Debito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount6=new BankAccount("Santander Credito Visa",new Long(500),peso,"Credito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount7=new BankAccount("Santander Credito Amex",new Long(400),peso,"Credito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");

        /*
        BankAccount bankAccount1=new BankAccount("Cordoba Debito",new Long(1000),"$","Debito",new Date("17/11/2015"),null,"Banco de Córdoba","11110002223334445566");
        BankAccount bankAccount2=new BankAccount("Frances Debito",new Long(900),"$","Debito",new Date("17/11/2015"),null,"Banco Frances","11110002223334445566");
        BankAccount bankAccount3=new BankAccount("Frances Credito",new Long(800),"$","Credito",new Date("17/11/2015"),null,"Banco Frances","11110002223334445566");
        BankAccount bankAccount4=new BankAccount("Santander Debito",new Long(700),"$","Debito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount5=new BankAccount("Santander Debito",new Long(600),"u$d","Debito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount6=new BankAccount("Santander Credito Visa",new Long(500),"$","Credito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount7=new BankAccount("Santander Credito Amex",new Long(400),"$","Credito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        */
        DBAccess.saveObject(bankAccount1);
        DBAccess.saveObject(bankAccount2);
        DBAccess.saveObject(bankAccount3);
        DBAccess.saveObject(bankAccount4);
        DBAccess.saveObject(bankAccount5);
        DBAccess.saveObject(bankAccount6);
        DBAccess.saveObject(bankAccount7);

        Person person1=new Person("Osvaldo",(long)1500,dolar,new Date("17/11/2015"),null,"Osvaldo Samuel Semrik","3513313182");
        Person person2=new Person("Matìas",(long)700,peso,new Date("17/11/2015"),null,"Matías Semrik","3513313182");
       /*
        Person person1=new Person("Osvaldo",(long)1500,"u$d",new Date("17/11/2015"),null,"Osvaldo Samuel Semrik","3513313182");
        Person person2=new Person("Matìas",(long)700,"$",new Date("17/11/2015"),null,"Matías Semrik","3513313182");
        */
        DBAccess.saveObject(person1);
        DBAccess.saveObject(person2);

        Reason reason=new Reason("Impuestos");
        Reason reason2=new Reason("Compras");
        Reason reason3=new Reason("Sueldo");
        Reason reason4=new Reason("Natacion");
        Reason reason5=new Reason("Super");
        Reason reason6=new Reason("Expensas");
        DBAccess.saveObject(reason);
        DBAccess.saveObject(reason2);
        DBAccess.saveObject(reason3);
        DBAccess.saveObject(reason4);
        DBAccess.saveObject(reason5);
        DBAccess.saveObject(reason6);

        Account account=(Account)DBAccess.getDBAccessAccount().getObjectById(1);
        Account account2=(Account)DBAccess.getDBAccessAccount().getObjectById(8);
        reason=(Reason) DBAccess.getDBAccessReason().getObjectById(1);
        peso=(Currency) DBAccess.getDBAccessCurrency().getObjectById(1);

        Movement movement = new Movement(account,account2,(long)100,new Date(),reason,peso,"test comment");
        DBAccess.saveObject(movement);
    }
}