/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import livraria.model.Livro;
import livraria.model.ItemCarrinho;
import java.sql.Statement;
/**
 *
 * @author Felipe
 */
public class DaoItemCarrinho {

    private Connection conn;
    
    public DaoItemCarrinho(Connection conn) {
        
        this.conn=conn;
    }   
      public void insertItemCarrinho(Integer idLivro, Integer qtde, String cupom) throws SQLException{
               
                           
        PreparedStatement st1,st2,st3,st4,st5,st6;
        ResultSet rs,rs2,rs3;
        String autor=null;
       
        
        st1 = conn.prepareStatement("SELECT valor FROM LIVRO WHERE idLIvro = ?");
        st1.setInt(1, idLivro);
        rs=st1.executeQuery();                 
        
        Double value =0.0;
            
        while(rs.next()){
            value=rs.getDouble("valor");               
        }
             
        st2 = conn.prepareStatement(
             "INSERT INTO ITEM_CARRINHO VALUES (?,?,?,?)");
             st2.setInt(1, idLivro);     
             st2.setDouble(2, value);
             st2.setInt(3, qtde);
             st2.setDouble(4, (qtde*value));
           
     
            st3=conn.prepareStatement("SELECT qtdeEstoque FROM LIVRO WHERE idLIvro = ?");
        st3.setInt(1, idLivro);
        rs2=st3.executeQuery();   
         
        
        Integer quantEstoque =0;
        
        while(rs2.next()){
            quantEstoque=rs2.getInt("qtdeEstoque");
        }
        
        if (quantEstoque >= qtde){
        //ADICIONA O LIVRO AO CARRINHO E ATUALIZA ESTOQUE    
            JOptionPane.showMessageDialog(null,"Adicionado");
            st2.executeUpdate(); 
            int estoqueAtual = quantEstoque - qtde;
            st4 = conn.prepareStatement(
             "UPDATE LIVRO SET qtdeEstoque = ? WHERE IDLIVRO = ?");
            
            st4.setInt(1, estoqueAtual);
            st4.setInt(2, idLivro);
            st4.executeUpdate();
        }    
        else
            JOptionPane.showMessageDialog(null,"Quantidade solicitada excede o estoque atual, que é de: " + quantEstoque + " unidades");
      
        //VALIDA E ADICIONA CUPOM
             if (cupom.contains("TrabalheNaTegra")){
                 
                 st5=conn.prepareStatement(
                 "SELECT autor FROM LIVRO a INNER JOIN ITEM_CARRINHO b ON a.idLivro=b.idItem WHERE a.idLivro =?");
                 st5.setInt(1,idLivro);
                 rs3=st5.executeQuery();
                 while(rs3.next()){
                     autor= rs3.getString("autor");
                 }
                 
                // JOptionPane.showMessageDialog(null,"teste");
                 if(autor.contains("Fowler")){
                 st6 = conn.prepareStatement(
                 "UPDATE ITEM_CARRINHO SET valorOriginal=?, subTotalItem=? WHERE idItem=?");
                 st6.setDouble(1, 0.9*value); 
                 st6.setDouble(2, 0.9*value*qtde);
                 st6.setInt(3, idLivro);     
                 st6.executeUpdate();
                 JOptionPane.showMessageDialog(null,"Cupom adicionado: 10% nos livros de autor Martin Fowler");
                    }
             
                 else if(autor.contains("Robert")){
                     
                 st6 = conn.prepareStatement(
                 "UPDATE ITEM_CARRINHO SET valorOriginal=?,subTotalItem=? WHERE idItem=?");
                 st6.setDouble(1, 0.8*value); 
                 st6.setDouble(2, 0.8*value*qtde);
                 st6.setInt(3, idLivro);
                 st6.executeUpdate();
                 JOptionPane.showMessageDialog(null,"Cupom adicionado: 20% nos livros de autor Robert C. Martin");
                    }
            }
                     
      }
      
             
           
    public List<ItemCarrinho> listaCarrinho() throws SQLException{
                   
        PreparedStatement st = null;
        ResultSet rs = null;
        
        st = conn.prepareStatement(
                "SELECT a.idItem,b.titulo,b.autor,a.valorOriginal,a.qtdeItem,a.subTotalItem FROM ITEM_CARRINHO a INNER JOIN LIVRO b ON a.idItem = b.idLivro"
        );
                
        rs=st.executeQuery();        
        
        List<ItemCarrinho> listaCarrinho = new ArrayList<>();
        while(rs.next()){
            ItemCarrinho itemCarrinho = new ItemCarrinho(rs.getInt("idItem"),rs.getString("titulo"),rs.getString("autor"),rs.getDouble("valorOriginal"),rs.getInt("qtdeItem"),rs.getDouble("subTotalItem"));
            listaCarrinho.add(itemCarrinho);        
            
        }      
                         
        return listaCarrinho; 
       }
        
    public void limpaCarrinho() throws SQLException{
           
        PreparedStatement st,st2,st3 =null;
        //RETORNA OS LIVROS EXCLUÍDOS AO ESTOQUE    
         st = conn.prepareStatement(
            "SELECT idItem, qtdeItem FROM ITEM_CARRINHO");
         ResultSet rs=st.executeQuery();
         
         
         while (rs.next()){
             st3=conn.prepareStatement(
            "UPDATE LIVRO SET qtdeEstoque = qtdeEstoque + ?"        
             );
             st3.setInt(1, rs.getInt("qtdeItem"));
             st3.executeUpdate();
         }
         
         
        
        st2 = conn.prepareStatement(
                "DELETE FROM ITEM_CARRINHO"
        );
          
        st2.executeUpdate();
        
        
       }
    
    
}
    
    
    
    

