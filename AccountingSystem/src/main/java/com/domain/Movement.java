package com.domain;

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
    private Reason reason;

    private String comment;

    public Movement(Account origAccount, Account destAccount, Long amount, Date movementDate, Reason reason, Currency currency, String comment) {
        this.origAccount = origAccount;
        this.destAccount = destAccount;
        this.amount = amount;
        this.movementDate = movementDate;
        this.reason = reason;
        this.currency = currency;
        this.comment = comment;
    }

    public Movement() {
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
        if (this.reason == null)
            attrMissing += " Reason.";
        if (this.comment == null)
            attrMissing += " Comment.";

        if (!attrMissing.isEmpty())
            attrMissing= "Missing Properties for Movement: " + attrMissing;

        return attrMissing;
    }

    @Override
    public String toString() {
        return "Movement [id=" + id + ", from=" + origAccount.getName() + ", to="
                + destAccount.getName() + ", amount=" + amount + "]";
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

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
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
}
