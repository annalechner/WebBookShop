/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.Author;
import beans.Book;
import beans.Publisher;
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
    private static DB_Access theInstance;
    
    public static DB_Access getInstance(){
        if(theInstance == null){
            theInstance = new DB_Access();
        }
        return theInstance;
    }
    
    private DB_Access(){
        
    }
    
    
    public List<Book> getAllBooks() throws Exception{
        PreparedStatement  pStat = pStatPool.getPStat(DB_StmtType.GET_ALL_BOOKS);
        //pStat.setString(1, "%Using%");
        ResultSet rs = pStat.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while(rs.next()){
            System.out.println(rs.getString(1));
            PreparedStatement prepStat = pStatPool.getPStat(DB_StmtType.GET_AUTHORS_FOR_BOOK);
            prepStat.setInt(1, Integer.parseInt(rs.getString(1)));
            ResultSet res = prepStat.executeQuery();
            List<Author> authors = new ArrayList<>();
            while(res.next()){
                Author auth = new Author(res.getString(2), res.getString(3), res.getString(4));
                authors.add(auth);
            }
            pStatPool.releasePStat(prepStat);
            Publisher pub = new Publisher(rs.getString(7),rs.getString(8));
            bookList.add(new Book(rs.getString(2),rs.getString(3),Double.parseDouble(rs.getString(4)),pub,rs.getString(6),authors));
        }
        pStatPool.releasePStat(pStat);
        return bookList;
    }
}
