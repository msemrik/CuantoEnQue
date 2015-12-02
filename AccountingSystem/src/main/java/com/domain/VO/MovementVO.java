package com.domain.VO;

import com.DAO.DBAccessObjects.DBAccessAccount;
import com.DAO.DBAccessObjects.DBAccessCurrency;
import com.DAO.DBAccessObjects.DBAccessCategory;
import com.domain.Account;
import com.domain.Currency;
import com.domain.Movement;
import com.domain.Category;
import com.util.CoreException;

import java.util.Date;

/**
 * Created by M-Sem on 29/11/2015.
 */
public class MovementVO {

    private String origAccount;
    private String destAccount;
    private Long amount;
    private String currency;
    private Date movementDate;
    private String reason;
    private String comment;

    public MovementVO() {
    }

    public MovementVO(String origAccount, String destAccount, Long amount, String currency, Date movementDate, String reason, String comment) {
        this.origAccount = origAccount;
        this.destAccount = destAccount;
        this.amount = amount;
        this.currency = currency;
        this.movementDate = movementDate;
        this.reason = reason;
        this.comment = comment;
    }

    public Movement createMovementfromVO() throws CoreException {

        Account origAccount = (Account) DBAccessAccount.getInstance().getObjectById(Long.parseLong(this.origAccount));
        Account destAccount = (Account) DBAccessAccount.getInstance().getObjectById(Long.parseLong(this.destAccount));
        Category category = (Category) DBAccessCategory.getInstance().getObjectById(Long.parseLong(this.reason));
        Currency currency = (Currency) DBAccessCurrency.getInstance().getObjectById(Long.parseLong(this.currency));

        return new Movement(origAccount,destAccount,amount,this.movementDate, category,currency,this.comment);
    }

    public String getOrigAccount() {
        return origAccount;
    }

    public void setOrigAccount(String origAccount) {
        this.origAccount = origAccount;
    }

    public String getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(String destAccount) {
        this.destAccount = destAccount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
