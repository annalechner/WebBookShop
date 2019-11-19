/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author annalechner
 */
public enum DB_StmtType {

    GET_BOOKS_FROM_AUTHOR("SELECT * FROM book");

    private DB_StmtType(String sqlString) {
        this.sqlString = sqlString;
    }

    private String sqlString;

    public String getSqlString() {
        return sqlString;
    }
}
