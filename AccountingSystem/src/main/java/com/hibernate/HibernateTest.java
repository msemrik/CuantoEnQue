package com.hibernate;

import com.DAO.DBAccess;
import com.domain.*;
import org.apache.log4j.Logger;

import java.util.Date;

public class HibernateTest {

    private static Logger logger = Logger.getLogger(HibernateTest.class);
    public static void main(String[] args) throws Exception {

        Currency peso;
        Currency dolar;
        try {
            peso = new Currency("peso", "$", 1);
            dolar = new Currency("dolar", "u$d", 15);
            DBAccess.getDBAccessObject(Currency.class).saveObject(peso);
            DBAccess.getDBAccessObject(Currency.class).saveObject(dolar);
        }catch (Exception e){
            peso = (Currency) DBAccess.getDBAccessObject(Currency.class).getObjectById(1);
            dolar = (Currency) DBAccess.getDBAccessObject(Currency.class).getObjectById(2);
        }

        System.out.println(peso);
        System.out.println(dolar);




        BankAccount bankAccount1;
        BankAccount bankAccount2;
        BankAccount bankAccount3;
        BankAccount bankAccount4;
        BankAccount bankAccount5;
        BankAccount bankAccount6;
        BankAccount bankAccount7;
        try {
            bankAccount1 = new BankAccount("Cordoba Debito", peso, "Debito", new Date("17/11/2015"), null, "Banco de Córdoba", "11110002223334445566");
            bankAccount2 = new BankAccount("Frances Debito", peso, "Debito", new Date("17/11/2015"), null, "Banco Frances", "11110002223334445566");
            bankAccount3 = new BankAccount("Frances Credito", peso, "Credito", new Date("17/11/2015"), null, "Banco Frances", "11110002223334445566");
            bankAccount4 = new BankAccount("Santander Debito", peso, "Debito", new Date("17/11/2015"), null, "Santander Rio", "11110002223334445566");
            bankAccount5 = new BankAccount("Santander Debito", dolar, "Debito", new Date("17/11/2015"), null, "Santander Rio", "11110002223334445566");
            bankAccount6 = new BankAccount("Santander Credito Visa", peso, "Credito", new Date("17/11/2015"), null, "Santander Rio", "11110002223334445566");
            bankAccount7 = new BankAccount("Santander Credito Amex", peso, "Credito", new Date("17/11/2015"), null, "Santander Rio", "11110002223334445566");

            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount1);
            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount2);
            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount3);
            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount4);
            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount5);
            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount6);
            DBAccess.getDBAccessObject(Account.class).saveObject(bankAccount7);
        } catch(Exception e){
            bankAccount1 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(1);
            bankAccount2 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(2);
            bankAccount3 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(3);
            bankAccount4 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(4);
            bankAccount5 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(5);
            bankAccount6 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(6);
            bankAccount7 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(7);


        }

        System.out.println(bankAccount1);
        System.out.println(bankAccount2);
        System.out.println(bankAccount3);
        System.out.println(bankAccount4);
        System.out.println(bankAccount5);
        System.out.println(bankAccount6);
        System.out.println(bankAccount7);




        Person person1;
        Person person2;

        try {
            person1=new Person("Osvaldo",dolar,new Date("17/11/2015"),null,"Osvaldo Samuel Semrik","3513313182");
            person2=new Person("Matìas",peso,new Date("17/11/2015"),null,"Matías Semrik","3513313182");bankAccount3 = new BankAccount("Frances Credito", peso, "Credito", new Date("17/11/2015"), null, "Banco Frances", "11110002223334445566");
            DBAccess.getDBAccessObject(Account.class).saveObject(person1);
            DBAccess.getDBAccessObject(Account.class).saveObject(person2);
        } catch(Exception e){
            person1 = (Person) DBAccess.getDBAccessObject(Account.class).getObjectById(1);
            person2 = (Person) DBAccess.getDBAccessObject(Account.class).getObjectById(2);
         }

        System.out.println(person1);
        System.out.println(person2);



       /*NO USAR
        Person person1=new Person("Osvaldo",(long)1500,"u$d",new Date("17/11/2015"),null,"Osvaldo Samuel Semrik","3513313182");
        Person person2=new Person("Matìas",(long)700,"$",new Date("17/11/2015"),null,"Matías Semrik","3513313182");
        */


        /*
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


        */
    }
}