
package s56;
import Database.DataUpdater;
import Database.WorkerData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author son75
 */
public class WorkerManagement extends ExceptionHandling implements WorkerData{
    
    //Data Updater
    DataUpdater du = new DataUpdater();
    
    //Add a new worker
    public void addWorker() throws Exception{   
        du.loadWorkerData();
        System.out.println("----------Add Worker-----------");
        System.out.print("Enter Code:");
        String code = getString().toUpperCase();
        while (isWorkerAlreadyExist(code)){
            code = getString().toUpperCase();
        }
        System.out.print("Enter Name:");
        String name = getString();
        System.out.print("Enter Age:");
        int age = getAge();
        System.out.print("Enter Salary:");
        double salary = getSalary();
        System.out.print("Enter work location:");
        String location = getString();
        worker.add(new Worker(code, name, age, salary, location));
        du.updateWorkerData();
    }
    
    
    //Search worker method that return a worker
    Worker searchWorker(String code){
        for (int i=0;i<worker.size();i++){
            if(worker.get(i).getCode().equalsIgnoreCase(code)){
                return worker.get(i);
            }
        }
        return null;
    }
    
    
    //Message processor to check whether it Up or Down
    public void updateSalaryHistory(Worker target, double salaryUpdate , String from) throws Exception{
        if (from.equals("up")) upSalary(target, salaryUpdate);
        if (from.equals("down")) downSalary(target, salaryUpdate);
    }
    
    
    //get date of salary changes
    public String getDate(){
           String pattern = "dd/MM/yyyy";
           DateFormat df = new SimpleDateFormat(pattern);
           Date today = Calendar.getInstance().getTime();
           return df.format(today);
    }
    
    //up salary process
    public void upSalary(Worker target, double salaryUpdate) throws Exception{
        target.setSalary(target.getSalary()+salaryUpdate);
        du.updateWorkerData();
        salaryHistory.add(new SalaryHistory("UP",getDate() , target.getCode(), target.getName(), target.getAge(), target.getSalary(), target.getLocation()));
        du.updateHistoryData();
    }
    
    //up salary GUI
    public void upSalary() throws Exception{
        du.loadWorkerData();
        if (isListEmpty(worker)){
            System.out.println("Worker Database is empty.");
            return;
        }
        System.out.println("---------Up Salary-----------");
        System.out.print("Enter code:");
        String code = getString();
        Worker target = searchWorker(code);
        while (!isWorkerExist(target)){
            code = getString();
            target = searchWorker(code);
        }
        System.out.print("Enter Salary:");
        double salaryUp= updateSalary();
        updateSalaryHistory(target, salaryUp, "up");
    }
    
    //down salary processor
    public void downSalary(Worker target, double salaryUpdate) throws Exception{
        target.setSalary(target.getSalary()-salaryUpdate);
        du.updateWorkerData();
        salaryHistory.add(new SalaryHistory("DOWN",getDate() , target.getCode(), target.getName(), target.getAge(), target.getSalary(), target.getLocation()));
        du.updateHistoryData();
    }
    
    //down salary GUI
    public void downSalary() throws Exception{
        du.loadWorkerData();
        if (isListEmpty(worker)){
            System.out.println("Worker Database is empty.");
            return;
        }
        System.out.println("-----------Down Salary-----------");
        System.out.print("Enter code:");
        String code = getString();
        Worker target = searchWorker(code);
        while (!isWorkerExist(target)){
            code = getString();
            target = searchWorker(code);
        }
        System.out.print("Enter Salary:");
        double salaryDown = updateSalaryCheckForSalaryDown(target.getSalary());
        updateSalaryHistory(target, salaryDown, "down");
    }
    
    //display worker salary history
    public void displaySalaryHistory() throws Exception{
        du.loadHistoryData();
        if (isListEmpty(salaryHistory)){
            System.out.println("Salary History is empty");
            return;
        }
        System.out.println("---------------------------------Display Information Salary------------------------------------");
        System.out.printf("%-10s%-30s%-10s%-15s%-15s%-20s\n","Code","Name","Age","Salary","Status","Date");
        /* if the below code doesn't work use these codes
        
        for (SalaryHistory sh: salaryHistory){
            System.out.printf("%-10s%-30s%-10s%-15s%-15s%-20s\n",sh.getCode(),sh.getName(),sh.getAge(),sh.getSalary(),sh.getStatus(),sh.getDate());
        }
        */
        salaryHistory.forEach((sh) -> {
            System.out.printf("%-10s%-30s%-10s%-15s%-15s%-20s\n",sh.getCode(),sh.getName(),sh.getAge(),sh.getSalary(),sh.getStatus(),sh.getDate());
        });
    }
}
