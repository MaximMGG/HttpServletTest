package com.httpservlet.test.httpservlets.servlet.service;

import java.util.List;

import com.httpservlet.test.httpservlets.servlet.dto.FlightDto;
import com.httpservlet.test.httpservlets.servlet.utils.dao.FlightDao;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();
    
    private final FlightDao flightDao = FlightDao.getIstance();

    private FlightService() {}

    public List<FlightDto> findAll(){
        return flightDao.findAll().stream()
                                    .map(x -> new FlightDto(
                                        x.getId(),
                                        """
                                            %s - %s - %s
                                                """.formatted(x.getDepartureAirportCode(), x.getArrivalAirportCode(), x.getStatus())
                                    )) 
                                    .toList();
    }

    public static FlightService getIstance() {
        return INSTANCE;
    }
}
