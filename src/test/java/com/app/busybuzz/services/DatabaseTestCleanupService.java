package com.app.busybuzz.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DatabaseTestCleanupService {
    @Autowired
    EntityManager entityManager;
    Connection conn;



    @Transactional
    public void resetData(String tablesNames) throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");

        entityManager
                .createNativeQuery("DROP TABLE " + tablesNames + " CASCADE")
                .executeUpdate();


        conn.close();
    }
}
