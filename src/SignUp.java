import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
    private String id;
    private String pwd;
    private String nickname;

    public SignUp() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JButton btn = new JButton();
        btn.setSize(275,75);
        btn.setLocation(584,724);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        c.add(btn);

        ImageIcon img = new ImageIcon("images/signup.jpg");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440,1024);
        imageLabel.setLocation(0,0);
        c.add(imageLabel);

        setSize(1440,1024);
        setVisible(true);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game();
                setVisible(false); // 창 안보이게 하기
            }
        });
    }

    public void Login(String str) {}
}




