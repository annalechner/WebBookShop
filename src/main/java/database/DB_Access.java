/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.Book;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annalechner
 */
public class DB_Access {
    DB_PStatPool pStatPool = DB_PStatPool.getInstance();
    
    public List<Book> getAllBooksFromAuthor() throws Exception{
        PreparedStatement  pStat = pStatPool.getPStat(DB_StmtType.GET_BOOKS_WITH_TITLE);
        pStat.setString(1, "'%Using%'");
       
        ResultSet rs = pStat.executeQuery();
        List<Book> bookList = new ArrayList<>();
        
        while(rs.next()){
            System.out.println(rs.getString(1));
//            bookList.add(new Book(rs.getString(1),rs.getString(2),Double.parseDouble(rs.getString(3)),rs.getString(4)));
        }
        return bookList;
    }
    
    public static void main(String[] args) {
        DB_Access dba = new DB_Access();
        try {
            for (Book book : dba.getAllBooksFromAuthor()) {
                System.out.println(book);
            }
        } catch (Exception ex) {
            Logger.getLogger(DB_Access.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
