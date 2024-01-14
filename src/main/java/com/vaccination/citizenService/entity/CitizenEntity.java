package com.vaccination.citizenService.entity;

import jakarta.persistence.*;

@Entity()
@Table(name = "citizendb", schema = "vaccine")
public class CitizenEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="citizendb_seq")
    @SequenceGenerator(name = "citizendb_seq", allocationSize = 1)
    private int id_no;
    @Column
    private String name;
    @Column(name = "vaccinationcenterid")
    private int vaccinationCenterID;

    public int getId() {
        return id_no;
    }

    public void setId(int id) {
        this.id_no = id;
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
