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

        JButton btn = new JButton("클릭하세요");

        btn.setSize(350, 100);
        btn.setLocation(510, 550);
        c.add(btn);

        ImageIcon img = new ImageIcon("images/startPage.png");
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
    }
}

public class Game {
    public Game() {}

    public static void order(Player player1, Player player2) {          // 선공,후공 정하는 함수
        int first = (int)(Math.random()*2);                             // 0과 1중 하나를 난수로 생성
        if(first == 1){                                                 // 0이 나오면 플레이어1이 선공(변화 없음), 1이 나오면 플레이어2가 선공
            String temp = player1.getName();                            // 기본적으로 플레이어1이 무조건 먼저 시작하므로 서로의 이름을 바꿈
            player1.setName(player2.getName());
            player2.setName(temp);
        }
    }


    public static Boolean victory(Player player, BoardContainer board[]) {                //임시 승리 조건. 반복문을 사용하지 않고 이 방법 보다 효율적인 방법을 찾아봐야함(라인 독점).
        if(player.getCoin() <= 0){                                              //파산 조건
            if (player.getAbilityNumber() == 10) {
                player.setAbilityNumber(0);
                player.updateCoin(500000);
                return false;
            }

            return true;
        }
        //라인 독점 조건
        else{
            if (board[0].getOwnPlayer().equals(player.getName()))
                if (board[1].getOwnPlayer().equals(player.getName()))
                    if (board[2].getOwnPlayer().equals(player.getName()))
                        if (board[3].getOwnPlayer().equals(player.getName()))
                            if (board[4].getOwnPlayer().equals(player.getName()))
                                return false;
            if (board[5].getOwnPlayer().equals(player.getName()))
                if (board[6].getOwnPlayer().equals(player.getName()))
                    if (board[7].getOwnPlayer().equals(player.getName()))
                        if (board[8].getOwnPlayer().equals(player.getName()))
                            if (board[9].getOwnPlayer().equals(player.getName()))
                                return false;
            if (board[10].getOwnPlayer().equals(player.getName()))
                if (board[11].getOwnPlayer().equals(player.getName()))
                    if (board[12].getOwnPlayer().equals(player.getName()))
                        if (board[13].getOwnPlayer().equals(player.getName()))
                            if (board[14].getOwnPlayer().equals(player.getName()))
                                return false;
            if (board[15].getOwnPlayer().equals(player.getName()))
                if (board[16].getOwnPlayer().equals(player.getName()))
                    if (board[17].getOwnPlayer().equals(player.getName()))
                        if (board[18].getOwnPlayer().equals(player.getName()))
                            if (board[19].getOwnPlayer().equals(player.getName()))
                                return false;

            return false;
        }
    }

    public static void main(String[] args) {
        new StartPage();


    }
}

