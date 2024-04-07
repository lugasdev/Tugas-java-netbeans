package pages;

import models.Registration;
import java.sql.*;
import javax.swing.JOptionPane;
import models.Doctor;
import models.Patient;

/**
 *
 * @author lugas
 */
public class Anamnesa extends javax.swing.JPanel {
    private Home parent; 
    Registration registrationModel = new Registration();
    Patient patientModel = new Patient();
    Doctor doctorModel = new Doctor();
    models.Anamnesa anamnesaModel = new models.Anamnesa();
    int RegistrationId;
    
    /**
     * Creates new form Anamnesa
     */
    public Anamnesa() {
        initComponents();
    }
    
    public Anamnesa(Home parent) {
        initComponents();
        this.parent = parent;
    }
    
    public Anamnesa(Home parent, int RegistrationId) {
        initComponents();
        this.parent = parent;

        this.RegistrationId = RegistrationId;
        try {
            ResultSet registrant = registrationModel.get(RegistrationId);                        
            registrant.next();
            
            System.out.println(registrant.getString("registration_at"));
            System.out.println(registrant.getString("patient_id"));
            System.out.println(registrant.getString("doctor_id"));  
            
            ResultSet patient = patientModel.get(registrant.getInt("patient_id"));
            patient.next();
            System.out.println(patient.getString("name"));            
            System.out.println(patient.getString("date_of_birth"));            
            
            inputPasienName.setText(patient.getString("name"));
            labelDOB.setText(patient.getString("date_of_birth") + " / " + patient.getString("id"));
            
            ResultSet doctor = doctorModel.get(registrant.getInt("doctor_id"));
            doctor.next();
            
            inputDokter.setText(doctor.getString("name") + " / " + doctor.getString("clinic"));
            
            inputTglPemeriksaan.setText(registrant.getString("registration_at"));
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());                                   
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputTinggi = new javax.swing.JFormattedTextField();
        inputBerat = new javax.swing.JFormattedTextField();
        inputTekananAtas = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        inputTekananBawah = new javax.swing.JFormattedTextField();
        inputMerokok = new javax.swing.JComboBox<>();
        inputAlkohol = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputKeluhan = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        inputPasienName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        inputDokter = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        inputRiwayat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        inputSuhu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        inputTglPemeriksaan = new javax.swing.JFormattedTextField();
        labelDOB = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 32));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Anamnesa Pasien");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 226, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 225, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 9, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Tinggi Badan (cm)");

        jLabel4.setText("Berat Badan (kg)");

        jLabel5.setText("Tekanan Darah");

        jLabel6.setText("Merokok");

        jLabel7.setText("Meminum Alkohol");

        jLabel8.setText("Keluhan/Keterangan");

        inputTinggi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        inputBerat.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        inputTekananAtas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        inputTekananAtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTekananAtasActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("/");

        inputTekananBawah.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        inputMerokok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak", "Ya" }));

        inputAlkohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak", "Ya" }));

        inputKeluhan.setColumns(20);
        inputKeluhan.setRows(5);
        jScrollPane1.setViewportView(inputKeluhan);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Pasien");

        jLabel11.setText("Dokter");

        inputDokter.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yyyy"))));

        jLabel2.setText("Riwayat Penyakit");

        jLabel12.setText("Suhu Tubuh (celcius)");

        jLabel13.setText("Waktu Pemeriksaan");

        inputTglPemeriksaan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yyyy"))));

        labelDOB.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAlkohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(inputTekananAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTekananBawah, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inputSuhu, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputMerokok, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(inputRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputDokter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputBerat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addComponent(inputTinggi, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(inputPasienName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(inputTglPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(inputPasienName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDOB))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(inputDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(inputTglPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputTekananAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(inputTekananBawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(inputSuhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputMerokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputAlkohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void inputTekananAtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTekananAtasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTekananAtasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {            
            String bloodPressure = inputTekananAtas.getText() + "/" + inputTekananBawah.getText();
            boolean isSmoking = false;
            if (inputMerokok.getSelectedItem().equals("Ya")) {
                isSmoking = true;
            }
            boolean isAlcohol = false;
            if (inputAlkohol.getSelectedItem().equals("Ya")) {
                isAlcohol = true;
            }
            
            anamnesaModel.create(
                RegistrationId, 
                Integer.parseInt(inputTinggi.getText()), 
                Integer.parseInt(inputBerat.getText()), 
                bloodPressure, 
                Integer.parseInt(inputSuhu.getText()), 
                isSmoking, 
                isAlcohol, 
                inputRiwayat.getText(), 
                inputKeluhan.getText()
            );
            
            boolean updateStat = registrationModel.updateStat(RegistrationId, 1);

            JOptionPane.showMessageDialog(null, "anamnesa disimpan");                                   
            
            this.parent.changePage("pasien");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());                                   
        }                
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> inputAlkohol;
    private javax.swing.JFormattedTextField inputBerat;
    private javax.swing.JFormattedTextField inputDokter;
    private javax.swing.JTextArea inputKeluhan;
    private javax.swing.JComboBox<String> inputMerokok;
    private javax.swing.JTextField inputPasienName;
    private javax.swing.JTextField inputRiwayat;
    private javax.swing.JTextField inputSuhu;
    private javax.swing.JFormattedTextField inputTekananAtas;
    private javax.swing.JFormattedTextField inputTekananBawah;
    private javax.swing.JFormattedTextField inputTglPemeriksaan;
    private javax.swing.JFormattedTextField inputTinggi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDOB;
    // End of variables declaration//GEN-END:variables
}
