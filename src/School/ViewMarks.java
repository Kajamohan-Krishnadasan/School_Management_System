/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;

import static School.ConnectDatabase.*;
import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Kajamohan
 */
public class ViewMarks extends javax.swing.JFrame {

    /**
     * Creates new form ViewMarks
     */
    private int posX, posY;
    private String clsID,stdID;
    private char logType;
    ConnectDatabase database = new ConnectDatabase();
    
    public void setClsID(String clsID) {
        this.clsID = clsID;
    }
    public void setType(char logType) {
        this.logType = logType;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }
    
    public ViewMarks() throws SQLException {
        initComponents();
        initialSetting();
        AutoCompleteDecorator.decorate(selectClass);
        AutoCompleteDecorator.decorate(selectSubject);
        AutoCompleteDecorator.decorate(selectTerm);
    }
    
    public  void initialSetting() throws SQLException{
        HeaderSetting h1 =  new HeaderSetting();
        h1.theader(ViewMarksTable.getTableHeader());  
        h1.HeaderRenderer(ViewMarksTable);
        
        ViewMarksTable.setColumnSelectionAllowed(false);
        ViewMarksTable.setRowSelectionAllowed(false);
        ViewMarksTable.setCellSelectionEnabled(false);
        
        ViewMarksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
        renderCenter.setHorizontalAlignment(JLabel.CENTER);
        
         // Add Class Drop Down Box
        ConnectDatabase.setClassNames();
        for(int i = 0; i < ConnectDatabase.ClassDetails.size(); i++){
            selectClass.addItem(ConnectDatabase.ClassDetails.get(i).getName());
        }
        
        if (YearTxt.getText().isEmpty()) {
            YearTxt.setForeground(Color.GRAY);
            YearTxt.setText("Year");
            YearTxt.setBackground(new Color(255,255,255));
        }
        
        ViewMarksTable.getColumnModel().getColumn(0).setCellRenderer(renderCenter);
        DefaultTableModel dm = (DefaultTableModel) ViewMarksTable.getModel();
        int rowCount = ViewMarksTable.getRowCount();
        
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        
    }
    
