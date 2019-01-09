package Pojos;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.omg.IOP.TransactionService;

import Data.AccountDao;
import Data.TransactionsDao;
import Data.UsersDao;
import Exceptions.InvalidAccountException;
import Services.AccountService;
import Services.TransactionsService;
import Utility.ConnectionUtil;

public class ERIC {
	ConnectionUtil connectionUtil;
	AccountService accountService;
	AccountDao accountDao;
	TransactionsService transactionService;
	TransactionsDao transactionDao;
	
	
	
	//TEST ERICS PASSWORD
	void TestEricPassword(UsersDao usersDao) {
		System.out.println("Please enter your password for ERICs ACCOUNT...");
		Scanner Estart = new Scanner(System.in);
		String startdecision = Estart.nextLine();
		switch (startdecision) {
		
		case "ERIC" :{
			System.err.println("CORRRECT PASSWORD! Now Logging into ERICs account...");
			try {
			EricSelectAccount(usersDao);
			}catch(InvalidAccountException e) {
				
				System.err.println("Invalid Eric Account type CUSTOM Exception..");
				System.err.println("Please type 1,2 or 3! Please try again!");
			

				try {
					EricSelectAccount(usersDao);
				} catch (InvalidAccountException e1) {
					;

				}
			}
		}
		break;
		case "EXIT" :{
			Bank eric = new Bank();
			eric.run(startdecision);
		}
		break;
		default: {
			System.err.println("WRONG PASSWORD, please try again or type EXIT");
			TestEricPassword(usersDao);
		}
		}
		Estart.close();
	}
	
