package com.vaccination.citizenService.model;

import jakarta.persistence.Column;

public class CitizenModel {

    private int id_no;
    private String name;
    private int vaccinationCenterID;

    public int getId_no() {
        return id_no;
    }

    public void setId_no(int id_no) {
        this.id_no = id_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVaccinationCenterID() {
        return vaccinationCenterID;
    }

    public void setVaccinationCenterID(int vaccinationCenterID) {
        this.vaccinationCenterID = vaccinationCenterID;
    }
}
