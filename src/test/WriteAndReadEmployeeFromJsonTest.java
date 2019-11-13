import org.junit.Assert;
import org.junit.Test;
import ua.profitsoft.trainee.drozdov.employee.Address;
import ua.profitsoft.trainee.drozdov.employee.Developer;
import ua.profitsoft.trainee.drozdov.employee.Employee;
import ua.profitsoft.trainee.drozdov.employee.Manager;
import ua.profitsoft.trainee.drozdov.service.WriteReadEmployeeJsonService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadEmployeeFromJsonTest {
    @Test
    public void testReadEmployeeFromJson() throws IOException {

        Developer employee1 = new Developer("Vadim","Drozdov",
                new Address("Nauki","51B",61485), "Java");
        Manager employee2 = new Manager("Oleg","Drozdov",
                new Address("Pobedi","51B",61485), "Soccer");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        WriteReadEmployeeJsonService.getInstance().write("data.json", employees);
        List<Employee> employees1 = WriteReadEmployeeJsonService.getInstance().readEmployee("data.json");
        Assert.assertTrue(new Developer("Vadim","Drozdov",
                new Address("Nauki","51B",61485), "Java").fullEquals(employees.get(0)));
    }
    @Test
    public void testCreateFileWithNewDirectory() throws IOException {
        Developer employee1 = new Developer("Vadim","Drozdov",
                new Address("Nauki","51B",61485), "Java");
        Manager employee2 = new Manager("Victor","Drozdov",
                new Address("Pobedi","51B",61485), "Soccer");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        WriteReadEmployeeJsonService.getInstance().write("temp/data.json", employees);
        File file = new File("temp");
        Assert.assertTrue(file.exists() && file.isDirectory());
    }
}
