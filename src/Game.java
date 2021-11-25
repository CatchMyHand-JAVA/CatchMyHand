import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        ImageIcon img = new ImageIcon("images/gamestart.jpg");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440,1024);
        imageLabel.setLocation(0,0);
        c.add(imageLabel);

        setSize(1440,1024);
        setVisible(true);

    public void order(String str) {}
    public void victory(Player player, BoardContainer board) {}
    public void callAbility() {}
}