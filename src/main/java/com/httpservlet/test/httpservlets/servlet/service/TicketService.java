package com.httpservlet.test.httpservlets.servlet.service;

import java.util.List;

import com.httpservlet.test.httpservlets.servlet.dto.TicketDto;
import com.httpservlet.test.httpservlets.servlet.utils.dao.TicketDao;

public class TicketService {
    
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    public static TicketService getInstance() {
        return INSTANCE;
    }

    private TicketService() {}

    public List<TicketDto> findAllByFlightId(Long flightId){ 
        return ticketDao.findAllByFlightId(flightId).stream()
                                    .map(ticket -> new TicketDto(
                                        ticket.getId(),
                                        ticket.getFightId(),
                                        ticket.getSeatNo()
                                    ))
                                    .toList();

    }
}