    public void setTableHeaderValuesInStudent() throws SQLException{
        selectClass.setVisible(false);
        selectSubject.setVisible(false);
        selectTerm.setVisible(false);
        viewBtn.setVisible(false);
        resetBtn.setVisible(false);
        YearTxt.setVisible(false);
        
        DefaultTableModel ViewMarksModel = (DefaultTableModel) ViewMarksTable.getModel();
        
        ViewMarksModel.setColumnIdentifiers(new String [] {
        "NO", "Subject Name", "Marks"
        });
        if (ViewMarksTable.getColumnModel().getColumnCount() > 0) {
            ViewMarksTable.getColumnModel().getColumn(0).setResizable(false);
            ViewMarksTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ViewMarksTable.getColumnModel().getColumn(1).setResizable(false);
            ViewMarksTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            ViewMarksTable.getColumnModel().getColumn(2).setResizable(false);
            ViewMarksTable.getColumnModel().getColumn(2).setPreferredWidth(100);
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
        closeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectClass = new javax.swing.JComboBox<>();
        selectSubject = new javax.swing.JComboBox<>();
        viewBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ViewMarksTable = new javax.swing.JTable();
        selectTerm = new javax.swing.JComboBox<>();
        resetBtn = new javax.swing.JButton();
        YearTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Marks");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 10, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(0, 102, 102));
        closeBtn.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Marks");

        selectClass.setBackground(new java.awt.Color(0, 102, 102));
        selectClass.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        selectClass.setForeground(new java.awt.Color(0, 102, 102));
        selectClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class" }));
        selectClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClassActionPerformed(evt);
            }
        });

        selectSubject.setBackground(new java.awt.Color(0, 102, 102));
        selectSubject.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        selectSubject.setForeground(new java.awt.Color(0, 102, 102));
        selectSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject" }));

        viewBtn.setBackground(new java.awt.Color(0, 102, 102));
        viewBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        viewBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        ViewMarksTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ViewMarksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Student Name", "Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ViewMarksTable.setRowHeight(40);
        ViewMarksTable.setShowGrid(true);
        ViewMarksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ViewMarksTable);
        if (ViewMarksTable.getColumnModel().getColumnCount() > 0) {
            ViewMarksTable.getColumnModel().getColumn(0).setResizable(false);
            ViewMarksTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ViewMarksTable.getColumnModel().getColumn(1).setResizable(false);
            ViewMarksTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            ViewMarksTable.getColumnModel().getColumn(2).setResizable(false);
            ViewMarksTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        selectTerm.setBackground(new java.awt.Color(0, 102, 102));
        selectTerm.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        selectTerm.setForeground(new java.awt.Color(0, 102, 102));
        selectTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Term" }));

        resetBtn.setBackground(new java.awt.Color(0, 102, 102));
        resetBtn.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        YearTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        YearTxt.setToolTipText("Year");
        YearTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                YearTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                YearTxtFocusLost(evt);
            }
        });
        YearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearTxtActionPerformed(evt);
            }
        });
        YearTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                YearTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(selectSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(YearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(YearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // Get Mouse Position X,Y Co-Ordinates
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // Move all Frame using Mouse 
        setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        try {
            ClearTable();
            teacherViewBtn();
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }//GEN-LAST:event_viewBtnActionPerformed

    private void selectClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectClassActionPerformed
        try {
            int sClass;
            int rowCount = ViewMarksTable.getRowCount();
            DefaultTableModel dm = (DefaultTableModel) ViewMarksTable.getModel();
            
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }
            
            selectTerm.removeAllItems();
            selectTerm.addItem("Select Term");
            //  Add Term Drop Down Box
            ConnectDatabase.setTerms();
            ConnectDatabase.Terms.forEach(terms -> {
                selectTerm.addItem(terms);
            }); 
            sClass = selectClass.getSelectedIndex();
            
            if(sClass>0){
//                displayStudents(ConnectDatabase.ClassDetails.get(sClass-1).getId());
            
                selectSubject.removeAllItems();
                selectSubject.addItem("Select Subject");

                String cID =  ConnectDatabase.ClassDetails.get(sClass-1).getId();

                ConnectDatabase.setSubjectsNames(cID);
                for(int i = 0; i < ConnectDatabase.SubjectDetails.size(); i++){
                    selectSubject.addItem(ConnectDatabase.SubjectDetails.get(i).getName());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selectClassActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        ClearTable();
        selectClass.setSelectedIndex(0);
        selectSubject.setSelectedIndex(0);
        selectTerm.setSelectedIndex(0);
        YearTxt.setText("");
        
        
        if (YearTxt.getText().isEmpty()) {
            YearTxt.setForeground(Color.GRAY);
            YearTxt.setText("Year");
            YearTxt.setBackground(new Color(255,255,255));
        }
    }//GEN-LAST:event_resetBtnActionPerformed

    private void YearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearTxtActionPerformed

    private void YearTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YearTxtKeyReleased
        // contains only digits
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex); 
        Matcher isYearMatched = pattern.matcher(YearTxt.getText()); 
        
        Student.CalcuateTerm();
        int cY = Student.currentYear;
        
        
        if(!isYearMatched.matches()){
            YearTxt.requestFocus();
            YearTxt.setBackground(new Color(255,106,83));

        }else{
            int y = Integer.parseInt(YearTxt.getText()) ;
            if( y < 1901 || y > cY ){

                YearTxt.requestFocus();
                YearTxt.setBackground(new Color(255,106,83));
            }else
                YearTxt.setBackground(new Color(255,255,255));
            
        }
    }//GEN-LAST:event_YearTxtKeyReleased

    private void YearTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YearTxtFocusGained
        if (YearTxt.getText().equals("Year")) {
            YearTxt.setText("");
            YearTxt.setForeground(Color.BLACK);
            YearTxt.setBackground(new Color(255,255,255));
        }
    }//GEN-LAST:event_YearTxtFocusGained

    private void YearTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_YearTxtFocusLost
        if (YearTxt.getText().isEmpty()) {
            YearTxt.setForeground(Color.GRAY);
            YearTxt.setText("Year");
            YearTxt.setBackground(new Color(255,255,255));
        }
    }//GEN-LAST:event_YearTxtFocusLost

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
            java.util.logging.Logger.getLogger(ViewMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewMarks().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewMarks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ViewMarksTable;
    private javax.swing.JTextField YearTxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetBtn;
    private javax.swing.JComboBox<String> selectClass;
    private javax.swing.JComboBox<String> selectSubject;
    private javax.swing.JComboBox<String> selectTerm;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
   
    
    public void tableValuesForStudents() throws SQLException{
        Student.CalcuateTerm();
        int Y = Student.currentYear;
        int T = Student.currentTerm;
        DefaultTableModel ViewMarksModel = (DefaultTableModel) ViewMarksTable.getModel();
        
        ConnectDatabase.StudentSubjectMarksTable.clear();
        ConnectDatabase.getSubjectAndMarks(Y, T, clsID,stdID);

        int No;
        String sName;
        float marks;

        if(StudentSubjectMarksTable.size() > 0){
           for(int i = 0; i<StudentSubjectMarksTable.size(); i++){
                No = i+1;
                sName = StudentSubjectMarksTable.get(i).getName();
                marks = StudentSubjectMarksTable.get(i).getMarks();

                ViewMarksModel.addRow(new Object[]{
                    No,sName,marks
                });
            } 
        }
    }
    
    public void teacherViewBtn() throws SQLException{
        
        if(checkValues()){
            String subID = ConnectDatabase.SubjectDetails.get(selectSubject.getSelectedIndex()-1).getId();
            int T = selectTerm.getSelectedIndex();
            int Y = Integer.parseInt(YearTxt.getText());
            
            ConnectDatabase.getStudentsAndMarks(Y, T, subID);
            DefaultTableModel ViewMarksModel = (DefaultTableModel) ViewMarksTable.getModel();
            int No;
            String sName;
            float marks;
           
            if(StudentMarksTable.size() >0){
                for(int i = 0; i<StudentMarksTable.size(); i++){
                    No = i+1;
                    sName = StudentMarksTable.get(i).getName();
                    marks = StudentMarksTable.get(i).getMarks();

                    ViewMarksModel.addRow(new Object[]{
                        No,sName,marks
                    });
                }  
            }else
                JOptionPane.showMessageDialog(this,"Not Found" );
  
        }
    }
    
    public boolean checkValues(){
        int sClass,sSubject,sTerm, sYear,Y;
        Student.CalcuateTerm();
        Y = Student.currentYear;
        
        sClass = selectClass.getSelectedIndex();
        sSubject = selectSubject.getSelectedIndex();
        sTerm = selectTerm.getSelectedIndex();
        
        // contains only digits
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex); 
        Matcher isYearMatched = pattern.matcher(YearTxt.getText()); 
        boolean b;
        
        if(sClass == 0){
            selectClass.requestFocus();
            JOptionPane.showMessageDialog(this, "Please Select the Class!!!","Error Message",NORMAL);
            b = false;
        }else if(sSubject == 0){
            selectSubject.requestFocus();
            JOptionPane.showMessageDialog(this, "Please Select the Subject!!!","Error Message",NORMAL);
            b = false;
        }else if(sTerm == 0){
            selectTerm.requestFocus();
            JOptionPane.showMessageDialog(this, "Please Select the Term!!!","Error Message",NORMAL);
            b = false;
        }else if(isYearMatched.matches()) {
            sYear = Integer.parseInt(YearTxt.getText());
            if(sYear < 1901 || sYear > Y || YearTxt.getText().length() != 4 ){
                YearTxt.requestFocus();
                JOptionPane.showMessageDialog(this, "Please Enter the Correct Year!!!","Error Message",NORMAL);
                b = false;
            }else{
                b = true;
            }
        }else if(!isYearMatched.matches()){
            YearTxt.requestFocus();
            JOptionPane.showMessageDialog(this, "Please Enter the Correct Year!!!","Error Message",NORMAL);
            b =  false;
        }else{
            b =  true;
        }
        
       
        return b;
        
    }
    
    public void ClearTable(){
        DefaultTableModel dm = (DefaultTableModel) ViewMarksTable.getModel();
        int rowCount = ViewMarksTable.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
}
