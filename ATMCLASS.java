package ATMJerryJia;
import java.util.Scanner;

public class ATMCLASS {
	static String accountNum = "Justin";  // the account number
	static int accountPin = 1234; // the valid pin
	static Scanner userInputAccount = new Scanner(System.in);
	static Scanner userInputPin = new Scanner(System.in);
	static int balance = 10000; // the global var for default balance
	static Scanner userInputChoise = new Scanner(System.in);
	static Scanner userInputDeposit = new Scanner(System.in);
	static Scanner userInputBalance = new Scanner(System.in);
	static Scanner userInputWithdraw = new Scanner(System.in);
	static int choiseInput = 0;
	static int restartProgramCheck = 0;
	static String userChoice = "no" ;
	static Scanner userInputWhetherAgain = new Scanner(System.in);
	/* All the other are the Scanner looking for user's input*/
	
	public static void main(String [] args){      // the main class
		
		String accountInput = "";
		int pinInput = 0;
		int countAccount = 0;
		int countPin = 0;
		while(countAccount ==0) {
			System.out.println("Welcome to Jia's ATM \n Please enter your username: ");
			accountInput = userInputAccount.nextLine();
			countAccount = CheckAccount(accountInput);		
			}
		System.out.println("Thanks!");
		while(countPin ==0) {
			System.out.println("Please enter your pin sir :" );
			pinInput = userInputPin.nextInt();
			countPin = CheckPin(pinInput);
		}
		System.out.println("Welcome! Justin. ");
		do {
			enterStartAgain();
			System.out.println("Is there anything else you want to do ?  \n Enter 'yes' or 'no' please :");
			userChoice = userInputWhetherAgain.nextLine();
			if(userChoice.equals("yes")){
				continue;
			}
			else if (userChoice.equals("no")) {
				System.out.println("Thank you for using Jia's ATM. I will see you next time! ");
				break;
			}
			else {
				System.out.println("Sorry, I cannot understand you. See you next time !" );
				break;
			}
		}while(restartProgramCheck == 0);
	}
	
	public static void enterStartAgain() {    // a class which can call withdraw, deposit, and check balance
		System.out.println("What do you want to do Mr. Kutscherousky? Press 1 to withdraw, 2 to deposit, and 3 to check your balance :");
		choiseInput = userInputChoise.nextInt();
		while(restartProgramCheck == 0) {
			if(choiseInput == 1) {
				restartProgram(1);
				choiseInput =+3;
				break;
			}
			else if (choiseInput ==2) {
				restartProgram(2);
				break;
			}
			else if(choiseInput ==3) {
				restartProgram(3);
				break;
				}				
			break;	
		}
			
		}
		
	public static void restartProgram(int Num) {  // the withdraw class
		choiseInput = Num;
		while(Num ==1) {
		int withdrawCheck = 0 ;
		int withdrawInput = 0;
			while (withdrawCheck ==0){
			choiseInput =+3;
			System.out.println("How much do you wish to withdraw : ");
			withdrawInput = userInputWithdraw.nextInt();
				if (withdrawInput <= balance) {
					withdrawCheck ++;
					balance -= withdrawInput;
					System.out.println("Congrats! Now the amount of money in your account is : " + balance);
					break;
					}
				else if(withdrawInput > balance) {
					System.out.println("Sorry, you cannot withdraw more than you have. ");
				}
			}
			break;
		}// The loop when Num = 1
		while(Num ==2) {   // the deposit class
			int depositCheck =0;
			int depositInput = 0;
			while(depositCheck == 0) {
				System.out.println("How much do you wish to deposit : ");
				depositInput = userInputDeposit.nextInt();
				balance += depositInput;
				System.out.println("Congrats! Now the amount of Money in your account is :" + balance);
				depositCheck++;
			}
			break;
		}// The loop when Num = 2
		while(Num ==3) {   // check balance class
			System.out.println("Your balance in your account is :" + balance);
			break;
		}
	}
	public static int CheckAccount(String Account) {    // check account
		if(Account.equals(accountNum)) {
			return -1;
		}
		else {
			return 0;
		}
	}
 	public static int CheckPin(int Pin) {   //check pin
		if(Pin == accountPin) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
