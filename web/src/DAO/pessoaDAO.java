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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.pessoa;

/**
 *
 * @author titof
 */
public class pessoaDAO {
    
    private dataSource ds;
    
    public pessoaDAO(dataSource d){
        this.ds = d;
    }
    
    public ArrayList<pessoa> READ(){
        
        try{
            
            String sql = "SELECT * FROM PESSOA";
            PreparedStatement ps = ds.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<pessoa> pessoas = new ArrayList<pessoa>();
            
            while(rs.next()){
                
                pessoa p = new pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getInt("cpf"));
                p.setTelefone(rs.getInt("telefone"));
                pessoas.add(p);
            }
            
            ps.close();
            return pessoas;
            
        }catch(SQLException ex){
            System.err.println("ERRO AO RECUPERAR : " + ex.getMessage());
            return null;
        }catch(Exception e){
            System.err.println("ERRO GERAL: " + e.getMessage());
            return null;
        }
        
    }
    
    
    public boolean inserir(pessoa p){

        try {
            String sql = "INSERT INTO PESSOA (nome, telefone, cpf) VALUES (?,?,?)";
            PreparedStatement ps = ds.getConnection().prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getTelefone());
            ps.setInt(3, p.getCpf());
            ps.execute();
            ps.close();

            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO AO INSERIR " + ex.getMessage());
        } catch(Exception e){
            System.err.println("ERRO GERAL: " + e.getMessage());
            return false;
        }
        return false;
    }
    
    public boolean UPDATE(){
        boolean check = false;
        String op = null;
        String alt = null;
        int altint = 0;
        
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE O ID DA PESSOA QUE DESEJA ALTERAR"));
            
        
        try{
            
            while(check == false){
            op = JOptionPane.showInputDialog(null,"DIGITE O CAMPO QUE DESEJA ALTERAR( NOME, TELEFONE, CPF): ");
            
             if( op.compareToIgnoreCase("nome") == 0){
                System.out.println("TRUE");
                alt = JOptionPane.showInputDialog(null,"Digite o novo nome");
                System.out.println(alt);
                check = true;
                System.out.println(check);
            }else if(op.compareToIgnoreCase("telefone") == 0){
                
                altint = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o novo telefone"));
                check = true;
            }else if(op.compareToIgnoreCase("cpf") == 0){
                
                altint = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o novo cpf"));
            check = true;
            }
               
            }
            
            String nome = JOptionPane.showInputDialog(null,"Digite o nome cadastrado da pessoa que deseja alterar");
            
            String sql = "UPDATE PESSOA SET " + op +" = '"+alt+"' " + "WHERE id LIKE '" + id + "'";
            PreparedStatement ps = ds.getConnection().prepareStatement(sql);
            ps.execute();
            ps.close();
            return true;
        }catch(SQLException ex){
            System.err.println("ERRO AO ATUALIZAR: " + ex.getMessage());
            return false;
        }catch(Exception e){
            System.err.println("ERRO GERAL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean DELETE(){
         
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"DIGITE O ID DA PESSOA QUE DESEJA DELETAR"));
        
        String sql = "DELETE FROM PESSOA WHERE id = " + id;
        try{
        PreparedStatement ps = ds.getConnection().prepareStatement(sql);
        ps.execute();
        return true;
        }catch(SQLException ex){
            System.err.println("ERRO AO DELETAR: " + ex.getMessage());
            return false;
        }
    }
    
       public ArrayList<String> relate(){
        String sql = "SELECT PESSOA.nome, CURSO.nomeCurso FROM PESSOA INNER JOIN CURSO ON PESSOA.matricula = CURSO.matricula";
        String r = null;
        try{
        
            PreparedStatement ps = ds.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<String> rList = new ArrayList<String>();
            
            while(rs.next()){
            r = "NOME: " + rs.getString("nome") + " CURSO: " +  rs.getString("nomeCurso");
            rList.add(r);
            }
            ps.close();
            return rList;
            
        }catch(SQLException ex){
            System.err.println("ERRO AO RELACIONAR : " + ex.getMessage());
            return null;
        }catch(Exception e){
            System.err.println("ERRO GERAL : " + e.getMessage());
            return null;
        }
       }
    
}
