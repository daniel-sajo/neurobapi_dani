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
@Table(name = "variable")
@NamedQueries({
    @NamedQuery(name = "Variable.findAll", query = "SELECT v FROM Variable v")})
public class Variable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 8)
    @Column(name = "orderletters")
    private String orderletters;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupid")
    private int groupid;
    @Size(max = 2)
    @Column(name = "freevalue")
    private String freevalue;
    @Column(name = "relevancestart")
    private Integer relevancestart;
    @Column(name = "relevanceend")
    private Integer relevanceend;

    public Variable() {
    }

    public Variable(Integer id) {
        this.id = id;
    }

    public Variable(Integer id, String name, int groupid) {
        this.id = id;
        this.name = name;
        this.groupid = groupid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderletters() {
        return orderletters;
    }

    public void setOrderletters(String orderletters) {
        this.orderletters = orderletters;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getFreevalue() {
        return freevalue;
    }

    public void setFreevalue(String freevalue) {
        this.freevalue = freevalue;
    }

    public Integer getRelevancestart() {
        return relevancestart;
    }

    public void setRelevancestart(Integer relevancestart) {
        this.relevancestart = relevancestart;
    }

    public Integer getRelevanceend() {
        return relevanceend;
    }

    public void setRelevanceend(Integer relevanceend) {
        this.relevanceend = relevanceend;
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
        if (!(object instanceof Variable)) {
            return false;
        }
        Variable other = (Variable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.sztaki.neurobapi.db.entities.Variable[ id=" + id + " ]";
    }

}
