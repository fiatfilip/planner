package ro.siit.planner.model;

import ro.siit.planner.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class EmployeeModel {
    private EntityManager entityManager;
    public EmployeeModel(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Employee> getEmployees(){
        Query q = entityManager.createQuery("SELECT employee FROM ro.siit.planner.entity.Employee employee");
        List<Employee> employees = q.getResultList();
        return employees;
    }

    public Employee getEmployeeById(UUID id){
        return entityManager.find(Employee.class, id);
    }
}
