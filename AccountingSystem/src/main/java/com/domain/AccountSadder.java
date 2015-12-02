package com.domain;

import javax.persistence.*;

/**
 * Created by M-Sem on 01/12/2015.
 */
@Entity
@Table(name = "AccountSadder")
public class AccountSadder implements DBObject {

    @Id
    @GeneratedValue(generator = "ACCOUNTSADDER_SEQ")
    @SequenceGenerator(name = "ACCOUNTSADDER_SEQ", sequenceName = "ACCOUNTSADDER_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Movement movement;

    @ManyToOne
    private Account account;

    private Long sadderBeforeMovement;
    private Long sadderAfterMovement;

    private MovementStatus movementStatus;

    public AccountSadder() {
    }

    public AccountSadder(Movement movement, Account account, Long sadderBeforeMovement, Long sadderAfterMovement, MovementStatus movementStatus) {
        this.id = id;
        this.movement = movement;
        this.account = account;
        this.sadderBeforeMovement = sadderBeforeMovement;
        this.sadderAfterMovement = sadderAfterMovement;
        this.movementStatus = movementStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getSadderBeforeMovement() {
        return sadderBeforeMovement;
    }

    public void setSadderBeforeMovement(Long sadderBeforeMovement) {
        this.sadderBeforeMovement = sadderBeforeMovement;
    }

    public Long getSadderAfterMovement() {
        return sadderAfterMovement;
    }

    public void setSadderAfterMovement(Long sadderAfterMovement) {
        this.sadderAfterMovement = sadderAfterMovement;
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public void setMovementStatus(MovementStatus movementStatus) {
        this.movementStatus = movementStatus;
    }

    @Override
    public String toString() {
        return "AccountSadder{" +
                "account=" + account +
                ", id=" + id +
                ", movement=" + movement +
                ", sadderBeforeMovement=" + sadderBeforeMovement +
                ", sadderAfterMovement=" + sadderAfterMovement +
                ", movementStatus=" + movementStatus +
                '}';
    }
}

