/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.util.LinkedList;
import java.sql.DriverManager;

/**
 *
 * @author annalechner
 */
public class DB_ConnectionPool implements DB_Config {

    private static DB_ConnectionPool theInstance = null;

    public static DB_ConnectionPool getInstance() {
        if (theInstance == null) {
            theInstance = new DB_ConnectionPool();
        }
        return theInstance;
    }

    private LinkedList<Connection> connPool = new LinkedList<>();
    private final int MAX_CON = 150;
    private int conCnt = 0;

    private DB_ConnectionPool() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Loading DB-driver failed: " + ex.toString());
        }
    }

    public synchronized Connection getConnection() throws Exception {
        if (connPool.isEmpty()) {
            if (MAX_CON == conCnt) { //alle Connections sind unterwegs
                throw new Exception("No connections available - try again later");
            }
            Connection connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);
            conCnt++;
        } else {
            return connPool.poll();
        }
        return null;
    }

    public synchronized void releaseConnection(Connection connection) {
        connPool.offer(connection);
    }
}
