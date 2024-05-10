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
    Tentang tentang = new Tentang();
    Master master = new Master();
    pages.master.Pasien masterPasien = new pages.master.Pasien();
    pages.master.Obat masterObat = new pages.master.Obat();
    pages.transaction.Registrasi transactionRegistration = new pages.transaction.Registrasi();

    boolean subMasterPanelVisible = false;
    boolean subTransactionPanelVisible = false;
    boolean subLaporanPanelVisible = false;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        subMasterPanel.setVisible(subMasterPanelVisible);
        subTransactionPanel.setVisible(subTransactionPanelVisible);
        subLaporanPanel.setVisible(subLaporanPanelVisible);

        changePage("welcome");
    }

    public void changePage(String page) {
        this.clearAllPanel();
        System.out.println("change show " + page);
        switch (page) {
            case "dokter":
                System.out.println("show dokter page");
                body.add(dokter, "card2");
                dokter.setVisible(true);
                break;
            case "pasien":
                System.out.println("show pasien page");
                body.add(pasien, "card2");
                pasien.setVisible(true);
                break;
            case "resep":
                System.out.println("show resep page");
                body.add(resep, "card2");
                resep.setVisible(true);
                break;
            case "anamnesa":
                System.out.println("show anamnesa page");
                body.add(anamnesa, "card2");
                anamnesa.setVisible(true);
                break;
            case "pemeriksaan":
                System.out.println("show pemeriksaan page");
                body.add(pemeriksaan, "card2");
                pemeriksaan.setVisible(true);
                break;
            case "registrasi":
                System.out.println("show registration page");
                body.add(registrasi, "card2");
                registrasi.setVisible(true);
                break;
            case "master":
                System.out.println("show master page");
                body.add(master, "card2");
                master.setVisible(true);
                break;
            case "master-pasien":
                System.out.println("show master pasien page");
                body.add(masterPasien, "card2");
                masterPasien.setVisible(true);
                break;
            case "master-obat":
                System.out.println("show master obat page");
                body.add(masterObat, "card2");
                masterObat.setVisible(true);
                break;
            case "transaction-registrasi":
                System.out.println("show transaksi registrasi page");
                body.add(transactionRegistration, "card2");
                transactionRegistration.setVisible(true);
                break;
            default:
                System.out.println("show default page");
                body.add(welcome, "card2");
                welcome.setVisible(true);
                System.out.println("no default");
        }

        body.setVisible(true);
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
        mainMenu = new javax.swing.JPanel();
        regBtn = new javax.swing.JButton();
        psnBtn = new javax.swing.JButton();
        dokBtn = new javax.swing.JButton();
        btnabout = new javax.swing.JButton();
        btnMaster = new javax.swing.JButton();
        subMasterPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnMaster1 = new javax.swing.JButton();
        subTransactionPanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnMaster2 = new javax.swing.JButton();
        subLaporanPanel = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setBackground(new java.awt.Color(193, 18, 31));
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
                .addContainerGap(933, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        mainMenu.setBackground(new java.awt.Color(0, 41, 107));
        mainMenu.setPreferredSize(new java.awt.Dimension(200, 469));

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

        psnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/5958254_cold_disease_epidemic_fever_flu_icon.png"))); // NOI18N
        psnBtn.setText("Daftar Pasien");
        psnBtn.setBorder(null);
        psnBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        psnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psnBtnActionPerformed(evt);
            }
        });

        dokBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/5958251_disease_doctor_epidemic_hospital_infection_icon.png"))); // NOI18N
        dokBtn.setText("Daftar Dokter");
        dokBtn.setBorder(null);
        dokBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        dokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dokBtnActionPerformed(evt);
            }
        });

        btnabout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/8956782_info_help_guide_about_customer service_icon.png"))); // NOI18N
        btnabout.setText("Tentang Aplikasi");
        btnabout.setBorder(null);
        btnabout.setPreferredSize(new java.awt.Dimension(150, 40));
        btnabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaboutActionPerformed(evt);
            }
        });

        btnMaster.setText("Master");
        btnMaster.setBorder(null);
        btnMaster.setBorderPainted(false);
        btnMaster.setPreferredSize(new java.awt.Dimension(150, 40));
        btnMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterActionPerformed(evt);
            }
        });

        subMasterPanel.setBackground(new java.awt.Color(0, 41, 107));
        subMasterPanel.setLayout(new java.awt.GridLayout(3, 0, 0, 5));

        jButton2.setText("Master Pasien");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setBorderPainted(false);
        jButton2.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton2.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        subMasterPanel.add(jButton2);

        jButton3.setText("Master Dokter");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton3.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton3.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        subMasterPanel.add(jButton3);

        jButton1.setText("Master Obat");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton1.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton1.setMinimumSize(new java.awt.Dimension(150, 20));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        subMasterPanel.add(jButton1);

        btnMaster1.setText("Transaksi");
        btnMaster1.setBorder(null);
        btnMaster1.setBorderPainted(false);
        btnMaster1.setPreferredSize(new java.awt.Dimension(150, 40));
        btnMaster1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaster1ActionPerformed(evt);
            }
        });

        subTransactionPanel.setBackground(new java.awt.Color(0, 41, 107));
        subTransactionPanel.setLayout(new java.awt.GridLayout(3, 0, 0, 5));

        jButton4.setText("Transaksi Registrasi");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton4.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton4.setMinimumSize(new java.awt.Dimension(150, 20));
        jButton4.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        subTransactionPanel.add(jButton4);

        jButton5.setText("Transaksi Obat");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton5.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton5.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        subTransactionPanel.add(jButton5);

        jButton6.setText("Transaksi Pemeriksaan");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton6.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton6.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        subTransactionPanel.add(jButton6);

        btnMaster2.setText("Laporan");
        btnMaster2.setBorder(null);
        btnMaster2.setBorderPainted(false);
        btnMaster2.setPreferredSize(new java.awt.Dimension(150, 40));
        btnMaster2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaster2ActionPerformed(evt);
            }
        });

        subLaporanPanel.setBackground(new java.awt.Color(0, 41, 107));
        subLaporanPanel.setLayout(new java.awt.GridLayout(4, 0, 0, 5));

        jButton7.setText("Laporan Registrasi");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton7.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton7.setMinimumSize(new java.awt.Dimension(150, 20));
        jButton7.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        subLaporanPanel.add(jButton7);

        jButton8.setText("Laporan Pasien");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton8.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton8.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        subLaporanPanel.add(jButton8);

        jButton9.setText("Laporan Dokter");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton9.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton9.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        subLaporanPanel.add(jButton9);

        jButton10.setText("Laporan Obat");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setMargin(new java.awt.Insets(10, 14, 10, 14));
        jButton10.setMaximumSize(new java.awt.Dimension(150, 20));
        jButton10.setPreferredSize(new java.awt.Dimension(150, 20));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        subLaporanPanel.add(jButton10);

        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(mainMenu);
        mainMenu.setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnabout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subMasterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTransactionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaster2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subLaporanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(regBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(psnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(dokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnabout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(subMasterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnMaster1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(subTransactionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnMaster2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(subLaporanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(mainMenu, java.awt.BorderLayout.LINE_START);

        body.setLayout(new java.awt.CardLayout());
        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnMaster2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaster2ActionPerformed
        showSubPanel("laporan");
    }//GEN-LAST:event_btnMaster2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        changePage("transaction-registrasi");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnMaster1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaster1ActionPerformed
        showSubPanel("transaksi");
    }//GEN-LAST:event_btnMaster1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        changePage("master-obat");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        changePage("dokter");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        changePage("master-pasien");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterActionPerformed
        // TODO add your handling code here:
        showSubPanel("master");
    }//GEN-LAST:event_btnMasterActionPerformed

    private void btnaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaboutActionPerformed
        // TODO add your handling code here:
        this.clearAllPanel();

        body.add(tentang, "card2");
        body.setVisible(true);
        tentang.setVisible(true);
    }//GEN-LAST:event_btnaboutActionPerformed

    private void dokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dokBtnActionPerformed
        this.clearAllPanel();

        body.add(dokter, "card2");
        body.setVisible(true);
        dokter.setVisible(true);
    }//GEN-LAST:event_dokBtnActionPerformed

    private void psnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psnBtnActionPerformed
        this.clearAllPanel();

        body.add(pasien, "card2");
        body.setVisible(true);
        pasien.setVisible(true);
    }//GEN-LAST:event_psnBtnActionPerformed

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
        this.clearAllPanel();

        body.add(registrasi, "card2");
        body.setVisible(true);
        registrasi.setVisible(true);
    }//GEN-LAST:event_regBtnActionPerformed

    private void clearAllPanel() {
        welcome.setVisible(false);
        pemeriksaan.setVisible(false);
        registrasi.setVisible(false);
        anamnesa.setVisible(false);
        resep.setVisible(false);
        pasien.setVisible(false);
        dokter.setVisible(false);
        tentang.setVisible(false);
        master.setVisible(false);
        masterPasien.setVisible(false);
        transactionRegistration.setVisible(false);
        masterObat.setVisible(false);

    }

//    private void btnMasterActionPerformed(java.awt.event.ActionEvent evt) {
//        showSubPanel("master");
//    }
    private void showSubPanel(String panel) {
        subMasterPanelVisible = false;
        subLaporanPanelVisible = false;
        subTransactionPanelVisible = false;
        switch (panel) {
            case "master":
                subMasterPanelVisible = true;
                break;
            case "laporan":
                subLaporanPanelVisible = true;
                break;
            case "transaksi":
                subTransactionPanelVisible = true;
                break;
            default:
        }
        subMasterPanel.setVisible(subMasterPanelVisible);
        subLaporanPanel.setVisible(subLaporanPanelVisible);
        subTransactionPanel.setVisible(subTransactionPanelVisible);
    }

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
    private javax.swing.JButton btnMaster;
    private javax.swing.JButton btnMaster1;
    private javax.swing.JButton btnMaster2;
    private javax.swing.JButton btnabout;
    private javax.swing.JButton dokBtn;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton psnBtn;
    private javax.swing.JButton regBtn;
    private javax.swing.JPanel subLaporanPanel;
    private javax.swing.JPanel subMasterPanel;
    private javax.swing.JPanel subTransactionPanel;
    // End of variables declaration//GEN-END:variables
}
