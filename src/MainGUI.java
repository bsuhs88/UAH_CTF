import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainGUI {
    private JFrame frame;
    private User user;
    private JTextField Username;

    public void main(String[] args) {
        this.frame = new JFrame("CTF - Capture the Flag");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 300);
        this.frame.setLayout(null);


        Username = new JTextField("Username");
        Username.setBounds(100, 50, 100, 40);
        this.frame.add(Username);

        JButton Login = new JButton("Login");
        Login.setBounds(100, 100, 100, 40);
        Login.setActionCommand("Login");
        Login.addActionListener(new ButtonListener());
        this.frame.add(Login);

        JButton Register = new JButton("Register");
        Register.setBounds(100, 150, 100, 40);
        Register.setActionCommand("Register");
        Register.addActionListener(new ButtonListener());
        this.frame.add(Register);


        this.frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Login")) {
                user = new User(Username.getText(), "password");
                CTFSelectScreen ctf = new CTFSelectScreen();
                ctf.main(new String[0]);
                frame.setVisible(false);
            } else if (command.equals("Register")) {
                // do something
            }
        }
    }
}
