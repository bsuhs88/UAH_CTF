package Modules;

import Modules.Event.FindIP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModuleGUI {

    private JFrame frame;
    private JTextField answer;
    public void main(Event<T> event) {
        this.frame = new JFrame("CTF - Capture the Flag");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 300);
        this.frame.setLayout(null);

        JLabel title = new JLabel(moduleTitle);
        title.setBounds(100, 50, 100, 40);
        this.frame.add(title);


        if (textField) {
            answer = new JTextField("");
            answer.setBounds(100, 100, 100, 40);
            this.frame.add(answer);
        }

        if(button) {
            JButton submit = new JButton("Submit");
            submit.setBounds(100, 150, 100, 40);
            submit.setActionCommand("Submit");
            this.frame.add(submit);
        }

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
