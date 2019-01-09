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

public class WEBBRICO {
	
	ConnectionUtil connectionUtil;
	AccountService accountService;
	AccountDao accountDao;
	TransactionsService transactionService;
	TransactionsDao transactionDao;
	
	
	 void TestWEBBRICOPassword(UsersDao usersDao) {
			System.out.println("Please enter your password for WEBBRICOs ACCOUNT...");
			Scanner Estart = new Scanner(System.in);
			String startdecision = Estart.nextLine();
			switch (startdecision) {
			
			case "WEBBRICO" :{
				System.err.println("CORRRECT PASSWORD! Now Logging into WEBBRICOs account...");

				UsersDao WEBBRICO = new UsersDao();
				WebbricoSelectAccount(WEBBRICO);
			}
			break;
			case "EXIT" :{
				Bank webbrico = new Bank();
				webbrico.run();
			}
			break;
			default: {
				System.err.println("WRONG PASSWORD, please try again or type EXIT");
				TestWEBBRICOPassword(usersDao);
			}
			}
			Estart.close();
		}
	 
	 
		public String WebbricoSelectAccount(UsersDao usersDao) {
			System.out.println("You Selected to login as WEBBRICO : USER_ID = 3");
			System.out.println("**Please select which **ACCOUNT** you want (1 - for SAVINGS, 2 - for CHECKING or 3- To Log Out. )");
			Scanner start = new Scanner(System.in);
			String startdecision = start.nextLine();
			System.out.println("Hello, you chose :  " + startdecision);
		switch(startdecision) {
			case "1" :
				System.out.println("You selected WEBBRICO - **SAVINGS** account. Account_ID 5");
				
				webbricoSavingsSelectSeven(usersDao);
			break;
			case "2" :
				System.out.println("You selected WEBBRICO - **CHECKING **   account. Accoun_ID 6");
				webbricoCheckingSelectSeven(usersDao);
			break;
			case "3" :
				System.out.println("You selected To Log Out.");
				new Bank().run();
			break;
			default: 
				System.err.println("You typed the wrong input! Its only 1,2,or 3!");
				WebbricoSelectAccount(usersDao);
				break;}
		start.close();
			return null;
			
			
			
		}


