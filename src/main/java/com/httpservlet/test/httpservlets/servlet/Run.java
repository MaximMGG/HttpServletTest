package com.httpservlet.test.httpservlets.servlet;

import com.httpservlet.test.httpservlets.servlet.service.FlightService;

public class Run {
    public static void main(String[] args) {
        FlightService fs = FlightService.getIstance();
        System.out.println(fs.findAll());
    }
}
