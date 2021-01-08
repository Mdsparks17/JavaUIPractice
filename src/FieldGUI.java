import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FieldGUI implements ActionListener {

    private String info;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextArea textarea;


    public FieldGUI() {

        frame = new JFrame();

        JButton button = new JButton("Submit");
        button.addActionListener(this);

        textarea = new JTextArea("enter text here");

        label = new JLabel("Number of clicks: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout((new GridLayout(0, 1)));
        panel.add(textarea);
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new FieldGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        info = textarea.getText();
        System.out.println(info);
        label.setText(info);

        //output to data.txt
        String filename = "data.txt";
        try {
            PrintWriter outputStream = new PrintWriter(filename);
            outputStream.println(info);
            outputStream.close();
        } catch (FileNotFoundException f) {
            System.out.println("File Not Found");
        }
    }
}
