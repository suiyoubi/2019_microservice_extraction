package org.javaee7.wildfly.samples.everest.checkout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.javaee7.wildfly.samples.everest.cart.Cart;
import org.javaee7.wildfly.samples.everest.cart.CartItem;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Named
@SessionScoped
public class OrderBean implements Serializable {
    @Inject Cart cart;
    
    String status;
    
    @PersistenceContext EntityManager em;
    
    @Transactional
    @OperationExecutionMonitoringProbe
    public void saveOrder() {
        Order order = new Order();
        List<OrderItem> items = new ArrayList<>();
        List<CartItem> cartItems = cart.getItems();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.itemId = cartItem.getItemId();
            orderItem.itemCount = cartItem.getItemCount();
            items.add(orderItem);
        }
        order.setOrderItems(items);
        try {
            em.persist(order);
            status = "Order successful, order number: " + order.orderId;
            
            cart.clearCart();
        } catch (Exception e) {
            status = e.getLocalizedMessage();
        }
    }

    @OperationExecutionMonitoringProbe
    public String getStatus() {
        return status;
    }

    @OperationExecutionMonitoringProbe
    public void setStatus(String status) {
        this.status = status;
    }
}
