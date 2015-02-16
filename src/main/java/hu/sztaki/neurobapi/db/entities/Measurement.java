package hu.sztaki.neurobapi.db.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "measurement")
@NamedQueries({
    @NamedQuery(name = "Measurement.findAll", query = "SELECT m FROM Measurement m")})
public class Measurement implements Serializable {
    @Lob
    @Size(max = 65535)
    @Column(name = "textualrepresentation")
    private String textualrepresentation;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patientid")
    private int patientid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "measurementtypeid")
    private int measurementtypeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "principalid")
    private int principalid;
    @Size(max = 45)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recordinguserid")
    private int recordinguserid;

    public Measurement() {
    }

    public Measurement(Integer id) {
        this.id = id;
    }

    public Measurement(Integer id, int patientid, int measurementtypeid, Date date, int principalid, int recordinguserid) {
        this.id = id;
        this.patientid = patientid;
        this.measurementtypeid = measurementtypeid;
        this.date = date;
        this.principalid = principalid;
        this.recordinguserid = recordinguserid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getMeasurementtypeid() {
        return measurementtypeid;
    }

    public void setMeasurementtypeid(int measurementtypeid) {
        this.measurementtypeid = measurementtypeid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(int principalid) {
        this.principalid = principalid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRecordinguserid() {
        return recordinguserid;
    }

    public void setRecordinguserid(int recordinguserid) {
        this.recordinguserid = recordinguserid;
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
        if (!(object instanceof Measurement)) {
            return false;
        }
        Measurement other = (Measurement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.sztaki.neurobapi.db.entities.Measurement[ id=" + id + " ]";
    }

    public String getTextualrepresentation() {
        return textualrepresentation;
    }

    public void setTextualrepresentation(String textualrepresentation) {
        this.textualrepresentation = textualrepresentation;
    }

}
