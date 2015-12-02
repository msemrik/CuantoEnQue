package com.domain;

import com.DAO.DBAccess;
import com.util.CoreException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movement")
public class Movement implements DBObject {


    @Id
    @GeneratedValue(generator = "MOVEMENT_SEQ")
    @SequenceGenerator(name = "MOVEMENT_SEQ", sequenceName = "MOVEMENT_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Account origAccount;

    @ManyToOne
    private Account destAccount;

    private Long amount;

    @ManyToOne
    private Currency currency;

    private Date movementDate;

    @ManyToOne
    private Category category;

    private String comment;

    private MovementStatus status;

    public Movement() {
    }

    public Movement(Account origAccount, Account destAccount, Long amount, Date movementDate, Category category, Currency currency, String comment) {
        this.origAccount = origAccount;
        this.destAccount = destAccount;
        this.amount = amount;
        this.movementDate = movementDate;
        this.category = category;
        this.currency = currency;
        this.comment = comment;
        this.status = MovementStatus.EXECUTED;
    }

    public String hasMissingParameters() {

        String attrMissing = "";

        if (this.origAccount == null)
            attrMissing += " Origin Account.";
        if (this.origAccount == null)
            attrMissing += " Destination Account.";
        if (this.amount == null)
            attrMissing += " Amount.";
        if (this.currency == null)
            attrMissing += " Currency.";
        if (this.movementDate == null)
            attrMissing += " Date.";
        if (this.category == null)
            attrMissing += " Category.";
        if (this.comment == null)
            attrMissing += " Comment.";

        if (!attrMissing.isEmpty())
            attrMissing = "Missing Properties for Movement: " + attrMissing;

        return attrMissing;
    }

    public void process() throws CoreException {

        Long sadder = this.destAccount.getSadder();
        Long newSadder=this.destAccount.getSadder() - this.amount;
        AccountSadder originAccountSadder = new AccountSadder(this, origAccount, sadder, newSadder, this.getStatus());
        sadder = this.origAccount.getSadder();
        newSadder=this.origAccount.getSadder() + this.amount;
        AccountSadder destAccountSadder = new AccountSadder(this, destAccount, sadder, newSadder, this.getStatus());

        DBAccess.getDBAccessMovement().saveMovement(this,originAccountSadder,destAccountSadder);

    }

    public void revert() throws CoreException {

        Long sadder = this.destAccount.getSadder();
        Long newSadder=this.destAccount.getSadder() + this.amount;
        AccountSadder originAccountSadder = new AccountSadder(this, origAccount, sadder, newSadder, this.getStatus());
        sadder = this.origAccount.getSadder();
        newSadder=this.origAccount.getSadder() - this.amount;
        AccountSadder destAccountSadder = new AccountSadder(this, destAccount, sadder, newSadder, this.getStatus());

        DBAccess.getDBAccessMovement().saveMovement(this,originAccountSadder,destAccountSadder);

    }


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getOrigAccount() {
        return origAccount;
    }

    public void setOrigAccount(Account origAccount) {
        this.origAccount = origAccount;
    }

    public Account getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(Account destAccount) {
        this.destAccount = destAccount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MovementStatus getStatus() {
        return status;
    }

    public void setStatus(MovementStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", origAccount=" + origAccount +
                ", destAccount=" + destAccount +
                ", amount=" + amount +
                ", currency=" + currency +
                ", movementDate=" + movementDate +
                ", category=" + category +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                '}';
    }

}
