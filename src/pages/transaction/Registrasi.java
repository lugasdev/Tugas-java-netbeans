/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages.transaction;

import models.PatientModel;
import pages.modal.PatientFilter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import models.DoctorModel;
import pages.modal.DoctorFilter;

/**
 *
 * @author lugas
 */
public class Registrasi extends javax.swing.JPanel {

    private models.RegistrationModel registrationModel = new models.RegistrationModel();
    private PatientModel patientModel = new PatientModel();
    private DoctorModel doctorModel = new DoctorModel();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String selectedRegistrationId = "";
    int patientId = 0;
    int doctorId = 0;

    /**
     * Creates new form Registrasi
     */
    public Registrasi() {
        initComponents();
    }

    private void initTable() {
        String[] columns = {"ID", "Waktu Pemeriksaan", "Klinik", "Dokter", "Nama Pasien", "Jenis Kelamin Pasien", "Tanggal Lahir Pasien", "Status"};
        registrationTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                columns
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });

        System.out.println("viewPatient");
        DefaultTableModel RecordTable = (DefaultTableModel) registrationTable.getModel();
        RecordTable.setRowCount(0);

        try {
            ResultSet registrations = registrationModel.getRegistrant();

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

//                disableButtons();
                switch (registrations.getInt("r.stat")) {
                    case 1:
                        stat = "Menunggu Pemeriksaan Dokter";
                        break;
                    case 2:
                        stat = "Menunggu Pemberian Obat";
                        break;
                    case 3:
                        stat = "Selesai";
                        break;
                    default:
                        stat = "Menunggu Anamnesa";
                }

                String genderString = "Laki-Laki";
                if (registrations.getInt("p.gender") == 2) {
                    genderString = "Perempuan";
                }

                Vector row = new Vector();
                row.add(registrations.getInt("r.id"));
                row.add(registrations.getString("r.registration_at"));
                row.add(registrations.getString("d.clinic"));
                row.add(registrations.getString("d.name"));
                row.add(registrations.getString("p.name"));
                row.add(genderString);
                row.add(registrations.getString("p.date_of_birth"));
                row.add(stat);
                RecordTable.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        registrationTable.getColumnModel().getColumn(0).setMinWidth(30);
        registrationTable.getColumnModel().getColumn(0).setMaxWidth(30);
        registrationTable.getColumnModel().getColumn(0).setWidth(30);
    }

    private void resetButton() {
        btnTambah.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputPatient = new javax.swing.JTextField();
        inputDoctor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputTanggal = new com.toedter.calendar.JCalendar();
        inputWaktu = new javax.swing.JFormattedTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        registrationTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Transaksi Registrasi");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Pasien");

        jLabel3.setText("Dokter");

        jLabel4.setText("Tanggal Pemeriksaan");
        jLabel4.setToolTipText("");

        jLabel5.setText("Waktu Pemeriksaan");
        jLabel5.setToolTipText("");

        inputTanggal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        inputTanggal.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));

        inputWaktu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));

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

        registrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        registrationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationTableMouseClicked(evt);
            }
        });
        registrationTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                registrationTableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(registrationTable);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/211885_search_icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/211885_search_icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputPatient))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(inputDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        java.util.Date regDate = inputTanggal.getDate();
        String formattedRegDate = dateFormat.format(regDate);
        System.out.println(formattedRegDate);

        String fullRegDate = formattedRegDate + " " + inputWaktu.getText();

        try {
            int id = registrationModel.create(doctorId, patientId, fullRegDate);

            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        initTable();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        java.util.Date regDate = inputTanggal.getDate();
        String formattedRegDate = dateFormat.format(regDate);
        System.out.println(formattedRegDate);

        String fullRegDate = formattedRegDate + " " + inputWaktu.getText();

        try {
            int id = registrationModel.update(Integer.parseInt(selectedRegistrationId), doctorId, patientId, fullRegDate);

            JOptionPane.showMessageDialog(null, "Registrasi Terupdate");
            resetButton();
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        initTable();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            registrationModel.delete(Integer.parseInt(selectedRegistrationId));

            JOptionPane.showMessageDialog(null, "Registrasi dihapus");
            resetButton();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        initTable();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PatientFilter patientFilter = new PatientFilter(this);
        patientFilter.setVisible(true);
        patientFilter.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registrationTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_registrationTableComponentShown

    }//GEN-LAST:event_registrationTableComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        initTable();
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DoctorFilter doctorFilter = new DoctorFilter(this);
        doctorFilter.setVisible(true);
        doctorFilter.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void registrationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationTableMouseClicked
        System.out.println("registrationTableMouseClicked");
        int row = registrationTable.rowAtPoint(evt.getPoint());
        int col = registrationTable.columnAtPoint(evt.getPoint());

        System.out.println(row);
        System.out.println(col);

        selectedRegistrationId = registrationTable.getValueAt(row, 0).toString();
        System.out.println(selectedRegistrationId);

        try {
            System.out.println("getRegistrant");
            ResultSet registration = registrationModel.getRegistrant(Integer.parseInt(selectedRegistrationId));

            while (registration.next()) {
                System.out.println(registration.getString("r.id"));
                System.out.println(registration.getString("r.registration_at"));
                System.out.println(registration.getString("d.id"));
                System.out.println(registration.getString("d.name"));
                System.out.println(registration.getString("p.id"));
                System.out.println(registration.getString("p.name"));

                String[] regAtSplit = registration.getString("r.registration_at").split(" ");
                String[] regAt = regAtSplit[0].split("-");
                java.util.Date regDate = new java.util.Date(Integer.parseInt(regAt[0]) - 1900, Integer.parseInt(regAt[1]), Integer.parseInt(regAt[2]));

                inputTanggal.setDate(regDate);
                inputWaktu.setText(regAtSplit[1]);
                doctorId = Integer.parseInt(registration.getString("d.id"));
                inputDoctor.setText(registration.getString("d.name"));
                patientId = Integer.parseInt(registration.getString("p.id"));
                inputPatient.setText(registration.getString("p.name"));

                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_registrationTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        initTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void selectedDoctorId(int id) {
        System.out.println("selectedDoctorId");
        System.out.println(id);
        try {
            ResultSet doctor = doctorModel.get(id);

            while (doctor.next()) {
                doctorId = doctor.getInt("id");
                inputDoctor.setText(doctor.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void selectedPatientId(int id) {
        System.out.println("selectedPatientId");
        System.out.println(id);
        try {
            ResultSet patient = patientModel.get(id);

            while (patient.next()) {
                patientId = patient.getInt("id");
                inputPatient.setText(patient.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTextField inputDoctor;
    private javax.swing.JTextField inputPatient;
    private com.toedter.calendar.JCalendar inputTanggal;
    private javax.swing.JFormattedTextField inputWaktu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable registrationTable;
    // End of variables declaration//GEN-END:variables
}
