package com.mycompany.frame.GUI;

import com.mycompany.frame.Model.EmploymentCategory;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class EmploymentCategoryRender extends JComboBox implements TableCellRenderer {
    public EmploymentCategoryRender(){

        addItem(EmploymentCategory.UNEMPLOYED.toString());
        addItem(EmploymentCategory.EMPLOYED.toString());
        addItem(EmploymentCategory.SELFEMPLOYED.toString());
        addItem(EmploymentCategory.OTHER.toString());

    }
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        this.setSelectedItem(o);
        return this;
    }

//    @Override
//    public String toString() {
//        return dataModel.toString();
//    }
}
