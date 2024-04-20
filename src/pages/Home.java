package pages;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JFrame;
import javax.swing.UIManager;
import pages.master.Master;

/**
 *
 * @author lugas
 */
public class Home extends javax.swing.JFrame {

    Pemeriksaan pemeriksaan = new Pemeriksaan();
    Registrasi registrasi = new Registrasi(this);
    Welcome welcome = new Welcome();
    Anamnesa anamnesa = new Anamnesa(this);
    Resep resep = new Resep();
    Pasien pasien = new Pasien(this);
    Dokter dokter = new Dokter();
    Master master = new Master();

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        changePage("welcome");
    }

    public void changePage(String page) {
        this.clearAllPanel();
        System.out.println("change show " + page);
        switch (page) {
            case "dokter":
                System.out.println("show dokter page");
                body.add(dokter, "card2");
                body.setVisible(true);
                dokter.setVisible(true);
                break;
            case "pasien":
                System.out.println("show pasien page");
                body.add(pasien, "card2");
                body.setVisible(true);
                pasien.setVisible(true);
                break;
            case "resep":
                System.out.println("show resep page");
                body.add(resep, "card2");
                body.setVisible(true);
                resep.setVisible(true);
                break;
            case "anamnesa":
                System.out.println("show anamnesa page");
                body.add(anamnesa, "card2");
                body.setVisible(true);
                anamnesa.setVisible(true);
                break;
            case "pemeriksaan":
                System.out.println("show pemeriksaan page");
                body.add(pemeriksaan, "card2");
                body.setVisible(true);
                pemeriksaan.setVisible(true);
                break;
            case "registrasi":
                System.out.println("show patient page");
                body.add(registrasi, "card2");
                body.setVisible(true);
                registrasi.setVisible(true);
                break;
            case "master":
                System.out.println("show master page");
                body.add(master, "card2");
                body.setVisible(true);
                master.setVisible(true);
                break;
            default:
                System.out.println("show default page");
                body.add(welcome, "card2");
                body.setVisible(true);
                welcome.setVisible(true);
                System.out.println("no default");
        }

        body.validate();
        body.repaint();
    }

    public void changePage(String page, int id) {
        this.clearAllPanel();
        System.out.println("change page with id " + page + " " + id);
        switch (page) {
            case "dokter":
                System.out.println("show dokter page");
                body.add(dokter, "card2");
                body.setVisible(true);
                dokter.setVisible(true);
                break;
            case "pasien":
                System.out.println("show pasien page");
                body.add(pasien, "card2");
                body.setVisible(true);
                pasien.setVisible(true);
                break;
            case "resep":
                resep = new Resep(this, id);
                System.out.println("show resep page");
                body.add(resep, "card2");
                body.setVisible(true);
                resep.setVisible(true);
                break;
            case "anamnesa":
                anamnesa = new Anamnesa(this, id);

                System.out.println("show anamnesa page");
                body.add(anamnesa, "card2");
                body.setVisible(true);
                anamnesa.setVisible(true);
                break;
            case "pemeriksaan":
                pemeriksaan = new Pemeriksaan(this, id);

                System.out.println("show pemeriksaan page");
                body.add(pemeriksaan, "card2");
                body.setVisible(true);
                pemeriksaan.setVisible(true);
                break;
            case "registrasi":
                System.out.println("show patient page");
                body.add(registrasi, "card2");
                body.setVisible(true);
                registrasi.setVisible(true);
                break;
            default:
                System.out.println("show default page");
                body.add(welcome, "card2");
                body.setVisible(true);
                welcome.setVisible(true);
                System.out.println("no default");
        }

        body.validate();
        body.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mainMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        regBtn = new javax.swing.JButton();
        psnBtn = new javax.swing.JButton();
        dokBtn = new javax.swing.JButton();
        obatBtn1 = new javax.swing.JButton();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setBackground(new java.awt.Color(193, 18, 31));
        header.setPreferredSize(new java.awt.Dimension(774, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jButton1.setText("Master");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1133, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        mainMenu.setBackground(new java.awt.Color(0, 41, 107));
        mainMenu.setPreferredSize(new java.awt.Dimension(200, 469));
        mainMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jPanel1.setBackground(new java.awt.Color(0, 41, 107));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        mainMenu.add(jPanel1);

        regBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/5958267_disease_epidemic_infection_patient_sufferer_icon.png"))); // NOI18N
        regBtn.setText("Registrasi Pasien");
        regBtn.setBorder(null);
        regBtn.setBorderPainted(false);
        regBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        regBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regBtnActionPerformed(evt);
            }
        });
        regBtn.setBorderPainted(false);
        regBtn.setBounds(0, 0, 0, 0);
        mainMenu.add(regBtn);

        psnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/5958254_cold_disease_epidemic_fever_flu_icon.png"))); // NOI18N
        psnBtn.setText("Daftar Pasien");
        psnBtn.setBorder(null);
        psnBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        psnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psnBtnActionPerformed(evt);
            }
        });
        mainMenu.add(psnBtn);

        dokBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/5958251_disease_doctor_epidemic_hospital_infection_icon.png"))); // NOI18N
        dokBtn.setText("Daftar Dokter");
        dokBtn.setBorder(null);
        dokBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        dokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dokBtnActionPerformed(evt);
            }
        });
        mainMenu.add(dokBtn);

        obatBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/8956782_info_help_guide_about_customer service_icon.png"))); // NOI18N
        obatBtn1.setText("Tentang Aplikasi");
        obatBtn1.setBorder(null);
        obatBtn1.setPreferredSize(new java.awt.Dimension(150, 40));
        obatBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obatBtn1ActionPerformed(evt);
            }
        });
        mainMenu.add(obatBtn1);

        getContentPane().add(mainMenu, java.awt.BorderLayout.LINE_START);

        body.setLayout(new java.awt.CardLayout());
        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearAllPanel() {
        welcome.setVisible(false);
        pemeriksaan.setVisible(false);
        registrasi.setVisible(false);
        anamnesa.setVisible(false);
        resep.setVisible(false);
        pasien.setVisible(false);
        dokter.setVisible(false);
        master.setVisible(false);
    }

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
        this.clearAllPanel();

        body.add(registrasi, "card2");
        body.setVisible(true);
        registrasi.setVisible(true);
    }//GEN-LAST:event_regBtnActionPerformed

    private void psnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psnBtnActionPerformed
        this.clearAllPanel();

        body.add(pasien, "card2");
        body.setVisible(true);
        pasien.setVisible(true);
    }//GEN-LAST:event_psnBtnActionPerformed

    private void dokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dokBtnActionPerformed
        // TODO add your handling code here:
        this.clearAllPanel();

        body.add(dokter, "card2");
        body.setVisible(true);
        dokter.setVisible(true);
    }//GEN-LAST:event_dokBtnActionPerformed

    private void obatBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obatBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obatBtn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.clearAllPanel();
        
        changePage("master");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton dokBtn;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton obatBtn1;
    private javax.swing.JButton psnBtn;
    private javax.swing.JButton regBtn;
    // End of variables declaration//GEN-END:variables
}
