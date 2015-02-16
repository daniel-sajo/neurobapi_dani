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
@Table(name = "allowedvalue")
@NamedQueries({
    @NamedQuery(name = "Allowedvalue.findAll", query = "SELECT a FROM Allowedvalue a")})
public class Allowedvalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "variableid")
    private int variableid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "value")
    private String value;

    public Allowedvalue() {
    }

    public Allowedvalue(Integer id) {
        this.id = id;
    }

    public Allowedvalue(Integer id, int variableid, String value) {
        this.id = id;
        this.variableid = variableid;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVariableid() {
        return variableid;
    }

    public void setVariableid(int variableid) {
        this.variableid = variableid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        if (!(object instanceof Allowedvalue)) {
            return false;
        }
        Allowedvalue other = (Allowedvalue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.sztaki.neurobapi.db.entities.Allowedvalue[ id=" + id + " ]";
    }

}
