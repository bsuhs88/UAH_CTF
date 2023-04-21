package Modules.Events;

import Modules.RunModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FindIP{

    private JFrame frame;
    private JTextField answer;
    private Event event = new Event();

    public FindIP() {
        event.setPoints(20);
        event.setSuccess(false);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent() {
        this.event = event;
    }

    public void main() {
        this.frame = new JFrame("CTF - Capture the Flag");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 300);
        this.frame.setLayout(null);

        JLabel title = new JLabel("Find the IP");
        title.setBounds(100, 50, 100, 40);
        this.frame.add(title);



        answer = new JTextField("");
        answer.setBounds(100, 100, 100, 40);
        this.frame.add(answer);



        JButton submit = new JButton("Submit");
        submit.setBounds(100, 150, 100, 40);
        submit.setActionCommand("Submit");
        this.frame.add(submit);


        this.frame.setVisible(true);
    }




    public boolean checkIP (String ip) throws IOException {
        String correctIP = getIP();
        correctIP = correctIP.replaceAll("/","");

        if (ip.equals(correctIP)) {
            return true;
        } else {
            return false;
        }
    }

    private String getIP() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        System.out.println(socket.getLocalAddress());
        return socket.getLocalAddress().toString();
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
