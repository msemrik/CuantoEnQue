package com.hibernate;

import com.DAO.DBAccess;
import com.DAO.DBAccessObjects.DBAccessAccount;
import com.DAO.DBAccessObjects.DBAccessAccountSadder;
import com.DAO.DBAccessObjects.DBAccessMovement;
import com.domain.*;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

public class HibernateTest {

    private static Logger logger = Logger.getLogger(HibernateTest.class);

    public static void maina(String[] args) throws Exception {

        Currency peso;
        Currency dolar;
        try {
            peso = new Currency("peso", "$", 1);
            dolar = new Currency("dolar", "u$d", 15);
            DBAccess.getDBAccessObject(Currency.class).saveObject(peso);
            DBAccess.getDBAccessObject(Currency.class).saveObject(dolar);
        } catch (Exception e) {
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
        } catch (Exception e) {
            //bankAccount1 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(1);
            bankAccount1 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(1, BankAccount.class);
            bankAccount2 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(2, BankAccount.class);
            bankAccount3 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(3, BankAccount.class);
            bankAccount4 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(4, BankAccount.class);
            bankAccount5 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(5, BankAccount.class);
            bankAccount6 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(6, BankAccount.class);
            bankAccount7 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(7, BankAccount.class);


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
            person1 = new Person("Osvaldo", dolar, new Date("17/11/2015"), null, "Osvaldo Samuel Semrik", "3513313182");
            person2 = new Person("Matìas", peso, new Date("17/11/2015"), null, "Matías Semrik", "3513313182");
            DBAccess.getDBAccessObject(Account.class).saveObject(person1);
            DBAccess.getDBAccessObject(Account.class).saveObject(person2);
        } catch (Exception e) {
            person1 = (Person) DBAccess.getDBAccessObject(Account.class).getObjectById(8, Person.class);
            person2 = (Person) DBAccess.getDBAccessObject(Account.class).getObjectById(9, Person.class);
        }

        System.out.println(person1);
        System.out.println(person2);


        Account incomeAccount;
        Account outcomeAccount;

        try {
            incomeAccount = new Account("Incomes", peso, new Date("17/11/2015"), null);
            outcomeAccount = new Account("Outcomes", peso, new Date("17/11/2015"), null);
            DBAccess.getDBAccessObject(Account.class).saveObject(incomeAccount);
            DBAccess.getDBAccessObject(Account.class).saveObject(outcomeAccount);
        } catch (Exception e) {
            incomeAccount = (Account) DBAccess.getDBAccessObject(Account.class).getObjectById(1, BankAccount.class);
            outcomeAccount = (Account) DBAccess.getDBAccessObject(Account.class).getObjectById(2, BankAccount.class);
        }

        System.out.println(incomeAccount);
        System.out.println(outcomeAccount);


        Category category;
        Category category2;
        Category category3;
        Category category4;
        Category category5;
        Category category6;
        try {
            category = new Category("Impuestos");
            category2 = new Category("Compras");
            category3 = new Category("Sueldo");
            category4 = new Category("Natacion");
            category5 = new Category("Super");
            category6 = new Category("Expensas");
            DBAccess.getDBAccessObject(category).saveObject(category);
            DBAccess.getDBAccessObject(category2).saveObject(category2);
            DBAccess.getDBAccessObject(category3).saveObject(category3);
            DBAccess.getDBAccessObject(category4).saveObject(category4);
            DBAccess.getDBAccessObject(category5).saveObject(category5);
            DBAccess.getDBAccessObject(category6).saveObject(category6);

        } catch (Exception e) {
            //bankAccount1 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(1);
            category = (Category) DBAccess.getDBAccessObject(Category.class).getObjectById(1);
            category2 = (Category) DBAccess.getDBAccessObject(Category.class).getObjectById(2);
            category3 = (Category) DBAccess.getDBAccessObject(Category.class).getObjectById(3);
            category4 = (Category) DBAccess.getDBAccessObject(Category.class).getObjectById(4);
            category5 = (Category) DBAccess.getDBAccessObject(Category.class).getObjectById(5);
            category6 = (Category) DBAccess.getDBAccessObject(Category.class).getObjectById(6);


        }

        System.out.println(category);
        System.out.println(category2);
        System.out.println(category3);
        System.out.println(category4);
        System.out.println(category5);
        System.out.println(category6);


        Detail detail1;
        Detail detail2;
        Detail detail3;
        Detail detail4;
        Detail detail5;
        Detail detail6;
        Detail detail7;
        Detail detail8;
        try {
            detail1 = new Detail(category, "Agua");
            detail2 = new Detail(category, "Gas");
            detail3 = new Detail(category, "Muni");
            detail4 = new Detail(category, "Rentas");
            detail5 = new Detail(category, "Agua");
            detail6 = new Detail(category3, "Haberes");
            detail7 = new Detail(category3, "Aguinaldo");
            detail8 = new Detail(category3, "Bono");
            DBAccess.getDBAccessObject(detail1).saveObject(detail1);
            DBAccess.getDBAccessObject(detail2).saveObject(detail2);
            DBAccess.getDBAccessObject(detail3).saveObject(detail3);
            DBAccess.getDBAccessObject(detail4).saveObject(detail4);
            DBAccess.getDBAccessObject(detail5).saveObject(detail5);
            DBAccess.getDBAccessObject(detail6).saveObject(detail6);
            DBAccess.getDBAccessObject(detail5).saveObject(detail7);
            DBAccess.getDBAccessObject(detail6).saveObject(detail8);
        } catch (Exception e) {
            //bankAccount1 = (BankAccount) DBAccess.getDBAccessObject(Account.class).getObjectById(1);
            detail1 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(1);
            detail2 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(2);
            detail3 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(3);
            detail4 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(4);
            detail5 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(5);
            detail6 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(6);
            detail7 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(7);
            detail8 = (Detail) DBAccess.getDBAccessObject(Detail.class).getObjectById(8);

        }

        System.out.println(detail1);
        System.out.println(detail2);
        System.out.println(detail3);
        System.out.println(detail4);
        System.out.println(detail5);
        System.out.println(detail6);
        System.out.println(detail7);
        System.out.println(detail8);



        Movement movement = new Movement(person2,bankAccount2,(long)100,new Date(), detail1,peso,"test comment");
        ((DBAccessMovement) DBAccess.getDBAccessObject(movement)).saveMovement(movement);

        List<Object> objects = ((DBAccessAccount)DBAccess.getDBAccessObject(Account.class)).loadEveryRow();
        List<Object> objectsSadder = ((DBAccessAccountSadder)DBAccess.getDBAccessObject(AccountSadder.class)).loadEveryRow();


    }
}