		private void webbricoSavingsSelectSeven(UsersDao usersDao) {
			System.out.println("HELLO and welcome to  **WEBBRICOS SAVINGS ** account...");

			System.out.println("**Please select wether you want (1-VIEW BALANCE, 2-WITHDRAW, 3-DEPOSIT , 4- TRANSFER, 5- RECEIPTS, 6- REQUEST CREDIT LINE, 7- To Log Out. **");
			Scanner start = new Scanner(System.in);
			String startdecision = start.nextLine();
			System.out.println("Hello, you chose :  " + startdecision);
		switch(startdecision) {
			case "1" :
				System.out.println("You selected VIEW BALANCE");
				try {
					init();
					Accounts e= accountService.findAccountID(5);
					System.err.println(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				webbricoSavingsSelectSeven(usersDao);
			break;
			case "2" :
				System.out.println("You selected WITHDRAWAL");
				webbricoSavingsWithdrawl(usersDao, null);
				webbricoSavingsSelectSeven(usersDao);
			break;
			case "3" :
				System.out.println("You selected DEPOSIT");
				webbricoSavingsDeposit(usersDao, null);
				webbricoSavingsSelectSeven(usersDao);
				
	
			break;
			case "4" :
				System.out.println("You selected TRANSFER");
				webbricoSavingsTransfer(usersDao, null);
				webbricoSavingsSelectSeven(usersDao);
	
			break;
			case "5" :
				System.out.println("You selected RECEIPTS");
				try {
					init();
					Transactions e = transactionService.getTransactionsById(5);
					System.err.println(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				webbricoSavingsSelectSeven(usersDao);
			break;
			case "6" :
				System.out.println("You selected REQUEST CREDIT LINE");
				webbyCreditrepot();
				webbricoSavingsSelectSeven(usersDao);
			break;
			case "7" :
				System.out.println("You selected To Log Out.");
				new Bank().run();
	
			break;
			default: 
				System.err.println("You typed the WRONG INPUT! Its only 1- 7!");
				webbricoSavingsSelectSeven(usersDao);
				break;}
		start.close();
			return;
	
		}
	

		private void webbricoSavingsTransfer(UsersDao usersDao, Accounts e) {
			 System.out.println("Please select which account you would like to SEND FUNDS TO...");
				System.out.println(" ACCOUNTS :1-ERIC SV, 2-ERIC CX, 3- WEBBY SV, 4-WEBBY CX, 6-WEBBRICO CX, 7-HOME");
				 Scanner accounts = new Scanner(System.in);
				 
				 try {
				 int account = accounts.nextInt();
				 if(account == 7) {
						webbricoSavingsSelectSeven(usersDao);
						}
				 if(account == 5) {
					 System.err.println("ERROR,Attempted to transfer to yourself.");
						webbricoSavingsTransfer(usersDao, null);
						}
				 if (account ==1 || account == 2 || account==4 || account ==3 || account==6)
					 {
					 System.out.println("HOW MUCH WOULD YOU LIKE TO TRANSFER TO THEM?");
					 System.out.println("This banks max TRANSFER is $5000 at a time.");
					 Scanner amounts = new Scanner(System.in);
					 int amount = amounts.nextInt();	
					 
					 if(amount <=5000 && amount > 0 ) {
						 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + account);
				 
						init();
						
						e = accountService.withdrawlAccount(5, amount);
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
				 
					webbricoSavingsTransfer(usersDao, null);
			}
				 catch (SQLException e2) {
					 	System.out.println("SQL ERROR!");
				 	e2.printStackTrace();
					 webbricoSavingsSelectSeven(usersDao);

				 }}				
		
		private void webbricoCheckingSelectSeven(UsersDao usersDao) {
			System.out.println("HELLO and welcome to  **WEBBRICOS CHECKING ** account...");
			System.out.println("**Please select wether you want (1-VIEW BALANCE, 2-WITHDRAW, 3-DEPOSIT , 4- TRANSFER, 5- RECEIPTS, 6- REQUEST CREDIT LINE, 7- Go HOME. **");
			Scanner start = new Scanner(System.in);
			String startdecision = start.nextLine();
			System.out.println("Hello, you chose :  " + startdecision);
		switch(startdecision) {
			case "1" :
				System.out.println("You selected VIEW BALANCE");
				try {
					init();
					Accounts e= accountService.findAccountID(6);
					System.err.println(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				webbricoCheckingSelectSeven(usersDao);
			break;
			case "2" :
				System.out.println("You selected WITHDRAW");
				webbricoCheckingWithdrawl(usersDao, null);
				webbricoCheckingSelectSeven(usersDao);
			break;
			case "3" :
				System.out.println("You selected DEPOSIT");
				webbricoCheckingDeposit(usersDao, null);

				webbricoCheckingSelectSeven(usersDao);
	
			break;
			case "4" :
				System.out.println("You selected TRANSFER");
				webbricoCheckingTransfer(usersDao, null);
				webbricoCheckingSelectSeven(usersDao);
	
			break;
			case "5" :
				System.out.println("You selected RECEIPTS");
				try {
					init();
					Transactions e = transactionService.getTransactionsById(6);
					System.err.println(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				webbricoCheckingSelectSeven(usersDao);
			break;
			case "6" :
				System.out.println("You selected REQUEST CREDIT LINE");
				webbyCreditrepot();
				webbricoCheckingSelectSeven(usersDao);
			break;
			case "7" :
				System.out.println("You selected To Log Out.");
				new Bank().run();
	
			break;
			default: 
				System.err.println("You typed the WRONG INPUT! Its only 1- 7!");
				webbricoCheckingSelectSeven(usersDao);
				break;}
		start.close();
			return;
	
		}	
		
		private void webbricoCheckingTransfer(UsersDao usersDao, Accounts e) {
			 System.out.println("Please select which account you would like to SEND FUNDS TO...");
				System.out.println(" ACCOUNTS :1-ERIC SV, 2-ERIC CX, 3- WEBBY SV, 4-WEBBY CX, 5-WEBBRICO SV, 7-HOME");
				 Scanner accounts = new Scanner(System.in);
				 
				 try {
				 int account = accounts.nextInt();
				 if(account == 7) {
						webbricoCheckingSelectSeven(usersDao);
						}
				 if(account == 6) {
					 System.err.println("ERROR,Attempted to transfer to yourself.");
						webbricoCheckingTransfer(usersDao, null);
						}
				 if (account ==1 || account == 2 || account==4 || account ==3 || account==5)
					 {
					 System.out.println("HOW MUCH WOULD YOU LIKE TO TRANSFER TO THEM?");
					 System.out.println("This banks max TRANSFER is $5000 at a time.");
					 Scanner amounts = new Scanner(System.in);
					 int amount = amounts.nextInt();	
					 
					 if(amount <=5000 && amount > 0 ) {
						 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + account);
				 
						init();
						
						e = accountService.withdrawlAccount(6, amount);
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
				 
					webbricoCheckingTransfer(usersDao, null);
			}
				 catch (SQLException e2) {
					 	System.out.println("SQL ERROR!");
				 	e2.printStackTrace();
					 webbricoCheckingSelectSeven(usersDao);

				 }}				

		public void findAccountByID(int a) {
			accountService.findAccountID(a);
		}
		
		 private void init() throws SQLException {
		    	ConnectionUtil connectionUtil = new ConnectionUtil("jdbc:postgresql://project0.cibaheitjalc.us-east-2.rds.amazonaws.com:5432/Project_0",
		    	"webbadmin", "password", new org.postgresql.Driver());
		    	accountDao = new AccountDao (connectionUtil);
		    	 accountService = new AccountService (accountDao);
		    	 transactionDao = new TransactionsDao(connectionUtil);
		    	 transactionService = new TransactionsService(transactionDao);}   
		
			//WEBBRICOS SAVINGS WITHDRAWL METHOD
		 public void webbricoSavingsWithdrawl(UsersDao usersDao, Accounts e) {
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
			 //WITHDRAWL For WEBBRICOS SAVINGS ACCOUNT#5 <- 
		 	 e= accountService.withdrawlAccount(5, withdrawlAmount);
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $500 or not even a number! :)");
				 webbricoSavingsSelectSeven(usersDao);
			 	}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			 webbricoSavingsSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
			 webbricoSavingsSelectSeven(usersDao);

		 }}
		 
	//WEBBRICOS CHECKINGS WITHDRAWL METHOD
	 public void webbricoCheckingWithdrawl(UsersDao usersDao, Accounts e) {
	 System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAWA L ?");
	 System.out.println("This banks max withdrawl is $500 at a time.");
	 Scanner withdrawl = new Scanner(System.in);
	 try {	 
	 int withdrawlAmount = withdrawl.nextInt();	
	 System.out.println("Hello, you chose to withdrawl the amount of... :  $" + withdrawlAmount);
	 
	 // CAN NTO SPEND WHAT YOU DONT HAVE + WITHDRAW LIMIT
	 if (withdrawlAmount >=0 && withdrawlAmount <=500 ) {
	  	
		 //Connects to ACCOUNTS DAO-SERVICE and CONNECTIONUTIL
		 init();
		 //WITHDRAWL For WEBBRICOS CHECKING ACCOUNT#6 
	 	 e= accountService.withdrawlAccount(6, withdrawlAmount);
	 	System.err.println(e);
	 }else {
		 	System.err.println("You typed an incorrect input either more than $500 or not even a number! :)");
		 	webbricoCheckingSelectSeven(usersDao);}}
	 catch (InputMismatchException e2) {
		 System.err.println("You typed an incorrect input either to much or not even a number! :)");
		webbricoCheckingSelectSeven(usersDao);
	 }
	 catch (SQLException e1) {
		 	System.out.println("SQL ERROR!");
	 	e1.printStackTrace();
		 webbricoCheckingSelectSeven(usersDao);

	 }}
	 private void webbricoSavingsDeposit(UsersDao usersDao, Accounts e) {
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
			 //WITHDRAWL For ERICS SAVINGS ACCOUNT#5 <- 
		 	 e= accountService.depositAccount(5, depositAmount);
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $5000 or not even a number! :)");
			 	webbricoSavingsSelectSeven(usersDao);
			 	}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			 	webbricoSavingsSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
		 	webbricoSavingsSelectSeven(usersDao);

		 }}			
	
	 private void webbricoCheckingDeposit(UsersDao usersDao, Accounts e) {
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
			 //WITHDRAWL For ERICS SAVINGS ACCOUNT#6 <- 
		 	 e= accountService.depositAccount(6, depositAmount);
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $5000 or not even a number! :)");
			 	webbricoCheckingSelectSeven(usersDao);
			 	}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			 	webbricoCheckingSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
		 	webbricoCheckingSelectSeven(usersDao);

		 }}		
	 private void webbyCreditrepot() {
		 System.err.println("PLEASE WAIT WHILE WE REVIEW YOUR CREDIT...");
			try {
				init();
				accountService.requestCredit(3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

	 
		
		
		


	
	 
	
