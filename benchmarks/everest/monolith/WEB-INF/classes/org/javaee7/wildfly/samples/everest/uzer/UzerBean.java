package org.javaee7.wildfly.samples.everest.uzer;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Named
@SessionScoped
public class UzerBean implements Serializable {
    @PersistenceContext EntityManager em;
    
    @Inject UzerItem uzerItem;
    
    String status;
    
    @Transactional
    @OperationExecutionMonitoringProbe
    public void addUzer() {
        Uzer uzer = new Uzer();
        uzer.setLogin(uzerItem.getLogin());
        uzer.setPassword(uzerItem.getPassword());
        uzer.setUsername(uzerItem.getUsername());
        uzer.setAddress1(uzerItem.getAddress1());
        uzer.setAddress2(uzerItem.getAddress2());
        uzer.setCity(uzerItem.getCity());
        uzer.setState(uzerItem.getState());
        uzer.setCountry(uzerItem.getCountry());
        uzer.setZip(uzerItem.getZip());
        uzer.setCreditcard(uzerItem.getCreditcard());
        
        try {
            em.persist(uzer);
        } catch (Exception e) {
            status = e.getLocalizedMessage();
            return;
        }
        
        status = "User added successfully, login: \"" + uzer.getLogin() + "\", password: \"" + uzer.getPassword() + "\"";
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
