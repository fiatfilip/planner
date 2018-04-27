package ro.siit.planner.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "plannings")
public class Planning {
    @Id
    @Column(name = "id")
    private UUID planningId;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Room room;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    public UUID getPlanningId() {
        return planningId;
    }

    public void setPlanningId(UUID planningId) {
        this.planningId = planningId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Planning() {
    }
}
