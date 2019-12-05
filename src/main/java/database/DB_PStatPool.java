/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author annalechner
 */
public class DB_PStatPool {
    DB_ConnectionPool conPool = DB_ConnectionPool.getInstance();
    
    private static DB_PStatPool theInstance = null;
    
     public static DB_PStatPool getInstance() {
        if (theInstance == null) {
            theInstance = new DB_PStatPool();
        }
        return theInstance;
    }
     
     private DB_PStatPool(){
     }
     
     private Map<Connection, Map<DB_StmtType, PreparedStatement>> conMap = new HashMap<>();
     
     public PreparedStatement getPStat(DB_StmtType stmtType) throws Exception{
         Connection connection = conPool.getConnection();
         Map<DB_StmtType, PreparedStatement> pStatMap = conMap.get(connection);
         if(pStatMap == null){
             pStatMap = new HashMap<>();
             conMap.put(connection, pStatMap);
         }
         PreparedStatement pStat = pStatMap.get(stmtType);
         if(pStat == null){
//             System.out.println(stmtType.getSqlString());
             pStat = connection.prepareStatement(stmtType.getSqlString());
             pStatMap.put(stmtType, pStat);
         }
         return pStat;
     }
     
     public void releasePStat(PreparedStatement pStat) throws SQLException{
         conPool.releaseConnection(pStat.getConnection());
     }
}
