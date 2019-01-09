package Pojos;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Data.AccountDao;
import Data.UsersDao;
import Exceptions.InvalidAccountException;
import Exceptions.InvalidUserInputException;
import Services.AccountService;
import Services.UserService;
import Utility.ConnectionUtil;


public class Bank {
	ConnectionUtil connectionUtil;
	UsersDao usersDao;
	UserService userService;
	AccountDao accountDao;
	AccountService accountService;
	

	
public void run(String ... args) {
		try {
//Test connection to database.
			init();
			}catch (SQLException ex) {
			System.err.println("Error Starting closing app...");
			System.exit(-1);}
//Select a user ERIC, WEBB, or WEBBY.
			try {
				selectUser(usersDao);
			} catch (InvalidUserInputException e) {
				System.err.println("Invlad User Input CUSTOM EXCEPTION.");
				System.out.println("Please try again...");
				new Bank().run(args);
				
			}	}
	
 private void init() throws SQLException {
    	ConnectionUtil connectionUtil = new ConnectionUtil("jdbc:postgresql://project0.cibaheitjalc.us-east-2.rds.amazonaws.com:5432/Project_0",
    	"webbadmin", "password", new org.postgresql.Driver());
    	 usersDao = new UsersDao (connectionUtil);
    	 userService  = new UserService(usersDao);
    	System.out.println("HELLO Welcome Back!");}
   
 //Selects users
@SuppressWarnings("resource")
public void selectUser(UsersDao usersDao) throws InvalidUserInputException {
//	boolean condition = true;
//	while(condition) {
		System.out.println("Which **USER ACCOUNT** would you like to login as?");
		System.out.println("*** 1-ERIC, 2- WEBBY, 3- WEBBRICO ***");
		Scanner start = new Scanner(System.in);
		String startdecision = start.nextLine();
		System.out.println("Hello, you chose :  " + startdecision);
		switch(startdecision) {
		case "1" :
			System.out.println("You selected **ERICS** account.");
			Users a= userService.findUserID(1);
			System.err.println(a);
			ERIC eric = new ERIC ();
			eric.TestEricPassword(usersDao);
//			condition = false;

			 
		break;
		
		case "2" :
			System.out.println("You selected **WEBBYS** account.");
			Users b= userService.findUserID(2);
			System.err.println(b);
			WEBBY webby = new WEBBY();
			webby.TestWebbyPassword(usersDao);
//			condition = false;


		break;
		
		case "3" :
			System.out.println("You selected **WEBBRICOS** account.");
			Users c= userService.findUserID(3);
			System.err.println(c);
			WEBBRICO webbrico = new WEBBRICO();
			webbrico.TestWEBBRICOPassword(usersDao);
//			condition = false;

			

			break;
		default: 
			
			
			throw new InvalidUserInputException();

		}
	start.close();
	return;
	}

//Gets list of users.
public List<Users> ListAllAccounts() {
List<Users> users = userService.findAllUsers();             
if(users == null || users.size() == 0) {
    System.out.println("There are no users to browse");
} else {
    for(final Users user : users) {
        System.out.println(user);
    }}return users;}

 //Finds users by ID.
 public void findUserByID(int a) {
	 userService.findUserID(a);}
 // finds account by ID
 public void findAccountByID(int a) {
		accountService.findAccountID(a);
	}

 }

 
    


