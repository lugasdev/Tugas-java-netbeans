package pages.transaction;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import models.ObatModel;
import models.PemeriksaanModel;
import models.ResepModel;
import pages.modal.RegistrationFilter;

/**
 *
 * @author lugas
 */
public class Pemeriksaan extends javax.swing.JPanel {
    
    PemeriksaanModel pemeriksaanModel = new PemeriksaanModel();
    ResepModel resepModel = new ResepModel();
    ObatModel obatModel = new ObatModel();
    String selectedPemeriksaanId = "";
    

    /**
     * Creates new form Resep
     */
    public Pemeriksaan() {
        initComponents();
    }

    private void initTable() {
        String[] columns = {"ID", "Registrasi ID", "Pemeriksaan Fisik", "DIagnosis", "Terapi"};
        resepTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            columns
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        DefaultTableModel RecordTable = (DefaultTableModel) resepTable.getModel();
        RecordTable.setRowCount(0);

        try {
            ResultSet pemeriksaans = pemeriksaanModel.get();
            
            while (pemeriksaans.next()) {                
                String id = pemeriksaans.getString("id");
                String reg_id = pemeriksaans.getString("registration_id");
                String physical = pemeriksaans.getString("physical");
                String diagnosis = pemeriksaans.getString("diagnosis");
                String therapy = pemeriksaans.getString("therapy");
                
                String[] row = {id, reg_id, physical, diagnosis, therapy};
                RecordTable.addRow(row);                
            }
                        
            resepTable.getColumnModel().getColumn(0).setMinWidth(50);
            resepTable.getColumnModel().getColumn(0).setMaxWidth(50);
            resepTable.getColumnModel().getColumn(0).setWidth(50);
            
            resepTable.getColumnModel().getColumn(1).setMinWidth(50);
            resepTable.getColumnModel().getColumn(1).setMaxWidth(50);
            resepTable.getColumnModel().getColumn(1).setWidth(50);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void initObat() {
        try {
            ResultSet obat = obatModel.get();
            int countObat = obatModel.countObat();
            String[] obatName = new String[countObat];

            int i = 0;
            while (obat.next()) {
                System.out.println(obat.getString("name"));
                obatName[i] = obat.getString("name") + "-" + obat.getString("id");

                i++;
            }
//            inputObatName.setModel(new javax.swing.DefaultComboBoxModel<>(obatName));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void resetButton() {
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        
        inputFisik.setText("");
        inputDiagnosa.setText("");
        inputTerapi.setText("");
        inputRegistrationId.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resepTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputRegistrationId = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputFisik = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputDiagnosa = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        inputTerapi = new javax.swing.JTextArea();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Transaksi Pemeriksaan");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        resepTable.setModel(new javax.swing.table.DefaultTableModel(
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
        resepTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resepTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resepTable);

        jLabel2.setText("Registrasi ID");

        jLabel4.setText("Diagnosa");

        jLabel5.setText("Pemeriksaan Fisik");

        jLabel6.setText("Terapi");

        btnTambah.setBackground(new java.awt.Color(0, 41, 107));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.setBorder(null);
        btnTambah.setBorderPainted(false);
        btnTambah.setPreferredSize(new java.awt.Dimension(100, 30));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 41, 107));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setBorder(null);
        btnEdit.setBorderPainted(false);
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(0, 41, 107));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(null);
        btnHapus.setBorderPainted(false);
        btnHapus.setEnabled(false);
        btnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 159, 28));
        jButton3.setText("Refresh");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/211885_search_icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        inputFisik.setColumns(20);
        inputFisik.setRows(5);
        jScrollPane3.setViewportView(inputFisik);

        inputDiagnosa.setColumns(20);
        inputDiagnosa.setRows(5);
        jScrollPane4.setViewportView(inputDiagnosa);

        inputTerapi.setColumns(20);
        inputTerapi.setRows(5);
        jScrollPane5.setViewportView(inputTerapi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(inputRegistrationId, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(inputRegistrationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void setRegistrationId(String id) {
        inputRegistrationId.setText(id);
    }
    
    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        initTable();
    }//GEN-LAST:event_jPanel2ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        initTable();
        initObat();
    }//GEN-LAST:event_formComponentShown

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
            String regId = inputRegistrationId.getText();
            String fisik = inputFisik.getText();
            String diagnosis = inputDiagnosa.getText();
            String terapi = inputTerapi.getText();
            pemeriksaanModel.create(Integer.parseInt(regId), fisik, diagnosis, terapi);

            resetButton();
            JOptionPane.showMessageDialog(null, "Registrasi ditambahkan");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        initTable();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {          
            String regId = inputRegistrationId.getText();
            String fisik = inputFisik.getText();
            String diagnosis = inputDiagnosa.getText();
            String terapi = inputTerapi.getText();
            pemeriksaanModel.update(Integer.parseInt(selectedPemeriksaanId), Integer.parseInt(regId), fisik, diagnosis, terapi);

            JOptionPane.showMessageDialog(null, "Registrasi diupdate");
            resetButton();
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        initTable();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Hapus Resep?") == 0) {
            try {
                String registrationId = inputRegistrationId.getText();
                pemeriksaanModel.delete(Integer.parseInt(selectedPemeriksaanId));

                JOptionPane.showMessageDialog(null, "Pemeriksaan dihapus");
                resetButton();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        initTable();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        initTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistrationFilter registrationFilter = new RegistrationFilter(this);
        registrationFilter.setVisible(true);
        registrationFilter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resepTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resepTableMouseClicked
        System.out.println("jTable1MouseClicked");
        int row = resepTable.rowAtPoint(evt.getPoint());
        int col = resepTable.columnAtPoint(evt.getPoint());

        System.out.println(row);
        System.out.println(col);

        selectedPemeriksaanId = resepTable.getValueAt(row, 0).toString();
        
        inputRegistrationId.setText(resepTable.getValueAt(row, 1).toString());
        inputFisik.setText(resepTable.getValueAt(row, 2).toString());
        inputDiagnosa.setText(resepTable.getValueAt(row, 3).toString());
        inputTerapi.setText(resepTable.getValueAt(row, 4).toString());
        
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_resepTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTextArea inputDiagnosa;
    private javax.swing.JTextArea inputFisik;
    private javax.swing.JTextField inputRegistrationId;
    private javax.swing.JTextArea inputTerapi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable resepTable;
    // End of variables declaration//GEN-END:variables
}
