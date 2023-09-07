package punto.de.venta.mendez;

import Conexion.Conectar;
import java.awt.event.KeyEvent;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 *
 * @author Mario Alberto
 */
public class InterfazPrincipalCobrar extends javax.swing.JFrame {

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
    private float fondo_caja;
    private float dinero_caja;
    public static float total;
    private static float pagoCon;
    private static float cambio;
    public static String code;
    private static String cantidadGranel;
    public Calendar day = new GregorianCalendar();
    public static int id_cajero = 0;
    public int anio = day.get(Calendar.YEAR),
            mes = day.get(Calendar.MONTH),
            dia = day.get(Calendar.DAY_OF_MONTH),
            hora = day.get(Calendar.HOUR_OF_DAY),
            min = day.get(Calendar.MINUTE),
            second = day.get(Calendar.SECOND);
    
    /*public Conectar cc = new Conectar();
    public Connection cn = cc.conexionAdmin();*/
    
    public Conectar cc = new Conectar();
    public Connection cn = (Connection) cc.conexionAdmin();
    
    public String Sql, Sql2;
    private static String name_cajero;
    public static String[] datos = new String[5];
    public int[] datos_p = new int[2];
    public DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 5) {
                return true;
            } else {
                return false;
            }
        }
    };
    
    public boolean b;    
    private boolean cancel;
    public JTextField cantidad = new JTextField(5), cdg_eliminar;
    public JTextField codigo = new JTextField(10);
    public JPanel myPanel = new JPanel();
    public JPanel PanelElim = new JPanel();
    public JPanel ElegirCajero = new JPanel();
    public JTextField eliminar = new JTextField(5);
    public JTable cajero = new JTable();
    public JTextField idCajero = new JTextField(5);
    
    public InterfazPrincipalCobrar() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        System.out.println(dinero_caja);
        jTextField1.requestFocusInWindow();
        eliminar.setText("");
        modelo.addColumn("ID Producto");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Importe");
        jTable1.setModel(modelo);        
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(120);
        columnModel.getColumn(1).setPreferredWidth(400);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(120);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setColumnSelectionAllowed(false);
        /* Sql = "select * from cajero;";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            while (rs.next()) {
                jLabel5.setText(rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("");
        }*/
        jLabel7.setText("$ 0");
        myPanel.add(new JLabel("Cantidad"));
        myPanel.add(cantidad);
        
        myPanel.add(Box.createHorizontalStrut(20));
        myPanel.add(new JLabel("Codigo"));
        myPanel.add(codigo);
        PanelElim.add(new JLabel("Ingrese la Fila:"));
        PanelElim.add(eliminar);
        PanelElim.add(Box.createHorizontalStrut(50));
        jLabel6.setText(dia + "/" + mes + "/" + anio);// + "  -  " + hora + ":" + min + " " + second);
        jLabel5.setText(name_cajero);
        jPanel5.setVisible(false);
        jButton7.setVisible(false);
        jLabel12.setVisible(false);
        jLabel14.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1020, 350));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/money-icon_1.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 204, 0));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cobrar_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Pago con:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("$ 0.00");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Cambio:");

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sale.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton7KeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Teclea ' ESC ' para Regresar.");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Oprime ' ESC ' para Cancelar.");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("El Pago debe ser equivalente.");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 153, 0));
        jLabel15.setText("Teclea 'ENTER' para Cobrar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel15)
                .addGap(2, 2, 2)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton5.setBackground(new java.awt.Color(0, 153, 0));
        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/shopping-cart.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1020, 180));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jTextField1.setFocusCycleRoot(true);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add (1).png"))); // NOI18N
        jButton2.setText("Agregar Cantidad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eliminar.png"))); // NOI18N
        jButton3.setText("Eliminar Articulo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ventas.png"))); // NOI18N
        jButton4.setText("Ventas del día");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logotipo (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(189, 189, 189))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 190));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(11, 0, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 236));
        jLabel1.setText("Lo Atiende: ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Usuario (2).png"))); // NOI18N
        jLabel3.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Lo Atiende: ");
        jLabel2.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Cajero: ");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setFocusable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir (2).png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Usuario (3).png"))); // NOI18N
        jButton6.setText("Cambiar Cajero");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/conf (1).png"))); // NOI18N
        jButton8.setText("Panel de Control");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton8))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton6)))
                                .addGap(172, 172, 172)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 260, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Salir();
        } catch (SQLException ex) {
            Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_jButton1ActionPerformed
     public void SalirResguardarTodo() throws SQLException{
         
        for (int i = 0; i < jTable1.getRowCount(); i++) {
        PreparedStatement pst=cn.prepareStatement("update Productos set Existencia= Existencia + "+ modelo.getValueAt(i, 3) +" where codigo = "+ modelo.getValueAt(i, 0) +";");
        pst.executeUpdate();        
        }
     }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        if (!jTextField1.getText().isEmpty()) {
            
        
        code = jTextField1.getText();
        Sql = "Select codigo, descripcion, precio_publico, Existencia from Productos where codigo=" + code + ";";
        if (id_cajero == 0) {
            String botones[] = {" Regresar "};
                    JOptionPane.showOptionDialog(this, "No se ha Registrado.", "Identificate Porfavor.",
                0, 0, null, botones , this);
        }else{
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            b = rs.next();
            if (b) {
                if (VerificarGranel()) {
                    
                    setCantidadGranel("0");
                    setCancel(true);
                    Granel g = new Granel(null, true);
                    g.setVisible(true);
                    b = false;
                    
                    
                    if (isCancel()) {
                        
                        if (parseFloat(getCantidadGranel()) != 0) {
                            
                        
                    AgregarInTable(getCantidadGranel(),getCode());}}
                    jTextField1.setText("");
                } else {
                    while (b) {
                        if (consultaTables(jTextField1.getText())) {
                            if (rs.getFloat(4) > 0) {
                            PreparedStatement pst=cn.prepareStatement("update Productos set Existencia= Existencia - 1 where codigo = "+ code +";");
                            pst.executeUpdate();
                            datos[4] = Float.toString(parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(jTextField1.getText()), 3)) + 1);
                            modelo.setValueAt(datos[4], consultaTablesexactitud(jTextField1.getText()), 3);
                            modelo.setValueAt(parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(jTextField1.getText()), 2)) * parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(jTextField1.getText()), 3)),
                                    consultaTablesexactitud(jTextField1.getText()), 4);
                            jTable1.getSelectionModel().setSelectionInterval(consultaTablesexactitud(jTextField1.getText()), 1);
                            TotalImporte();
                            }else{
                                NotFoundInventario();
                            }
                        } else {
                            if (rs.getFloat(4) > 0) {
                            PreparedStatement pst=cn.prepareStatement("update Productos set Existencia= Existencia - 1 where codigo = "+ code +";");
                            pst.executeUpdate();
                            datos[0] = rs.getString(1);
                            datos[1] = rs.getString(2);
                            datos[2] = rs.getString(3);
                            datos[3] = "1";
                            datos[4] = Float.toString(parseFloat(datos[3]) * parseFloat(datos[2]));
                            modelo.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), "1", Float.toString(parseFloat(rs.getString(3)) * 1)});
                            modelo.setValueAt(parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(jTextField1.getText()), 2)) * parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(jTextField1.getText()), 3)),
                                    consultaTablesexactitud(jTextField1.getText()), 4);
                            TotalImporte();
                        }
                        else{
                                NotFoundInventario();
                            }}
                        b = false;
                        jTextField1.setText("");
                    }
                }
            } else {
                NotFound();
                jTextField1.requestFocusInWindow();
                jTextField1.setText("");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
    }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        try {
            Folios f = new Folios(this, true);
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Ingresar", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                AgregarInTable(cantidad.getText(), codigo.getText());
            } catch (SQLException ex) {
                Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            cantidad.setText("");
            codigo.setText("");
        } else {
            cantidad.setText("");
            codigo.setText("");
        }
        jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, PanelElim,
                "Eliminar", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                code = eliminar.getText();
                EliminarInTable(code);
            } catch (SQLException ex) {
                Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            TotalImporte();
        }
        jTextField1.requestFocusInWindow();
        eliminar.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jTable1.getRowCount() > 0) {
            
            jPanel5.setVisible(true);
            jTextField1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            jTextField2.requestFocusInWindow();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ElegirCajeroDialog el = new ElegirCajeroDialog(this, true);
        el.jButton1.setEnabled(true);
        el.setVisible(true);
        jLabel5.setText(getName_cajero());
        System.out.println(getName_cajero());
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        if (!jTextField2.getText().isEmpty()) {
            setPagoCon(parseFloat(jTextField2.getText()));
            if (total <= parseFloat(jTextField2.getText())) {
                setCambio(parseFloat(jTextField2.getText()) - total);
                jLabel10.setText("$ " + getCambio());
                jButton7.setVisible(true);
                jLabel12.setVisible(true);
                jTextField2.setEnabled(false);
                jLabel13.setText("");
                jLabel14.setVisible(false);
                jButton7.requestFocusInWindow();
                
            } else {
                jLabel14.setVisible(true);
                jTextField2.setText("");
                jLabel14.setText("El Pago debe ser equivalente.");
            }
        } else {
            jLabel14.setText("Ingrese el Efectivo recibido.");
            jLabel14.setVisible(true);
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9'))
                && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.' || jTextField2.getText().contains("."))) {
            evt.consume();
        }
        {            
            
        }

    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
            
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jPanel5.setVisible(false);
            jTextField1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            jTextField1.requestFocusInWindow();            
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            jButton2.doClick();
            
        } else if (evt.getKeyCode() == KeyEvent.VK_F12) {
            jButton5.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jLabel10.setText("$ 0");
            jButton7.setVisible(false);
            jLabel12.setVisible(false);
            jTextField2.setEnabled(true);
            jTextField2.requestFocusInWindow();
            jLabel13.setText("Oprime ' ESC ' para Cancelar.");
            jTextField2.setText("");
            
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton7.doClick();
        }
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int folio[] = new int[1];
        try {
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("insert into folios (id_cajero, name_cajero, total_ticket, pago_con, cambio) values(?,?,?,?,?)");
            pst.setInt(1, getId_cajero());
            pst.setString(2, getName_cajero());
            pst.setFloat(3, getTotal());
            pst.setFloat(4, getPagoCon());
            pst.setFloat(5, getCambio());
            int a = pst.executeUpdate();
            if (a == 1) {
                ResultSet rs = st.executeQuery("Select id_folio from folios order by id_folio desc limit 1;");
                while (rs.next()) {
                    folio[0] = rs.getInt(1);
                }
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    pst = cn.prepareStatement("insert into ticket(codigo, descripcion, importe_unitario, cantidad, total, id_folio)values(?,?,?,?,?,?);");
                    pst.setInt(1, parseInt((String) jTable1.getValueAt(i, 0)));
                    pst.setString(2, (String) jTable1.getValueAt(i, 1));
                    pst.setFloat(3, parseFloat((String) jTable1.getValueAt(i, 2)));
                    pst.setFloat(4, parseFloat((String) jTable1.getValueAt(i, 3)));
                    pst.setFloat(5, (float) jTable1.getValueAt(i, 4));
                    pst.setInt(6, folio[0]);
                    pst.executeUpdate();                    
                }
                
            }            
            modelo.setRowCount(0);
            TotalImporte();
            Retornar();
        } catch (SQLException ex) {
            Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        PanelControl pc = new PanelControl(this, true);
        pc.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    public void ElegirCajero(String name, int id) {
        setId_cajero(id);
        setName_cajero(name);
        
    }
    
    public void AgregarInTable(String A, String B) throws SQLException {
        System.out.println("quiobo");
        Sql = "select codigo, descripcion, precio_publico, Existencia from Productos where codigo=" + B + ";";        
        try {            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            b = rs.next();
            if (b) {
                while (b) {
                    if (consultaTables(B)) {
                        if ((rs.getFloat(4) - parseFloat(A)) >= 0) {
                        PreparedStatement pst=cn.prepareStatement("update Productos set Existencia= Existencia - "+A+" where codigo = "+ code +";");
                        pst.executeUpdate();
                        datos[4] = Float.toString(parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(B), 3)) + parseFloat(A));
                        modelo.setValueAt(datos[4], consultaTablesexactitud(B), 3);
                        modelo.setValueAt(parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(B), 2)) * parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(B), 3)),
                                consultaTablesexactitud(B), 4);
                        
                        jTable1.getSelectionModel().setSelectionInterval(consultaTablesexactitud(B), 1);
                        TotalImporte();
                        }else{
                            NotFoundInventario();
                        }
                    } else {
                        if (rs.getFloat(4) > 0) {
                        PreparedStatement pst=cn.prepareStatement("update Productos set Existencia= Existencia - "+A+" where codigo = "+ code +";");
                        pst.executeUpdate();
                        datos[0] = rs.getString(1);
                        datos[1] = rs.getString(2);
                        datos[2] = rs.getString(3);
                        datos[3] = A;
                        datos[4] = Float.toString(parseFloat(datos[3]) * parseFloat(datos[2]));
                        modelo.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), A, Float.toString(parseFloat(rs.getString(3)) * 1)});
                        modelo.setValueAt(parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(B), 2)) * parseFloat((String) jTable1.getValueAt(consultaTablesexactitud(B), 3)),
                                consultaTablesexactitud(B), 4);
                        TotalImporte();                        
                        }else{
                            NotFoundInventario();
                        }
                    }
                    b = false;
                    jTextField1.setText("");
                }                
            } else {
                NotFound();                
                jTextField1.requestFocusInWindow();
                jTextField1.setText("");
            }
        } catch (SQLException ex) {
            NotFound();
        }        
        
    }    

    public void Actualizar(String A) {
        setCantidadGranel(A);
    }
    public void Cancel(boolean b){
        setCancel(b);
    }

    public void Retornar() {
        jPanel5.setVisible(false);
        jTextField1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jTextField1.requestFocusInWindow();
        jLabel10.setText("$ 0");
        jTextField2.setText("");
        jTextField2.setEnabled(true);
    }

    public void EliminarInTable(String fila) throws SQLException {
        Object co = parseString((String) modelo.getValueAt(parseInt(fila)-1, 0));
        float c = parseFloat((String) jTable1.getValueAt(parseInt(fila)-1, 3));
        PreparedStatement pst=cn.prepareStatement("update Productos set Existencia= Existencia + "+ c +" where codigo = "+ co +";");
        pst.executeUpdate();
        modelo.removeRow(parseInt(fila) - 1);
        TotalImporte();
        jTextField1.requestFocusInWindow();
        
    }

    public boolean VerificarGranel() throws SQLException {
        String Sql3 = "select tipo_producto from Productos where codigo = " + code + ";";
        Statement st = cn.createStatement();
        try {
            ResultSet rs = st.executeQuery(Sql3);
            while (rs.next()) {
                boolean x = rs.getBoolean(1);
                if (x) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean consultaTables(String A) {
        b = false;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if ((jTable1.getValueAt(i, 0).toString().equals(A))) {
                b = true;
                break;
            }
        }
        return b;
    }

    public int consultaTablesexactitud(String A) {
        int a = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if ((jTable1.getValueAt(i, 0).toString().equals(A))) {
                a = i;
                break;
            }
        }
        return a;
    }

    public void TotalImporte() {
        setTotal(0);
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            setTotal(getTotal() + (float) jTable1.getValueAt(i, 4));            
        }
        jLabel7.setText("$ " + getTotal());        
    }    

    public void Salir() throws SQLException {
        String botones[] = {" Salir ", " Regresar "};
        int eleccion = JOptionPane.showOptionDialog(this, "La Aplicación se cerrara, ¿Esta Seguro?", "Salir",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            SalirResguardarTodo();
            System.exit(0);
            
        } else if (eleccion == JOptionPane.NO_OPTION) {
            
        }
        
    }
    
    public void NotFound() {
        String botones[] = {" Regresar "};
        JOptionPane.showOptionDialog(this, "Producto No Encontrado", "No Disponible",
                0, 0, null, botones, this);
    }
        public void NotFoundInventario() {
        String botones[] = {" Regresar "};
        JOptionPane.showOptionDialog(this, "No hay Existencias", "Producto Agotado disculpe.",
                0, 0, null, botones, this);
    }

    public static String getName_cajero() {
        return name_cajero;
    }
    
    public static void setName_cajero(String aName_cajero) {
        name_cajero = aName_cajero;
    }
    
    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(javax.swing.JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                            ElegirCajeroDialog el = new ElegirCajeroDialog(null, true);
                            el.jButton1.setEnabled(false);
                            el.setVisible(true);
                            DineroEnCaja dec = new DineroEnCaja(null, true);
                            dec.setVisible(true);
        
                    new InterfazPrincipalCobrar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazPrincipalCobrar.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("LA HIPERCAGASTE, REVISA BIEN WEY");
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
    
    public void ingresarFondo(float f){
        setDinero_caja(f);
    }
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    /**
     * @return the code
     */
    public static String getCode() {
        return code;
    }

    /**
     * @param aCode the code to set
     */
    public static void setCode(String aCode) {
        code = aCode;
    }

    public static String getCantidadGranel() {
        return cantidadGranel;
    }
    
    public static void setCantidadGranel(String aCantidadGranel) {
        cantidadGranel = aCantidadGranel;
    }
    
    public static float getPagoCon() {
        return pagoCon;
    }
    
    public static void setPagoCon(float aPagoCon) {
        pagoCon = aPagoCon;
    }
    
    public static float getCambio() {
        return cambio;
    }
    
    public static void setCambio(float aCambio) {
        cambio = aCambio;
    }
    public void DineroEnCaja(float money){
        setDinero_caja(money);
    }

    public float getDinero_caja() {
        return dinero_caja;
    }

    public void setDinero_caja(float dinero_caja) {
        this.dinero_caja = dinero_caja;
    }

    /**
     * @return the fondo_caja
     */
    public float getFondo_caja() {
        return fondo_caja;
    }

    /**
     * @param fondo_caja the fondo_caja to set
     */
    public void setFondo_caja(float fondo_caja) {
        this.fondo_caja = fondo_caja;
    }
}
