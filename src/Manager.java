public record Manager(String name, double baseSalary) implements Employee {
    @Override
    public double calculateSalary() {
        return baseSalary * 1.2;
    }
}
