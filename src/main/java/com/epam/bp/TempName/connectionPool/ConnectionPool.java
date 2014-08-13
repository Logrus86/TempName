package com.epam.bp.TempName.connectionPool;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool<T> {
    private ArrayBlockingQueue<T> connectionQueue;
    static ResourceBundle rb = ResourceBundle.getBundle("db.properties");
    String driver = rb.getString("db.driver");
    String url = rb.getString("db.url");
    String user = rb.getString("db.user");
    String password = rb.getString("db.password");

    public ConnectionPool(final int POOL_SIZE) throws SQLException, ClassNotFoundException {
        connectionQueue = new ArrayBlockingQueue<T>(POOL_SIZE);
        Class.forName(driver);
        for (int i = 0; i < POOL_SIZE; i++) {
            T connection = (T) new ProxyConnection(DriverManager.getConnection(url, user, password));
            connectionQueue.offer(connection);
        }
    }

    public T getConnection() throws InterruptedException {
        T connection = null;
        connection = connectionQueue.take();
        return connection;
    }

    public void closeConnection(T connection) {
        connectionQueue.offer(connection);
    }

    // example of usage:
    // ConnectionPool<ProxyConnection> pool = new ConnectionPool<>(20);
}
