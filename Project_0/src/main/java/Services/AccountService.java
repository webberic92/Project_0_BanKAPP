 package Services;
import java.util.List;

import Data.AccountDao;
import Pojos.Accounts;
import Pojos.Transactions;
import Pojos.Users;

public class AccountService {
	
	private AccountDao accountDao;
	
	public AccountService() {}
	
	public AccountService (AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public Accounts findAccountID(int id) {
		return this.accountDao.getByID(id);
	}

		public Accounts withdrawlAccount(int id, int withdrawlAmount) {
			return this.accountDao.withdrawCash(id, withdrawlAmount);
	}

		public Accounts depositAccount(int id, int depositAmount) {
			return this.accountDao.depositCash(id, depositAmount);

		}
		public Users requestCredit(int id) {
			return this.accountDao.requestCreditcard(id);
			
		}
		public Accounts transferToAnother(int you, int me, int amount ) {
			return this.accountDao.transferMoney(you,me,amount);
		}
		
}
