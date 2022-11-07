//Exception handling class
package s56;
import Exception.AgeOutOfBoundException;
import Exception.SalaryUnderZeroException;
import Exception.WorkerNotFoundException;
import Exception.SalaryNotChangedException;
import Exception.PoorWorkerException;
import Exception.InvalidChoiceException;
import Exception.ListEmptyException;
import Exception.WorkerAlreadyExistException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author son75
 */
public class ExceptionHandling {
    
    Scanner sc = new Scanner(System.in);

    // Exception Handling for age 
    public int getAge(){
        while (true) {            
            try {
                int age = Integer.parseInt(sc.nextLine());
                if (age<18 || age>50) throw new AgeOutOfBoundException();
                return age;
            } catch (AgeOutOfBoundException e) {
                System.out.print("Age must be between 18 and 50. Please re-enter: ");
            }
        }
    }
    
    
    // Exception Handling for Salary
    public double getSalary(){
        while (true){
            try {
                double salary = Double.parseDouble(sc.nextLine());
                if (salary<0) throw new SalaryUnderZeroException();
                return salary;
            } catch (NumberFormatException e) {
                System.out.print("Salary must be digit. Please re-enter: ");
            } catch (SalaryUnderZeroException e){
                System.out.print("Salary must be higher than 0. Please re-enter:");
            }
        }
    }
    
    // Exception Handling for String type data
    public String getString(){
        return sc.nextLine().trim();
    }
    
    public boolean isWorkerExist(Worker worker){
        try {
            if (worker==null) throw new WorkerNotFoundException();
        } catch (WorkerNotFoundException e) {
            System.out.print("Worker not found. Please re-enter code:");
            return false;
        }
        return true;
    }
    
    // Exception Handling for updating salary
    public double updateSalary(){
        while (true) {            
            try {
                double salaryNew = getSalary();
                if (salaryNew==0) throw new SalaryNotChangedException();
                return salaryNew;
            } catch (SalaryNotChangedException e) {
                System.out.print("Salary cannot be updated. Please re-enter: ");
            }
        }
    }
    
    // Exception Handling for choice validation
    public boolean validChoice(String msg){
        System.out.print(msg+"(Y/N):");
        while (true) {            
            try {
                String choice = getString();
                if (choice.equalsIgnoreCase("y")) return true;
                if (choice.equalsIgnoreCase("n")) return false;
                else throw new InvalidChoiceException();
            } catch (InvalidChoiceException e) {
                System.out.print("Invalid choice. Please re-enter(Y/N):");
            }
        }
    }
    
    
    // Exception Handling for salary down
    public double updateSalaryCheckForSalaryDown(double currentSalary){
        while(true){
            try {
                double salaryNew = getSalary();
                if (salaryNew==0) throw new SalaryNotChangedException();
                if (salaryNew>=currentSalary) throw new PoorWorkerException();
                return salaryNew;
            } catch (SalaryNotChangedException e) {
                System.out.print("Salary cannot be updated. Please re-enter: ");
            } catch (PoorWorkerException e){
                System.out.println("Salary would be under 0 after the update.");
                boolean continueUpdate = validChoice("Do you still want to update salary?It will be 0.");
                if (continueUpdate) return currentSalary;
                else {
                    System.out.print("Re-enter:");
                }
            }
        }
    }
    
    //Exception handling for empty list
    public boolean isListEmpty(List list){
        try {
            if (list.isEmpty()) return true;
            else throw new ListEmptyException();
        } catch (ListEmptyException e) {
            return false;
        }
    }
    
    //Exception to check existing worker
    public boolean isWorkerAlreadyExist(String code){
        WorkerManagement wm = new WorkerManagement();
        try {
            if (wm.searchWorker(code)==null) return false;
            else {
                throw new WorkerAlreadyExistException();
            }
        } catch (WorkerAlreadyExistException e) {
            System.out.print("Worker already exist. Re-enter: ");
            return true;
        }
    }
    
}
