package database;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableProperty extends DefaultTableCellRenderer {

    public TableProperty()
    {
        //super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column)
    {
        /*
        Grade grade = (Grade) value;
        if(grade == Grade.A) {
            super.setBackground(Color.GREEN);
        }
        else if(grade == Grade.B) {
            super.setBackground(Color.BLUE);
        }
        else if(grade == Grade.C) {
            super.setBackground(Color.RED);
        }*/
        // check students here
        if (row % 2 == 0) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
