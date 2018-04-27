package ro.siit.planner.model;

import ro.siit.planner.entity.Planning;

import javax.persistence.EntityManager;

public class PlanningModel {
    private EntityManager entityManager;
    public PlanningModel(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void schedulePlanning(Planning planning){
        entityManager.getTransaction().begin();
        entityManager.persist(planning);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
}
