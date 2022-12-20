package ru.mfc.mfcreference.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.mfc.mfcreference.db.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.mfc.mfcreference.dto.OfficeNameDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "office")
@TypeDef(name = "JsonType", typeClass = JsonType.class)
public class Office implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column
    private Long officeId;

    @Type(type = "JsonType")
    @Column(columnDefinition = "jsonb")
    //private Map<String, Object> officeName = new HashMap<>();
    private OfficeNameDto officeName;

    @Column
    private boolean officeIsActive;

    @Type(type = "JsonType")
    @Column(columnDefinition = "jsonb")
    private Map<Long, Object> officeService = new HashMap<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public boolean isOfficeIsActive() {
        return officeIsActive;
    }

    public void setOfficeIsActive(boolean officeIsActive) {
        this.officeIsActive = officeIsActive;
    }

    public Map<Long, Object> getOfficeService() {
        return officeService;
    }

    public void setOfficeService(Map<Long, Object> officeService) {
        this.officeService = officeService;
    }

//    public Map<String, Object> getOfficeName() {
//        return officeName;
//    }
//
//    public void setOfficeName(Map<String, Object> officeName) {
//        this.officeName = officeName;
//    }

    public OfficeNameDto getOfficeName() {
        return officeName;
    }

    public void setOfficeName(OfficeNameDto officeName) {
        this.officeName = officeName;
    }
}
