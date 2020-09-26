package ru.systematic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "information")
public class InformationForProtocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameInformation;
    private int count;

    @ManyToMany(mappedBy = "listInfoForProtocol")
    @JsonIgnore
    private List<Protocol> listProtocol = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameInformation() {
        return nameInformation;
    }

    public void setNameInformation(String nameInformation) {
        this.nameInformation = nameInformation;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
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
        return "InformationForProtocol{" +
                "id=" + id +
                ", nameInformation='" + nameInformation + '\'' +
                ", count=" + count +
                ", listProtocol=" + listProtocol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationForProtocol that = (InformationForProtocol) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
