package org.javaee7.wildfly.samples.everest.checkout;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Entity
@Table(name = "CART_ORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    int orderId;
    
    @ElementCollection
    List<OrderItem> orderItems;

    @OperationExecutionMonitoringProbe
    public int getOrderId() {
        return orderId;
    }

    @OperationExecutionMonitoringProbe
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @OperationExecutionMonitoringProbe
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @OperationExecutionMonitoringProbe
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
