package com.httpservlet.test.httpservlets.servlet.entity;

import java.math.BigDecimal;

public class Ticket {
    
    private Long id;
    private String passangerNo;
    private String passengerName;
    private Long lightId;
    private String seatNo;
    private BigDecimal cost;

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", passangerNo=" + passangerNo + ", passengerName=" + passengerName + ", lightId="
                + lightId + ", seatNo=" + seatNo + ", cost=" + cost + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Ticket(Long id, String passangerNo, String passengerName, Long lightId, String seatNo, BigDecimal cost) {
        this.id = id;
        this.passangerNo = passangerNo;
        this.passengerName = passengerName;
        this.lightId = lightId;
        this.seatNo = seatNo;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassangerNo() {
        return passangerNo;
    }

    public void setPassangerNo(String passangerNo) {
        this.passangerNo = passangerNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getFightId() {
        return lightId;
    }

    public void setLightId(Long lightId) {
        this.lightId = lightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
