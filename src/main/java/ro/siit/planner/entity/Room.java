package ro.siit.planner.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "id")
    private UUID roomId;

    @Column(name = "name")
    private String roomName;

    @OneToMany(mappedBy = "room")
    private List<Planning> plannings;

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    public Room(){}
}
