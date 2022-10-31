/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;


import static java.awt.Color.red;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author Kajamohan
 */
public final class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */       
            
    public LoginPage() {        
        initComponents();
        initailsSetting("");  

    }
    
    private ConnectDatabase database = new ConnectDatabase();
    private int posX = 0, posY = 0;
    
    public void initailsSetting(String k){
        
        HideViewBtn.setVisible(false);
        
        UserTypeInvalid.setVisible(false);
        UserNameInvalid.setVisible(false);
        PasswordInvalid.setVisible(false);
        
        LogoutMsg.setText(k);
        
        userType.setSelectedIndex(0);
        Password.setText("");
        userName.setText("");
        
        userType.setToolTipText("User Type");
        userName.setToolTipText("User Name");
        Password.setToolTipText("User Password");
        
        userTypeIcon.setToolTipText("User Type");
        userNameIcon.setToolTipText("User Name");
        passwordIcon.setToolTipText("User Password");
        
           
    }
    
    // Check Whether the user Input is Empty or Not
    public void CheckInputs(String UN,String PWD, int UTYPEID){
         if(UTYPEID == 0 ){
            JOptionPane.showMessageDialog(this,"Please Check Your User Type");
            userType.requestFocus();
            UserTypeInvalid.setVisible(true);
            UserTypeInvalid.setToolTipText("Please Select the User Type");
            
            if(UN.isEmpty() && PWD.isEmpty()){
                UserNameInvalid.setVisible(true);
                UserNameInvalid.setToolTipText("Please Enter Your Username");
                PasswordInvalid.setVisible(true);
                PasswordInvalid.setToolTipText("Please Enter Your Password");
            }else if(UN.isEmpty()){
                UserNameInvalid.setVisible(true);
                UserNameInvalid.setToolTipText("Please Enter Your Username");
                PasswordInvalid.setVisible(false);  
            }else if(PWD.isEmpty()) {
                UserNameInvalid.setVisible(false);
                PasswordInvalid.setVisible(true);  
                PasswordInvalid.setToolTipText("Please Enter Your Password");
            }else{
                UserNameInvalid.setVisible(false);
                PasswordInvalid.setVisible(false); 
            }
        }else if(UTYPEID != 0 && UN.isEmpty() ){
            JOptionPane.showMessageDialog(this,"Please Enter Your User Name");
            userName.requestFocus();
            UserNameInvalid.setVisible(true);
            UserNameInvalid.setToolTipText("Please Enter Your Username");
            
            if(PWD.isEmpty()){
                UserTypeInvalid.setVisible(false);
                PasswordInvalid.setVisible(true);
                PasswordInvalid.setToolTipText("Please Enter Your Password");
            }else{
                UserTypeInvalid.setVisible(false);
                PasswordInvalid.setVisible(false);
            }         
        }else{
            JOptionPane.showMessageDialog(this,"Please Enter Your Password");
            Password.requestFocus();
            PasswordInvalid.setVisible(true);
            PasswordInvalid.setToolTipText("Please Enter Your Password");
            UserTypeInvalid.setVisible(false);
            UserNameInvalid.setVisible(false);
        }     
    }
    
    public void Login() throws SQLException{
        String UN,PWD,UTYPE = "";
        int UTYPEID;
        
        //Store Data
        UN = userName.getText();
        PWD = String.valueOf(Password.getPassword());        
        UTYPEID = userType.getSelectedIndex();


        // User Name , Password , User Type is Empty
        if(UTYPEID == 0 || UN.isBlank()|| PWD.isBlank()){
            CheckInputs(UN, PWD, UTYPEID);
        }else {
            
            UserTypeInvalid.setVisible(false);
            UserNameInvalid.setVisible(false);
            PasswordInvalid.setVisible(false);            
            UTYPE = switch (UTYPEID) {
                        case 1 -> "Principal";
                        case 2 -> "Teacher";
                        case 3 -> "Student";
                        default -> "Cleark";
                    };
           
                if(database.userVerification(UN,PWD,UTYPE)){                                        
                    
                    switch (UTYPEID) {
                        case 1, 4 -> {                           
                            this.dispose();
                            AdminPage admin = new AdminPage();
                            admin.setUserDetails(UN, PWD);                           
                            admin.setVisible(true);
                        }
                        case 2 -> {                           
                            this.dispose();
                            TeacherPage Teacher = new TeacherPage();
                            Teacher.setUserDetails(UN, PWD);
                            Teacher.setVisible(true);
                        }
                        case 3 -> {                           
                            this.dispose();
                            StudentPage Student = new StudentPage();
                            Student.setUserDetails(UN, PWD);
                            Student.setVisible(true);
                        }
                    }
                }else{
                    initailsSetting("Your User Name, Password or User Type is Incorrect!!!");
                    JOptionPane.showMessageDialog(null,"Your User Name, Password or User Type is Incorrect!!!");
                    UserNameInvalid.setVisible(true);
                    UserNameInvalid.setToolTipText("Please Check Your User Name and Enter Agin!!!");
                    PasswordInvalid.setVisible(true);
                    PasswordInvalid.setToolTipText("Please Check Your Password and Enter Again!!!");
                    userType.requestFocus();    
                }
            
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

        LoginMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogoutMsg = new javax.swing.JLabel();
        userTypeIcon = new javax.swing.JLabel();
        userNameIcon = new javax.swing.JLabel();
        passwordIcon = new javax.swing.JLabel();
        userType = new javax.swing.JComboBox<>();
        userName = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        Reset = new javax.swing.JButton();
        UserTypeInvalid = new javax.swing.JLabel();
        UserNameInvalid = new javax.swing.JLabel();
        HideViewBtn = new javax.swing.JToggleButton();
        PasswordInvalid = new javax.swing.JLabel();
        CancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(red);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(50, 100));

        LoginMain.setBackground(new java.awt.Color(204, 204, 204));
        LoginMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 10, true));
        LoginMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                LoginMainMouseDragged(evt);
            }
        });
        LoginMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginMainMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/user login.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login to Your Account");

        LogoutMsg.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        LogoutMsg.setForeground(new java.awt.Color(255, 0, 0));
        LogoutMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoutMsg.setText("You Logout Successfully !!!");

        userTypeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/user type.png"))); // NOI18N
        userTypeIcon.setToolTipText("User Type");
        userTypeIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userTypeIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        userNameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/user name.png"))); // NOI18N
        userNameIcon.setToolTipText("User Name");
        userNameIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userNameIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        passwordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/password.png"))); // NOI18N
        passwordIcon.setToolTipText("Password");
        passwordIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        passwordIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        userType.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Your User Type", "Principal", "Teacher", "Student", "Cleark" }));
        userType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTypeKeyPressed(evt);
            }
        });

        userName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameKeyPressed(evt);
            }
        });

        Login.setBackground(new java.awt.Color(0, 153, 153));
        Login.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginKeyPressed(evt);
            }
        });

        Password.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordKeyPressed(evt);
            }
        });

        Reset.setBackground(new java.awt.Color(0, 153, 153));
        Reset.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        UserTypeInvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/Invalid.png"))); // NOI18N
        UserTypeInvalid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        UserNameInvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/Invalid.png"))); // NOI18N
        UserNameInvalid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        HideViewBtn.setBackground(new java.awt.Color(51, 255, 51));
        HideViewBtn.setForeground(new java.awt.Color(0, 204, 0));
        HideViewBtn.setIcon(new javax.swing.ImageIcon("F:\\UINVERSITY OF JAFFNA NOTES\\5th Semester\\SQL Project\\SchoolManagementSystem\\src\\School\\Icons\\hide.png")); // NOI18N
        HideViewBtn.setMaximumSize(new java.awt.Dimension(57, 30));
        HideViewBtn.setMinimumSize(new java.awt.Dimension(57, 30));
        HideViewBtn.setPreferredSize(new java.awt.Dimension(57, 30));
        HideViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HideViewBtnActionPerformed(evt);
            }
        });

        PasswordInvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/School/Icons/Invalid.png"))); // NOI18N
        PasswordInvalid.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        CancelBtn.setBackground(new java.awt.Color(0, 153, 153));
        CancelBtn.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginMainLayout = new javax.swing.GroupLayout(LoginMain);
        LoginMain.setLayout(LoginMainLayout);
        LoginMainLayout.setHorizontalGroup(
            LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginMainLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LogoutMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(LoginMainLayout.createSequentialGroup()
                        .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LoginMainLayout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1))
                            .addGroup(LoginMainLayout.createSequentialGroup()
                                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userTypeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userNameIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwordIcon))
                                .addGap(18, 18, 18)
                                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userName)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UserNameInvalid)
                                    .addGroup(LoginMainLayout.createSequentialGroup()
                                        .addComponent(PasswordInvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(HideViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(UserTypeInvalid))))
                        .addGap(30, 30, 30))))
            .addGroup(LoginMainLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LoginMainLayout.setVerticalGroup(
            LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginMainLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userType)
                            .addComponent(userTypeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(LoginMainLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(UserTypeInvalid)))
                .addGap(20, 20, 20)
                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userName)
                    .addComponent(userNameIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginMainLayout.createSequentialGroup()
                        .addComponent(UserNameInvalid)
                        .addGap(17, 17, 17)))
                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginMainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Password)))
                    .addGroup(LoginMainLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HideViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordInvalid))))
                .addGap(25, 25, 25)
                .addGroup(LoginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(LoginMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // Clear the User type, user name and Password
        initailsSetting("");        
        
    }//GEN-LAST:event_ResetActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        try {
//            System.out.println("User Type : " + userType.getSelectedItem().toString());
//            System.out.println("User name : " + userName.getText());
//            System.out.println("Password : " +  String.valueOf(Password.getPassword()));
            Login();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           try {
               Login();
           } catch (SQLException ex) {
               Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_LoginKeyPressed

    private void HideViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HideViewBtnActionPerformed
       // Hide or View the Password
        Icon iconHide = new ImageIcon("F:\\UINVERSITY OF JAFFNA NOTES\\5th Semester\\SQL Project\\SchoolManagementSystem\\src\\School\\Icons\\hide.png");
        Icon iconView = new ImageIcon("F:\\UINVERSITY OF JAFFNA NOTES\\5th Semester\\SQL Project\\SchoolManagementSystem\\src\\School\\Icons\\view.png");
        
        // Check Whether the user click the Hide / View Button
        if(HideViewBtn.getModel().isSelected()){
            Password.setEchoChar((char)0);
            HideViewBtn.setIcon(iconView);
        }else{
            Password.setEchoChar('*');
            HideViewBtn.setIcon(iconHide);
        }

    }//GEN-LAST:event_HideViewBtnActionPerformed

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained
        HideViewBtn.setVisible(true);
    }//GEN-LAST:event_PasswordFocusGained

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
        HideViewBtn.setVisible(false);
    }//GEN-LAST:event_PasswordFocusLost

    private void userNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                Login();
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_userNameKeyPressed

    private void PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                Login();
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_PasswordKeyPressed

    private void userTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                Login();
            } catch (SQLException ex) {
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_userTypeKeyPressed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void LoginMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMainMousePressed
        // Get Mouse Position X,Y Co-Ordinates
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_LoginMainMousePressed

    private void LoginMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginMainMouseDragged
        // Move all Frame using Mouse 
        setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_LoginMainMouseDragged

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JToggleButton HideViewBtn;
    private javax.swing.JButton Login;
    private javax.swing.JPanel LoginMain;
    private javax.swing.JLabel LogoutMsg;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordInvalid;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel UserNameInvalid;
    private javax.swing.JLabel UserTypeInvalid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel passwordIcon;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userNameIcon;
    private javax.swing.JComboBox<String> userType;
    private javax.swing.JLabel userTypeIcon;
    // End of variables declaration//GEN-END:variables
}
