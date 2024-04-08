package pages;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lugas
 */
public class Pasien extends javax.swing.JPanel {
    private Home parent;
    private models.RegistrationModel registrationModel = new models.RegistrationModel();
    private int clickedRegistrationId = 0;
    private String dateNow = "";

    /**
     * Creates new form Pasien
     */
    public Pasien() {
        initComponents();
        
        LocalDateTime dateNowObj = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateNow = dateNowObj.format(dateFormatter);
        
        filterDate.setText(dateNow);
                
        anamnesaBtn.setEnabled(false);
        pemeriksaanBtn.setEnabled(false);
        resepBtn.setEnabled(false);
        profilBtn.setEnabled(false);                
    }
    
    public Pasien(Home parent) {
        initComponents();
        this.parent = parent;
 
        LocalDateTime dateNowObj = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        dateNow = dateNowObj.format(dateFormatter);
        
        filterDate.setText(dateNow);
                
        anamnesaBtn.setEnabled(false);
        pemeriksaanBtn.setEnabled(false);
        resepBtn.setEnabled(false);
        profilBtn.setEnabled(false);                
    }    
    

    private void viewPatient() {
        System.out.println("viewPatient");
        DefaultTableModel RecordTable = (DefaultTableModel)registrationTable.getModel();
        RecordTable.setRowCount(0);
        
        try {
            ResultSet registrations = registrationModel.getRegistrantByDate(filterDate.getText());
            
            while (registrations.next()) {
                System.out.println(registrations.getString("r.id"));
                System.out.println(registrations.getString("r.registration_at"));
                System.out.println(registrations.getString("d.clinic"));
                System.out.println(registrations.getString("d.name"));
                System.out.println(registrations.getString("p.name"));
                System.out.println(registrations.getString("p.gender"));
                System.out.println(registrations.getString("p.date_of_birth"));
                System.out.println(registrations.getString("r.stat"));
                
                String stat = "";
                
                switch (registrations.getInt("r.stat")) {
                    case 1:
                        stat = "Anamnesa Selesai";
                        break;
                    case 2:
                        stat = "Pemeriksaan Selesai";
                        break;                        
                    case 3:
                        stat = "Resep Obat Selesai";
                        break;                        
                    default:
                        stat = "Menunggu Anamnesa";
                }
                
                String genderString = "Laki-Laki";
                if (registrations.getInt("p.gender") == 2) {
                    genderString = "Perempuan";
                }
                
                Vector column = new Vector();
                column.add(registrations.getInt("r.id"));
                column.add(registrations.getString("r.registration_at"));
                column.add(registrations.getString("d.clinic"));
                column.add(registrations.getString("d.name"));
                column.add(registrations.getString("p.name"));
                column.add(genderString);
                column.add(registrations.getString("p.date_of_birth"));
                column.add(stat);
                RecordTable.addRow(column);                

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        anamnesaBtn = new javax.swing.JButton();
        pemeriksaanBtn = new javax.swing.JButton();
        resepBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        registrationTable = new javax.swing.JTable();
        filterDate = new javax.swing.JFormattedTextField();
        profilBtn = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Daftar Registrasi Pasien");
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        anamnesaBtn.setText("Anamnesa");
        anamnesaBtn.setPreferredSize(new java.awt.Dimension(150, 23));
        anamnesaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anamnesaBtnActionPerformed(evt);
            }
        });

        pemeriksaanBtn.setText("Pemeriksaan");
        pemeriksaanBtn.setPreferredSize(new java.awt.Dimension(150, 23));
        pemeriksaanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemeriksaanBtnActionPerformed(evt);
            }
        });

        resepBtn.setText("Resep Obat");
        resepBtn.setPreferredSize(new java.awt.Dimension(150, 23));

        registrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Waktu Pemeriksaan", "Klinik", "Dokter", "Nama Pasien", "Jenis Kelamin Pasien", "Tanggal Lahir Pasien", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        registrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(registrationTable);

        filterDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        filterDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterDateKeyReleased(evt);
            }
        });

        profilBtn.setText("Profil Pasien");
        profilBtn.setPreferredSize(new java.awt.Dimension(150, 23));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(anamnesaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(pemeriksaanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(resepBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(profilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(filterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anamnesaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pemeriksaanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resepBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        System.out.println("Pasien show");
        viewPatient();

    }//GEN-LAST:event_formComponentShown

    private void filterDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterDateKeyReleased
        viewPatient();
    }//GEN-LAST:event_filterDateKeyReleased

    private void registrationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationTableMouseClicked
        System.out.println("registrationTableMouseClicked");
        int row = registrationTable.rowAtPoint(evt.getPoint());
        int col = registrationTable.columnAtPoint(evt.getPoint());

        System.out.println(row);
        System.out.println(col);        

        clickedRegistrationId = (int) registrationTable.getValueAt(row, 0);

        System.out.println(clickedRegistrationId);

        anamnesaBtn.setEnabled(true);
        pemeriksaanBtn.setEnabled(true);
        resepBtn.setEnabled(true);
        profilBtn.setEnabled(true);                
    }//GEN-LAST:event_registrationTableMouseClicked

    private void anamnesaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anamnesaBtnActionPerformed
        this.parent.changePage("anamnesa", clickedRegistrationId);
    }//GEN-LAST:event_anamnesaBtnActionPerformed

    private void pemeriksaanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemeriksaanBtnActionPerformed
        this.parent.changePage("pemeriksaan", clickedRegistrationId);
    }//GEN-LAST:event_pemeriksaanBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anamnesaBtn;
    private javax.swing.JFormattedTextField filterDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pemeriksaanBtn;
    private javax.swing.JButton profilBtn;
    private javax.swing.JTable registrationTable;
    private javax.swing.JButton resepBtn;
    // End of variables declaration//GEN-END:variables
}
