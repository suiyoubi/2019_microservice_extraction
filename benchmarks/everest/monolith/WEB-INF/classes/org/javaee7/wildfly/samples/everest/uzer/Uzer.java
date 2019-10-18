package org.javaee7.wildfly.samples.everest.uzer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import kieker.monitoring.annotation.OperationExecutionMonitoringProbe;

/**
 * @author arungupta
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Uzer.findAll", query = "SELECT u FROM Uzer u"),
    @NamedQuery(name = "Uzer.findByLogin", query = "SELECT u FROM Uzer u where u.login = :login")
})
public class Uzer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    
    @Column
    String login;

    @Column
    String password;

    @Column
    String username;

    @Column
    String address1;

    @Column
    String address2;

    @Column
    String city;

    @Column
    String state;

    @Column
    String zip;

    @Column
    String country;

    @Column
    String creditcard;

    @OperationExecutionMonitoringProbe
    public String getLogin() {
        return login;
    }

    @OperationExecutionMonitoringProbe
    public void setLogin(String login) {
        this.login = login;
    }

    @OperationExecutionMonitoringProbe
    public String getPassword() {
        return password;
    }

    @OperationExecutionMonitoringProbe
    public void setPassword(String password) {
        this.password = password;
    }

    @OperationExecutionMonitoringProbe
    public String getUsername() {
        return username;
    }

    @OperationExecutionMonitoringProbe
    public void setUsername(String username) {
        this.username = username;
    }

    @OperationExecutionMonitoringProbe
    public String getAddress1() {
        return address1;
    }

    @OperationExecutionMonitoringProbe
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @OperationExecutionMonitoringProbe
    public String getAddress2() {
        return address2;
    }

    @OperationExecutionMonitoringProbe
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @OperationExecutionMonitoringProbe
    public String getCity() {
        return city;
    }

    @OperationExecutionMonitoringProbe
    public void setCity(String city) {
        this.city = city;
    }

    @OperationExecutionMonitoringProbe
    public String getState() {
        return state;
    }

    @OperationExecutionMonitoringProbe
    public void setState(String state) {
        this.state = state;
    }

    @OperationExecutionMonitoringProbe
    public String getZip() {
        return zip;
    }

    @OperationExecutionMonitoringProbe
    public void setZip(String zip) {
        this.zip = zip;
    }

    @OperationExecutionMonitoringProbe
    public String getCountry() {
        return country;
    }

    @OperationExecutionMonitoringProbe
    public void setCountry(String country) {
        this.country = country;
    }

    @OperationExecutionMonitoringProbe
    public String getCreditcard() {
        return creditcard;
    }

    @OperationExecutionMonitoringProbe
    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    
}
