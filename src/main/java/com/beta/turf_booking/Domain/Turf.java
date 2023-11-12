package com.beta.turf_booking.Domain;

import com.beta.turf_booking.Model.TurfResponseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.beta.turf_booking.Utils.CommonUtils.mapToSlotResponseModels;

@Entity
@Table(name = "turf")
public class Turf {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private String phone;
    private String city;
    private String area;

    @OneToMany(mappedBy = "turf", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slot> slots;


    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public Turf() {
        slots = new ArrayList<>();
    }

    public Turf(long id, String name, String type, String phone, String city, String area) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.phone = phone;
        this.city = city;
        this.area = area;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
        slot.setTurf(this);
    }

    public void removeSlot(Slot slot) {
        slots.remove(slot);
        slot.setTurf(null);
    }

    public TurfResponseModel mapToTurfResponseModel() {
        return new TurfResponseModel(
                getId(),
                getName(),
                getType(),
                getPhone(),
                getCity(),
                getArea(),
                mapToSlotResponseModels(getSlots())
        );
    }
}
