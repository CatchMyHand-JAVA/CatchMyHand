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
        setSize(1440, 1024);
        //jp.setPreferredSize(new Dimension(1440, 1024));
        JButton[] btn = new JButton[24];
        JButton diceBtn = new JButton();
        JPanel jp = new JPanel();
        jp.setLayout(null);

        diceBtn.setContentAreaFilled(false);
        diceBtn.setOpaque(false);
        diceBtn.setBorderPainted(false);
        diceBtn.setBounds(1061, 556, 169, 60);
        add(diceBtn);

        for(int i = 0; i<24; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setOpaque(false);
            btn[i].setBorderPainted(false);
            add(btn[i]);
        }
        btn[0].setBounds(730, 797, 74, 74);
        btn[1].setBounds(557, 797, 74, 74);
        btn[2].setBounds(480, 797, 74, 74);
        btn[3].setBounds(404, 797, 74, 74);
        btn[4].setBounds(327, 797, 74, 74);
        btn[5].setBounds(251, 797, 74, 74);
        btn[6].setBounds(77, 797, 74, 74);
        btn[7].setBounds(77, 624, 74, 74);
        btn[8].setBounds(77, 547, 74, 74);
        btn[9].setBounds(77, 471, 74, 74);
        btn[10].setBounds(77, 394, 74, 74);
        btn[11].setBounds(77, 318, 74, 74);
        btn[12].setBounds(77, 146, 74, 74);
        btn[13].setBounds(251, 147, 74, 74);
        btn[14].setBounds(327, 147, 74, 74);
        btn[15].setBounds(404, 147, 74, 74);
        btn[16].setBounds(480, 147, 74, 74);
        btn[17].setBounds(557, 147, 74, 74);
        btn[18].setBounds(731, 147, 74, 74);
        btn[19].setBounds(731, 318, 74, 74);
        btn[20].setBounds(731, 394, 74, 74);
        btn[21].setBounds(731,471 , 74, 74);
        btn[22].setBounds(731, 547, 74, 74);
        btn[23].setBounds(731, 624, 74, 74);
        add(jp);
        setVisible(true);


        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        ImageIcon img = new ImageIcon("images/gamestart.png");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440, 1024);
        imageLabel.setLocation(0, 0);
        add(imageLabel);
        add(jp);

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


    public static void victory(Player player, BoardContainer board[]) {                //임시 승리 조건. 반복문을 사용하지 않고 이 방법 보다 효율적인 방법을 찾아봐야함(라인 독점).
        if(player.getCoin() <= 0){                                              //파산 조건
            if (player.getAbilityNumber() == 10) {
                player.setAbilityNumber(0);
                player.updateCoin(500000);
            }

            else return;
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
// 회원가입 플레이어 이름 설정에서 2개의 닉네임 받기

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        new StartPage();

        // 지정 후 삭제 필요
        String name1 = " ", name2 = " ";    // 임시

        //signup.Login(id,pwd) ;           //플레이어1 로그인
        Player player1 = new Player(name1);          //플레이어1 객체 생성
        Player player2 = new Player(name2);          //플레이어2 객체 생성


        //보드의 인덱스, 통행료 정보를 받아오는 코드
        BoardContainer[] bc = new BoardContainer[24];                  //BoardContainer 를 객체 배열로 생성
        File file = new File("BoardInfo.txt");                  //보드의 위치와 통행료가 저장된 파일 객체
        try {
            Scanner scanner = new Scanner(file);                     //파일 내의 정보를 읽어 오기 위한 Scanner 객체
            int idx = 0, price = 0;                                         //저장된 정보를 읽어오기 위한 정수형 변수 2개
            String own = " ";                                               //지역의 소유자 읽어오기 위한 변수
            while (scanner.hasNextInt()) {                           //더이상 읽을 수 있는 정수가 없을 때까지 반복
                idx = scanner.nextInt();                        //인덱스 값 읽어오기
                price = scanner.nextInt();                        //통행료 값 읽어오기
                own = scanner.next();
                System.out.printf("%d, %d, %s\n", idx, price, own);
                bc[idx] = new BoardContainer(idx, price,0 ,own);   //BoardContainer 객체 배열 생성자
            }
            scanner.close();
        } catch (Exception e) {                                    //입력된 값이 없을 시 예외 처리
            e.printStackTrace();
        }


        //게임 start
        order(player1, player2);                                //선공 후공 설정

        int pos = 0;                                            //다른 클래스 메소드 반복 호출을 줄이기 위한 변수
        String name = " ";                                      //다른 클래스 메소드 반복 호출을 줄이기 위한 변수

        while(true){                                                //게임 시작
            //선공(플레이어1)
            player1.setTurn(player1.getTurn()+1);                   //플레이어1의 턴을 1로 설정
            while(player1.getTurn() != 0){
                int dice = 0;
                if (player1.getAbilityNumber() >= 1 && player1.getAbilityNumber() <= 5) {
                    if (player1.isCallAbility()) {
                        if (player1.getAbilityNumber() == 1) {
                            System.out.println("원하는 위치 받아야 함");
                            int want = scan.nextInt();
                            player1.teleport(want);
                        }

                        else if (player1.getAbilityNumber() == 2) {
                            player1.doubleDice();
                        }

                        else if (player1.getAbilityNumber() == 3) {
                            player1.goToLAB(player2);
                            dice = player1.rollDice();
                        }
                        else if (player1.getAbilityNumber() == 4) {
                            player1.setTurn(player2.getTurn()-1);
                            break;
                        }
                        else if (player1.getAbilityNumber() == 5) {
                            System.out.println("원하는 위치 받아야 함");
                            int want = scan.nextInt();
                            bc[want].setBooth(0);
                            dice = player1.rollDice();
                        }
                        player1.setAbilityNumber(0);
                    }
                }
                else if (player1.getAbilityNumber() != 10) {
                    dice = player1.rollDice();
                    if (player1.isCallAbility()){
                        player1.setAbilityNumber(0);
                    }
                }

                else dice = player1.rollDice();

                player1.updatePos(dice);

                if(pos == 0 || pos == 6 || pos == 12 || pos == 18 ) {  // 특수칸 도착 시,
                    if(pos == 0){  player1.updateCoin(300000); }    // 출발점

                    else if(pos == 6) { player1.setTurn(0); }       // 랩실

                    else if(pos == 12){         //주류 판매
                        System.out.println("원하는 위치 받아야 함");
                        int want = scan.nextInt();
                        bc[want].setPassingFee(3);
                    }
                    else if(pos == 18){         //전동킥보드 ( 한 턴 안쉬고 바로 선택 후 이동 )
                        System.out.println("원하는 위치 받아야 함");
                        int want = scan.nextInt();
                        player1.updatePos(want);    // 한 칸씩 할지, 순간이동으로 할지 ( 구현이 가능한지 모르겠음 )
                        bc[want].checkBoardOwner(player1, player2);
                    }
                }
                else
                    bc[pos].checkBoardOwner(player1, player2);
                player1.setTurn(player1.getTurn()-1);                   //플레이어1의 턴을 1 감소
            }

            victory(player1, bc);

            //후공(플레이어2)
            player2.setTurn(player2.getTurn()+1);
            pos = player2.getPos();
            while(player2.getTurn() != 0){
                int dice = 0;
                if (player2.getAbilityNumber() >= 1 && player2.getAbilityNumber() <= 5) {
                    if (player2.isCallAbility()) {
                        if (player2.getAbilityNumber() == 1) {
                            System.out.println("원하는 위치 받아야 함");
                            int want = scan.nextInt();
                            player2.teleport(want);
                        }

                        else if (player2.getAbilityNumber() == 2) {
                            player2.doubleDice();
                        }

                        else if (player2.getAbilityNumber() == 3) {
                            player2.goToLAB(player1);
                            dice = player2.rollDice();
                        }
                        else if (player2.getAbilityNumber() == 4) {
                            player2.setTurn(player2.getTurn()-1);
                            break;
                        }
                        else if (player2.getAbilityNumber() == 5) {
                            System.out.println("원하는 위치 받아야 함");
                            int want = scan.nextInt();
                            bc[want].setBooth(0);
                            dice = player2.rollDice();
                        }
                        player2.setAbilityNumber(0);
                    }
                }
                else if (player2.getAbilityNumber() != 10) {
                    dice = player2.rollDice();
                    if (player2.isCallAbility()){
                        player2.setAbilityNumber(0);
                    }
                }
                else dice = player2.rollDice();

                if (pos == 0 || pos == 6 || pos == 12 || pos == 18 ) {     // 특수칸 도착 시,
                    if(pos == 0){  player2.updateCoin(300000); }    // 출발점

                    else if(pos == 6) { player2.setTurn(0); }       // 랩실

                    else if(pos == 12){         //주류 판매
                        System.out.println("원하는 위치 받아야 함");
                        int want = scan.nextInt();
                        bc[want].setPassingFee(3);
                    }
                    else if(pos == 18){         //전동킥보드 ( 한 턴 안쉬고 바로 선택 후 이동 )
                        System.out.println("원하는 위치 받아야 함");
                        int want = scan.nextInt();
                        player2.updatePos(want);    // 한 칸씩 할지, 순간이동으로 할지 ( 구현이 가능한지 모르겠음 )
                        bc[want].checkBoardOwner(player2, player1);
                    }
                }
                else
                    bc[pos].checkBoardOwner(player2, player1);

                player2.setTurn(player2.getTurn()-1);
            }
            victory(player2, bc);
        }
    }
}