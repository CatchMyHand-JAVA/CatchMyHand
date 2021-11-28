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

    public static void order(Player player1, Player player2) {          // 선공,후공 정하는 함수
        int first = (int)(Math.random()*2);                             // 0과 1중 하나를 난수로 생성
        if(first == 1){                                                 // 0이 나오면 플레이어1이 선공(변화 없음), 1이 나오면 플레이어2가 선공
            String temp = player1.getName();                            // 기본적으로 플레이어1이 무조건 먼저 시작하므로 서로의 이름을 바꿈
            player1.setName(player2.getName());
            player2.setName(temp);
        }
    }

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
        
        //로그인(스윙으로 id,pwd 입력받아야함), 플레이어 객체 생성(플레이어 생성자의 매개변수 필요)
        SignUp signup = new SignUp();
        signup = new SignUp();
        
        String id = " ", pwd = " ";         //임시 변수
        
        signup.Login(id,pwd);           //플레이어1 로그인
        Player player1 = new Player();          //플레이어1 객체 생성
        
        signup.Login(id,pwd);           //플레이어2 로그인
        Player player2 = new Player();          //플레이어2 객체 생성
        
        
        
        //보드의 인덱스, 통행료 정보를 받아오는 코드
        BoardContainer[] bc = new BoardContainer[20];						//BoardContainer를 객체 배열로 생성
        File file = new File("BoardInfo.txt");						//보드의 위치와 통행료가 저장된 파일 객체
        try {
            Scanner scanner = new Scanner(file);							//파일 내의 정보를 읽어 오기 위한 Scanner 객체
            int i = 0;														//객체 배열의 인덱스
            int idx = 0, price = 0;                                         //저장된 정보를 읽어오기 위한 정수형 변수 2개
            String own = " ";                                               //지역의 소유자 읽어오기 위한 변수
            while (scanner.hasNextInt()) {									//더이상 읽을 수 있는 정수가 없을 때까지 반복
                idx = scanner.nextInt();								//인덱스 값 읽어오기
                price = scanner.nextInt();								//통행료 값 읽어오기
                own = scanner.next();
                System.out.printf("%d, %d, %s\n", idx, price, own);
                bc[i] = new BoardContainer(idx, price,0 ,own);	//BoardContainer 객체 배열 생성자
                i++;																			//객체 배열의 인덱스 값 증가
            }
            scanner.close();
        } catch (Exception e) {												//입력된 값이 없을 시 예외 처리
            e.printStackTrace();
        }
        
        
        //기본 구동
        order(player1, player2);                                //선공 후공

        int pos = 0;                                            //다른 클래스 메소드 반복 호출을 줄이기 위한 변수
        String name = " ";                                      //다른 클래스 메소드 반복 호출을 줄이기 위한 변수

        while(true){                                                //게임 시작
            //선공(플레이어1)
            player1.setTurn(player1.getTurn()+1);                                     //플레이어1의 턴을 1로 설정
            name = player1.getName();                               //이름 변수에 플레이어1의 이름 저장
            while(player1.getTurn() != 0){
                player1.rollDice();
                pos = player1.getPos();                                 //위치 변수에 플레이어1의 현재 위치 저장
                if(bc[pos].getOwnPlayer().equals("None")){              //도착한 지역의 소유자가 없을 때
                    //구매 팝업창 필요
                    int buy = 0;
                    if(buy == 1){
                        bc[pos].buyBoard(player1);
                        //지역 색 변화(GUI)
                        //부스 설치(GUI)
                    }
                }
                else if(bc[pos].getOwnPlayer().equals(name)){           //도착한 지역의 소유자가 자신(플레이어1)일 때
                    //부스 업그레이드 팝업창 필요
                    int buy = 0;
                    if(buy == 1) {
                        bc[pos].updateBooth(player1);
                        //부스 업그레이드(GUI)
                    }
                }
                else if(bc[pos].getOwnPlayer().equals(player2.getName())){                                                   //도착한 지역의 소유자가 상대(플레이어2)일 때
                    bc[pos].calPassingFee(player1, player2);
                    //통행료 지불 팝업창 필요
                }
                else{           //특수칸 도착시
                    if(pos == 0){           //출발점

                    }
                    else if(pos == 6){          //랩실
                        player1.setTurn(0);
                    }
                    else if(pos == 12){         //주류 판매

                    }
                    else if(pos == 18){         //전동킥보드

                    }
                }
                player1.setTurn(player1.getTurn()-1);                   //플레이어1의 턴을 1 감소
            }
            //후공(플레이어2)
            player2.setTurn(player1.getTurn()+1);
            pos = player2.getPos();
            name = player2.getName();
            while(player2.getTurn() != 0){
                player2.rollDice();
                if(bc[pos].getOwnPlayer().equals("None")){
                    //구매 팝업창 필요
                    int buy = 0;
                    if(buy == 1){
                        bc[pos].buyBoard(player2);
                        //지역 색 변화(GUI)
                        //부스 설치(GUI)
                    }
                }
                else if(bc[pos].getOwnPlayer().equals(name)){
                    //부스 업그레이드 팝업창 필요
                    int buy = 0;
                    if(buy == 1) {
                        bc[pos].updateBooth(player2);
                        //부스 업그레이드(GUI)
                    }
                }
                else if(bc[pos].getOwnPlayer().equals(player1.getName())){
                    bc[pos].calPassingFee(player1, player2);
                    //통행료 지불 팝업창 필요
                }
                //특수칸 도착 시
                else{
                    if(pos == 0){           //출발점

                    }
                    else if(pos == 6){          //랩실
                        player2.setTurn(0);
                    }
                    else if(pos == 12){         //주류 판매

                    }
                    else if(pos == 18){         //전동킥보드

                    }
                }
                player2.setTurn(player2.getTurn()-1);
            }

        }



    }
}