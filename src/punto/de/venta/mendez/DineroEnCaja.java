/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.de.venta.mendez;
import static java.time.LocalDate.now;
import Conexion.Conectar;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseFloat;

/**
 *
 * @author Mario Alberto
 */
public class DineroEnCaja extends javax.swing.JDialog {
    public Conectar cc = new Conectar();
    public Connection cn = cc.conexionAdmin();
    public Object datos[] = new Object[10];
    public DineroEnCaja(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        jTextField3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        jTextField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/caja.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Fondo de Caja:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 180, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Fondo de Caja.");
        }else{
            try {
                        try {
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery("select fecha from cortes where fecha LIKE '%"+now()+"%';"); 
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Ajustar 'Fondo de caja' en 'Panel de Control'. ");
            }else{   
                PreparedStatement pst=cn.prepareStatement("insert into cortes(fondo_caja) values("+jTextField1.getText()+")");
                pst.executeUpdate();
            }
        
    }catch (SQLException ex) {
            Logger.getLogger(Folios.class.getName()).log(Level.SEVERE, null, ex);
        }
            InterfazPrincipalCobrar ipc = new InterfazPrincipalCobrar();
            this.dispose();
            } catch (SQLException ex) {
            Logger.getLogger(DineroEnCaja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        
        char c = evt.getKeyChar();
        if ((( c < '0') || (c > '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || jTextField1.getText().contains(".")) ) evt.consume();
       
    }//GEN-LAST:event_jTextField1KeyTyped
    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt){
                
        char c = evt.getKeyChar();
        if ((( c < '0') || (c > '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || jTextField1.getText().contains(".")) ) evt.consume();
       
    }
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
                    
        try {
            PreparedStatement pst=cn.prepareStatement("update cortes set fondo_caja = "+jTextField2.getText()+" where fecha LIKE '%"+now()+"%';");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DineroEnCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        try {      
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select id_corte from cortes order by id_corte desc limit 1;");
                while (rs.next()) {
                    datos[0] = rs.getInt(1);
                }
            //PreparedStatement pst=cn.prepareStatement("SET SQL_SAFE_UPDATES = 0;");
            //pst.executeUpdate();
            PreparedStatement pst=cn.prepareStatement("update cortes set fondo_caja = "+jTextField3.getText()+" where id_corte = "+datos[0]+" ;");
            int a=pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(this, "¡Cambio realizado con éxito!");
            }
            //pst=cn.prepareStatement("SET SQL_SAFE_UPDATES = 1;");
            //pst.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(DineroEnCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
                char c = evt.getKeyChar();
        if ((( c < '0') || (c > '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || jTextField1.getText().contains(".")) ) evt.consume();
       
    }//GEN-LAST:event_jTextField3KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
