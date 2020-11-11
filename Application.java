import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
	private static Scanner sc = new Scanner(System.in);
	 private static ArrayStack S ;
	 private static int top =0;
	public static void showComm() {
		System.out.println("Available commands");
		for (Menu comm : Menu.values()) {
			System.out.println(  comm + " "+ comm.getdescription());
		}
	}
	
	public static String getDataCaseUnsensitive(String msg) {
		return getData(msg, false);
	}
	
	public static String getData(String msg, boolean caseSensitive) {
		System.out.println(msg);
		return caseSensitive ? sc.next() : sc.next().toUpperCase();
	}
	public static void main(String[] args) {
		boolean exit = true;
		boolean stackexist = false;
		boolean empty=true;
		int max_size=0;
		while(exit) {
			
				
				try {
					System.out.println("Type Help if you want to see all the commands");
					Menu com = Menu.valueOf(getDataCaseUnsensitive("Chose a command:"));
				switch (com) {
				case ADD:
				{

							while(!stackexist)
					{
						System.out.println("Creating a new Stack...");
						System.out.println("Please input the maximum size of the Stack:");
					try{
						max_size= new Scanner(System.in).nextInt();
						if(max_size>0)
						{S= new ArrayStack(max_size);
						 S.setTop(top);
						 stackexist=true;
						}
						else
							System.out.println("Input a number above 0");
					
					}
					catch(InputMismatchException e)
					{
						System.out.println("Input a number please!");
					}
					catch(UnsupportedOperationException e)
					{
						System.out.println("Input a number please!");
					}

						
					}
					boolean adding =true;	
					while(adding)
					try{System.out.println("Input a number in the Stack");
					int number = sc.nextInt();
					S.push(number);
					
					top++;
					S.setTop(top);
					empty=false;
					System.out.println(number + " was added to the Stack");
					System.out.println("Type another number or back to go to the mainmenu");
					}
					catch(InputMismatchException e)
					{
						System.out.println("Input a number please!");
						adding=false;
						break;
					}
					
					break;
				}
				case HELP:
				{
					showComm();
					break;
				}
				case TOP:
				{
					if(empty)
						System.out.println("PLease add a number in the stack");
					else
					System.out.println("The top number on the top of the Stack is: " +S.top());
					break; 
				}
				case POP:
				{
					if(empty)
						System.out.println("The Stack is already empty!");
					else {
					S.pop();
					top--;
					S.setTop(top);
					System.out.println("The top elemnet of eliminated!");}
					break;
				}
				case QUIT:
				{
					System.out.println("Closing the aplication... ");
					exit=false;
					break;
				}
				case ISEMPTY:
				{ if(stackexist)
					System.out.println("The Stack is empty?:" + S.isEmpty());
				else
					System.out.println("Please create the Stack!");
					break;
				}
				case SIZE:
				{
					if(stackexist)
					System.out.println("The size of the Stack:"+ S.size());
					else
						System.out.println("The Stack was not created");
					break;
				}
				default:	
					{System.out.println("Invalid command!");
					showComm();
					break;
					}
					
				}
				}
				catch(IllegalArgumentException com) {
					System.out.println("Invalid command!");
				}
				finally {
					
				}
			
		}

	}

}
