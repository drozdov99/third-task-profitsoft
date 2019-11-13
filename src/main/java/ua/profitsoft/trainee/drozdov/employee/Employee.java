package ua.profitsoft.trainee.drozdov.employee;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Developer.class, name = "ua.profitsoft.trainee.drozdov.employee.Developer"),
        @JsonSubTypes.Type(value = Manager.class, name = "ua.profitsoft.trainee.drozdov.employee.Manager")
})
public abstract class Employee {

    private String first_name;
    private String last_name;
    private Address address;

    public Employee() {
    }

    public Employee(String first_name, String last_name, Address address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(first_name, employee.first_name) &&
                Objects.equals(last_name, employee.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
