package ro.siit.planner.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id")
    private UUID employeeId;

    @Column(name = "name")
    private String employeeName;

    @OneToMany(mappedBy = "employee")
    List<Planning> plannings;

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    public List<Planning> getPlannings() {
        return plannings;
    }

    public Employee() {
    }
}
