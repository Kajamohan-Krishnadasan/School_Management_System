/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;


import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author Kajamohan
 */
public class AddNewClass extends javax.swing.JFrame {

    /**
     * Creates new form AddNewClass
     */
    
    ConnectDatabase database = new ConnectDatabase();
    private int posX, posY;
    
    public AddNewClass() throws SQLException {
        initComponents();
        initialSetting();
        AutoCompleteDecorator.decorate(TeacherName);
    }
    
    public  void initialSetting() throws SQLException{
        try {
            String ID = database.getClassFinalID();
            int id = Integer.valueOf(ID)+1;    
            if(id < 10){
                ClassID.setText("CLASS00"+String.valueOf(id));
            }else if(id < 100){
                ClassID.setText("CLASS0"+String.valueOf(id));
            }else{
                ClassID.setText("CLASS"+String.valueOf(id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectDatabase.setTeachersNames();
        ConnectDatabase.Teachers.forEach(t->{
            TeacherName.addItem(t.getName());
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewClass = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ClassID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ClassName = new javax.swing.JTextField();
        TeacherName = new javax.swing.JComboBox<>();
        OkBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        ResetBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New Class");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        NewClass.setBackground(new java.awt.Color(255, 255, 255));
        NewClass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 8, true));
        NewClass.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                NewClassMouseDragged(evt);
            }
        });
        NewClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NewClassMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Class");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Class ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Class Name :");

        ClassID.setBackground(new java.awt.Color(204, 204, 204));
        ClassID.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ClassID.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Class Teacher :");

        ClassName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ClassName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ClassNameKeyPressed(evt);
            }
        });

        TeacherName.setEditable(true);
        TeacherName.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        TeacherName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Teacher" }));
        TeacherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeacherNameKeyPressed(evt);
            }
        });

        OkBtn.setBackground(new java.awt.Color(0, 102, 102));
        OkBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        OkBtn.setForeground(new java.awt.Color(255, 255, 255));
        OkBtn.setText("OK");
        OkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(0, 102, 102));
        CancelBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        ResetBttn.setBackground(new java.awt.Color(0, 102, 102));
        ResetBttn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ResetBttn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBttn.setText("Reset");
        ResetBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewClassLayout = new javax.swing.GroupLayout(NewClass);
        NewClass.setLayout(NewClassLayout);
        NewClassLayout.setHorizontalGroup(
            NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewClassLayout.createSequentialGroup()
                .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewClassLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewClassLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClassID, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NewClassLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(OkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(ResetBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        NewClassLayout.setVerticalGroup(
            NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewClassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClassID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(NewClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ResetBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(NewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(NewClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ResetBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBttnActionPerformed
        ClassName.setText("");
        TeacherName.setSelectedIndex(0);        
    }//GEN-LAST:event_ResetBttnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void OkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtnActionPerformed
        EnterPress();
        
    }//GEN-LAST:event_OkBtnActionPerformed

    private void NewClassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewClassMousePressed
       // Get Mouse Position X,Y Co-Ordinates
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_NewClassMousePressed

    private void NewClassMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewClassMouseDragged
        // Move all Frame using Mouse 
        setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_NewClassMouseDragged

    private void ClassNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClassNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            EnterPress();
        }
    }//GEN-LAST:event_ClassNameKeyPressed

    private void TeacherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeacherNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            EnterPress();
        }
    }//GEN-LAST:event_TeacherNameKeyPressed

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
            java.util.logging.Logger.getLogger(AddNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddNewClass().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddNewClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel ClassID;
    private javax.swing.JTextField ClassName;
    private javax.swing.JPanel NewClass;
    private javax.swing.JButton OkBtn;
    private javax.swing.JButton ResetBttn;
    private javax.swing.JComboBox<String> TeacherName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
    public boolean CheckOldClass() throws SQLException{
        boolean b = true;
        
        ConnectDatabase.setClassNames();
        for(int i = 0; i < ConnectDatabase.ClassDetails.size(); i++){
            if(ClassName.getText().toLowerCase().equals(ConnectDatabase.ClassDetails.get(i).getName().toLowerCase())){
                JOptionPane.showMessageDialog(this,"You Already Have this Class!!!","Change Class Name",NORMAL);
                ClassName.requestFocus();
                ClassName.select(0, ClassName.getText().length());
                b = false;
                break;
            }
                
        }
        return b;
    }
    
    private void EnterPress(){
        try {
            String id,name,teacher;
            id = ClassID.getText();
            name = ClassName.getText();
            int  teacherID = TeacherName.getSelectedIndex()-1;
            if(teacherID != -1 && !name.isBlank() && !name.isEmpty() && CheckOldClass()){
                
                teacher = ConnectDatabase.Teachers.get(teacherID).getId();
                database.addNewClass(id, name, teacher);
                callYesNo();
                
                
            }else if(name.isBlank() || name.isEmpty()){
                JOptionPane.showMessageDialog(this,"Please Enter the Class Name!!!");
                ClassName.requestFocus();
            }else if(teacherID == -1){
                JOptionPane.showMessageDialog(this,"Please Select Teacher Name!!!");
                TeacherName.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void callYesNo() throws SQLException{
        int result = JOptionPane.showConfirmDialog(this,"New Class Added Successfully\nDo You Want to add Another Class?","Students Marks",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
                
        if(result == JOptionPane.NO_OPTION){
            this.dispose();
            
        }else{
            this.dispose();
            new AddNewClass().setVisible(true);
        }
    }
}
