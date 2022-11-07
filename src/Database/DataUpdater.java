
package Database;
import java.io.IOException;
import s56.Worker;
import s56.SalaryHistory;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
/**
 *
 * @author son75
 */
public class DataUpdater implements WorkerData{
    
    //If the compiler doesn't make file automatically, create it manually
    //WorkerData.dat
    //SalaryHistoryData.dat
    
    //clean worker to rewrite
    public void cleanWorkerData() throws Exception {
        PrintWriter writer = new PrintWriter("WorkerData.dat");
        writer.print("");
        writer.close();
    } 
    //clean History data to rewrite
    public void cleanHistoryData() throws Exception{
        PrintWriter writer = new PrintWriter("SalaryHistoryData.dat");
        writer.print("");
        writer.close();
    }
    
    //write on WorkerData.dat
    public void updateWorkerData() throws Exception{
        cleanWorkerData();
        RandomAccessFile f = new RandomAccessFile("WorkerData.dat", "rw");
        for (Worker w: worker){
            f.writeBytes(w.getCode().replace(" ","_")+" "+w.getName().replace(" ","_")+" "+w.getAge()+" "+w.getSalary()+" "+ w.getLocation().replace(" ","_"));
            f.writeBytes("\r\n");
        }
    }
    
    //write on SalaryWorkerData.dat
    public void updateHistoryData() throws Exception{
        cleanHistoryData();
        RandomAccessFile f = new RandomAccessFile("SalaryHistoryData.dat","rw");
        for (SalaryHistory sh: salaryHistory){
            f.writeBytes(sh.getStatus() +" "+ sh.getDate() +" "+ sh.getCode().replace(" ","_") +" "+ sh.getName().replace(" ","_")+" "+sh.getAge()+" "+sh.getSalary()+" "+sh.getLocation().replace(" ","_"));
            f.writeBytes("\r\n");
        }
    }
    
    //load Worker data and add to list
    //String Code, String Name, int age, double salary, String location
    public void loadWorkerData() throws Exception{
        worker.clear();
        RandomAccessFile f = new RandomAccessFile("WorkerData.dat", "rw");
        StringTokenizer t;
        try {
            String temp;
            while ((temp = f.readLine())!=null){
                temp = temp.trim();
                t = new StringTokenizer(temp);
                String code = t.nextToken();
                String name = t.nextToken();
                int age = Integer.parseInt(t.nextToken());
                double salary = Double.parseDouble(t.nextToken());
                String location = t.nextToken();
                worker.add(new Worker(code.replace("_"," "), name.replace("_"," "), age, salary, location.replace("_"," ")));
            }
        } catch (IOException | NumberFormatException e) {
        }
    }
    
    //Load Salary Update History and add to list
    //String status, String date, String Code, String Name, int age, double salary, String location
    public void loadHistoryData() throws Exception{
        salaryHistory.clear();
        RandomAccessFile f = new RandomAccessFile("SalaryHistoryData.dat","rw");
        StringTokenizer t;
        try {
            String temp;
            while ((temp=f.readLine())!=null){
                temp = temp.trim();
                t = new StringTokenizer(temp);
                String status = t.nextToken();
                String date = t.nextToken();
                String code = t.nextToken();
                String name = t.nextToken();
                int age = Integer.parseInt(t.nextToken());
                double salary = Double.parseDouble(t.nextToken());
                String location = t.nextToken();
                salaryHistory.add(new SalaryHistory(status,date,code.replace("_"," "), name.replace("_"," "), age, salary, location.replace("_"," ")));
            }
        } catch (IOException | NumberFormatException e) {
        }
    }
}

//File Diagram
/*

*/
