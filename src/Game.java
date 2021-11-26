import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

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
    public void victory(Player player, BoardContainer board[]) {                //임시 승리 조건. 반복문을 사용하지 않고 이 방법 보다 효율적인 방법을 찾아봐야함(라인 독점).
        if(player.getCoin() <= 0){                                              //파산 조건
            return;
        }
        //라인 독점 조건
        else{
            if (board[0].getOwnPlayer().equals(player.getName()))
                if (board[1].getOwnPlayer().equals(player.getName()))
                    if (board[2].getOwnPlayer().equals(player.getName()))
                        if (board[3].getOwnPlayer().equals(player.getName()))
                            if (board[4].getOwnPlayer().equals(player.getName()))
                                return;
            if (board[5].getOwnPlayer().equals(player.getName()))
                if (board[6].getOwnPlayer().equals(player.getName()))
                    if (board[7].getOwnPlayer().equals(player.getName()))
                        if (board[8].getOwnPlayer().equals(player.getName()))
                            if (board[9].getOwnPlayer().equals(player.getName()))
                                return;
            if (board[10].getOwnPlayer().equals(player.getName()))
                if (board[11].getOwnPlayer().equals(player.getName()))
                    if (board[12].getOwnPlayer().equals(player.getName()))
                        if (board[13].getOwnPlayer().equals(player.getName()))
                            if (board[14].getOwnPlayer().equals(player.getName()))
                                return;
            if (board[15].getOwnPlayer().equals(player.getName()))
                if (board[16].getOwnPlayer().equals(player.getName()))
                    if (board[17].getOwnPlayer().equals(player.getName()))
                        if (board[18].getOwnPlayer().equals(player.getName()))
                            if (board[19].getOwnPlayer().equals(player.getName()))
                                return;
        }
    }
//    public void callAbility() {}

    public static void main(String[] args) {
        new StartPage();
        
        
        //보드의 인덱스, 통행료 정보를 받아오는 코드
        BoardContainer[] bc = new BoardContainer[20];															//BoarContainer를 객체 배열로 생성
        File file = new File("BoardInfo.txt");															        //보드의 위치와 통행료가 저장된 파일 객체
        try {
            Scanner scanner = new Scanner(file);																//파일 내의 정보를 읽어 오기 위한 Scanner 객체
            int i = 0;																							//객체 배열의 인덱스
            int[] readInt = {0,0};																				//저장된 정보를 2개씩 읽어 오기 위한 정수 배열
            while (scanner.hasNextInt()) {																		//더이상 읽을 수 있는 정수가 없을 때까지 반복
                readInt[0] = scanner.nextInt();																//인덱스 값 읽어오기
                readInt[1] = scanner.nextInt();																//통행료 값 읽어오기
                System.out.printf("%d, %d\n", readInt[0], readInt[1]);
                bc[i] = new BoardContainer(readInt[0], readInt[1],0 ,"None");					                //BoardContainer 객체 배열 생성자
                i++;																							//객체 배열의 인덱스 값 증가
            }
            scanner.close();
        } catch (Exception e) {																				//입력된 값이 없을 시 예외 처리
            e.printStackTrace();
        }



    }
}