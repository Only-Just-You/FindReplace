package org.example.swing;

import org.example.awt.MatchTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindReplace extends JFrame implements ActionListener {
    private final JTextArea taObj;
    private final JTextField tfObj1;
    private final JTextField tfObj2;

    public FindReplace() {
        super("文本替换与查找");

        taObj = new JTextArea();

        tfObj1 = new JTextField();
        tfObj2 = new JTextField();

        JButton buttonObj1 = new JButton("Find");
        JButton buttonObj2 = new JButton("Replace");
        JButton buttonObj3 = new JButton("Exit");

        JLabel labObj1 = new JLabel("文本区域");
        JLabel labObj2 = new JLabel("待查找或替换前的字符串");
        JLabel labObj3 = new JLabel("替换后的字符串");

        JPanel pObj1 = new JPanel();
        JPanel pObj2 = new JPanel();
        JPanel pObj3 = new JPanel();
        JPanel pObj4 = new JPanel();
        JPanel pObj5 = new JPanel();

        pObj1.setLayout(new BorderLayout());
        pObj1.add("North", labObj1);
        pObj1.add("Center", taObj);

        pObj2.setLayout(new BorderLayout());
        pObj2.add("North", labObj2);
        pObj2.add("Center", tfObj1);

        pObj3.setLayout(new BorderLayout());
        pObj3.add("North", labObj3);
        pObj3.add("Center", tfObj2);

        pObj4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pObj4.add(buttonObj1);
        pObj4.add(buttonObj2);
        pObj4.add(buttonObj3);

        pObj5.setLayout(new GridLayout(3, 1));
        pObj5.add(pObj2);
        pObj5.add(pObj3);
        pObj5.add(pObj4);

        setLayout(new GridLayout(1, 2));
        Container container = getContentPane();
        container.setVisible(true);
        container.add(pObj1);
        container.add(pObj5);

        buttonObj1.addActionListener(this);
        buttonObj2.addActionListener(this);
        buttonObj3.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(450,450);
        setSize(560, 260);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FindReplace();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton butObj = (JButton) e.getSource();

        if (butObj.getText().equals("Exit")) System.exit(0);

        if (butObj.getText().equals("Find") || butObj.getText().equals("Replace")) {
            String strObj1 = taObj.getText();
            String strObj2 = tfObj1.getText();
            int matchNum;
            int cursorPos = taObj.getCaretPosition();
            MatchTool classObj = new MatchTool();
            if (butObj.getText().equals("Find")) {
                matchNum = classObj.strFind(strObj1, strObj2, cursorPos);
                JOptionPane.showMessageDialog(null, "共找到" + matchNum + "处",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }
            if (butObj.getText().equals("Replace")) {
                String strObj3 = tfObj2.getText();
                matchNum = classObj.strReplace(strObj1, strObj2, strObj3, cursorPos);
                StringBuffer taText = classObj.repStr;
                taObj.setText(taText.toString());
                JOptionPane.showMessageDialog(null, "共替换到" + matchNum +
                        "处", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}