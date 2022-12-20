package ru.mfc.mfcreference.dto;


import java.util.ArrayList;
import java.util.List;


public class UnitServiceDto {
    private List<UnitServiceDto> children = new ArrayList<>();

    private List<UnitServiceDto> childrenGroups = new ArrayList<>();

    private String description;

    private Long id;

    private String name;

    public List<UnitServiceDto> getChildren() {
        return children;
    }

    public void setChildren(List<UnitServiceDto> children) {
        this.children = children;
    }

    public List<UnitServiceDto> getChildrenGroups() {
        return childrenGroups;
    }

    public void setChildrenGroups(List<UnitServiceDto> childrenGroups) {
        this.childrenGroups = childrenGroups;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
