package Services;

import java.util.List;

import Data.TransactionsDao;
import Pojos.Transactions;

public class TransactionsService {
	
	private TransactionsDao transactionsDao;
	
	public TransactionsService() {}
	
	public TransactionsService(TransactionsDao transactionsDao) {
		this.transactionsDao = transactionsDao;
	}
	//only posted one
	public  Transactions getTransactionsById(int id) {
		return this.transactionsDao.getTransactionsbyAccountId(id);
	}
//	public Transactions findAllTransactions(){
//		String out = "";
//		Transactions transaction = new Transactions();
//		 out = transaction.getTransaction_type();
//		 return out;
//	}

}
