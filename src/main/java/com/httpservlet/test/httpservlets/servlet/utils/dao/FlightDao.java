package com.httpservlet.test.httpservlets.servlet.utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.httpservlet.test.httpservlets.servlet.entity.Flight;
import com.httpservlet.test.httpservlets.servlet.entity.FlightStatus;
import com.httpservlet.test.httpservlets.servlet.utils.ConnectionManager;


public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANSE = new FlightDao();

    private static final String FIND_ALL = """
            SELECT *
            FROM flight
            """;

    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.get();
        PreparedStatement prStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet res = prStatement.executeQuery();
            List<Flight> flights = new ArrayList<>();
            while (res.next()) {
                flights.add(buildFlight(res));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private FlightDao() {}

    private Flight buildFlight(ResultSet res) throws SQLException {
        return new Flight(
            res.getObject("id", Long.class),
            res.getObject("flight_no", String.class),
            res.getObject("departure_date",Timestamp.class).toLocalDateTime(),
            res.getObject("departure_airport_code", String.class),
            res.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
            res.getObject("arrival_airport_code", String.class),
            res.getObject("aircraft_id", Integer.class),
            FlightStatus.valueOf(res.getObject("status", String.class))
        );
    }

    @Override
    public Optional<Flight> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(Flight entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Flight save(Flight entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public static FlightDao getIstance() {
        return INSTANSE;
    }
    
}
