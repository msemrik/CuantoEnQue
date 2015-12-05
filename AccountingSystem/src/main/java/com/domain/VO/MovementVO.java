package com.domain.VO;

import com.DAO.DBAccessObjects.DBAccessAccount;
import com.DAO.DBAccessObjects.DBAccessCurrency;
import com.DAO.DBAccessObjects.DBAccessCategory;
import com.domain.*;
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
    private String detail;
    private String comment;

    public MovementVO() {
    }

    public MovementVO(String origAccount, String destAccount, Long amount, String currency, Date movementDate, String detail, String comment) {
        this.origAccount = origAccount;
        this.destAccount = destAccount;
        this.amount = amount;
        this.currency = currency;
        this.movementDate = movementDate;
        this.detail = detail;
        this.comment = comment;
    }

    public Movement createMovementfromVO() throws CoreException {

        Account origAccount = (Account) DBAccessAccount.getInstance().getObjectById(Long.parseLong(this.origAccount));
        Account destAccount = (Account) DBAccessAccount.getInstance().getObjectById(Long.parseLong(this.destAccount));
        Detail detail = (Detail) DBAccessCategory.getInstance().getObjectById(Long.parseLong(this.detail));
        Currency currency = (Currency) DBAccessCurrency.getInstance().getObjectById(Long.parseLong(this.currency));

        return new Movement(origAccount,destAccount,amount,this.movementDate, detail,currency,this.comment);
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String reason) {
        this.detail = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
