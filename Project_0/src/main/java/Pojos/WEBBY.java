package Pojos;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Data.AccountDao;
import Data.TransactionsDao;
import Data.UsersDao;
import Services.AccountService;
import Services.TransactionsService;
import Utility.ConnectionUtil;

public class WEBBY {
	
	ConnectionUtil connectionUtil;
	AccountService accountService;
	AccountDao accountDao;
	TransactionsService transactionService;
	TransactionsDao transactionDao;
	
	void TestWebbyPassword(UsersDao usersDao) {
		System.out.println("Please enter your password for WEBBYs ACCOUNT...");
		Scanner Estart = new Scanner(System.in);
		String startdecision = Estart.nextLine();
		switch (startdecision) {
		
		case "WEBBY" :{
			System.err.println("CORRRECT PASSWORD! Now Logging into WEBBYs account...");

			UsersDao WEBBY = new UsersDao();
			WebbySelectAccount(WEBBY);
		}
		break;
		case "EXIT" :{
			Bank webby = new Bank();
			webby.run(startdecision);		}
		break;
		default: {
			System.err.println("WRONG PASSWORD, please try again or type EXIT");
			TestWebbyPassword(usersDao);
		}
		}
		Estart.close();
	}
	
	public String WebbySelectAccount (UsersDao usersDao) {
		System.out.println("You Selected to login as WEBBY : USER_ID = 2");
		System.out.println("**Please select wether you want (1 -SAVINGS for , 2 - for CHECKING or 3- To Log Out. ) **");
		Scanner start = new Scanner(System.in);
		String startdecision = start.nextLine();
		System.out.println("Hello, you chose :  " + startdecision);
	switch(startdecision) {
		case "1" :
			System.out.println("You selected WEBBYS - **SAVINGS** account. Account_ID 3");
			webbySavingsSelectSeven(usersDao);
		break;
		case "2" :
			System.out.println("You selected WEBBYS -**CHECKING **   account. Accoun_ID 4");
			webbyCheckingSelectSeven(usersDao);
		break;
		case "3" :
			System.out.println("You selected To Log Out.");
			new Bank().run();

		break;
		default: 
			System.err.println("You typed the wrong input! Its only 1,2,or 3!");
			WebbySelectAccount(usersDao);
			break;}
	start.close();
		return null;
	}

