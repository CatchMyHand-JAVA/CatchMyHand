import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test extends JFrame implements ActionListener{


    public test() {
        JFrame f = new JFrame();
        f.setBounds(300,300,1000,1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setLayout(null);
        f.setVisible(true);

        JPanel endPage = new JPanel();
        endPage.setBounds(0,0,784,565);
        f.getContentPane().add(endPage);
        endPage.setLayout(null);

        JButton btnBefore = new JButton("gogo");
        btnBefore.setBounds(200,200,100,100);
        endPage.add(btnBefore);

        JPanel startPage = new JPanel();
        startPage.setBounds(0,0,784,565);
        f.getContentPane().add(startPage);
        startPage.setLayout(null);

        JButton btnNext = new JButton("go next");
        btnNext.setBounds(50,50, 100, 100);
        startPage.add(btnNext);

        endPage.setVisible(false);

        btnNext.addActionListener(e -> {
            endPage.setVisible(true);
            startPage.setVisible(false);
        });

        btnBefore.addActionListener(e -> {
            endPage.setVisible(false);
            startPage.setVisible(true);
        });
    }



    public static void main(String[] args) {
        new test();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
