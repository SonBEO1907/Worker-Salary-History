//Data class Worker
package s56;

/**
 *
 * @author son75
 */
public class Worker {
    //Worker propertries
    String Code;
    String Name;
    int age;
    double salary;
    String location;
    
    //Default Constructor

    public Worker() {}
    
    //Constructor
    public Worker(String Code, String Name, int age, double salary, String location) {
        this.Code = Code;
        this.Name = Name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }
    
    //Getters and Setters

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
