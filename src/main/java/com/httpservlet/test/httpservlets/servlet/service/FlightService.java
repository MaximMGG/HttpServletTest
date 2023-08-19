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
                                    .map(flight -> FlightDto.builder()
                                        .id(flight.getId())
                                        .description(
                                        """
                                            %s - %s - %s
                                                """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))
                                        .build()
                                    )
                                    .toList();
    }

    public static FlightService getIstance() {
        return INSTANCE;
    }
}
