package MidExam.EmployeeManagementSystem.Intefaces;

import MidExam.EmployeeManagementSystem.Classes.CompanyEmployee;

public interface Manager {
    void addEmployee(CompanyEmployee employee);

    void editEmployee(int id,String name,String department, String role, double salary);
    void fireEmployee(int id);
    void listEmployees();
    void searchEmployee(int id);
    void searchEmployee(String searchBy, String word);

    void execute(String command);
}
