/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.control;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import livraria.model.Livro;
import java.util.List;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Felipe
 */
public class DaoLivro {
    
    private Connection conn;
    
    
    public DaoLivro(Connection conn){
    	this.conn=conn;
   }
             
    public void insertLivro(Integer idLivro, String titulo, String autor, Double valor, Integer qtdeEstoque) throws SQLException{
               
        PreparedStatement st,st2 = null;
        ResultSet rs = null;
      
        //VERIFICA SE O LIVRO JÁ ESTÁ CADASTRADO E TRATA-SE DE UMA ATUALIZAÇÃO DE DADOS
        st2 = conn.prepareStatement(
             "SELECT * FROM LIVRO WHERE idLivro = ?");
            st2.setInt(1, idLivro);
                 
        
        ResultSet result = st2.executeQuery();
         
        if(result.next() ==false) {

        st = conn.prepareStatement(
             "INSERT INTO LIVRO VALUES (?,?,?,?,?)");
             
             st.setInt(1, idLivro);
             st.setString(2, titulo);
             st.setString(3, autor);
             st.setDouble(4, valor);
             st.setInt(5, qtdeEstoque);
            
        st.executeUpdate(); 
        }
        else{
            st = conn.prepareStatement(
             "UPDATE LIVRO SET titulo=?, autor=?, valor=?, qtdeEstoque=? WHERE idLivro=?");
        
             st.setString(1, titulo);
             st.setString(2, autor);
             st.setDouble(3, valor);
             st.setInt(4, qtdeEstoque);
             st.setInt(5, idLivro);
            
        st.executeUpdate(); 
           
        }   
    }
    
        
    public List<Livro> listaLivro() throws SQLException{
                   
        PreparedStatement st = null;
        ResultSet rs = null;
        
        st = conn.prepareStatement(
                "SELECT * FROM LIVRO"
        );
                
        rs=st.executeQuery();        
        
        List<Livro> listaLivro = new ArrayList<>();
        while(rs.next()){
            Livro livro = new Livro(rs.getInt("idLivro"),rs.getString("titulo"),rs.getString("autor"),rs.getDouble("valor"),rs.getInt("qtdeEstoque"));
            listaLivro.add(livro);
        }
        
        return listaLivro; 
       }
    
      
    
    public List<Livro> listaLivroFilt(String autor) throws SQLException{
                   
        PreparedStatement st = null;
        ResultSet rs = null;
        
        st = conn.prepareStatement(
                "SELECT * FROM LIVRO WHERE autor LIKE ?"
        );
        st.setString(1, autor);
        rs=st.executeQuery();        
        
        List<Livro> listaLivroF = new ArrayList<>();
        while(rs.next()){
            Livro livro = new Livro(rs.getInt("idLivro"),rs.getString("titulo"),rs.getString("autor"),rs.getDouble("valor"),rs.getInt("qtdeEstoque"));
            listaLivroF.add(livro);
        }
        
        return listaLivroF; 
    }
    
    
    public void deleteLivro(Integer idLivro) throws SQLException{
        Livro livro = null;
           
        PreparedStatement st = null;
        ResultSet rs = null;
        
        st = conn.prepareStatement(
                "DELETE FROM LIVRO WHERE idLivro = ?"
        );
        
        st.setInt(1, idLivro);   
        st.executeUpdate();
       }
    
    
     public List<Livro> carregaLivro(Integer Id) throws SQLException{
                   
        PreparedStatement st = null;
        ResultSet rs = null;
        
        st = conn.prepareStatement(
                "SELECT * FROM LIVRO WHERE IDLIVRO = ?"
        );
        st.setInt(1, Id);        
        rs=st.executeQuery();        
        
        List<Livro> listaLivro = new ArrayList<>();
        while(rs.next()){
            Livro livro = new Livro(rs.getInt("idLivro"),rs.getString("titulo"),rs.getString("autor"),rs.getDouble("valor"),rs.getInt("qtdeEstoque"));
            listaLivro.add(livro);
        }
        
        return listaLivro; 
       }
        
}
