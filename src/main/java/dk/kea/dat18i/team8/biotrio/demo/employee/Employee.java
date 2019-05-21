package dk.kea.dat18i.team8.biotrio.demo.employee;

public class Employee {

    private int employee_id;
    private String name;
    private String lastName;
    private String username;
    private String password;


    public Employee() {
    }


    public Employee(int employee_id, String name, String lastName, String username, String password) {
        this.employee_id = employee_id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}