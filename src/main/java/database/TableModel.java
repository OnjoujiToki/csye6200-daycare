package database;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class TableModel extends DefaultTableModel {
    static Vector<String> columnsNames = new Vector<>();
    static {
        /*
        columnsNames.addElement("ID");
        columnsNames.addElement("Name");
        columnsNames.addElement("Age");
        columnsNames.addElement("Parent");
        columnsNames.addElement("Address");
        columnsNames.addElement("Hib Status");
        columnsNames.addElement("DTaP Status");
        columnsNames.addElement("Polio Status");
        columnsNames.addElement("Hepatitis B Status");
        columnsNames.addElement("MMR Status");
        columnsNames.addElement("Varicella Status");*/
        columnsNames.addElement("ID");
        columnsNames.addElement("Name");
        columnsNames.addElement("Parent");
        columnsNames.addElement("E-mail(Parent)");
        columnsNames.addElement("Mathematics");
        columnsNames.addElement("English");
        columnsNames.addElement("Chemistry");
        columnsNames.addElement("Physics");
        columnsNames.addElement("Java");
        columnsNames.addElement("Music");
    }
    private TableModel() {
        super(null, columnsNames);
    }

    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return false;
    }

    private static final TableModel tableModel = new TableModel();

    public static TableModel analyzeData(Vector<Vector<Object>> data) {
        tableModel.setDataVector(data, columnsNames);
        return tableModel;
    }
    public static Vector<String> getColumns() {
        return columnsNames;
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                //System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
