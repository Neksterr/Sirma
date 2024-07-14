package MidExam.EmployeeManagementSystem.Classes;

import MidExam.EmployeeManagementSystem.Intefaces.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements Service {
    public EmployeeService(String reader, String writer) {
        reader(reader);
        writer( writer);
    }

    @Override
    public void reader(String fileNameInput) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInput))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {

                    String name = fields[1];
                    String department = fields[2];
                    String role = fields[2];
                    double salary = Double.parseDouble(fields[4]);
                    boolean fired = Boolean.parseBoolean(fields[5]);


//                    CompanyEmployee employee = new CompanyEmployee(name, department, role, salary);

                }
            }
            System.out.println("Successfully loaded from " + fileNameInput);

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void writer(String fileNameOutput) {
        List<CompanyEmployee> employeesList = new ArrayList<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOutput))) {
            writer.write("ItemID,Name,Department,Role,Salary");
            writer.newLine();
            for (CompanyEmployee emp : employeesList) {
                writer.write(emp.getEmployeeID() + "," +
                        emp.getName() + "," +
                        emp.getDepartment() + "," +
                        emp.getRole() + "," +
                        emp.getSalary() + ",");
                writer.newLine();
            }
            System.out.println("Successfully saved to " + fileNameOutput);

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }



}
