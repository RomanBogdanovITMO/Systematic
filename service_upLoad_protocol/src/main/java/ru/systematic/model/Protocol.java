package ru.systematic.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "protocols")
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameElection;
    private String electoralCommission;
    private Date dateElection;
    private Date dateProtocol;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PROTOCOL_INFO",
            joinColumns = { @JoinColumn(name = "PROTOCOL_ID") },
            inverseJoinColumns = { @JoinColumn(name = "INFO_FOR_PROTOCOL_ID") })
    private List<InformationForProtocol> listInfoForProtocol = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PROTOCOL_CANDIDATE",
            joinColumns = { @JoinColumn(name = "PROTOCOL_ID") },
            inverseJoinColumns = { @JoinColumn(name = "CANDIDATE_ID") })
    private List<Candidate> listCandidate = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameElection() {
        return nameElection;
    }

    public void setNameElection(String nameElection) {
        this.nameElection = nameElection;
    }

    public String getElectoralCommission() {
        return electoralCommission;
    }

    public void setElectoralCommission(String electoralCommission) {
        this.electoralCommission = electoralCommission;
    }

    public Date getDateElection() {
        return dateElection;
    }

    public void setDateElection(Date dateElection) {
        this.dateElection = dateElection;
    }

    public Date getDateProtocol() {
        return dateProtocol;
    }

    public void setDateProtocol(Date dateProtocol) {
        this.dateProtocol = dateProtocol;
    }

    public List<InformationForProtocol> getListInfoForProtocol() {
        return listInfoForProtocol;
    }

    public void setListInfoForProtocol(List<InformationForProtocol> listInfoForProtocol) {
        this.listInfoForProtocol = listInfoForProtocol;
    }

    public List<Candidate> getListCandidate() {
        return listCandidate;
    }

    public void setListCandidate(List<Candidate> listCandidate) {
        this.listCandidate = listCandidate;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "id=" + id +
                ", nameElection='" + nameElection + '\'' +
                ", electoralCommission='" + electoralCommission + '\'' +
                ", dateElection=" + dateElection +
                ", dateProtocol=" + dateProtocol +
                ", listInfoForProtocol=" + listInfoForProtocol +
                ", listCandidate=" + listCandidate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Protocol protocol = (Protocol) o;
        return id == protocol.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
