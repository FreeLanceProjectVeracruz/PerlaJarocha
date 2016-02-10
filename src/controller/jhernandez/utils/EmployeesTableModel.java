package controller.jhernandez.utils;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN 8
 */
public class EmployeesTableModel extends AbstractTableModel {

    private static final String[] data = {"This is the 1st String", "String 2", "Another String",
        "The Final String"};
    private static final String[] columns = {"Name", "Length", "Upper-case"};

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String theData = data[rowIndex];
        Object result = null;
        switch (columnIndex) {
            case 1:
                result = theData.length(); // auto-boxing.
                break;
            case 2:
                result = theData.toUpperCase();
                break;
            default:
                result = theData;
        }

        return result;
    }
}
