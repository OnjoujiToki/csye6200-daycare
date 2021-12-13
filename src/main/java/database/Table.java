package database;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Table extends JTable {
    public Table(){
        // Modify Later
        JTableHeader heading = getTableHeader();
        setHeading(heading);
        setFont(new Font(null, Font.PLAIN, 14));
        setForeground(Color.black);
        setGridColor(Color.BLACK);
        setRowHeight(30);
        getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    private void setHeading(JTableHeader heading) {
        heading.setFont(new Font(null, Font.ITALIC, 16));
        heading.setForeground(Color.RED);
    }


    public void render(String[] columnNames) {
        String[] columnName = columnNames;
        TableProperty property = new TableProperty();
        for (int i = 0; i < columnName.length; i++) {
            TableColumn cur = getColumn(columnName[i]);
            cur.setCellRenderer(property);
            if (i == 0 ) {
                cur.setPreferredWidth(50);
                cur.setMaxWidth(50);
                cur.setResizable(false);
            }
        }
    }

    public void render2(String[] columnNames) {
        String[] columnName = columnNames;
        TableProperty property = new TableProperty();
        System.out.println("Entered Render2");
        for (int i = 0; i < columnName.length; i++) {
            TableColumn cur = getColumn(columnName[i]);
            cur.setCellRenderer(property);
            for (int j = 0; j < 10; j++) {}

                // cur.setPreferredWidth(50);
                // cur.setMaxWidth(50);
                // cur.setResizable(false);

        }
    }
}

