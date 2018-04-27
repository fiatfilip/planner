package ro.siit.planner.model;

import ro.siit.planner.entity.Room;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class RoomModel {
    private EntityManager entityManager;
    public RoomModel(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Room> getRooms(){
        Query q = entityManager.createQuery("SELECT room FROM ro.siit.planner.entity.Room room");
        List<Room> rooms = q.getResultList();
        return rooms;
    }

    public Room getRoomById(UUID id){
        return entityManager.find(Room.class, id);
    }
}
