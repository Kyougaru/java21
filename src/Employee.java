sealed interface Employee permits Developer, Manager {
    String name();
    double calculateSalary();
}
