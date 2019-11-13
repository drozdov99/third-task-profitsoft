package ua.profitsoft.trainee.drozdov.employee;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accountant {

    private List<Employee> employees;

    private Accountant() {
    }

    private static Accountant instance;

    public static Accountant getInstance() {
        if (instance == null) {
            instance = new Accountant();
        }
        return instance;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static void setInstance(Accountant instance) {
        Accountant.instance = instance;
    }
}
