import Modules.Event.FindIP;
import Modules.RunModule;

import javax.swing.*;
import java.awt.event.*;

public class CTFSelectScreen {
    private JFrame frame;

    public void main(String[] args) {
        this.frame = new JFrame("CTF - Capture the Flag");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 500);
        this.frame.setLayout(null);

        JButton task1 = new JButton("Task 1");
        task1.setBounds(100, 100, 100, 40);
        task1.setActionCommand("1");
        this.frame.add(task1);

        JButton task2 = new JButton("Task 2");
        task2.setBounds(100, 150, 100, 40);
        task2.setActionCommand("2");
        this.frame.add(task2);

        JButton task3 = new JButton("Task 3");
        task3.setBounds(100, 200, 100, 40);
        task3.setActionCommand("3");
        this.frame.add(task3);

        this.frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            boolean success = false;
            if (command.equals("1")) {
                success = RunModule.runModule();
                if (success) {
                    // do something
                }
            } else if (command.equals("2")) {
                // do something
            } else if (command.equals("3")) {

            }
        }
    }
}
