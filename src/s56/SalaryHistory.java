//Data class SalaryHistory
package s56;

/**
 *
 * @author son75
 */
public class SalaryHistory extends Worker {
    
    String status;
    String date;

    public SalaryHistory() {}

    /*public SalaryHistory(String status, String date, String Code, String Name, int age, double salary, String location) {
        super(Code, Name, age, salary, location);
        this.status = status;
        this.date = date;
    }*/

    public SalaryHistory(String status, String date, String Code, String Name, int age, double salary, String location) {
        super(Code, Name, age, salary, location);
        this.status = status;
        this.date = date;
    }

    
    
    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
