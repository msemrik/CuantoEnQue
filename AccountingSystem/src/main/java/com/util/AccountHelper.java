package com.util;

import com.DAO.DBAccessObjects.DBAccessAccountSadder;
import com.domain.Account;

/**
 * Created by x217204 on 12/2/2015.
 */
public class AccountHelper {

    public static Long obtainSadder(Account account) throws CoreException {

        return DBAccessAccountSadder.getInstance().getAccountSadder(account);

    }
}
