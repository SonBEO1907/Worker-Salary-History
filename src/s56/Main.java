
package s56;
    
import java.util.Scanner;
    
    //To-do:
    //data class Worker : Code, Name, Age, Salary, Location
    //data class SalaryHistory: super(Worker), Status, Date
    //Function:add, up salary, down salary, display
    //Database: List, record type file.
    //Exceptions:Age, Salary, List Empty, Not Found, Choice.

/**
 *
 * @author son75
 */
public class Main{

    /**
     */
    Scanner sc = new Scanner(System.in);
    
    public int getInt(){
        while (true) {            
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Must be digit. Please re-enter: ");
            }
        }
    }
    
    public void menu() throws Exception{
        WorkerManagement wm = new WorkerManagement();
        int choice = 0;
        do {            
            System.out.println("=========Worker Management==========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = getInt();
            switch (choice){
                case 1: wm.addWorker();break;
                case 2: wm.upSalary();break;
                case 3: wm.downSalary();break;
                case 4: wm.displaySalaryHistory();
                case 5: break;
                default: System.out.print("Invalid input. Re-enter:");
            }
        } while (choice!=5);
    }
    
    public static void main(String[] args) throws Exception{
        Main main = new Main();
        main.menu();
    }
    
}
