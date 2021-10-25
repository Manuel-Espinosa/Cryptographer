import javax.swing.*;
import java.awt.event.*;

public class Cryptographer {
    String number;
    JFrame frame;
    JPanel panel;
    JButton cryptButton;
    JButton uncryptButton;
    JLabel cryptLabel;
    JLabel encryptedNumber;
    JLabel unencryptedNumber;
    JLabel uncryptLabel;
    JLabel cryptedResultLabel;
    JLabel uncryptedResultLabel;
    JTextField tocrypt;
    JTextField toUncrypt;

    public static void main(String[] args) {
        Cryptographer cryptographer = new Cryptographer();
        cryptographer.createWindow();
    }

    public void createWindow() {
        frame = new JFrame("Cryptographer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        this.cryptLabel = new JLabel("Ingrese numero para encriptar");
        cryptLabel.setBounds(5, 10, 200, 20);

        this.tocrypt = new JTextField();
        tocrypt.setBounds(5, 35, 100, 20);

        this.cryptedResultLabel = new JLabel("Numero encriptado: ");
        cryptedResultLabel.setBounds(5, 55, 200, 20);

        this.encryptedNumber = new JLabel("0000");
        encryptedNumber.setBounds(150, 55, 200, 20);

        this.cryptButton = new JButton("Encriptar");
        cryptButton.setBounds(5, 80, 100, 20);

        this.uncryptLabel = new JLabel("Ingrese numero para desencriptar");
        uncryptLabel.setBounds(300, 10, 200, 20);

        this.toUncrypt = new JTextField();
        toUncrypt.setBounds(300, 35, 100, 20);

        this.uncryptedResultLabel = new JLabel("Numero desencriptado: ");
        uncryptedResultLabel.setBounds(300, 55, 200, 20);

        this.unencryptedNumber = new JLabel("0000");
        unencryptedNumber.setBounds(450, 55, 200, 20);

        this.uncryptButton = new JButton("Desencriptar");
        uncryptButton.setBounds(300, 80, 100, 20);

        frame.add(panel);
        panel.add(cryptLabel);
        panel.add(tocrypt);
        panel.add(cryptedResultLabel);
        panel.add(encryptedNumber);
        panel.add(cryptButton);
        panel.add(uncryptLabel);
        panel.add(toUncrypt);
        panel.add(uncryptedResultLabel);
        panel.add(unencryptedNumber);
        panel.add(uncryptButton);
        frame.setSize(550, 150);
        panel.setLayout(null);
        frame.setVisible(true);

        ListenForButton buttonListener = new ListenForButton();
        cryptButton.addActionListener(buttonListener);
        uncryptButton.addActionListener(buttonListener);

    }

    public void toCrypt(String message){
        char [] digits = message.toCharArray();
        String code = "";
        for (char digit : digits) {
            int number = (Integer.parseInt(String.valueOf(digit))+7)%10;
            String result = String.valueOf(number); 
            code += result;
        }
        encryptedNumber.setText(""+code.charAt(2)+code.charAt(3)+code.charAt(0)+code.charAt(1));

    }

    public void uncrypt(String message){
        char [] digits = message.toCharArray();
        String code = "";
        for (char digit : digits) {
            int number = Integer.parseInt(String.valueOf(digit))+3;
            String result = String.valueOf(number); 
            code += result.charAt(result.length()-1);
        }
        unencryptedNumber.setText(""+code.charAt(2)+code.charAt(3)+code.charAt(0)+code.charAt(1));

    }

    private class ListenForButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cryptButton){
                number = tocrypt.getText();
                toCrypt(number);

            }else if(e.getSource() == uncryptButton){
                number = toUncrypt.getText();
                uncrypt(number);

            }

        }
    }

}




