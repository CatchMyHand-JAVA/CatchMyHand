import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    public LogIn() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        //회원가입 버튼
        JButton btn = new JButton();
        btn.setSize(275,75);
        btn.setLocation(848,724);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        c.add(btn);

        //로그인 버튼
        JButton btn1 = new JButton();
        btn1.setSize(275,75);
        btn1.setLocation(328,724);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        c.add(btn1);

        //배경 이미지
        ImageIcon img = new ImageIcon("images/login.jpg");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440,1024);
        imageLabel.setLocation(0,0);
        c.add(imageLabel);

        setSize(1440,1024);
        setVisible(true);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUp();
                setVisible(false);
            }
        });

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GamePage();
                setVisible(false);
            }
        });
    }
}




