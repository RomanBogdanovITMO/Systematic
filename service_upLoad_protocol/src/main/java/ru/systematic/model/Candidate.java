package ru.systematic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCandidate;
    private double count;

    @ManyToMany(mappedBy = "listCandidate")
    @JsonIgnore
    private List<Protocol> listProtocol = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCandidate() {
        return nameCandidate;
    }

    public void setNameCandidate(String nameCandidate) {
        this.nameCandidate = nameCandidate;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public List<Protocol> getListProtocol() {
        return listProtocol;
    }

    public void setListProtocol(List<Protocol> listProtocol) {
        this.listProtocol = listProtocol;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", nameCandidate='" + nameCandidate + '\'' +
                ", count=" + count +
                ", listProtocol=" + listProtocol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
