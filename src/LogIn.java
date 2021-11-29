import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

//331, 646            //271, 69

class GameThread extends Thread {
    private JFrame gamePanel;

    public GameThread(JFrame gp) {
        this.gamePanel = gp;
        gamePanel.setSize(1440, 1024);
        //jp.setPreferredSize(new Dimension(1440, 1024));
        JButton[] btn = new JButton[24];
        JButton diceBtn = new JButton();
        JPanel jp = new JPanel();
        jp.setLayout(null);

        diceBtn.setContentAreaFilled(false);
        diceBtn.setOpaque(false);
        diceBtn.setBorderPainted(false);
        diceBtn.setBounds(1061, 556, 169, 60);
        gamePanel.add(diceBtn);

        for(int i = 0; i<24; i++) {
            btn[i] = new JButton();
            btn[i].setContentAreaFilled(false);
            btn[i].setOpaque(false);
            btn[i].setBorderPainted(false);
            gamePanel.add(btn[i]);
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
        gamePanel.add(jp);


        gamePanel.setTitle("굴러라! 코리아텍");
        gamePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = gamePanel.getContentPane();
        c.setLayout(null);

        ImageIcon img = new ImageIcon("images/gamestart.png");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440, 1024);
        imageLabel.setLocation(0, 0);
        gamePanel.add(imageLabel);
        gamePanel.add(jp);

        gamePanel.setSize(1440, 1024);
        gamePanel.setVisible(true);

//        diceBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int dice1 = (int)(Math.random()*6) + 1;
//                int dice2 = (int)(Math.random()*6) + 1;
//                String str1 = Integer.toString(dice1);
//                String str2 = Integer.toString(dice2);
//                String str = "주사위1 : " + str1 + ", 주사위2 : " + str2;
//                JOptionPane.showMessageDialog(null, str);
//            }
//        });
    }

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

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
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
                //System.out.printf("%d, %d, %s\n", idx, price, own);
                bc[idx] = new BoardContainer(idx, price,0 ,own);   //BoardContainer 객체 배열 생성자
            }
            scanner.close();
        } catch (Exception e) {                                    //입력된 값이 없을 시 예외 처리
            e.printStackTrace();
        }

        //게임 start
        order(player1, player2);                                //선공 후공 설정

        int pos = 0;                                            //다른 클래스 메소드 반복 호출을 줄이기 위한 변수
        String name = " ";

        while(true){                                                //게임 시작
            //선공(플레이어1)
            JOptionPane.showMessageDialog(null, "플레이어1의 차례");
            player1.setTurn(player1.getTurn()+1);                   //플레이어1의 턴을 1로 설정
            while(player1.getTurn() != 0){
                int dice = 0;
                JOptionPane.showMessageDialog(null, player1.getAbilityNumber());
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
                            //while(true) { if(next == 1) break;
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
                            //while(true) { if(next == 1) break;}
                            dice = player1.rollDice();
                        }
                        player1.setAbilityNumber(0);
                    }
                }
                else if (player1.getAbilityNumber() != 10) {
                    //while(true) { if(next == 1) break;}
                    dice = player1.rollDice();
                    if (player1.isCallAbility()){
                        player1.setAbilityNumber(0);
                    }
                }

                else {
                    //while(true) { if(next == 1) break;}
                    dice = player1.rollDice();
                }


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
            //next = 0;

            //후공(플레이어2)
            JOptionPane.showMessageDialog(null, "플레이어2의 차례");
            player2.setTurn(player2.getTurn()+1);
            pos = player2.getPos();
            JOptionPane.showMessageDialog(null, player1.getAbilityNumber());
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
                            //while(true) { if(next == 1) break;}
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
                            //
                            // while(true) { if(next == 1) break;}
                            dice = player2.rollDice();
                        }
                        player2.setAbilityNumber(0);
                    }
                }
                else if (player2.getAbilityNumber() != 10) {
                    //while(true) { if(next == 1) break;}
                    dice = player2.rollDice();
                    if (player2.isCallAbility()){
                        player2.setAbilityNumber(0);
                    }
                }
                else {
                    //while(true) { if(next == 1) break;}
                    dice = player2.rollDice();
                }

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

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                return;
            }
        }

    }
}

public class LogIn extends JFrame implements ActionListener {
    JTextField tf;
    JPasswordField pf;
    JButton loginButton, signUpButton;

//    final String ID="admin"; //원래 DB에 있어야함. 임시로 부여
//    final String PWD="1234";

    public LogIn() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setVisible(true);
        ImageIcon image=new ImageIcon("images/login.PNG");

        tf=new JTextField();
        pf=new JPasswordField();

        loginButton=new JButton("로그인");
        signUpButton =new JButton("회원가입");

        tf.setBounds(331, 646, 271, 69);
        pf.setBounds(848, 646, 271, 69);
        loginButton.setBounds(331, 746, 271, 69);
        signUpButton.setBounds(848, 746, 271, 69);

        JPanel p=new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(image.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);

            }

        };
        add(loginButton);
        add(signUpButton);
        add(tf);
        add(pf);
        add(p);

        setSize(1440, 1024);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //창 종료시 계속실행 끔(빨간□)
        loginButton.addActionListener(this); //로그인
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignUp();
                setVisible(false);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) { //로그인 버튼 클릭시
            String id=tf.getText(); //입력한 값을 갖고와서
            if (id.trim().length() < 1) { //입력이 안됐다면
                JOptionPane.showMessageDialog(this, "ID를 입력하세요.");
                tf.requestFocus(); //focus 올려줌
                return;
            }
            String pwd=String.copyValueOf(pf.getPassword());
            if (pwd.trim().length() < 1) { //입력이 안됐다면
                JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
                tf.requestFocus(); //focus 올려줌
                return;
            }

            String str;

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("UserInfo.txt"));
                while(true) {
                    str = reader.readLine();
                    String[] info = str.split("/");
                    //입력이 완료 → 처리
                    if (id.equalsIgnoreCase(info[0])) { //equals의 사용 예시
                        if (pwd.equals(info[1])) {
                            JOptionPane.showMessageDialog(this, id + "님 로그인 되었습니다.");
                            GamePage gp = new GamePage();
                            GameThread gth = new GameThread(gp);
                            gth.start();
                            setVisible(false);
                            break;
                        } else {
                            JOptionPane.showMessageDialog(this, "패스워드가 틀립니다.");
                            pf.setText("");
                            pf.requestFocus();
                        }

                    } else {
                        if (str == null) {
                            JOptionPane.showMessageDialog(this, "존재하지 않는 ID입니다.");
                            tf.setText("");
                            pf.setText("");
                            tf.requestFocus();
                            break;
                        }
                    }
                }
                reader.close();
            } catch (Exception r) {
                r.printStackTrace();
            }

        }


    }

}


