package com.kyougaru;

import com.kyougaru.model.Developer;
import com.kyougaru.model.Employee;
import com.kyougaru.model.Manager;

import java.util.ArrayList;

import static java.util.FormatProcessor.FMT;

public class Main {
    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();
        employees.add(new Manager("João", 5000));
        employees.add(new Developer("Maria", 20, 173));

        for (var employee : employees) {
            var role = switch (employee) {
                case Manager(String name, double baseSalary) -> "manager";
                case Developer(String name, double hourlyRate, int hoursWorked) -> "developer";
            };

            var message = FMT."The salary of the \{role} \{employee.name()} is $%1.2f\{employee.calculateSalary()}";
            System.out.println(message);
        }
    }
}