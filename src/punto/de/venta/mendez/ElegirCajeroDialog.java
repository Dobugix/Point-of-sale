/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.de.venta.mendez;

import Conexion.Conectar;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario Alberto
 */
public class ElegirCajeroDialog extends javax.swing.JDialog {
        public Conectar cc = new Conectar();
    public Connection cn = (Connection) cc.conexionAdmin();
    public  JButton jButton1;
    public JPanel jPanel1, jPanel2;
    public JLabel jLabel1;
    public JTextField jTextField1;
    public JScrollPane jScrollPane1;
    public JTable cajero;
    public String[] datosTable= new String[4];
    public String Sql, name;
        public DefaultTableModel modeloCajero = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas==5){
                return true;
            }else{
                return false;
            }
        }
    };
    /**
     * Creates new form ElegirCajeroDialog
     * @param parent
     * @param modal
     */
    public ElegirCajeroDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Punto de venta Abarrotes 'Tamesí'");
        modeloCajero.addColumn("ID Cajero");
        modeloCajero.addColumn("Nombre");
        cajero.setModel(modeloCajero);
        cajero.getTableHeader().setReorderingAllowed(false);
        cajero.setRowSelectionAllowed(true);
        cajero.setColumnSelectionAllowed(false);
        Sql = "select id_cajero, name_cajero from cajero;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){               
                datosTable[0]=rs.getString(1);
                datosTable[1]=rs.getString(2);
                modeloCajero.addRow(datosTable);                            
            }
            cajero.setModel(modeloCajero);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajero = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back1.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Usuario (2).png"))); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 310));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        cajero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(cajero);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 220, 180));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 220, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        try {
            boolean a = true;
            InterfazPrincipalCobrar ipc = new InterfazPrincipalCobrar();
            for (int i = 0; i < cajero.getRowCount(); i++) {
                if ((cajero.getValueAt(i, 0).toString().equals(jTextField1.getText()))) {
                    name = ((String) cajero.getValueAt(i, 1));
                    ipc.ElegirCajero(name, parseInt((String) cajero.getValueAt(i, 0)));
                    jButton1.setEnabled(true);
                    this.dispose();
                    a = false;
                    break;
                }else if (i<cajero.getRowCount()) {
                } else {
                }
            }
            if (a) {
                JOptionPane.showMessageDialog(null, "ID equivocado","Intentelo de Nuevo", JOptionPane.WARNING_MESSAGE);
                jTextField1.setText("");}
        } catch (SQLException ex) {
            Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ElegirCajeroDialog dialog = new ElegirCajeroDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    }
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable cajero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

*/