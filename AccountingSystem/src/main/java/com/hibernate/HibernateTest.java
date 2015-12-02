package com.hibernate;

import com.DAO.DBAccess;
import com.domain.*;
import org.apache.log4j.Logger;

import java.util.Date;

public class HibernateTest {

    private static Logger logger = Logger.getLogger(HibernateTest.class);
    public static void main(String[] args) throws Exception {

        Currency peso=new Currency("peso","$",1);
        Currency dolar=new Currency("dolar","u$d",15);
        DBAccess.saveObject(peso);
        DBAccess.saveObject(dolar);


        BankAccount bankAccount1=new BankAccount("Cordoba Debito",peso,"Debito",new Date("17/11/2015"),null,"Banco de Córdoba","11110002223334445566");
        BankAccount bankAccount2=new BankAccount("Frances Debito",peso,"Debito",new Date("17/11/2015"),null,"Banco Frances","11110002223334445566");
        BankAccount bankAccount3=new BankAccount("Frances Credito",peso,"Credito",new Date("17/11/2015"),null,"Banco Frances","11110002223334445566");
        BankAccount bankAccount4=new BankAccount("Santander Debito",peso,"Debito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount5=new BankAccount("Santander Debito",dolar,"Debito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount6=new BankAccount("Santander Credito Visa",peso,"Credito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");
        BankAccount bankAccount7=new BankAccount("Santander Credito Amex",peso,"Credito",new Date("17/11/2015"),null,"Santander Rio","11110002223334445566");

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

        Person person1=new Person("Osvaldo",dolar,new Date("17/11/2015"),null,"Osvaldo Samuel Semrik","3513313182");
        Person person2=new Person("Matìas",peso,new Date("17/11/2015"),null,"Matías Semrik","3513313182");
       /*
        Person person1=new Person("Osvaldo",(long)1500,"u$d",new Date("17/11/2015"),null,"Osvaldo Samuel Semrik","3513313182");
        Person person2=new Person("Matìas",(long)700,"$",new Date("17/11/2015"),null,"Matías Semrik","3513313182");
        */
        DBAccess.saveObject(person1);
        DBAccess.saveObject(person2);

        peso=(Currency) DBAccess.getDBAccessCurrency().getObjectById(1);
        Account incomeAccount = new Account("Incomes", peso, new Date("17/11/2015"),null);
        Account outcomeAccount= new Account("Outcomes", peso, new Date("17/11/2015"),null);
        DBAccess.saveObject(incomeAccount);
        DBAccess.saveObject(outcomeAccount);


        Category category =new Category("Impuestos");
        Category category2 =new Category("Compras");
        Category category3 =new Category("Sueldo");
        Category category4 =new Category("Natacion");
        Category category5 =new Category("Super");
        Category category6 =new Category("Expensas");
        DBAccess.saveObject(category);
        DBAccess.saveObject(category2);
        DBAccess.saveObject(category3);
        DBAccess.saveObject(category4);
        DBAccess.saveObject(category5);
        DBAccess.saveObject(category6);

        Account account=(Account)DBAccess.getDBAccessAccount().getObjectById(1);
        Account account2=(Account)DBAccess.getDBAccessAccount().getObjectById(8);
        category =(Category) DBAccess.getDBAccessCategory().getObjectById(1);
        peso=(Currency) DBAccess.getDBAccessCurrency().getObjectById(1);

        Movement movement = new Movement(account,account2,(long)100,new Date(), category,peso,"test comment");
        DBAccess.saveObject(movement);
    }
}