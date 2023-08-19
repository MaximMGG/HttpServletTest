package com.httpservlet.test.httpservlets.servlet.utils.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.httpservlet.test.httpservlets.servlet.entity.Ticket;
import com.httpservlet.test.httpservlets.servlet.utils.ConnectionManager;

public class TicketDao implements Dao{

    private static final TicketDao INSTANCE = new TicketDao();

    private static final String FIND_ALL_BY_FLIGHT_ID = """
                    SELECT *
                    FROM ticket
                    WHERE flight_id = ?
            """;
    
    private TicketDao() {}

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    public List<Ticket> findAllByFlightId(Long flightId) {
        try (Connection connection = ConnectionManager.get();
        PreparedStatement prStatement = connection.prepareStatement(FIND_ALL_BY_FLIGHT_ID)) {
            prStatement.setObject(1, flightId);

            ResultSet res = prStatement.executeQuery(); 
            List<Ticket> tickets = new ArrayList<>();
            while (res.next()) {
                tickets.add(buildTicket(res));
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Ticket buildTicket(ResultSet res) throws SQLException {
        return new Ticket(
            res.getObject("id", Long.class),
            res.getObject("passenger_no", String.class),
            res.getObject("passenger_name", String.class),
            res.getObject("flight_id", Long.class),
            res.getObject("seat_no", String.class),
            res.getObject("cost", BigDecimal.class)
        );
    }

    @Override
    public List findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional findById(Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean delete(Object id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Object save(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    } 
}
