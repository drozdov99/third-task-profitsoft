package ua.profitsoft.trainee.drozdov;

import ua.profitsoft.trainee.drozdov.employee.Address;
import ua.profitsoft.trainee.drozdov.employee.Developer;
import ua.profitsoft.trainee.drozdov.employee.Employee;
import ua.profitsoft.trainee.drozdov.employee.Manager;
import ua.profitsoft.trainee.drozdov.service.WriteReadEmployeeJsonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {

        Developer employee1 = new Developer("Vadim","Drozdov",
                new Address("Nauki","51B",61485), "Java");
        Manager employee2 = new Manager("Victor","Drozdov",
                new Address("Pobedi","51B",61485), "Soccer");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        WriteReadEmployeeJsonService.getInstance().write("data/employee/employee.json", employees);

        List<Employee> employees1 = WriteReadEmployeeJsonService.getInstance().readEmployee("data/employee/employee.json");

        for (Employee e : employees1) {
            System.out.println(e);
        }

    }
}
