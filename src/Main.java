import java.util.ArrayList;

import static java.util.FormatProcessor.FMT;

public class Main {
    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();
        employees.add(new Manager("João", 5000));
        employees.add(new Developer("Maria", 20, 173));

        for (var employee : employees) {
            double salary = switch (employee) {
                case Manager manager -> manager.calculateSalary();
                case Developer developer -> developer.calculateSalary();
            };

            var message = FMT."The salary of \{employee.name()} is $%1.2f\{salary}";
            System.out.println(message);
        }
    }
}