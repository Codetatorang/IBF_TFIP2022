package src;

public class Employee implements Comparable<Employee> {
    private Integer staffNo;
    private String fullName;
    private String department;
    private String role;
    private String emailAddress;
    private Integer salary;

    public String getRole() { return role;}
    public void setRole(String role) { this.role = role;}

    public Integer getStaffNo() { return staffNo;}
    public void setStaffNo(Integer staffNo) { this.staffNo = staffNo;}

    public String getFullName() { return fullName;}
    public void setFullName(String fullName) { this.fullName = fullName;}

    public String getDepartment() { return department;}
    public void setDepartment(String department) { this.department = department;}

    public String getEmailAddress() { return emailAddress;}
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress;}
    
    public Integer getSalary() { return salary;}
    public void setSalary(Integer salary) { this.salary = salary;}
    
    public Employee(Integer staffNo, String fullName, String department, String role, String emailAddress,
            Integer salary) {
        this.staffNo = staffNo;
        this.fullName = fullName;
        this.department = department;
        this.role = role;
        this.emailAddress = emailAddress;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return staffNo + "," + fullName + "," + department + ", role" + ","+ emailAddress + "," + salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getFullName().compareTo(o.getFullName());
    }

}