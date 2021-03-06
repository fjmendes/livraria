/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.view;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import livraria.control.DaoLivro;
import livraria.control.Conexao;
import livraria.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Locale;
/**
 *
 * @author Felipe
 */
public class GuiEstoque extends javax.swing.JFrame {

    //private Object modEstoque;
   
    /**
     * Creates new form GuiEstoque
     */
    public GuiEstoque() {
       initComponents();
       Locale.setDefault(Locale.UK);
       carregaEstoque();

    }
    

    
      public void carregaEstoque(){
            DaoLivro daoLivro = new DaoLivro(Conexao.getConnection());

            List<Livro> lista = new ArrayList<>();

            try {
                lista = daoLivro.listaLivro();
            } catch (SQLException ex) {
                Logger.getLogger(GuiEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel modEstoque = (DefaultTableModel)tblEstoque.getModel();

            Object livro[] = new Object[5];
            
            
                    
            for(int i=0; i<lista.size(); i++){

                livro[0]=lista.get(i).getIdLivro();
                livro[1]=lista.get(i).getTitulo();
                livro[2]=lista.get(i).getAutor();
                livro[3]=String.format("%.2f",lista.get(i).getValor()).replace(".", ",");
                livro[4]=lista.get(i).getQtdeEstoque();

                modEstoque.addRow(livro);
            };

    }        
      
      public void carregaLivro(){
            DaoLivro daoLivro = new DaoLivro(Conexao.getConnection());

            List<Livro> lista = new ArrayList<>();

            try {
                
                lista = daoLivro.carregaLivro(Integer.parseInt(txtEstIdLivro.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(GuiEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultTableModel modEstoque = (DefaultTableModel)tblEstoque.getModel();
            
            

            for(int i=0; i<lista.size(); i++){

                txtEstIdLivro.setText(lista.get(i).getIdLivro().toString());
                txtEstTitulo.setText(lista.get(i).getTitulo());
                txtEstAutores.setText(lista.get(i).getAutor());
                txtEstPc.setText(String.format("%.2f",lista.get(i).getValor()).replace(".", ","));
                txtEstQtde.setText(lista.get(i).getQtdeEstoque().toString());

           
            };
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstoque = new javax.swing.JTable();
        btnCadastraLivro = new javax.swing.JButton();
        txtEstAutores = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEstTitulo = new javax.swing.JTextField();
        txtEstIdLivro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEstQtde = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEstPc = new javax.swing.JTextField();
        btnExcluiLivro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCarregaLivro = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        mnVitrine = new javax.swing.JMenuItem();
        mnCarrinho = new javax.swing.JMenuItem();
        mnEstoque = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEstoque.setAutoCreateRowSorter(true);
        tblEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Livro", "Título", "Autor", "Preço", "Qtde Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEstoque.setName("tblEstoque"); // NOI18N
        jScrollPane1.setViewportView(tblEstoque);

        btnCadastraLivro.setText("Cadastrar");
        btnCadastraLivro.setNextFocusableComponent(btnExcluiLivro);
        btnCadastraLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraLivroActionPerformed(evt);
            }
        });

        txtEstAutores.setNextFocusableComponent(txtEstQtde);
        txtEstAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstAutoresActionPerformed(evt);
            }
        });

        jLabel1.setText("Autores");

        jLabel2.setText("Título");

        txtEstTitulo.setNextFocusableComponent(txtEstAutores);
        txtEstTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstTituloActionPerformed(evt);
            }
        });

        txtEstIdLivro.setNextFocusableComponent(txtEstTitulo);
        txtEstIdLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstIdLivroActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        txtEstQtde.setFocusCycleRoot(true);
        txtEstQtde.setNextFocusableComponent(txtEstPc);
        txtEstQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstQtdeActionPerformed(evt);
            }
        });

        jLabel4.setText("Qtde Estoque");

        jLabel5.setText("Preço Unitário");

        txtEstPc.setNextFocusableComponent(btnCadastraLivro);
        txtEstPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstPcActionPerformed(evt);
            }
        });

        btnExcluiLivro.setText("Excluir");
        btnExcluiLivro.setName("btnExcluiLivro"); // NOI18N
        btnExcluiLivro.setNextFocusableComponent(txtEstIdLivro);
        btnExcluiLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiLivroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Estoque");

        btnCarregaLivro.setText("Carrega livro por ID para alteração");
        btnCarregaLivro.setName("btnExcluiLivro"); // NOI18N
        btnCarregaLivro.setNextFocusableComponent(txtEstIdLivro);
        btnCarregaLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregaLivroActionPerformed(evt);
            }
        });

        jMenu4.setText("Telas");

        mnVitrine.setText("Vitrine");
        mnVitrine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVitrineActionPerformed(evt);
            }
        });
        jMenu4.add(mnVitrine);

        mnCarrinho.setText("Carrinho");
        mnCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCarrinhoActionPerformed(evt);
            }
        });
        jMenu4.add(mnCarrinho);

        mnEstoque.setText("Estoque");
        mnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEstoqueActionPerformed(evt);
            }
        });
        jMenu4.add(mnEstoque);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEstTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEstAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstIdLivro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEstPc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEstQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65))
                            .addComponent(btnCadastraLivro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnExcluiLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCarregaLivro)))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtEstQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtEstPc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastraLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluiLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarregaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
  
       
               
    private void btnCadastraLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraLivroActionPerformed
        
        DaoLivro daoLivro = new DaoLivro(Conexao.getConnection());
        
             
        try {
            daoLivro.insertLivro(Integer.parseInt(txtEstIdLivro.getText()),txtEstTitulo.getText(), txtEstAutores.getText(), Double.parseDouble(txtEstPc.getText().replace(",", ".")),Integer.parseInt(txtEstQtde.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(GuiEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modEstoque = (DefaultTableModel)tblEstoque.getModel();
         modEstoque.setRowCount(0);
         carregaEstoque();
               
        txtEstIdLivro.setText("");
        txtEstTitulo.setText("");
        txtEstAutores.setText("");
        txtEstPc.setText("");
        txtEstQtde.setText("");
        
    }//GEN-LAST:event_btnCadastraLivroActionPerformed

    private void txtEstAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstAutoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstAutoresActionPerformed

    private void txtEstTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstTituloActionPerformed

    private void txtEstIdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstIdLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstIdLivroActionPerformed

    private void txtEstQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstQtdeActionPerformed

    private void txtEstPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstPcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstPcActionPerformed

    private void btnExcluiLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiLivroActionPerformed

        DaoLivro daoLivro = new DaoLivro(Conexao.getConnection());
                     
       try {
            daoLivro.deleteLivro(Integer.parseInt(txtEstIdLivro.getText()));
        } 
        catch (SQLException ex) {
           Logger.getLogger(GuiEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtEstIdLivro.setText("");
        
        DefaultTableModel modEstoque = (DefaultTableModel)tblEstoque.getModel();
        //
        modEstoque.setRowCount(0);
        carregaEstoque();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluiLivroActionPerformed

    private void mnCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCarrinhoActionPerformed
    
        GuiCarrinho GuiCarrinho= new GuiCarrinho();
        GuiCarrinho.setVisible(true);
        dispose();
    }//GEN-LAST:event_mnCarrinhoActionPerformed

    private void mnVitrineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVitrineActionPerformed
        GuiVitrine GuiVitrine= new GuiVitrine();
        GuiVitrine.setVisible(true);
        dispose();
      
    }//GEN-LAST:event_mnVitrineActionPerformed

    private void mnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEstoqueActionPerformed

        GuiEstoque GuiEstoque= new GuiEstoque();
        GuiEstoque.setVisible(true);
        dispose();
    }//GEN-LAST:event_mnEstoqueActionPerformed

    private void btnCarregaLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregaLivroActionPerformed


        carregaLivro();


        // TODO add your handling code here:
    }//GEN-LAST:event_btnCarregaLivroActionPerformed

     private void mnEstoqueMouseClicked(java.awt.event.MouseEvent evt) {                                       
       
        
        GuiEstoque GuiEstoque= new GuiEstoque();
        GuiEstoque.setVisible(true);
        
    }                                      

     private void mnCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {                                       
       
        
        GuiCarrinho GuiCarrinho= new GuiCarrinho();
        GuiCarrinho.setVisible(true);
        
    } 
    
       private void mnVitrineMouseClicked(java.awt.event.MouseEvent evt) {                                       
       
        
        GuiVitrine GuiVitrine= new GuiVitrine();
        GuiVitrine.setVisible(true);
        
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiEstoque().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastraLivro;
    private javax.swing.JButton btnCarregaLivro;
    private javax.swing.JButton btnExcluiLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnCarrinho;
    private javax.swing.JMenuItem mnEstoque;
    private javax.swing.JMenuItem mnVitrine;
    private javax.swing.JTable tblEstoque;
    private javax.swing.JTextField txtEstAutores;
    private javax.swing.JTextField txtEstIdLivro;
    private javax.swing.JTextField txtEstPc;
    private javax.swing.JTextField txtEstQtde;
    private javax.swing.JTextField txtEstTitulo;
    // End of variables declaration//GEN-END:variables
}
