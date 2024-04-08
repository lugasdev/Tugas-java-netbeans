package pages;

import javax.swing.JFrame;

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
        System.out.println("change show "+ page);
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
        System.out.println("change page with id "+ page + " " + id);
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
        mainMenu = new javax.swing.JPanel();
        regBtn = new javax.swing.JButton();
        psnBtn = new javax.swing.JButton();
        dokBtn = new javax.swing.JButton();
        anamnesaBtn = new javax.swing.JButton();
        pmrBtn = new javax.swing.JButton();
        obatBtn = new javax.swing.JButton();
        obatBtn1 = new javax.swing.JButton();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(131, 188, 255));
        header.setPreferredSize(new java.awt.Dimension(774, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1211, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        mainMenu.setBackground(new java.awt.Color(255, 104, 107));
        mainMenu.setPreferredSize(new java.awt.Dimension(200, 469));
        mainMenu.setLayout(new java.awt.FlowLayout(1, 5, 10));

        regBtn.setBackground(new java.awt.Color(255, 255, 255));
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

        psnBtn.setBackground(new java.awt.Color(255, 255, 255));
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

        dokBtn.setBackground(new java.awt.Color(255, 255, 255));
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

        anamnesaBtn.setBackground(new java.awt.Color(255, 255, 255));
        anamnesaBtn.setText("Anamnesa");
        anamnesaBtn.setBorder(null);
        anamnesaBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        anamnesaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anamnesaBtnMouseClicked(evt);
            }
        });
        anamnesaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anamnesaBtnActionPerformed(evt);
            }
        });
        mainMenu.add(anamnesaBtn);

        pmrBtn.setBackground(new java.awt.Color(255, 255, 255));
        pmrBtn.setText("Pemeriksaan");
        pmrBtn.setBorder(null);
        pmrBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        pmrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pmrBtnMouseClicked(evt);
            }
        });
        pmrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmrBtnActionPerformed(evt);
            }
        });
        mainMenu.add(pmrBtn);

        obatBtn.setBackground(new java.awt.Color(255, 255, 255));
        obatBtn.setText("Resep Obat");
        obatBtn.setBorder(null);
        obatBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        obatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obatBtnActionPerformed(evt);
            }
        });
        mainMenu.add(obatBtn);

        obatBtn1.setBackground(new java.awt.Color(255, 255, 255));
        obatBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/8956782_info_help_guide_about_customer service_icon.png"))); // NOI18N
        obatBtn1.setText("Tentang Aplikasi");
        obatBtn1.setActionCommand("Tentang Aplikasi");
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
    }
    
    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
        this.clearAllPanel();
        
        body.add(registrasi, "card2");
        body.setVisible(true);
        registrasi.setVisible(true);
    }//GEN-LAST:event_regBtnActionPerformed

    private void pmrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmrBtnActionPerformed
        this.clearAllPanel();
                
        body.add(pemeriksaan, "card2");
        body.setVisible(true);
        pemeriksaan.setVisible(true);        
    }//GEN-LAST:event_pmrBtnActionPerformed

    private void pmrBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pmrBtnMouseClicked
    }//GEN-LAST:event_pmrBtnMouseClicked

    private void anamnesaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anamnesaBtnMouseClicked
        this.clearAllPanel();
        
        body.add(anamnesa, "card2");
        body.setVisible(true);
        anamnesa.setVisible(true);
    }//GEN-LAST:event_anamnesaBtnMouseClicked

    private void anamnesaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anamnesaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anamnesaBtnActionPerformed

    private void obatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obatBtnActionPerformed
        // TODO add your handling code here:
        this.clearAllPanel();
        
        body.add(resep, "card2");
        body.setVisible(true);
        resep.setVisible(true);
    }//GEN-LAST:event_obatBtnActionPerformed

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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anamnesaBtn;
    private javax.swing.JPanel body;
    private javax.swing.JButton dokBtn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton obatBtn;
    private javax.swing.JButton obatBtn1;
    private javax.swing.JButton pmrBtn;
    private javax.swing.JButton psnBtn;
    private javax.swing.JButton regBtn;
    // End of variables declaration//GEN-END:variables
}
