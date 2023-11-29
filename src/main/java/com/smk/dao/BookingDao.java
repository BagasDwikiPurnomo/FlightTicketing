package com.smk.dao;

import com.smk.model.Booking;

import java.sql.Connection;
import java.util.Optional;

public class BookingDao {
    private final Optional<Connection> connection;
    public BookingDao(){
        connection = JdbcConnection.getConnection();
    }

    public static Optional<Integer> save(Booking booking) {
        return null;
    }
}
