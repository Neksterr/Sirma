package MidExam.EmployeeManagementSystem.Classes;

public class CompanyEmployee extends EmployeeAbstract {
    private int employeeID;


    public CompanyEmployee(int id, String name, String department, String role, double salary) {
        super(id, name, department, role, salary);

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getDetails() {
        return "ID " + getEmployeeID() + ", Name: " + getName() + ", Department: " + getDepartment() + ", Role: " + getRole() + ", Salary: " + getSalary();
    }
}
