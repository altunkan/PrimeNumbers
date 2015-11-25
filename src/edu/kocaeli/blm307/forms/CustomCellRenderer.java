/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.kocaeli.blm307.forms;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AnilAltunkan
 */
public class CustomCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if ("true".equals(value))
            cellComponent.setBackground(Color.GREEN);
        else
            cellComponent.setBackground(Color.RED);
        return cellComponent;
    }
}
