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
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
            PreparedStatement prepStat = pStatPool.getPStat(DB_StmtType.GET_AUTHORS_FOR_BOOK);
            prepStat.setInt(1, Integer.parseInt(rs.getString(1)));
            ResultSet res = prepStat.executeQuery();
            List<Author> authors = new ArrayList<>();
            while(res.next()){
                Author auth = new Author(res.getString(2), res.getString(3), res.getString(4),res.getInt(5));
                authors.add(auth);
            }
            authors = authors.stream().sorted(Comparator.comparing(Author::getRank)).collect(Collectors.toList());
            pStatPool.releasePStat(prepStat);
            Publisher pub = new Publisher(rs.getString(8),rs.getString(9));
            bookList.add(new Book(rs.getString(2),rs.getString(3),Double.parseDouble(rs.getString(4)),pub,rs.getString(6),authors));
        }
        pStatPool.releasePStat(pStat);
        return bookList;
    }
}
