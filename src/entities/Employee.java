package entities;

public class Employee {
    private int employeeID;
    private String employeeName;
    private double salary;

    public Employee() {}

    public Employee(int employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(int employeeID, String employeeName, double salary, int spvrID) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.salary = salary;
        this.spvrID = spvrID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSpvrID() {
        return spvrID;
    }

    public void setSpvrID(int spvrID) {
        this.spvrID = spvrID;
    }

    private int spvrID;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", spvrID=" + spvrID +
                '}';
    }
}
