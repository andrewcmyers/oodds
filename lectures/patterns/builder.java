class Employee {
    private Employee(String name, double salary,
                     Collection<PayCheck> paychecks) {
        ...
    }
}

public class EmployeeBuilder {
    public EmployeeBuilder();
    Maybe<String> name;
    Maybe<Double> salary;
    Collection<PayCheck> paychecks;

    public EmployeeBuilder setName(String name) { 
        this.name = Maybe.some(name);
        paychecks = new ArrayList<>();
        return this;
    }

    public EmployeeBuilder setSalary(double salary) {
        this.salary = Maybe.some(salary);
        return this;
    }

    public EmployeeBuilder addPaycheck(Paycheck p) {
        paychecks.add(p);
    }

    public Employee create() throws MissingInformation {
        try {
            return new Employee(name.get(), salary.get(), paychecks);
        } catch (NoMaybeValue) {
            throw new MissingInformation("name");
        }
    }
}

...
Employee e = new EmployeeBuilder()
                .setName("Joe")
                .setSalary(10000)
                .addPaycheck(p1)
                .create();
