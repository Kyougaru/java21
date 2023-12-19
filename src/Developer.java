public record Developer(String name, double hourlyRate, int hoursWorked) implements Employee {
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
