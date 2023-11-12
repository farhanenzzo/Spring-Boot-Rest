package com.beta.turf_booking.Domain;

import com.beta.turf_booking.Model.SlotRequestModel;
import com.beta.turf_booking.Model.SlotResponseModel;

import javax.persistence.*;

@Entity
@Table(name = "slot")
public class Slot {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String startTime;
    private String endTime;
    private String cost;
    private String status;

    @ManyToOne()
    @JoinColumn(name = "turf_id")
    private Turf turf;

    public Slot() {
    }

    public Slot(String name, String startTime, String endTime, String cost, String status, Turf turf) {
        this();

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
        this.status = status;
        this.turf = turf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Turf getTurf() {
        return turf;
    }

    public void setTurf(Turf turf) {
        this.turf = turf;
    }

    public SlotResponseModel mapToSlotResponseModel() {
        return new SlotResponseModel(
                getId(),
                getName(),
                getStartTime(),
                getEndTime(),
                getCost(),
                getStatus(),
                getTurf().getId()
        );
    }

    public static Slot mapToSlot(SlotRequestModel requestModel, Turf turf) {
        return new Slot(
                requestModel.getName(),
                requestModel.getStartTime(),
                requestModel.getEndTime(),
                requestModel.getCost(),
                requestModel.getStatus(),
                turf);
    }
}