	//SELECT SAVINGS OR CHECKINGS
	@SuppressWarnings("resource")
	public void EricSelectAccount (UsersDao usersDao) throws InvalidAccountException {
		System.out.println("You Selected to login as ERIC : USER_ID = 1");
		System.out.println("**Please select which **ACCOUNT** you want (1 - for SAVINGS, 2 - for CHECKING or 3- To Log Out. ) **");
		Scanner start = new Scanner(System.in);
		String startdecision = start.nextLine();
		System.out.println("Hello, you chose :  " + startdecision);
	switch(startdecision) {
		case "1" :
			System.out.println("You selected ERICS - **SAVINGS ** account. Account_ID 1");		
			ericSavingsSelectSeven(usersDao);

		break;
		case "2" :
			System.out.println("You selected ERICS - **CHECKINGS**  account. Accoun_ID 2");
			ericCheckingSelectSeven(usersDao);

		break;
		case "3" :
			System.out.println("You selected To Log Out.");
			new Bank().run();

			break;
		default: 

			throw new InvalidAccountException();

			

			}
	start.close();
		return;
	}

//ERICS SAVINGS ACCOUNT#1 SELECT SEVEN
	private void ericSavingsSelectSeven(UsersDao usersDao) {
			System.out.println("HELLO and welcome to  **ERICS SAVINGS ** account...");
			System.out.println("**Please select wether you want (1-VIEW BALANCE, 2-WITHDRAW, 3-DEPOSIT , 4- TRANSFER, 5- RECEIPTS, 6- REQUEST CREDIT LINE, 7- To Log Out. **");
			Scanner start = new Scanner(System.in);
			String startdecision = start.nextLine();
			System.out.println("Hello, you chose :  " + startdecision);
			

		switch(startdecision) {
			case "1" :
				System.out.println("You selected VIEW BALANCE");
				try {
					init();
					Accounts e= accountService.findAccountID(1);
					System.err.println(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ericSavingsSelectSeven(usersDao);
			break;
			case "2" :
				System.out.println("You selected WITHDRAWAL");
				ericSavingsWithdrawl(usersDao, null);
				ericSavingsSelectSeven(usersDao);
			break;
			case "3" :
				System.out.println("You selected DEPOSIT");
				ericSavingsDeposit(usersDao, null);
				ericSavingsSelectSeven(usersDao);

			break;
			case "4" :
				System.out.println("You selected TRANSFER");
				ericSavingsTransfer(usersDao, null);
				ericSavingsSelectSeven(usersDao);

				break;
			case "5" :
				System.out.println("You selected RECEIPTS");
//				ericSavingsReceipts(1);
				try {
					init();
					Transactions e = transactionService.getTransactionsById(1);
					System.err.println(e);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
//				ericSavingsReceipts(1);
				ericSavingsSelectSeven(usersDao);
		

				
			break;
			case "6" :
				System.out.println("You selected REQUEST CREDIT LINE");
				ericCreditrepot(1);				
				ericSavingsSelectSeven(usersDao);
			break;
			case "7" :
				System.out.println("You selected To Log Out..");
				new Bank().run();

			break;
			default: 
				System.err.println("You typed the WRONG INPUT! Its only 1- 7!");
				ericSavingsSelectSeven(usersDao);
				break;}
		
		start.close();
			return;

		}	
	
	private void ericCheckingSelectSeven(UsersDao usersDao) {
		System.out.println("HELLO and welcome to  **ERICS CHECKING ** account...");
		System.out.println("**Please select wether you want (1-VIEW BALANCE, 2-WITHDRAW, 3-DEPOSIT , 4- TRANSFER, 5- RECEIPTS, 6- REQUEST CREDIT LINE, 7- To Log Out. **");
		Scanner start = new Scanner(System.in);
		String startdecision = start.nextLine();
		System.out.println("Hello, you chose :  " + startdecision);
	switch(startdecision) {
		case "1" :
			System.out.println("You selected VIEW BALANCE");
			
		try {
			init();
			//ERICS CHECKING BALANCE			
			Accounts e= accountService.findAccountID(2);
			System.out.println(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			ericCheckingSelectSeven(usersDao);
		break;
		case "2" :
			System.out.println("You selected WITHDRAW");
			//ERICS CHECKING METHOD
			ericCheckingWithdrawl1(usersDao, null);
			ericCheckingSelectSeven(usersDao);
		break;
		case "3" :
			System.out.println("You selected DEPOSIT");
			ericCheckingDeposit(usersDao, null);
			ericCheckingSelectSeven(usersDao);

		break;
		case "4" :
			System.out.println("You selected TRANSFER");
			ericCheckingTransfer(usersDao, null);
			ericCheckingSelectSeven(usersDao);
	
		break;
		case "5" :
			System.out.println("You selected RECEIPTS");
			try {
				init();
				Transactions e = transactionService.getTransactionsById(2);
				System.err.println(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ericCheckingSelectSeven(usersDao);
		break;
		case "6" :
			System.out.println("You selected REQUEST CREDIT LINE");
			ericCreditrepot(1);
			ericCheckingSelectSeven(usersDao);
		break;
		case "7" :
			System.out.println("You selected To Log Out..");
			new Bank().run();

		break;
		default: 
			System.out.println("You typed the WRONG INPUT! Its only 1- 7!");
			ericCheckingSelectSeven(usersDao);
			break;}
	start.close();
		return;

	}
	
	private void ericCheckingTransfer(UsersDao usersDao, Accounts e) {
		 System.out.println("Please select which account you would like to SEND FUNDS TO...");
			System.out.println(" ACCOUNTS : 1-ERIC SV, 3- WEBBY SV, 4-WEBBY CX, 5- WEBBRICO SV,6-WEBBRICO CX, 7-HOME");
			 Scanner accounts = new Scanner(System.in);
			 
			 try {
			 int account = accounts.nextInt();
			 if(account == 7) {
					ericCheckingSelectSeven(usersDao);
					}
			 if(account == 2) {
				 System.err.println("ERROR,Attempted to transfer to yourself.");
					ericCheckingTransfer(usersDao, null);
					}
			 if (account ==1 || account ==3 || account==4 || account ==5 || account==6)
				 {
				 System.out.println("HOW MUCH WOULD YOU LIKE TO TRANSFER TO THEM?");
				 System.out.println("This banks max TRANSFER is $5000 at a time.");
				 Scanner amounts = new Scanner(System.in);
				 int amount = amounts.nextInt();	
				 
				 if(amount <=5000 && amount > 0 ) {
					 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + account);
			 
					init();
					
					e = accountService.withdrawlAccount(2, amount);
					System.out.println("Your new Balance after WITHDRAWL is...");
					System.err.println(e);

					e= accountService.depositAccount(account, amount);
					System.out.println("Account # "+ account + " new Balance is...");
					System.err.println(e);
					 }
				 else{
					 System.err.println("ERROR, Tried to transfer more than $5000.");
						ericCheckingTransfer(usersDao, null);
	 
				 } 		
				 
		}}catch(InputMismatchException e1) {
			 System.err.println("ERROR, BAD INPUT TRY AGAIN.");
				ericCheckingTransfer(usersDao, null);
		}
			 catch (SQLException e2) {
				 	System.out.println("SQL ERROR!");
			 	e2.printStackTrace();
				ericCheckingTransfer(usersDao, null);

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
	    	 transactionService = new TransactionsService(transactionDao);
	    	 }   
	
	 private void ericSavingsTransfer(UsersDao usersDao, Accounts e) {

			 System.out.println("Please select which account you would like to SEND FUNDS TO...");
				System.out.println(" ACCOUNTS : 2-ERIC CX, 3- WEBBY SV, 4-WEBBY CX, 5- WEBBRICO SV,6-WEBBRICO CX, 7-HOME");
				 Scanner accounts = new Scanner(System.in);
				 
				 try {
				 int account = accounts.nextInt();
				 if(account == 7) {
						ericSavingsSelectSeven(usersDao);}
				 if(account == 1) {
					 System.err.println("ERROR,Attempted to transfer to yourself.");
						ericSavingsTransfer(usersDao, null);}
				 if (account ==2 || account ==3 || account==4 || account ==5 || account==6)
					 {
					 System.out.println("HOW MUCH WOULD YOU LIKE TO TRANSFER TO THEM?");
					 System.out.println("This banks max TRANSFER is $5000 at a time.");
					 Scanner amounts = new Scanner(System.in);
					 int amount = amounts.nextInt();	
					 
					 if(amount <=5000 && amount > 0 ) {
						 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + account);
				 
						init();
						
						e = accountService.withdrawlAccount(1, amount);
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
				 
				 ericSavingsTransfer( usersDao, null);			
			}
				 catch (SQLException e2) {
					 	System.out.println("SQL ERROR!");
				 	e2.printStackTrace();
					 ericSavingsSelectSeven(usersDao);

				 }}
	 
	//ERICS SAVINGS WITHDRAWL METHOD
	 public void ericSavingsWithdrawl(UsersDao usersDao, Accounts e) {
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
			 
			 //WITHDRAWL For ERICS SAVINGS ACCOUNT#1 <- 
		 	 e= accountService.withdrawlAccount(1, withdrawlAmount);
		 	 
		 	 
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $500 or not even a number! :)");
			 	ericSavingsSelectSeven(usersDao);}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			 ericSavingsSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
			 ericSavingsSelectSeven(usersDao);

		 }}
		 
	//ERICS CHECKINGS WITHDRAWL METHOD
	 public void ericCheckingWithdrawl1(UsersDao usersDao, Accounts e) {
	 System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAWL ?");
	 System.out.println("This banks max withdrawl is $5000 at a time.");
	 Scanner withdrawl = new Scanner(System.in);
	 try {	 
	 int withdrawlAmount = withdrawl.nextInt();	
	 System.out.println("Hello, you chose to withdrawl the amount of... :  $" + withdrawlAmount);
	 
	 // CAN NTO SPEND WHAT YOU DONT HAVE + WITHDRAW LIMIT
	 if (withdrawlAmount >=0 && withdrawlAmount <=5000 ) {
	  	
		 //Connects to ACCOUNTS DAO-SERVICE and CONNECTIONUTIL
		 init();
		 //WITHDRAWL For ERICS CHECKING ACCOUNT#2 
	 	 e= accountService.withdrawlAccount(2, withdrawlAmount);
	 	System.err.println(e);
	 }else {
		 	System.err.println("You typed an incorrect input either more than $500 or not even a number! :)");
		 	ericCheckingSelectSeven(usersDao);}}
	 catch (InputMismatchException e2) {
		 System.err.println("You typed an incorrect input either to much or not even a number! :)");
		 ericCheckingSelectSeven(usersDao);
	 }
	 catch (SQLException e1) {
		 	System.out.println("SQL ERROR!");
	 	e1.printStackTrace();
		 ericCheckingSelectSeven(usersDao);

	 }}
	 
	//ERICS SAVINGS DEPOSIT METHOD
	 public void ericSavingsDeposit(UsersDao usersDao, Accounts e) {
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
		 //WITHDRAWL For ERICS SAVINGS ACCOUNT#1 <- 
	 	 e= accountService.depositAccount(1, depositAmount);
	 	System.err.println(e);
	 }else {
		 	System.err.println("You typed an incorrect input either more than $5000 or not even a number! :)");
		 	ericSavingsSelectSeven(usersDao);
		 	}}
	 catch (InputMismatchException e2) {
		 System.err.println("You typed an incorrect input either to much or not even a number! :)");
		 	ericSavingsSelectSeven(usersDao);
	 }
	 catch (SQLException e1) {
		 	System.out.println("SQL ERROR!");
	 	e1.printStackTrace();
		 ericSavingsSelectSeven(usersDao);

	 }}


	//ERICS Checking DEPOSIT METHOD
		 public void ericCheckingDeposit(UsersDao usersDao, Accounts e) {
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
			 //WITHDRAWL For ERICS SAVINGS ACCOUNT#2 <- 
		 	 e= accountService.depositAccount(2, depositAmount);
		 	System.err.println(e);
		 }else {
			 	System.err.println("You typed an incorrect input either more than $5000 or not even a number! :)");
			 	ericCheckingSelectSeven(usersDao);
			 	}}
		 catch (InputMismatchException e2) {
			 System.err.println("You typed an incorrect input either to much or not even a number! :)");
			 	ericCheckingSelectSeven(usersDao);
		 }
		 catch (SQLException e1) {
			 	System.out.println("SQL ERROR!");
		 	e1.printStackTrace();
		 	ericCheckingSelectSeven(usersDao);

		 }}
		 
		 //ERICS credit approval.
		 private void ericCreditrepot(int id) {
			 System.err.println("PLEASE WAIT WHILE WE REVIEW YOUR CREDIT...");
				try {
					init();
					accountService.requestCredit(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }}
	 
		
		 
		 
					
		
	 

	


