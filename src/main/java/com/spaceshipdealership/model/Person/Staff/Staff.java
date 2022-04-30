package com.spaceshipdealership.model.Person.Staff;

import com.spaceshipdealership.model.Person.Person;
import com.spaceshipdealership.model.enums.DepartmentEnum;
import com.spaceshipdealership.model.enums.RaceEnum;

public class Staff extends Person {
    private int employeeID;
    private DepartmentEnum department;
    private int salary;


    public Staff(String firstName, String lastName, RaceEnum race, String holophoneAdr, int employeeID, DepartmentEnum department, int salary) {
        super(firstName, lastName, race, holophoneAdr);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public DepartmentEnum getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEnum department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeID='" + employeeID + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", holophoneAdr='" + holophoneAdr + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
