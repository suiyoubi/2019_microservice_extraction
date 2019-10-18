package org.javaee7.wildfly.samples.everest.cart;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Named
@SessionScoped
public class CartItem implements Serializable {
    private int itemId;
    private String itemName;
    private int itemCount;
    
    public CartItem() { }

    public CartItem(int itemId, String itemName, int itemCount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCount = itemCount;
    }
    
    @OperationExecutionMonitoringProbe
    public int getItemId() {
        return itemId;
    }

    @OperationExecutionMonitoringProbe
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @OperationExecutionMonitoringProbe
    public int getItemCount() {
        return itemCount;
    }

    @OperationExecutionMonitoringProbe
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @OperationExecutionMonitoringProbe
    public String getItemName() {
        return itemName;
    }

    @OperationExecutionMonitoringProbe
    public void setName(String name) {
        this.itemName = name;
    }
}
