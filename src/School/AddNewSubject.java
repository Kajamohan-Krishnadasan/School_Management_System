/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;


import static School.ConnectDatabase.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Kajamohan
 */
public class AddNewSubject extends javax.swing.JFrame {

    /**
     * Creates new form AddNewSubject
     */
    ConnectDatabase database = new ConnectDatabase();
    private int posX, posY;
    LocalDate Current = LocalDate.now();
        
    
    public AddNewSubject() throws SQLException {
        initComponents();
        AutoCompleteDecorator.decorate(TeachNameTxt);
        AutoCompleteDecorator.decorate(ClsNameTxt);
        AutoCompleteDecorator.decorate(SelectTerm);
        setInitialSetting();        
    }
    
    
    public void setInitialSetting() throws SQLException{ 
         
        try {
            String ID = database.getSubjectFinalID();
            int id = Integer.valueOf(ID)+1;    
            if(id < 10){
                SubjectIDLabel.setText("SUBJECT00"+String.valueOf(id));
            }else if(id < 100){
                SubjectIDLabel.setText("SUBJECT0"+String.valueOf(id));
            }else{
                SubjectIDLabel.setText("SUBJECT"+String.valueOf(id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Add Teacher Drop Down Box
        ConnectDatabase.setTeachersNames();
        for(int i = 0; i < ConnectDatabase.Teachers.size(); i++){
            TeachNameTxt.addItem(ConnectDatabase.Teachers.get(i).getName());
        }
        
        // Add Class Drop Down Box
        ConnectDatabase.setClassNames();
        for(int i = 0; i < ConnectDatabase.ClassDetails.size(); i++){
            ClsNameTxt.addItem(ConnectDatabase.ClassDetails.get(i).getName());
        }
        
//        // Add Term Drop Down Box
//        ConnectDatabase.setTerms(ClsNameTxt.getSelectedItem().toString());
//        ConnectDatabase.Terms.forEach(terms -> {
//            SelectTerm.addItem(terms);
//        });
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewSubjectMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        SubjectIDLabel = new javax.swing.JLabel();
        SubjectNameTxt = new javax.swing.JTextField();
        SelectTerm = new javax.swing.JComboBox<>();
        YearTxt = new com.toedter.calendar.JYearChooser();
        TeachNameTxt = new javax.swing.JComboBox<>();
        ClsNameTxt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Subject");
        setUndecorated(true);

        NewSubjectMain.setBackground(new java.awt.Color(255, 255, 255));
        NewSubjectMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 10, true));
        NewSubjectMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                NewSubjectMainMouseDragged(evt);
            }
        });
        NewSubjectMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NewSubjectMainMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Subject");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Subject ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Subject Name :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Year :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Term :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Teacher Name :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Classs Name :");

        AddBtn.setBackground(new java.awt.Color(0, 153, 153));
        AddBtn.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(0, 153, 153));
        CancelBtn.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(0, 153, 153));
        ResetBtn.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        SubjectIDLabel.setBackground(new java.awt.Color(231, 231, 231));
        SubjectIDLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectIDLabel.setOpaque(true);

        SubjectNameTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubjectNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectNameTxtActionPerformed(evt);
            }
        });

        SelectTerm.setEditable(true);
        SelectTerm.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        SelectTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Term" }));

        YearTxt.setFont(new java.awt.Font("Times New Roman", 0, 24));

        TeachNameTxt.setEditable(true);
        TeachNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        TeachNameTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Teacher" }));

        ClsNameTxt.setEditable(true);
        ClsNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ClsNameTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class" }));
        ClsNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClsNameTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewSubjectMainLayout = new javax.swing.GroupLayout(NewSubjectMain);
        NewSubjectMain.setLayout(NewSubjectMainLayout);
        NewSubjectMainLayout.setHorizontalGroup(
            NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewSubjectMainLayout.createSequentialGroup()
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewSubjectMainLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubjectNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TeachNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClsNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectTerm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubjectIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NewSubjectMainLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(CancelBtn)
                        .addGap(52, 52, 52)
                        .addComponent(ResetBtn))
                    .addGroup(NewSubjectMainLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        NewSubjectMainLayout.setVerticalGroup(
            NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewSubjectMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubjectIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubjectNameTxt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(YearTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TeachNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClsNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(NewSubjectMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NewSubjectMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(NewSubjectMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        SubjectNameTxt.setText("");
        YearTxt.setYear(Current.getYear());
        TeachNameTxt.setSelectedIndex(0);
        ClsNameTxt.setSelectedIndex(0);
        SelectTerm.setSelectedIndex(0);
        SubjectNameTxt.requestFocus();
        
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        System.out.println("Term : "+SelectTerm.getSelectedItem().toString());
        System.out.println("Index : "+SelectTerm.getSelectedIndex());
        
        String sID,sName,sYear,sTerm,sTeacherID,sClassID;
        boolean checkValue;
        
        if(SubjectNameTxt.getText().isBlank() ){
            checkValue = false;
            JOptionPane.showMessageDialog(this,"Enter the Subject Name!!! ");  
            SubjectNameTxt.requestFocus();
        }else if (TeachNameTxt.getSelectedIndex() == 0){
            checkValue = false;
            JOptionPane.showMessageDialog(this,"Please Select the Teacher!!! ");  
            TeachNameTxt.requestFocus();
        }else if(ClsNameTxt.getSelectedIndex() == 0){
            checkValue = false;
            JOptionPane.showMessageDialog(this,"Please Select the Class!!! ");  
            ClsNameTxt.requestFocus();
        }else if(SelectTerm.getSelectedIndex() == 0 ){
            checkValue = false;
            JOptionPane.showMessageDialog(this,"Please Select the Term ");  
            SelectTerm.requestFocus();
        }else{
             checkValue = true;
        }

        sID = SubjectIDLabel.getText();
        sName = SubjectNameTxt.getText();
        sYear = Integer.toString(YearTxt.getYear());
        sTerm = Integer.toString(SelectTerm.getSelectedIndex());               
        
        if(checkValue){
            try {
                sClassID = ConnectDatabase.ClassDetails.get(ClsNameTxt.getSelectedIndex()-1).getId();
                sTeacherID = ConnectDatabase.Teachers.get(TeachNameTxt.getSelectedIndex()-1).getId();
                database.insertNewSubject(sID, sName, sYear, sTerm, sClassID, sTeacherID);
                
                callYesNo();
                
            } catch (SQLException ex) {
                Logger.getLogger(AddNewSubject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_AddBtnActionPerformed

    private void NewSubjectMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewSubjectMainMousePressed
        // Get Mouse Position X,Y Co-Ordinates
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_NewSubjectMainMousePressed

    private void NewSubjectMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewSubjectMainMouseDragged
        // Move all Frame using Mouse 
        setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_NewSubjectMainMouseDragged

    private void SubjectNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectNameTxtActionPerformed
        
    }//GEN-LAST:event_SubjectNameTxtActionPerformed

    private void ClsNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClsNameTxtActionPerformed
        SelectTerm.removeAllItems();
        SelectTerm.addItem("Select Term");
        // Add Term Drop Down Box
        ConnectDatabase.setTerms();
        ConnectDatabase.Terms.forEach(terms -> {
            SelectTerm.addItem(terms);
        });
        SelectTerm.setSelectedIndex(0);
    }//GEN-LAST:event_ClsNameTxtActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddNewSubject().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddNewSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JComboBox<String> ClsNameTxt;
    private javax.swing.JPanel NewSubjectMain;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JComboBox<String> SelectTerm;
    private javax.swing.JLabel SubjectIDLabel;
    private javax.swing.JTextField SubjectNameTxt;
    private javax.swing.JComboBox<String> TeachNameTxt;
    private com.toedter.calendar.JYearChooser YearTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
    
    private void callYesNo() throws SQLException{
        int result = JOptionPane.showConfirmDialog(this,"New Subject Added Succesfully\nDo You Want to add Another Subject?","Students Marks",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
                
        if(result == JOptionPane.NO_OPTION){
            this.dispose();
        }else{
            this.dispose();
            new AddNewSubject().setVisible(true);
        }
    }
}
