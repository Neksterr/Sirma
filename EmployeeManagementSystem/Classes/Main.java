package MidExam.EmployeeManagementSystem.Classes;

import MidExam.EmployeeManagementSystem.Intefaces.Manager;
import MidExam.EmployeeManagementSystem.Intefaces.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String reader = "C:\\Users\\nekst\\Documents\\SirmaAcademy\\Sirma\\src\\MidExam\\utils\\Input.txt";
        String writer = "C:\\Users\\nekst\\Documents\\SirmaAcademy\\Sirma\\src\\MidExam\\utils\\Output.txt";

        // implement fileReader/fileWriter to handle saving into csv/json
        Service service = new EmployeeService(reader, writer);
        Manager manager = new EmployeeManager(service);
        System.out.println(" Welcome to Employee Management System ");

        displayCommands();

        boolean isRunning = true;
        while (isRunning) {
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
             manager.execute(command);
// Add Employee
// 1, Peter Peterson, IT, Junior Java Developer, 1400.50
// Add Employee
// 2, Ivan Ivanson, IT, Junior Front-End Developer, 1400.00
// Edit 1
// Peter Peterson, IT, Java Developer, 2500.00
// List employees
// Search Department Marketing
// Search Id 1
// Fire 1
// Search Name Ivan
// Save &amp; Exit
        }
    }

    private static void displayCommands() {
        System.out.println("You are at the Main Menu! Select one of the following commands:");
        System.out.println();
        System.out.println("1. Add a new employee to the System");
        System.out.println("2. Remove employee from the System");
        System.out.println("3. Display all employees");

        System.out.println("9. Save inventory to a file");
        System.out.println("10. Load inventory from a file");
        System.out.println("11. Search by");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");
    }

}
