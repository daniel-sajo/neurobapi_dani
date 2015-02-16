package hu.sztaki.neurobapi.db.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "datapoint")
@NamedQueries({
    @NamedQuery(name = "Datapoint.findAll", query = "SELECT d FROM Datapoint d")})
public class Datapoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "measurementid")
    private int measurementid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "variableid")
    private int variableid;
    @Column(name = "valueid")
    private Integer valueid;
    @Size(max = 128)
    @Column(name = "freevalue")
    private String freevalue;
    @Size(max = 64)
    @Column(name = "note")
    private String note;

    public Datapoint() {
    }

    public Datapoint(Integer id) {
        this.id = id;
    }

    public Datapoint(Integer id, int measurementid, int variableid) {
        this.id = id;
        this.measurementid = measurementid;
        this.variableid = variableid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMeasurementid() {
        return measurementid;
    }

    public void setMeasurementid(int measurementid) {
        this.measurementid = measurementid;
    }

    public int getVariableid() {
        return variableid;
    }

    public void setVariableid(int variableid) {
        this.variableid = variableid;
    }

    public Integer getValueid() {
        return valueid;
    }

    public void setValueid(Integer valueid) {
        this.valueid = valueid;
    }

    public String getFreevalue() {
        return freevalue;
    }

    public void setFreevalue(String freevalue) {
        this.freevalue = freevalue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datapoint)) {
            return false;
        }
        Datapoint other = (Datapoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.sztaki.neurobapi.db.entities.Datapoint[ id=" + id + " ]";
    }

}
