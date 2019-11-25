/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataSource.dataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.curso;
import model.pessoa;

/**
 *
 * @author titof
 */
public class cursosDAO {
    
    private dataSource ds;
    
    public cursosDAO(dataSource d){
        this.ds = d;
    }
    
        public ArrayList<curso> READ(){
        
        try{
            
            String sql = "SELECT * FROM CURSO";
            PreparedStatement ps = ds.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<curso> cursos = new ArrayList<curso>();
            
            while(rs.next()){
                
                curso c = new curso();
                c.setMatricula(rs.getInt("matricula"));
                c.setNome(rs.getString("nomeCurso"));
                cursos.add(c);
            }
            
            ps.close();
            return cursos;
            
        }catch(SQLException ex){
            System.err.println("ERRO AO RECUPERAR : " + ex.getMessage());
            return null;
        }catch(Exception e){
            System.err.println("ERRO GERAL: " + e.getMessage());
            return null;
        }
        
    }
    
}
