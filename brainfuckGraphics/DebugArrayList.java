package brainfuckGraphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class DebugArrayList {

    public static String[] columnTitles = {"Index#", "Value"};
    public static ArrayList<Byte> values = new ArrayList();
    static DefaultTableModel model = new DefaultTableModel();
    static JTable table = new JTable(model);
    static int AmtOfTimesBtnPressed = 0;

    public static void AddValuesToArrayList() {
        values.add((byte) 10);
        values.add((byte) 20);
        values.add((byte) 30);
    }

    public static void main(String args[]) {
        AddValuesToArrayList();
        CreateGui();
        System.out.println(columnTitles);
        System.out.println(values);
    }

    public static void CreateGui() {

        //CREATING THE GUI OBJECTS
        JFrame jf = new JFrame();
        JScrollPane jsp = new JScrollPane(table);
        JButton addColumnButton = new JButton();

        model.addColumn("Index#");
        model.addColumn("Value");

        jsp.setBounds(2, 264, 200, 100);
        jsp.createVerticalScrollBar();
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jf.setLayout(null);

        table.setVisible(true);
        table.setBounds(0, 0, 200, 100);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(false);

        //WHENEVER THE BUTTON IS PRESSED, PERFORM THE ACTION INSIDE THE actionPerformed scope ------------
        addColumnButton.setBounds(240, 260, 40, 20);
        addColumnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddColumnToTable();
            }
        });

        //THE GUIS SETTINGS ----------------
        jf.setSize(400, 400);
        jf.setVisible(true);
        jf.add(jsp);
        jf.add(addColumnButton);

    }

    public static void AddColumnToTable() {
        values.add((byte) 5);
        model.addRow(new Object[]{AmtOfTimesBtnPressed, values.size()});
        AmtOfTimesBtnPressed++;
        table.revalidate();
    }

}
