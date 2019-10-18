package org.javaee7.wildfly.samples.everest.checkout;

import java.io.Serializable;
import javax.persistence.Embeddable;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Embeddable
public class OrderItem implements Serializable {
    int itemId;
    int itemCount;

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
    
}
