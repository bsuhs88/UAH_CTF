import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.util.Scanner;

public class fileExists {


    private CTFSelectScreen ctf;
    private JFrame frame;
    private JTextField answer;
    private Event event = new Event();
    private JLabel incorrect;

    public fileExists(CTFSelectScreen CTF) {
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

        JLabel title = new JLabel("<html><p style='text-align:center'>Create a file named 'flag.txt' in the root directory of the computer and put the IP in it.</p></html>");
        title.setBounds(50, 50, 200, 120);
        this.frame.add(title);

        this.incorrect = new JLabel("");
        this.incorrect.setBounds(50, 10, 200, 120);
        this.frame.add(this.incorrect);



        /*answer = new JTextField("");
        answer.setBounds(100, 100, 100, 40);
        this.frame.add(answer);*/



        JButton submit = new JButton("Check");
        submit.setBounds(100, 150, 100, 40);
        submit.setActionCommand("1");
        submit.addActionListener(new fileExists.ButtonListener());
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
    private boolean setCurrentDir() {
        boolean result = false;
        File directory = new File(System.getProperty("user.home"));
        if(directory.exists()) {
            System.out.println("fix dir");
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }
        return result;
    }
    private boolean checkFile() throws IOException, InterruptedException {
        String fileName = System.getProperty("user.home") + "/flag.txt";
        setCurrentDir();
        Path p = Paths.get(fileName);
        File f = new File(fileName).getAbsoluteFile();
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println("HERE!!!!");
        if(f.exists() && !f.isDirectory()) {
           System.out.println("HERE123");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (checkIP(line)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    private void runCheck() throws IOException, InterruptedException {
        boolean success = checkFile();
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
