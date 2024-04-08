package pages;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.PatientModel;
import models.PemeriksaanModel;
import models.RegistrationModel;

/**
 *
 * @author lugas
 */
public class Pemeriksaan extends javax.swing.JPanel {
    private Home parent; 
    RegistrationModel registrationModel = new RegistrationModel();
    PatientModel patientModel = new PatientModel();
    models.AnamnesaModel anamnesaModel = new models.AnamnesaModel();
    PemeriksaanModel pemeriksaanModel = new PemeriksaanModel();
    int registrationId;

    /**
     * Creates new form Pemeriksaan
     */
    public Pemeriksaan() {
        initComponents();
    }

    public Pemeriksaan(Home parent) {
        initComponents();
        this.parent = parent;
    }

    public Pemeriksaan(Home parent, int registrationId) {
        initComponents();
        this.parent = parent;
        this.registrationId = registrationId;
        
        try {
            ResultSet registrant = registrationModel.get(registrationId);                        
            registrant.next();
            
            System.out.println(registrant.getString("registration_at"));
            System.out.println(registrant.getString("patient_id"));
            System.out.println(registrant.getString("doctor_id"));  
            
            ResultSet patient = patientModel.get(registrant.getInt("patient_id"));
            patient.next();
            System.out.println(patient.getString("name"));            
            System.out.println(patient.getString("date_of_birth"));            
            
            int genderId = patient.getInt("gender");
            String gender = "Perempuan";
            if (genderId == 1) {
                gender = "Laki-laki";
            } 
            
            labelPatientName.setText(patient.getString("name"));
            labelPatientGender.setText(gender);
            labelPatientDob.setText(patient.getString("date_of_birth"));
            
            ResultSet anamnesa = anamnesaModel.GetByRegistrationId(registrationId);
            anamnesa.next();
            
            inputTinggi.setText(anamnesa.getString("height"));
            inputBerat.setText(anamnesa.getString("weight"));
            inputSuhu.setText(anamnesa.getString("temperature"));
            inputBP.setText(anamnesa.getString("blood_pressure"));
            inputAlcohol.setSelectedIndex(anamnesa.getInt("is_alcohol"));
            inputSmoking.setSelectedIndex(anamnesa.getInt("is_smoking"));

            for (int i = 0; i < inputBT.getItemCount(); i++) {
                if (inputBT.getItemAt(i).equals(patient.getString("blood_type"))) {
                    inputBT.setSelectedIndex(i);                    
                }
            }
            
            inputRiwayat.setText(anamnesa.getString("disease_history"));
            inputKeluhan.setText(anamnesa.getString("complaint"));
                        
            
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputTinggi = new javax.swing.JTextField();
        inputBerat = new javax.swing.JTextField();
        inputSuhu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputBP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputKeluhan = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputPFisik = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputDiagnosis = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputTerapi = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        labelPatientName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelPatientGender = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelPatientDob = new javax.swing.JLabel();
        inputSmoking = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        inputAlcohol = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        inputBT = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        inputRiwayat = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Pemeriksaaan");
        jPanel1.add(jLabel1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tinggi Badan");

        jLabel3.setText("Berat Badan");

        jLabel4.setText("Suhu Tubuh");

        jLabel5.setText("Tekanan Darah");

        jLabel6.setText("Keluhan Utama");

        inputKeluhan.setColumns(20);
        inputKeluhan.setRows(5);
        jScrollPane1.setViewportView(inputKeluhan);

        jLabel7.setText("Pemeriksaan Fisik");

        inputPFisik.setColumns(20);
        inputPFisik.setRows(5);
        jScrollPane2.setViewportView(inputPFisik);

        jLabel8.setText("Diagonisis");

        inputDiagnosis.setColumns(20);
        inputDiagnosis.setRows(5);
        jScrollPane3.setViewportView(inputDiagnosis);

        inputTerapi.setColumns(20);
        inputTerapi.setRows(5);
        jScrollPane4.setViewportView(inputTerapi);

        jLabel9.setText("Terapi");

        saveButton.setText("Simpan");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Pasien");

        labelPatientName.setText("name");

        jLabel12.setText("/");

        labelPatientGender.setText("gender");

        jLabel14.setText("/");

        labelPatientDob.setText("dob");

        inputSmoking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak", "Ya" }));
        inputSmoking.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel11.setText("Merokok");

        inputAlcohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak", "Ya" }));
        inputAlcohol.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel13.setText("Alkohol");

        inputBT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A -", "A +", "B -", "B +", "AB -", "AB +", "O -", "O +" }));
        inputBT.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabel15.setText("Gol. Darah");

        jLabel16.setText("Riwayat Penyakit");

        inputRiwayat.setColumns(20);
        inputRiwayat.setRows(5);
        jScrollPane5.setViewportView(inputRiwayat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputSuhu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputBP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputSmoking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(inputBT, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4))
                        .addGap(226, 226, 226))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPatientName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPatientGender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPatientDob))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(saveButton)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelPatientName)
                    .addComponent(jLabel12)
                    .addComponent(labelPatientGender)
                    .addComponent(jLabel14)
                    .addComponent(labelPatientDob))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputTinggi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSuhu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSmoking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {            
            String physical = inputPFisik.getText();
            String diagnosis = inputDiagnosis.getText();
            String therapy = inputTerapi.getText();
            
            pemeriksaanModel.create(registrationId, physical, diagnosis, therapy);

            registrationModel.updateStat(registrationId, 2);

            JOptionPane.showMessageDialog(null, "Pemeriksaan Tersimpan");
            
            this.parent.changePage("pasien");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e);
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> inputAlcohol;
    private javax.swing.JTextField inputBP;
    private javax.swing.JComboBox<String> inputBT;
    private javax.swing.JTextField inputBerat;
    private javax.swing.JTextArea inputDiagnosis;
    private javax.swing.JTextArea inputKeluhan;
    private javax.swing.JTextArea inputPFisik;
    private javax.swing.JTextArea inputRiwayat;
    private javax.swing.JComboBox<String> inputSmoking;
    private javax.swing.JTextField inputSuhu;
    private javax.swing.JTextArea inputTerapi;
    private javax.swing.JTextField inputTinggi;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPatientDob;
    private javax.swing.JLabel labelPatientGender;
    private javax.swing.JLabel labelPatientName;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
