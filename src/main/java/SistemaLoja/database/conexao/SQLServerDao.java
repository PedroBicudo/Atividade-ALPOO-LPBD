/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedroh
 */
public class SQLServerDao {
    
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=LOJA";
    private static SQLServerDao database;
    
    private Connection connection;

    public synchronized static SQLServerDao getInstance() {
        if (database != null) {
            return database;
        } 
        
        try {
            Class.forName(DRIVER);
            database = new SQLServerDao();
            database.connection = DriverManager.getConnection(DATABASE_URL, "sa", "masterkey");
            return database;
        
        } catch (ClassNotFoundException|SQLException exception) {
            System.out.println(exception.getMessage());
            
            return null;
        }
    }
    
}
