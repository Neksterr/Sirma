package MidExam.EmployeeManagementSystem.Classes;

import MidExam.EmployeeManagementSystem.Intefaces.Department;
import MidExam.EmployeeManagementSystem.Intefaces.Fired;
import MidExam.EmployeeManagementSystem.Intefaces.Person;
import MidExam.EmployeeManagementSystem.Intefaces.Role;

public abstract class EmployeeAbstract implements Person, Department, Fired, Role {
    private int id;
    private String name;
    private String department;
    private String role;
    private double salary;
    private boolean fired;

    public EmployeeAbstract(int id,String name, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.fired = false;
    }



    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRole() {
        return this.role;
    }


    public double getSalary() {
        return salary;
    }

    @Override
    public double setSalary(double salary) {
        this.salary = salary;
        return salary;
    }

    @Override
    public boolean isFired() {
        return this.fired;
    }

}
