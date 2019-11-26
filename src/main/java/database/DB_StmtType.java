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

    GET_ALL_BOOKS("SELECT * FROM book b INNER JOIN publisher p ON p.publisher_id = b.publisher_id;"),
    GET_AUTHORS_FOR_BOOK("SELECT a.author_id, a.lastname, a.firstname, a.url  FROM book b INNER JOIN bookauthor ba ON b.book_id = ba.book_id "
            + "INNER JOIN author a ON ba.author_id = a.author_id WHERE b.book_id = ?;");

    private DB_StmtType(String sqlString) {
        this.sqlString = sqlString;
    }

    private String sqlString;

    public String getSqlString() {
        return this.sqlString;
    }
}
