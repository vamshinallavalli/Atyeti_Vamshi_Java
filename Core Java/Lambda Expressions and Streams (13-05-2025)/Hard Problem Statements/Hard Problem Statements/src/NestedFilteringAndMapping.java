import java.util.*;

public class NestedFilteringAndMapping {
    public static void nestedFiltering() {
        Project p1 = new Project("Alpha");
        Project p2 = new Project("Beta");
        Project p3 = new Project("Gamma");

        Employee e1 = new Employee(Arrays.asList(p1, p2));
        Employee e2 = new Employee(Arrays.asList(p1, p3));
        Employee e3 = new Employee(Arrays.asList(p1));
        Employee e4 = new Employee(Arrays.asList(p2, p3));

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);

        Map<String, Set<Employee>> projectToEmployees = new HashMap<>();

        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                projectToEmployees
                        .computeIfAbsent(project.getName(), k -> new HashSet<>())
                        .add(employee);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<Employee>> entry : projectToEmployees.entrySet()) {
            if (entry.getValue().size() > 2) {
                result.add(entry.getKey());
            }
        }

        System.out.println("Projects assigned to more than 2 employees: " + result);
    }

    public static void main(String[] args) {
        nestedFiltering();
    }
}

class Employee {
    private List<Project> projects;

    public Employee(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}

class Project {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
