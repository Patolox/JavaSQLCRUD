/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author titof
 */
public class dataSource {
    
    private String host;
    private int port;
    private String dataBase;
    private String username;
    private String password;
    
    private Connection connection;
    
    
    public dataSource(){
        try{
            host = "localhost";
            port = 3306;
            dataBase = "javadb";
            username = "root";
            password = "123";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dataBase +"?useTimezone=true&serverTimezone=UTC";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
  
        }catch(SQLException ex){
            System.err.println("Erro na conexão " + ex.getMessage());
        }catch(Exception e){
            System.err.println("ERROR " + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        
        try{
           connection.close();
        }catch(Exception ex){
            System.err.println("ERRO AO DESCONECTAR " + ex.getMessage());
        }
        
    }
}
