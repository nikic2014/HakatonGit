package com.AlertSystem.backendSiteDiplom.dto;

public class TaskDTO {
    private int idCourse;
    private String label;
    private String description;
    private String infoToRep;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfoToRep() {
        return infoToRep;
    }

    public void setInfoToRep(String infoToRep) {
        this.infoToRep = infoToRep;
    }
}
