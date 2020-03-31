/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.view;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import livraria.control.Conexao;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import livraria.control.DaoLivro;
import livraria.model.Livro;
import livraria.control.DaoItemCarrinho;

/**
 *
 * @author Felipe
 */
public class GuiVitrine extends javax.swing.JFrame {

    /**
     * Creates new form Vitrine
     */
    public GuiVitrine() {
        initComponents();
        Locale.setDefault(Locale.UK);
        carregaVitrine();
        
        
    }
    
    
    
       public void carregaVitrine(){
            DaoLivro daoLivro = new DaoLivro(Conexao.getConnection());

            List<Livro> lista = new ArrayList<>();

            try {
                lista = daoLivro.listaLivro();
            } catch (SQLException ex) {
                Logger.getLogger(GuiEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            // System.out.println(lista);
            
            DefaultTableModel modVitrine = (DefaultTableModel)tblVitrine.getModel();

            Object livro[] = new Object[4];

            for(int i=0; i<lista.size(); i++){

                livro[0]=lista.get(i).getIdLivro();
                livro[1]=lista.get(i).getTitulo();
                livro[2]=lista.get(i).getAutor();
                livro[3]=String.format("%.2f",lista.get(i).getValor()).replace(".", ",");
               

                modVitrine.addRow(livro);
            };
    } 
    
    public void filtraAutor(String autor){
        
         List<Livro> listaF = new ArrayList<>();
        
        DaoLivro daoLivro = new DaoLivro(Conexao.getConnection());
       
        
        try {
                listaF = daoLivro.listaLivroFilt("%"+autor+"%");
            } catch (SQLException ex) {
                Logger.getLogger(GuiEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
        DefaultTableModel modVitrine = (DefaultTableModel)tblVitrine.getModel();
        modVitrine.setRowCount(0);
        
            Object livro[] = new Object[4];

            for(int i=0; i<listaF.size(); i++){

                livro[0]=listaF.get(i).getIdLivro();
                livro[1]=listaF.get(i).getTitulo();
                livro[2]=listaF.get(i).getAutor();
                livro[3]=String.format("%.2f",listaF.get(i).getValor()).replace(".", ",");
               

                modVitrine.addRow(livro);
            };
       
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVitrine = new javax.swing.JTable();
        btnAddCarrinho = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEstIdLivro = new javax.swing.JTextField();
        txtQtde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAutorFiltro = new javax.swing.JTextField();
        btnFiltraAutor = new javax.swing.JButton();
        btnTirarFiltro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCupom = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        mnVitrine = new javax.swing.JMenuItem();
        mnCarrinho = new javax.swing.JMenuItem();
        mnEstoque = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVitrine.setAutoCreateRowSorter(true);
        tblVitrine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Livro", "Título", "Autor", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblVitrine.setName("tblVitrine"); // NOI18N
        jScrollPane1.setViewportView(tblVitrine);

        btnAddCarrinho.setText("Adicionar ao carrinho");
        btnAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCarrinhoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade");

        jLabel2.setText("id Livro");

        txtEstIdLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstIdLivroActionPerformed(evt);
            }
        });

        txtQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vitrine de Livros");

        jLabel4.setText("Autor");

        txtAutorFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorFiltroActionPerformed(evt);
            }
        });

        btnFiltraAutor.setText("Filtrar por autor");
        btnFiltraAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltraAutorActionPerformed(evt);
            }
        });

        btnTirarFiltro.setText("Tirar filtro");
        btnTirarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarFiltroActionPerformed(evt);
            }
        });

        jLabel5.setText("Cupom");

        txtCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCupomActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCupom))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtEstIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtAutorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel3)))
                                .addGap(93, 93, 93)))
                        .addComponent(btnAddCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFiltraAutor)
                        .addGap(26, 26, 26)
                        .addComponent(btnTirarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAddCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutorFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnFiltraAutor)
                    .addComponent(btnTirarFiltro))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnVitrineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVitrineActionPerformed
        GuiVitrine GuiVitrine= new GuiVitrine();
        GuiVitrine.setVisible(true);
        dispose();
    }//GEN-LAST:event_mnVitrineActionPerformed

    private void mnCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCarrinhoActionPerformed

        GuiCarrinho GuiCarrinho= new GuiCarrinho();
        GuiCarrinho.setVisible(true);
        dispose();
    }//GEN-LAST:event_mnCarrinhoActionPerformed

    private void mnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEstoqueActionPerformed

        GuiEstoque GuiEstoque= new GuiEstoque();
        GuiEstoque.setVisible(true);
        dispose();
    }//GEN-LAST:event_mnEstoqueActionPerformed

    private void txtQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdeActionPerformed

    private void btnAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCarrinhoActionPerformed

        DaoItemCarrinho daoItemCarrinho = new DaoItemCarrinho(Conexao.getConnection());

        
       try {
                daoItemCarrinho.insertItemCarrinho(Integer.parseInt(txtEstIdLivro.getText()), Integer.parseInt(txtQtde.getText()),txtCupom.getText());
            
        } catch (SQLException ex) {
            Logger.getLogger(GuiVitrine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnAddCarrinhoActionPerformed

    private void txtAutorFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorFiltroActionPerformed

    private void btnFiltraAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltraAutorActionPerformed
    
        filtraAutor(txtAutorFiltro.getText());
        

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltraAutorActionPerformed

    private void txtEstIdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstIdLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstIdLivroActionPerformed

    private void btnTirarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarFiltroActionPerformed

        DefaultTableModel modVitrine = (DefaultTableModel)tblVitrine.getModel();
        modVitrine.setRowCount(0);
        carregaVitrine();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTirarFiltroActionPerformed

    private void txtCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCupomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCupomActionPerformed

     
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
            java.util.logging.Logger.getLogger(GuiVitrine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiVitrine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiVitrine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiVitrine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiVitrine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCarrinho;
    private javax.swing.JButton btnFiltraAutor;
    private javax.swing.JButton btnTirarFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnCarrinho;
    private javax.swing.JMenuItem mnEstoque;
    private javax.swing.JMenuItem mnVitrine;
    private javax.swing.JTable tblVitrine;
    private javax.swing.JTextField txtAutorFiltro;
    private javax.swing.JTextField txtCupom;
    private javax.swing.JTextField txtEstIdLivro;
    private javax.swing.JTextField txtQtde;
    // End of variables declaration//GEN-END:variables
}
