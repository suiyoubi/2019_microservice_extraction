package org.javaee7.wildfly.samples.everest.catalog;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CatalogItem.findAll", query = "SELECT i FROM CatalogItem i"),
    @NamedQuery(name = "CatalogItem.findById", query = "SELECT i FROM CatalogItem i where i.id = :id")
})
public class CatalogItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    
    @Column(length=60)
    private String name;

    @Column
    private int type;
    
    @Column(length=100)
    private String description;
    
    public CatalogItem() { }

    public CatalogItem(String name, int type) {
        this.name = name;
        this.type = type;
    }

    @OperationExecutionMonitoringProbe
    public int getId() {
        return id;
    }

    @OperationExecutionMonitoringProbe
    public void setId(int id) {
        this.id = id;
    }

    @OperationExecutionMonitoringProbe
    public String getName() {
        return name;
    }

    @OperationExecutionMonitoringProbe
    public void setName(String name) {
        this.name = name;
    }

    @OperationExecutionMonitoringProbe
    public int getType() {
        return type;
    }

    @OperationExecutionMonitoringProbe
    public void setType(int type) {
        this.type = type;
    }

    @OperationExecutionMonitoringProbe
    public String getDescription() {
        return description;
    }

    @OperationExecutionMonitoringProbe
    public void setDescription(String description) {
        this.description = description;
    }
}
