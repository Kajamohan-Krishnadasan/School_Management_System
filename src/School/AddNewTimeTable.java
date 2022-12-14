/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;


import static School.ConnectDatabase.*;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Kajamohan
 */
public class AddNewTimeTable extends javax.swing.JFrame {

    /**
     * Creates new form AddNewTimeTable
     */
    ConnectDatabase database = new ConnectDatabase();
    int colValue ;
    int rowValue ;
    private int posX, posY;
    
    public AddNewTimeTable() throws SQLException {
        initComponents();
        initialSetting();
    }
    
    private void initialSetting() throws SQLException{
        HeaderSetting h1 =  new HeaderSetting();
        h1.theader(newTimetable.getTableHeader());  
        h1.HeaderRenderer(newTimetable);
        colValue = newTimetable.getColumnCount();
        rowValue = newTimetable.getRowCount();
        
        AutoCompleteDecorator.decorate(SelectClass);
        AutoCompleteDecorator.decorate(SelectTerm);

        
         // Add Class Drop Down Box
        ConnectDatabase.setClassNames();

        for(int i = 0; i < ConnectDatabase.ClassDetails.size(); i++){
            SelectClass.addItem(ConnectDatabase.ClassDetails.get(i).getName());
        }

        SelectSubjects.setFont(new java.awt.Font("Times New Roman", 1, 20));
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
        jLabel3 = new javax.swing.JLabel();
        SelectClass = new javax.swing.JComboBox<>();
        SelectTerm = new javax.swing.JComboBox<>();
        SelectYear = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        newTimetable = new javax.swing.JTable();
        okBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New TimeTable");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 10, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Corbel", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Select Year :");
        jLabel3.setAlignmentX(0.5F);

        SelectClass.setBackground(new java.awt.Color(0, 102, 102));
        SelectClass.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        SelectClass.setForeground(new java.awt.Color(0, 102, 102));
        SelectClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class" }));
        SelectClass.setOpaque(false);
        SelectClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectClassActionPerformed(evt);
            }
        });

        SelectTerm.setBackground(new java.awt.Color(0, 102, 102));
        SelectTerm.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        SelectTerm.setForeground(new java.awt.Color(0, 102, 102));
        SelectTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Term" }));
        SelectTerm.setOpaque(false);
        SelectTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectTermActionPerformed(evt);
            }
        });

        SelectYear.setBackground(new java.awt.Color(204, 255, 255));
        SelectYear.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SelectYear.setFont(new Font("Times New Roman", 0, 26));
        SelectYear.setOpaque(false);

        newTimetable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newTimetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        newTimetable.setColumnSelectionAllowed(true);
        newTimetable.setEditingColumn(0);
        newTimetable.setEditingRow(0);
        newTimetable.setRequestFocusEnabled(false);
        newTimetable.setRowHeight(45);
        newTimetable.setRowMargin(2);
        newTimetable.setShowGrid(true);
        newTimetable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(newTimetable);
        newTimetable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (newTimetable.getColumnModel().getColumnCount() > 0) {
            newTimetable.getColumnModel().getColumn(0).setResizable(false);
            newTimetable.getColumnModel().getColumn(0).setPreferredWidth(200);
            newTimetable.getColumnModel().getColumn(1).setResizable(false);
            newTimetable.getColumnModel().getColumn(1).setPreferredWidth(200);
            newTimetable.getColumnModel().getColumn(2).setResizable(false);
            newTimetable.getColumnModel().getColumn(2).setPreferredWidth(200);
            newTimetable.getColumnModel().getColumn(3).setResizable(false);
            newTimetable.getColumnModel().getColumn(3).setPreferredWidth(200);
            newTimetable.getColumnModel().getColumn(4).setResizable(false);
            newTimetable.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        okBtn.setBackground(new java.awt.Color(0, 102, 102));
        okBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        okBtn.setText("Add");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(0, 102, 102));
        CancelBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(0, 102, 102));
        ResetBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Time Table");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SelectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(SelectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(SelectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SelectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SelectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void SelectClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectClassActionPerformed

        SelectTerm.removeAllItems();
        SelectTerm.addItem("Select Term");

        // Add Term Drop Down Box
        ConnectDatabase.setTerms();
        ConnectDatabase.Terms.forEach(terms -> {
            SelectTerm.addItem(terms);
        });
       
    }//GEN-LAST:event_SelectClassActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
       this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        boolean b = true;
        
        for (int i = 0; i < rowValue; i++) {
            for (int j = 0; j < colValue; j++) {                
                if(newTimetable.getModel().getValueAt(i , j ) == null){ 
                    b = false;
                    break;
                }else if(newTimetable.getModel().getValueAt(i , j ).toString().isBlank()){
                    b = false;
                    newTimetable.getModel().isCellEditable(i, j);
                    break;
                }                   
            }
        }
        
        if (SelectClass.getSelectedIndex() != 0 && SelectTerm.getSelectedIndex() != 0 && b){
            try {
                callYesNo();
            } catch (SQLException ex) {
                Logger.getLogger(AddNewTimeTable.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }else if(SelectClass.getSelectedIndex() == 0 ){
            SelectClass.requestFocus();
            JOptionPane.showMessageDialog(this,"Please Check the Class","Error Message",NORMAL);
        }else if( SelectTerm.getSelectedIndex() == 0){
            SelectTerm.requestFocus();
            JOptionPane.showMessageDialog(this,"Please Check the Term","Error Message",NORMAL);
        }else{
            JOptionPane.showMessageDialog(this,"Please Check the Details in Timetable!!","Error Message",NORMAL);
            newTimetable.requestFocus();
        }
    }//GEN-LAST:event_okBtnActionPerformed

    
    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        colValue = newTimetable.getColumnCount();
        rowValue = newTimetable.getRowCount();       
        
        for (int i = 0; i < rowValue; i++) {
            for (int j = 0; j < colValue; j++) {
                    newTimetable.getModel().setValueAt("",i , j );
            }
        }
        
        JTextField emptyLabel = new JTextField();
        for(int i = 0; i < colValue; i++ ){
            newTimetable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(emptyLabel));
        }
        
        SelectTerm.removeAllItems();
        SelectTerm.addItem("Select Term");
        
        SelectClass.setSelectedIndex(0);
        SelectTerm.setSelectedIndex(0);
        Student.CalcuateTerm();
        SelectYear.setYear(Student.currentYear);
        SelectSubjects.removeAllItems();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        newTimetable.requestFocus(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // Get Mouse Position X,Y Co-Ordinates
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // Move all Frame using Mouse 
        setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void SelectTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectTermActionPerformed
        try {
            setSubjects();
        } catch (SQLException ex) {
            Logger.getLogger(AddNewTimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SelectTermActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       int x =  SelectSubjects.getSelectedIndex();
        System.out.println("0,0 : index  "+ x );
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(AddNewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddNewTimeTable().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddNewTimeTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JComboBox<String> SelectClass;
    private javax.swing.JComboBox<String> SelectTerm;
    private com.toedter.calendar.JYearChooser SelectYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable newTimetable;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
    JComboBox<String> SelectSubjects = new JComboBox<>(new String [] {""});
    
    public void setSubjects() throws SQLException{
        SelectSubjects.removeAllItems();
        int idOfClass = SelectClass.getSelectedIndex()-1;
        
        if(idOfClass > -1){
            getSubjectAndTeacherID(ClassDetails.get(idOfClass).getId(),SelectTerm.getSelectedIndex(), SelectYear.getYear());
            int subjectSize = subjectTeacherDetails.size();

            //  setSubjectsNames(ClassDetails.get(idOfClass).getId());
            //  int subjectSize = SubjectDetails.size();
            
            if(subjectSize > 0){
                for(int i=0; i<subjectSize; i++ ){
//                    SelectSubjects.addItem(SubjectDetails.get(i).getName()+" - S" +SubjectDetails.get(i).getId().toLowerCase().substring(1, 9));
                        SelectSubjects.addItem(subjectTeacherDetails.get(i).getsName()+" - " +subjectTeacherDetails.get(i).gettName());
                }
                
                SelectSubjects.setMaximumRowCount(5);
                for(int i = 0; i < 5; i++ ){
                   newTimetable.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(SelectSubjects));
                }
                
                
            }
        }
    }
    
    
    
    private void callYesNo() throws SQLException{
        int result = JOptionPane.showConfirmDialog(this,"Students Marks Added Successfully\nDo You Want to add Another Marks?","Students Marks",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
                
        if(result == JOptionPane.NO_OPTION){
            sentDetails();
            this.dispose();
        }else{
            
           sentDetails();
           this.dispose();
           new AddNewTimeTable().setVisible(true);
        }
    }
    
    public void sentDetails() throws SQLException{
        String subID,day,subName,clsID;
        int year,term,period = 0;
        clsID = ConnectDatabase.ClassDetails.get(SelectClass.getSelectedIndex()-1).getId();
        String weekDays[] = {"Monday", "Tuesday","Wednesday","Thursday","Friday"};
        year = SelectYear.getYear();
        term = SelectTerm.getSelectedIndex();
        
        System.out.println("Row : "+rowValue + " column : "+colValue);
        
        for(int i = 0; i< rowValue; i++){
            for(int j = 0; j< colValue; j++){
                subName = newTimetable.getModel().getValueAt(i , j).toString();
                period = i+1;
                day = weekDays[j];
                subID = setSubjectID(subName);
                
// addTimeTable(String SubjectID, int Year, int Term, String Day, int Period)
                database.addTimeTable(subID, year, term, day, period,clsID);
            }
        }
        
        
    }
       
       String setSubjectID(String s){
           for(int i=0; i < SelectSubjects.getItemCount(); i++ ){
               if(SelectSubjects.getItemAt(i).equals(s))
                   return subjectTeacherDetails.get(i).getsID();
           }
           return "Null";
           
       }
    
}
