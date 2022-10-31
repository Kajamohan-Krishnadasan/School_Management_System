/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Kajamohan
 */
public class HeaderSetting {
    Color BgColor;
    Color FontColor;
    Font setFont;
    Font fontType;
    Font fontSize;
    JTableHeader tHead;
    DefaultTableCellRenderer renderer;

    public void HeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer)
        table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    public void theader(JTableHeader table){
        tHead = table;
        tHead.setForeground(Color.MAGENTA);
        tHead.setBackground(Color.DARK_GRAY);
        tHead.setFont(new Font("Times New Roman",Font.BOLD,24));
        
    }

}