	private void webbySavingsSelectSeven(UsersDao usersDao) {
		System.out.println("HELLO and welcome to  **WEBBYS SAVINGS ** account...");

		System.out.println("**Please select wether you want (1-VIEW BALANCE, 2-WITHDRAW, 3-DEPOSIT , 4- TRANSFER, 5- RECEIPTS, 6- REQUEST CREDIT LINE, 7- To Log Out. **");
		Scanner start = new Scanner(System.in);
		String startdecision = start.nextLine();
		System.out.println("Hello, you chose :  " + startdecision);
	switch(startdecision) {
		case "1" :
			System.out.println("You selected VIEW BALANCE");
			try {
				init();
				Accounts e= accountService.findAccountID(3);
				System.err.println(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			webbySavingsSelectSeven(usersDao);
		break;
		case "2" :
			System.out.println("You selected WITHDRAW");
			webbySavingsWithdrawl(usersDao, null);
			webbySavingsSelectSeven(usersDao);
		break;
		case "3" :
			System.out.println("You selected DEPOSIT");
			webbySavingsDeposit(usersDao, null);
			webbySavingsSelectSeven(usersDao);

		break;
		case "4" :
			System.out.println("You selected TRANSFER");
			webbySavingsTransfer(usersDao,null);
			webbySavingsSelectSeven(usersDao);

		break;
		case "5" :
			System.out.println("You selected RECEIPTS");
			try {
				init();
				Transactions e = transactionService.getTransactionsById(3);
				System.err.println(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			webbySavingsSelectSeven(usersDao);
		break;
		case "6" :
			System.out.println("You selected REQUEST CREDIT LINE");
			webbyCreditrepot();
			webbySavingsSelectSeven(usersDao);
		break;
		case "7" :
			System.out.println("You selected To Log Out.");
			new Bank().run();

		break;
		default: 
			System.err.println("You typed the WRONG INPUT! Its only 1- 7!");
			webbySavingsSelectSeven(usersDao);
			break;}
	start.close();
		return;

	}		
	

	private void webbySavingsTransfer(UsersDao usersDao, Accounts e) {

		 System.out.println("Please select which account you would like to SEND FUNDS TO...");
			System.out.println(" ACCOUNTS :1-ERIC SV 2-ERIC CX, 4-WEBBY CX, 5- WEBBRICO SV,6-WEBBRICO CX, 7-HOME");
			 Scanner accounts = new Scanner(System.in);
			 
			 try {
			 int account = accounts.nextInt();
			 if(account == 7) {
					webbySavingsSelectSeven(usersDao);
					}
			 if(account == 3) {
				 System.err.println("ERROR,Attempted to transfer to yourself.");
					webbySavingsTransfer(usersDao, null);
					}
			 if (account ==1 || account == 2 || account==4 || account ==5 || account==6)
				 {
				 System.out.println("HOW MUCH WOULD YOU LIKE TO TRANSFER TO THEM?");
				 System.out.println("This banks max TRANSFER is $5000 at a time.");
				 Scanner amounts = new Scanner(System.in);
				 int amount = amounts.nextInt();	
				 
				 if(amount <=5000 && amount > 0 ) {
					 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + account);
			 
					init();
					
					e = accountService.withdrawlAccount(3, amount);
					System.out.println("Your new Balance after WITHDRAWL is...");
					System.err.println(e);

					e= accountService.depositAccount(account, amount);
					System.out.println("Account # "+ account + " new Balance is...");
					System.err.println(e);
					 }
				 else{
					 System.err.println("ERROR, Tried to transfer more than $5000.");
					 } 		
				 
		}}catch(InputMismatchException e1) {
			 System.err.println("ERROR, BAD INPUT TRY AGAIN.");
			 
				webbySavingsTransfer(usersDao, null);
		}
			 catch (SQLException e2) {
				 	System.out.println("SQL ERROR!");
			 	e2.printStackTrace();
				 webbySavingsSelectSeven(usersDao);

			 }}	
	

	private void webbyCheckingSelectSeven(UsersDao usersDao) {
		System.out.println("HELLO and welcome to  **WEBBYS CHECKING** account...");

		System.out.println("**Please select wether you want (1-VIEW BALANCE, 2-WITHDRAW, 3-DEPOSIT , 4- TRANSFER, 5- RECEIPTS, 6- REQUEST CREDIT LINE, 7- To Log Out. **");
		Scanner start = new Scanner(System.in);
		String startdecision = start.nextLine();
		System.out.println("Hello, you chose :  " + startdecision);
	switch(startdecision) {
		case "1" :
			System.out.println("You selected VIEW BALANCE");
			try {
				init();
				Accounts e= accountService.findAccountID(4);
				System.out.println(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			webbyCheckingSelectSeven(usersDao);
		break;
		case "2" :
			System.out.println("You selected WITHDRAWAL");
			ericCheckingWithdrawl(usersDao,null);
			webbyCheckingSelectSeven(usersDao);
		break;
		case "3" :
			System.out.println("You selected DEPOSIT");
			webbyCheckingDeposit(usersDao, null);
			webbyCheckingSelectSeven(usersDao);

		break;
		case "4" :
			System.out.println("You selected TRANSFER");
			webbyCheckingTransfer(usersDao, null);
			webbyCheckingSelectSeven(usersDao);

		break;
		case "5" :
			System.out.println("You selected RECEIPTS");
			try {
				init();
				Transactions e = transactionService.getTransactionsById(4);
				System.err.println(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			webbyCheckingSelectSeven(usersDao);
		break;
		case "6" :
			System.out.println("You selected REQUEST CREDIT LINE");
			webbyCreditrepot();
			webbyCheckingSelectSeven(usersDao);
		break;
		case "7" :
			System.out.println("You selected To Log Out.");
			new Bank().run();

		break;
		default: 
			System.err.println("You typed the WRONG INPUT! Its only 1- 7!");
			webbyCheckingSelectSeven(usersDao);
			break;}
	start.close();
		return;

	}	
	
	
	
	 private void webbyCheckingTransfer(UsersDao usersDao, Accounts e) {

		 System.out.println("Please select which account you would like to SEND FUNDS TO...");
			System.out.println(" ACCOUNTS :1-ERIC SV 2-ERIC CX, 3-WEBBY SV, 5- WEBBRICO SV,6-WEBBRICO CX, 7-HOME");
			 Scanner accounts = new Scanner(System.in);
			 
			 try {
			 int account = accounts.nextInt();
			 if(account == 7) {
					webbyCheckingSelectSeven(usersDao);
					}
			 if(account == 4) {
				 System.err.println("ERROR,Attempted to transfer to yourself.");
					webbyCheckingTransfer(usersDao, null);
					}
			 if (account ==1 || account == 2 || account==3|| account ==5 || account==6)
				 {
				 System.out.println("HOW MUCH WOULD YOU LIKE TO TRANSFER TO THEM?");
				 System.out.println("This banks max TRANSFER is $5000 at a time.");
				 Scanner amounts = new Scanner(System.in);
				 int amount = amounts.nextInt();	
				 
				 if(amount <=5000 && amount > 0 ) {
					 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + account);
			 
					init();
					
					e = accountService.withdrawlAccount(3, amount);
					System.out.println("Your new Balance after WITHDRAWL is...");
					System.err.println(e);

					e= accountService.depositAccount(account, amount);
					System.out.println("Account # "+ account + " new Balance is...");
					System.err.println(e);
					 }
				 else{
					 System.err.println("ERROR, Tried to transfer more than $5000.");
					 } 		
				 
		}}catch(InputMismatchException e1) {
			 System.err.println("ERROR, BAD INPUT TRY AGAIN.");
			 
				webbyCheckingTransfer(usersDao, null);
		}
			 catch (SQLException e2) {
				 	System.out.println("SQL ERROR!");
			 	e2.printStackTrace();
				 webbyCheckingSelectSeven(usersDao);

			 }}			
	
	private void init() throws SQLException {
	    	ConnectionUtil connectionUtil = new ConnectionUtil("jdbc:postgresql://project0.cibaheitjalc.us-east-2.rds.amazonaws.com:5432/Project_0",
	    	"webbadmin", "password", new org.postgresql.Driver());
	    	accountDao = new AccountDao (connectionUtil);
	    	 accountService = new AccountService (accountDao);
	    	 transactionDao = new TransactionsDao(connectionUtil);
	    	 transactionService = new TransactionsService(transactionDao);
	    	 }   
	
	
		public void findAccountByID(int a) {
			accountService.findAccountID(a);
		}
		
//		public void withdrwalByAccountID(int a) {
//			accountService.withdrawlAccount(a, a);}
		 
		 
			//WEBBYS SAVINGS WITHDRAWL METHOD
			 public void webbySavingsWithdrawl(UsersDao usersDao, Accounts e) {
				 
			 System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAWL ?");
			 System.out.println("This banks max withdrawl is $500 at a time.");
			 Scanner withdrawl = new Scanner(System.in);
			 try {	 
			 int withdrawlAmount = withdrawl.nextInt();	
			 System.out.println("Hello, you chose to withdrawl the amount of... :  $" + withdrawlAmount);
			 
			 // CAN NTO SPEND WHAT YOU DONT HAVE + WITHDRAW LIMIT
			 if (withdrawlAmount >=0 && withdrawlAmount <=500 ) {
			  	
				 //Connects to ACCOUNTS DAO-SERVICE and CONNECTIONUTIL
				 init();
				 //WITHDRAWL For WEBBYS SAVINGS ACCOUNT#3 <- 
			 	 e= accountService.withdrawlAccount(3, withdrawlAmount);
			 	System.err.println(e);
			 }else {
				 	System.err.println("You typed an incorrect input either more than $500 or not even a number! :)");
				 	webbySavingsSelectSeven(usersDao);
			 }
			 }
			 catch (InputMismatchException e2) {
				 System.err.println("You typed an incorrect input either to much or not even a number! :)");
				 	webbySavingsSelectSeven(usersDao);}
			 catch (SQLException e1) {
				 	System.out.println("SQL ERROR!");
			 	e1.printStackTrace();
			 	webbySavingsSelectSeven(usersDao);
			 }}
			 
		//WEBBY CHECKINGS WITHDRAWL METHOD
		 public void ericCheckingWithdrawl(UsersDao usersDao, Accounts e) {
			 
		 System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAWL ?");
		 System.out.println("This banks max withdrawal is $500 at a time.");
		 Scanner withdrawl = new Scanner(System.in);
		 try {	 
		 int withdrawlAmount = withdrawl.nextInt();	
		 System.out.println("Hello, you chose to withdrawl the amount of... :  $" + withdrawlAmount);
		 
		 // CAN NTO SPEND WHAT YOU DONT HAVE + WITHDRAW LIMIT
		 if (withdrawlAmount >=0 && withdrawlAmount <=500 ) {
		  	
			 //Connects to ACCOUNTS DAO-SERVICE and CONNECTIONUTIL
			 init();
			 //WITHDRAWL For WEBBYS CHECKING ACCOUNT#4 
		 	 e= accountService.withdrawlAccount(4, withdrawlAmount);
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $500 or not even a number! :)");
			 	webbyCheckingSelectSeven(usersDao);}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			webbyCheckingSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
			 webbyCheckingSelectSeven(usersDao);

		 }}
		 
		//WEBBY SAVINGS DEPOSIT METHOD
		 public void webbySavingsDeposit(UsersDao usersDao, Accounts e) {
		 System.out.println("HOW MUCH WOULD YOU LIKE TO DEPOSIT ?");
		 System.out.println("This banks max deposit is $5000 at a time.");
		 Scanner deposit = new Scanner(System.in);
		 try {	 
		 int depositAmount = deposit.nextInt();	
		 System.out.println("Hello, you chose to deposit the amount of... :  $" + depositAmount);
		 
		 // Deposit more then 0$ less then 5000.
		 if (depositAmount >=0 && depositAmount <=5000 ) {
		  	
			 //Connects to ACCOUNTS DAO-SERVICE and CONNECTIONUTIL
			 init();
			 //WITHDRAWL For WEBBYS SAVINGS ACCOUNT#3 <- 
		 	 e= accountService.depositAccount(3, depositAmount);
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $5000 or not even a number! :)");
			 	webbySavingsSelectSeven(usersDao);
			 	}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			 	webbySavingsSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
			webbySavingsSelectSeven(usersDao);

		 }}


		//ERICS Checking DEPOSIT METHOD
			 public void webbyCheckingDeposit(UsersDao usersDao, Accounts e) {
			 System.out.println("HOW MUCH WOULD YOU LIKE TO DEPOSIT ?");
			 System.out.println("This banks max deposit is $5000 at a time.");
			 Scanner deposit = new Scanner(System.in);
			 try {	 
			 int depositAmount = deposit.nextInt();	
			 System.out.println("Hello, you chose to deposit the amount of... :  $" + depositAmount);
			 
			 // Deposit more then 0$ less then 5000.
			 if (depositAmount >=0 && depositAmount <=5000 ) {
			  	
				 //Connects to ACCOUNTS DAO-SERVICE and CONNECTIONUTIL
				 init();
				 //WITHDRAWL For WEBBY CHECKING ACCOUNT#4 <- 
			 	 e= accountService.depositAccount(4, depositAmount);
			 	System.err.println(e);
			 }else {
				 	System.err.println("You typed an incorrect input either more than $5000 or not even a number! :)");
				 	webbyCheckingSelectSeven(usersDao);
				 	}}
			 catch (InputMismatchException e2) {
				 System.err.println("You typed an incorrect input either to much or not even a number! :)");
				 	webbyCheckingSelectSeven(usersDao);
			 }
			 catch (SQLException e1) {
				 	System.out.println("SQL ERROR!");
			 	e1.printStackTrace();
			 	webbyCheckingSelectSeven(usersDao);

			 }}
			 
			 private void webbyCreditrepot() {
				 System.err.println("PLEASE WAIT WHILE WE REVIEW YOUR CREDIT...");
					try {
						init();
						accountService.requestCredit(2);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		 
		}
		 

	
