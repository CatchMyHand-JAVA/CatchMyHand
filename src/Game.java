import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StartPage extends JFrame {
    public StartPage() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JButton btn = new JButton();
        btn.setSize(350, 100);
        btn.setLocation(545, 689);
        c.add(btn);

        ImageIcon img = new ImageIcon("images/start.jpg");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440, 1024);
        imageLabel.setLocation(0, 0);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        c.add(imageLabel);

        setSize(1440, 1024);
        setVisible(true);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LogIn();
                setVisible(false); // 창 안보이게 하기
            }
        });
    }
}

class GamePage extends JFrame {
    public GamePage() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        ImageIcon img = new ImageIcon("images/gamestart.jpg");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440, 1024);
        imageLabel.setLocation(0, 0);
        c.add(imageLabel);

        setSize(1440, 1024);
        setVisible(true);
    }
}

public class Game {
    public Game() {}

//    public void order(String str) {}
//    public void victory(Player player, BoardContainer board) {}
//    public void callAbility() {}

    public static void main(String[] args) {
        new StartPage();
    }
}