

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FindIP{

    private CTFSelectScreen ctf;
    private JFrame frame;
    private JTextField answer;
    private Event event = new Event();
    private JLabel incorrect;

    public FindIP(CTFSelectScreen CTF) {
        event.setPoints(20);
        event.setSuccess(false);
        this.ctf = CTF;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent() {
        this.event = event;
    }

    public void main() {
        this.frame = new JFrame("CTF - Capture the Flag");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(300, 300);
        this.frame.setLayout(null);

        JLabel title = new JLabel("Find the IP");
        title.setBounds(100, 50, 100, 40);
        this.frame.add(title);

        this.incorrect = new JLabel("");
        this.incorrect.setBounds(100, 10, 100, 40);
        this.frame.add(this.incorrect);



        answer = new JTextField("");
        answer.setBounds(100, 100, 100, 40);
        this.frame.add(answer);



        JButton submit = new JButton("Submit");
        submit.setBounds(100, 150, 100, 40);
        submit.setActionCommand("1");
        submit.addActionListener(new ButtonListener());
        this.frame.add(submit);


        this.frame.setVisible(true);
    }




    public boolean checkIP (String ip) throws IOException {
        String correctIP = getIP();
        correctIP = correctIP.replaceAll("/","");

        if (ip.equals(correctIP)) {
            System.out.println("I am here");
            return true;
        } else {
            System.out.println("oh dear");
            return false;
        }
    }

    private String getIP() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        System.out.println(socket.getLocalAddress());
        return socket.getLocalAddress().toString();
    }

    private void runCheck() throws IOException, InterruptedException {
        boolean success = checkIP(answer.getText());
        if (success) {
            event.setSuccess(true);
            updatePoints();
            this.incorrect.setText("Correct!");

            this.frame.setVisible(false);
            //JOptionPane.showMessageDialog(null, "Correct!");
        } else {
            this.incorrect.setText("Incorrect!");
            //JOptionPane.showMessageDialog(null, "Incorrect!");
        }
    }

    private void updatePoints() {
        ctf.setPoints(ctf.getPoints() + event.getPoints());
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println("oh dear1");
            System.out.println(command);
            boolean success = false;
            if (command.equals("1")) {
                try {
                    runCheck();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }


}
