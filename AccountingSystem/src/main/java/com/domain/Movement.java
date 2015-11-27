package com.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Movement {
    @Id
    @GeneratedValue(generator = "YOUR_ENTITY_SEQ2")
    @SequenceGenerator(name = "YOUR_ENTITY_SEQ2", sequenceName = "YOUR_ENTITY_SEQ2", allocationSize = 1)
    private Long id;
    @ManyToOne
    private BankAccount origAccount;
    @ManyToOne
    private BankAccount destAccount;

    private Long amount;

    private Date movementDate;

    @ManyToOne
    private Reason reason;

    public Movement(BankAccount origAccount,BankAccount destAccount, Long amount, Date movementDate, Reason reason) {
        this.origAccount=origAccount;
        this.destAccount=destAccount;
        this.amount=amount;
        this.movementDate=movementDate;
        this.reason=reason;
    }

    public Movement() {
    }


    @Override
    public String toString() {
        return "Movement [id=" + id + ", from=" + origAccount.getName()+ ", to="
                + destAccount.getName() + ", amount=" + amount+ "]";
    }
}
