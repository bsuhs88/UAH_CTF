import Modules.Events.FindIP;
import Modules.Events.Event;

import javax.swing.*;
import java.awt.event.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;

public class CTFSelectScreen {
    private JFrame frame;

    private int points;

    public void CTFSelectScreen() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void main(String[] args) {

        Set<String> Classes = getClasses("src/Modules/Event");
        System.out.printf(Classes.toString());

        //x = Class.forName("Modules.Event.FindIP");

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

    private Set<String> getClasses(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    private Set<String> getCleanClasses(Set<String> classes) {
        return classes.stream()
                .map(s -> s.substring(0, s.length() - 6))
                .collect(Collectors.toSet());
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            int pounts = 0;
            if (command.equals("1")) {
                FindIP findIP = new FindIP();
                findIP.main();
                Event event = findIP.getEvent();
                boolean success = event.getSuccess();
                while(!success) {
                    success = event.getSuccess();
                    // do something
                }
            } else if (command.equals("2")) {
                // do something
            } else if (command.equals("3")) {

            }
        }
    }
}
