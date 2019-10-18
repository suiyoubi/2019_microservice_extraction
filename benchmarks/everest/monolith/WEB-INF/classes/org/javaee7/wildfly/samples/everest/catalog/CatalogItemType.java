package org.javaee7.wildfly.samples.everest.catalog;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Entity
public class CatalogItemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;

    @Column
    private String name;

    public CatalogItemType() {
    }

    public CatalogItemType(int id, String name) {
        this.id = id;
        this.name = name;
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
}
