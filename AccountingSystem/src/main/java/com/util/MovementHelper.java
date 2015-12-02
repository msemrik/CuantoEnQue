package com.util;

import com.DAO.DBAccess;
import com.domain.AccountSadder;
import com.domain.Movement;

/**
 * Created by x217204 on 12/2/2015.
 */
public class MovementHelper {
/*
    public static boolean processMovement(Movement movement) throws CoreException {

        Long sadder = AccountHelper.obtainSadder(movement.getOrigAccount());
        Long newSadder = AccountHelper.obtainSadder(movement.getOrigAccount())-movement.getAmount();
        AccountSadder originAccountSadder = new AccountSadder(movement, movement.getOrigAccount(), sadder, newSadder, movement.getStatus());

        sadder = AccountHelper.obtainSadder(movement.getDestAccount());
        newSadder = AccountHelper.obtainSadder(movement.getDestAccount())-movement.getAmount();
        AccountSadder destAccountSadder = new AccountSadder(movement, movement.getDestAccount(), sadder, newSadder, movement.getStatus());

        DBAccess.getDBAccessObject().saveObject(this, originAccountSadder, destAccountSadder);)

    }

    public void revert() throws CoreException {

        Long sadder = this.destAccount.obtainSadder();
        Long newSadder = this.destAccount.obtainSadder() + this.amount;
        AccountSadder originAccountSadder = new AccountSadder(this, origAccount, sadder, newSadder, this.getStatus());
        sadder = this.origAccount.obtainSadder();
        newSadder = this.origAccount.obtainSadder() - this.amount;
        AccountSadder destAccountSadder = new AccountSadder(this, destAccount, sadder, newSadder, this.getStatus());

        DBAccess.getDBAccessMovement().saveMovement(this, originAccountSadder, destAccountSadder);

    }*/
}
