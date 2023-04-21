import javax.swing.*;
import java.awt.event.*;

public class CTFSelectScreen {
    private JFrame frame;

    private int points;

    private JLabel pointsLabel;

    private boolean event1success = false;
    private boolean event2success = false;
    private boolean event3success = false;

    public void setEvent1success(boolean event1success) {
        this.event1success = event1success;
    }


    public void CTFSelectScreen() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        pointsLabel.setText("Points: " + this.points);
    }

    public void main() {


        this.frame = new JFrame("CTF - Capture the Flag");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 500);
        this.frame.setLayout(null);

        pointsLabel = new JLabel("Points: " + this.points);
        pointsLabel.setBounds(200, 10, 100, 40);
        this.frame.add(pointsLabel);

        JButton task1 = new JButton("Task 1");
        task1.setBounds(100, 100, 100, 40);
        task1.setActionCommand("1");
        task1.addActionListener(new ButtonListener());
        this.frame.add(task1);

        JButton task2 = new JButton("Task 2");
        task2.setBounds(100, 150, 100, 40);
        task2.setActionCommand("2");
        task2.addActionListener(new ButtonListener());
        this.frame.add(task2);

        JButton task3 = new JButton("Task 3");
        task3.setBounds(100, 200, 100, 40);
        task3.setActionCommand("3");
        task3.addActionListener(new ButtonListener());
        this.frame.add(task3);

        this.frame.setVisible(true);
    }

    private void callFindIP() {
        FindIP findIP = new FindIP(this);
        findIP.main();
    }

    private void callFileExists() {
        fileExists fe = new fileExists(this);
        fe.main();
    }

    private void callFilePermissions() {
        FilePermissions fp = new FilePermissions(this);
        fp.main();
    }



    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            int pounts = 0;
            if (command.equals("1")) {
                callFindIP();
            } else if (command.equals("2")) {
                callFileExists();
            } else if (command.equals("3")) {
                callFilePermissions();
            }
        }
    }
}
