package MidExam.EmployeeManagementSystem.Classes;

import MidExam.EmployeeManagementSystem.Intefaces.Manager;
import MidExam.EmployeeManagementSystem.Intefaces.Service;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager implements Manager {
    private Service service;
    public EmployeeManager(Service service) {
        this.service = service;
    }

    List<CompanyEmployee> listOfEmploees = new ArrayList<>();
    public List<CompanyEmployee> getCompanyEmployees() {
        return listOfEmploees;
    }
    @Override
    public void addEmployee(CompanyEmployee newEmployee) {
        listOfEmploees.add(newEmployee);
    }

    @Override
    public void editEmployee(int id, String name, String department, String role, double salary) {
        for (CompanyEmployee emp : listOfEmploees){
            if(emp.getEmployeeID() == id){
                emp.setName(name);
                emp.setDepartment(department);
                emp.setRole(role);
                emp.setSalary(salary);
                break;
            }
        }
    }

    @Override
    public void fireEmployee(int id) {
            listOfEmploees.removeIf(emp -> emp.getEmployeeID() == id);
    }

    @Override
    public void listEmployees() {
        if (listOfEmploees.isEmpty()) {
            System.out.println("There are no employees.");
            return;
        }
        for (CompanyEmployee empl : listOfEmploees) {
            System.out.println(empl.getDetails());
        }
    }

    @Override
    public void searchEmployee(int id) {
        for (CompanyEmployee employee : listOfEmploees) {
            if (employee.getEmployeeID() == id) {
                System.out.println(employee.getDetails());
            }
        }
//        return "Employee not found";
    }

    @Override
    public void searchEmployee(String searchBy, String word) {
        boolean found = false;
        if (searchBy.equals("Name")) {

            for (CompanyEmployee emp : listOfEmploees) {
                if (emp.getDepartment().equalsIgnoreCase(word)) {
                    System.out.println(emp.getDetails());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee '" + word + "' not found.");
            }
        } else if (searchBy.equals("Department")) {
            for (CompanyEmployee emp : listOfEmploees) {
                if (emp.getName().equalsIgnoreCase(word)) {
                    System.out.println(emp.getDetails());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("There is no such department.");
            }
        } else {
            System.out.println("You can only search by id, name or department");
        }
    }
    @Override
    public void execute(String command){
        String[] line = command.split("//s+");
        switch (line[0]. toLowerCase()){
            case "add employee":
                addEmployee(parseEmployee(line[1]));
                break;
            case "edit":
                int id = Integer.parseInt(line[1]);
                editEmployee(id,line[2],line[3], line[4],Double.parseDouble(line[5]));
                break;
            case "fire":
                fireEmployee(Integer.parseInt(line[1]));
                break;
            case "list":
                listEmployees();
                break;
            case "search":
                try {
                    if (isInteger(line[1])) {
                        searchEmployee(Integer.parseInt(line[1]));
                    } else {
                        searchEmployee(line[1], line[2]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid command.");
                }
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private CompanyEmployee parseEmployee(String data) {
        String[] parts = data.split(",");
        return new CompanyEmployee(
                Integer.parseInt(parts[0].trim()),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim(),
                Double.parseDouble(parts[4].trim())
        );
    }
}
