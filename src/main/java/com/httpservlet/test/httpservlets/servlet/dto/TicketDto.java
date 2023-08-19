package com.httpservlet.test.httpservlets.servlet.dto;

public class TicketDto {
    
    private Long id;
    private Long flightId;
    private String seatNo;

    public TicketDto(Long id, Long flightId, String seatNo) {
        this.id = id;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }
     
    @Override
    public String toString() {
        return "TicketDto [id=" + id + ", flightId=" + flightId + ", seatNo=" + seatNo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
        result = prime * result + ((seatNo == null) ? 0 : seatNo.hashCode());
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
        TicketDto other = (TicketDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (flightId == null) {
            if (other.flightId != null)
                return false;
        } else if (!flightId.equals(other.flightId))
            return false;
        if (seatNo == null) {
            if (other.seatNo != null)
                return false;
        } else if (!seatNo.equals(other.seatNo))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getFlightId() {
        return flightId;
    }
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
    public String getSeatNo() {
        return seatNo;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
     
}
