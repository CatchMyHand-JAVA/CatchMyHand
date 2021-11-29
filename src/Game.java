import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Scanner;

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


class GamePage extends JFrame{
    boolean open =false;
    JLabel first;  //첫번째 주사위
    JLabel second; //두번째 주사위

    public GamePage() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setVisible(true);

        Container c = getContentPane();
        c.setLayout(null);
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

        DiceEvent diceEvent =new DiceEvent();  //마우스 리스터 객체 생성
        jp.addMouseListener(diceEvent);   //MouseListener 리스너 등록
        first = new JLabel("클릭"+"",SwingConstants.CENTER);
        second = new JLabel("클릭"+"",SwingConstants.CENTER);


        jp.add(first);
        jp.add(second);
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


        ImageIcon image1 =new ImageIcon("images/1.대학본부.png");
        JLabel buildImage1 =new JLabel(image1);
        buildImage1.setSize(248, 238);
        buildImage1.setLocation(313,389);
        c.add(buildImage1);
        add(buildImage1);
        buildImage1.setVisible(false);

        ImageIcon image2 =new ImageIcon("images/2.다솔관.png");
        JLabel buildImage2 =new JLabel(image2);
        buildImage2.setSize(248, 238);
        buildImage2.setLocation(313,389);
        c.add(buildImage2);
        add(buildImage2);
        buildImage2.setVisible(false);

        ImageIcon image3 =new ImageIcon("images/3.예솔관.png");
        JLabel buildImage3 =new JLabel(image3);
        buildImage3.setSize(248, 238);
        buildImage3.setLocation(313,389);
        c.add(buildImage3);
        add(buildImage3);
        buildImage3.setVisible(false);

        ImageIcon image4 =new ImageIcon("images/4.함지관.png");
        JLabel buildImage4 =new JLabel(image4);
        buildImage4.setSize(248, 238);
        buildImage4.setLocation(313,389);
        c.add(buildImage4);
        add(buildImage4);
        buildImage4.setVisible(false);

        ImageIcon image5 =new ImageIcon("images/5.예지관.png");
        JLabel buildImage5 =new JLabel(image5);
        buildImage5.setSize(248, 238);
        buildImage5.setLocation(313,389);
        c.add(buildImage5);
        add(buildImage5);
        buildImage5.setVisible(false);

        ImageIcon image7 =new ImageIcon("images/7.해울관.png");
        JLabel buildImage7 =new JLabel(image7);
        buildImage7.setSize(248, 238);
        buildImage7.setLocation(313,389);
        c.add(buildImage7);
        add(buildImage7);
        buildImage7.setVisible(false);

        ImageIcon image8 =new ImageIcon("images/8.한울관.png");
        JLabel buildImage8 =new JLabel(image8);
        buildImage8.setSize(248, 238);
        buildImage8.setLocation(313,389);
        c.add(buildImage8);
        add(buildImage8);
        buildImage8.setVisible(false);

        ImageIcon image9 =new ImageIcon("images/9.솔빛관.png");
        JLabel buildImage9 =new JLabel(image9);
        buildImage9.setSize(248, 238);
        buildImage9.setLocation(313,389);
        c.add(buildImage9);
        add(buildImage9);
        buildImage9.setVisible(false);

        ImageIcon image10 =new ImageIcon("images/10.은솔관.png");
        JLabel buildImage10 =new JLabel(image10);
        buildImage10.setSize(248, 238);
        buildImage10.setLocation(313,389);
        c.add(buildImage10);
        add(buildImage10);
        buildImage10.setVisible(false);

        ImageIcon image11 =new ImageIcon("images/11.청솔관.png");
        JLabel buildImage11 =new JLabel(image11);
        buildImage11.setSize(248, 238);
        buildImage11.setLocation(313,389);
        c.add(buildImage11);
        add(buildImage11);
        buildImage11.setVisible(false);

        ImageIcon image13 =new ImageIcon("images/13.참빛관.png");
        JLabel buildImage13 =new JLabel(image13);
        buildImage13.setSize(248, 238);
        buildImage13.setLocation(313,389);
        c.add(buildImage13);
        add(buildImage13);
        buildImage13.setVisible(false);

        ImageIcon image14 =new ImageIcon("images/14.산업협력단.png");
        JLabel buildImage14 =new JLabel(image14);
        buildImage14.setSize(248, 238);
        buildImage14.setLocation(313,389);
        c.add(buildImage14);
        add(buildImage14);
        buildImage14.setVisible(false);

        ImageIcon image15 =new ImageIcon("images/15.4공.png");
        JLabel buildImage15 =new JLabel(image15);
        buildImage15.setSize(248, 238);
        buildImage15.setLocation(313,389);
        c.add(buildImage15);
        add(buildImage15);
        buildImage15.setVisible(false);

        ImageIcon image16 =new ImageIcon("images/16.대즐.png");
        JLabel buildImage16 =new JLabel(image16);
        buildImage16.setSize(248, 238);
        buildImage16.setLocation(313,389);
        c.add(buildImage16);
        add(buildImage16);
        buildImage16.setVisible(false);

        ImageIcon image17 =new ImageIcon("images/17.다산.png");
        JLabel buildImage17 =new JLabel(image17);
        buildImage17.setSize(248, 238);
        buildImage17.setLocation(313,389);
        c.add(buildImage17);
        add(buildImage17);
        buildImage17.setVisible(false);

        ImageIcon image19 =new ImageIcon("images/19.3공.png");
        JLabel buildImage19 =new JLabel(image19);
        buildImage19.setSize(248, 238);
        buildImage19.setLocation(313,389);
        c.add(buildImage19);
        add(buildImage19);
        buildImage19.setVisible(false);

        ImageIcon image20 =new ImageIcon("images/20.1공.png");
        JLabel buildImage20 =new JLabel(image20);
        buildImage20.setSize(248, 238);
        buildImage20.setLocation(313,389);
        c.add(buildImage20);
        add(buildImage20);
        buildImage20.setVisible(false);

        ImageIcon image21 =new ImageIcon("images/21.2공.png");
        JLabel buildImage21 =new JLabel(image21);
        buildImage21.setSize(248, 238);
        buildImage21.setLocation(313,389);
        c.add(buildImage21);
        add(buildImage21);
        buildImage21.setVisible(false);

        ImageIcon image22 =new ImageIcon("images/22.인경관.png");
        JLabel buildImage22 =new JLabel(image22);
        buildImage22.setSize(248, 238);
        buildImage22.setLocation(313,389);
        c.add(buildImage22);
        add(buildImage22);
        buildImage22.setVisible(false);

        ImageIcon image23 =new ImageIcon("images/23.담헌.png");
        JLabel buildImage23 =new JLabel(image23);
        buildImage23.setSize(248, 238);
        buildImage23.setLocation(313,389);
        c.add(buildImage23);
        add(buildImage23);
        buildImage23.setVisible(false);

        ImageIcon dice1_1 =new ImageIcon("images/주사위 1.png");
        JLabel diceimage1 =new JLabel(dice1_1);
        diceimage1.setSize(100, 100);
        diceimage1.setLocation(1050,460);
        c.add(diceimage1);
        add(diceimage1);
        diceimage1.setVisible(false);

        ImageIcon dice1_2 =new ImageIcon("images/주사위 2.png");
        JLabel diceimage2 =new JLabel(dice1_2);
        diceimage2.setSize(100, 100);
        diceimage2.setLocation(1050,460);
        c.add(diceimage2);
        add(diceimage2);
        diceimage2.setVisible(false);

        ImageIcon dice1_3 =new ImageIcon("images/주사위 3.png");
        JLabel diceimage3 =new JLabel(dice1_3);
        diceimage3.setSize(100, 100);
        diceimage3.setLocation(1050,460);
        c.add(diceimage3);
        add(diceimage3);
        diceimage3.setVisible(false);

        ImageIcon dice1_4 =new ImageIcon("images/주사위 4.png");
        JLabel diceimage4 =new JLabel(dice1_4);
        diceimage4.setSize(100, 100);
        diceimage4.setLocation(1050,460);
        c.add(diceimage4);
        add(diceimage4);
        diceimage4.setVisible(false);

        ImageIcon dice1_5 =new ImageIcon("images/주사위 5.png");
        JLabel diceimage5 =new JLabel(dice1_5);
        diceimage5.setSize(100, 100);
        diceimage5.setLocation(1050,460);
        c.add(diceimage5);
        add(diceimage5);
        diceimage5.setVisible(false);

        ImageIcon dice1_6 =new ImageIcon("images/주사위 6.png");
        JLabel diceimage6 =new JLabel(dice1_6);
        diceimage6.setSize(100, 100);
        diceimage6.setLocation(1050,460);
        c.add(diceimage6);
        add(diceimage6);
        diceimage6.setVisible(false);

        ImageIcon dice2_1 =new ImageIcon("images/주사위 1.png");
        JLabel diceimage2_1 =new JLabel(dice2_1);
        diceimage2_1.setSize(100, 100);
        diceimage2_1.setLocation(1150,460);
        c.add(diceimage2_1);
        add(diceimage2_1);
        diceimage2_1.setVisible(false);

        ImageIcon dice2_2 =new ImageIcon("images/주사위 2.png");
        JLabel diceimage2_2 =new JLabel(dice2_2);
        diceimage2_2.setSize(100, 100);
        diceimage2_2.setLocation(1150,460);
        c.add(diceimage2_2);
        add(diceimage2_2);
        diceimage2_2.setVisible(false);

        ImageIcon dice2_3 =new ImageIcon("images/주사위 3.png");
        JLabel diceimage2_3 =new JLabel(dice2_3);
        diceimage2_3.setSize(100, 100);
        diceimage2_3.setLocation(1150,460);
        c.add(diceimage2_3);
        add(diceimage2_3);
        diceimage2_3.setVisible(false);

        ImageIcon dice2_4 =new ImageIcon("images/주사위 4.png");
        JLabel diceimage2_4 =new JLabel(dice2_4);
        diceimage2_4.setSize(100, 100);
        diceimage2_4.setLocation(1150,460);
        c.add(diceimage2_4);
        add(diceimage2_4);
        diceimage2_4.setVisible(false);

        ImageIcon dice2_5 =new ImageIcon("images/주사위 5.png");
        JLabel diceimage2_5 =new JLabel(dice2_5);
        diceimage2_5.setSize(100, 100);
        diceimage2_5.setLocation(1150,460);
        c.add(diceimage2_5);
        add(diceimage2_5);
        diceimage2_5.setVisible(false);

        ImageIcon dice2_6 =new ImageIcon("images/주사위 6.png");
        JLabel diceimage2_6 =new JLabel(dice2_6);
        diceimage2_6.setSize(100, 100);
        diceimage2_6.setLocation(1150,460);
        c.add(diceimage2_6);
        add(diceimage2_6);
        diceimage2_6.setVisible(false);



        ImageIcon img = new ImageIcon("images/메인보드.png");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440, 1024);
        imageLabel.setLocation(0, 0);
        c.add(imageLabel);
        add(imageLabel);



        btn[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage1.setVisible(true);
                    open=true;
                }
                else {
                    buildImage1.setVisible(false);
                    open=false;
                }
            }

        });
        btn[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage2.setVisible(true);
                    open=true;
                }
                else {
                    buildImage2.setVisible(false);
                    open=false;
                }

            }

        });
        btn[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage3.setVisible(true);
                    open=true;
                }
                else {
                    buildImage3.setVisible(false);
                    open=false;
                }
            }

        });
        btn[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage4.setVisible(true);
                    open=true;
                }
                else {
                    buildImage4.setVisible(false);
                    open=false;
                }
            }

        });
        btn[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage5.setVisible(true);
                    open=true;
                }
                else {
                    buildImage5.setVisible(false);
                    open=false;
                }
            }

        });
        btn[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage7.setVisible(true);
                    open=true;
                }
                else {
                    buildImage7.setVisible(false);
                    open=false;
                }
            }

        });
        btn[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage8.setVisible(true);
                    open=true;
                }
                else {
                    buildImage8.setVisible(false);
                    open=false;
                }
            }

        });
        btn[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage9.setVisible(true);
                    open=true;
                }
                else {
                    buildImage9.setVisible(false);
                    open=false;
                }
            }

        });
        btn[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage10.setVisible(true);
                    open=true;
                }
                else {
                    buildImage10.setVisible(false);
                    open=false;
                }
            }

        });

        btn[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage11.setVisible(true);
                    open=true;
                }
                else {
                    buildImage11.setVisible(false);
                    open=false;
                }
            }

        });
        btn[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage13.setVisible(true);
                    open=true;
                }
                else {
                    buildImage13.setVisible(false);
                    open=false;
                }
            }

        });
        btn[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage14.setVisible(true);
                    open=true;
                }
                else {
                    buildImage14.setVisible(false);
                    open=false;
                }
            }

        });
        btn[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(open == false) {
                    buildImage15.setVisible(true);
                    open=true;
                }
                else {
                    buildImage15.setVisible(false);
                    open=false;
                }
            }

        });
        btn[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage16.setVisible(true);
                    open=true;
                }
                else {
                    buildImage16.setVisible(false);
                    open=false;
                }
            }

        });
        btn[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage17.setVisible(true);
                    open=true;
                }
                else {
                    buildImage17.setVisible(false);
                    open=false;
                }
            }

        });
        btn[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage19.setVisible(true);
                    open=true;
                }
                else {
                    buildImage19.setVisible(false);
                    open=false;
                }
            }

        });

        btn[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage20.setVisible(true);
                    open=true;
                }
                else {
                    buildImage20.setVisible(false);
                    open=false;
                }
            }

        });
        btn[21].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage21.setVisible(true);
                    open=true;
                }
                else {
                    buildImage21.setVisible(false);
                    open=false;
                }
            }

        });
        btn[22].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage22.setVisible(true);
                    open=true;
                }
                else {
                    buildImage22.setVisible(false);
                    open=false;
                }
            }

        });
        btn[23].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!open) {
                    buildImage23.setVisible(true);
                    open=true;
                }
                else {
                    buildImage23.setVisible(false);
                    open=false;
                }
            }

        });



        diceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                diceimage1.setVisible(false);
                diceimage2.setVisible(false);
                diceimage3.setVisible(false);
                diceimage4.setVisible(false);
                diceimage5.setVisible(false);
                diceimage6.setVisible(false);
                diceimage2_1.setVisible(false);
                diceimage2_2.setVisible(false);
                diceimage2_3.setVisible(false);
                diceimage2_4.setVisible(false);
                diceimage2_5.setVisible(false);
                diceimage2_6.setVisible(false);
                int dice1 = (int)(Math.random()*6) + 1;
                int dice2 = (int)(Math.random()*6) + 1;
                String str1 = Integer.toString(dice1);
                String str2 = Integer.toString(dice2);
                String str = "주사위1 : " + str1 + ", 주사위2 : " + str2;

                switch (str1) {
                    case "1" : diceimage1.setVisible(true);
                    case "2" : diceimage2.setVisible(true);
                    case "3" : diceimage3.setVisible(true);
                    case "4" : diceimage4.setVisible(true);
                    case "5" : diceimage5.setVisible(true);
                    case "6" : diceimage6.setVisible(true);
                }

                switch (str2) {
                    case "1" : diceimage2_1.setVisible(true);
                    case "2" : diceimage2_2.setVisible(true);
                    case "3" : diceimage2_3.setVisible(true);
                    case "4" : diceimage2_4.setVisible(true);
                    case "5" : diceimage2_5.setVisible(true);
                    case "6" : diceimage2_6.setVisible(true);
                }


            }

        });
    }

    class DiceEvent implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            first.setFont(new Font("굴림",Font.PLAIN,15));
            second.setFont(new Font("굴림",Font.PLAIN,15));

            first.setText("주사위 "+"\n"+"굴리는중");
            second.setText("주사위 "+"\n"+"굴리는중");
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            first.setFont(new Font("굴림",Font.PLAIN,30));
            second.setFont(new Font("굴림",Font.PLAIN,30));

            first.setText((int)(Math.random()*6)+1+"");
            second.setText((int)(Math.random()*6)+1+"");

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
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

//    public void callAbility() {}
// 회원가입 플레이어 이름 설정에서 2개의 닉네임 받기

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
        new StartPage();


//        String name1 = " ", name2 = " ";    // 임시
//
//        //signup.Login(id,pwd) ;           //플레이어1 로그인
//        Player player1 = new Player(name1);          //플레이어1 객체 생성
//        Player player2 = new Player(name2);          //플레이어2 객체 생성
//
//
//        //보드의 인덱스, 통행료 정보를 받아오는 코드
//        BoardContainer[] bc = new BoardContainer[24];                  //BoardContainer 를 객체 배열로 생성
//        File file = new File("BoardInfo.txt");                  //보드의 위치와 통행료가 저장된 파일 객체
//        try {
//            Scanner scanner = new Scanner(file);                     //파일 내의 정보를 읽어 오기 위한 Scanner 객체
//            int idx = 0, price = 0;                                         //저장된 정보를 읽어오기 위한 정수형 변수 2개
//            String own = " ";                                               //지역의 소유자 읽어오기 위한 변수
//            while (scanner.hasNextInt()) {                           //더이상 읽을 수 있는 정수가 없을 때까지 반복
//                idx = scanner.nextInt();                        //인덱스 값 읽어오기
//                price = scanner.nextInt();                        //통행료 값 읽어오기
//                own = scanner.next();
//                System.out.printf("%d, %d, %s\n", idx, price, own);
//                bc[idx] = new BoardContainer(idx, price,0 ,own);   //BoardContainer 객체 배열 생성자
//            }
//            scanner.close();
//        } catch (Exception e) {                                    //입력된 값이 없을 시 예외 처리
//            e.printStackTrace();
//        }
//
//
//        //게임 start
//        order(player1, player2);                                //선공 후공 설정
//
//        int pos = 0;                                            //다른 클래스 메소드 반복 호출을 줄이기 위한 변수
//        String name = " ";                                      //다른 클래스 메소드 반복 호출을 줄이기 위한 변수
//
//        while(true){                                                //게임 시작
//            //선공(플레이어1)
//            player1.setTurn(player1.getTurn()+1);                   //플레이어1의 턴을 1로 설정
//            while(player1.getTurn() != 0){
//                int dice = 0;
//                if (player1.getAbilityNumber() >= 1 && player1.getAbilityNumber() <= 5) {
//                    if (player1.isCallAbility()) {
//                        if (player1.getAbilityNumber() == 1) {
//                            System.out.println("원하는 위치 받아야 함");
//                            int want = scan.nextInt();
//                            player1.teleport(want);
//                        }
//
//                        else if (player1.getAbilityNumber() == 2) {
//                            player1.doubleDice();
//                        }
//
//                        else if (player1.getAbilityNumber() == 3) {
//                            player1.goToLAB(player2);
//                            dice = player1.rollDice();
//                        }
//                        else if (player1.getAbilityNumber() == 4) {
//                            player1.setTurn(player2.getTurn()-1);
//                            break;
//                        }
//                        else if (player1.getAbilityNumber() == 5) {
//                            System.out.println("원하는 위치 받아야 함");
//                            int want = scan.nextInt();
//                            bc[want].setBooth(0);
//                            dice = player1.rollDice();
//                        }
//                        player1.setAbilityNumber(0);
//                    }
//                }
//                else if (player1.getAbilityNumber() != 10) {
//                    dice = player1.rollDice();
//                    if (player1.isCallAbility()){
//                        player1.setAbilityNumber(0);
//                    }
//                }
//
//                else dice = player1.rollDice();
//
//                player1.updatePos(dice);
//
//                if(pos == 0 || pos == 6 || pos == 12 || pos == 18 ) {  // 특수칸 도착 시,
//                    if(pos == 0){  player1.updateCoin(300000); }    // 출발점
//
//                    else if(pos == 6) { player1.setTurn(0); }       // 랩실
//
//                    else if(pos == 12){         //주류 판매
//                        System.out.println("원하는 위치 받아야 함");
//                        int want = scan.nextInt();
//                        bc[want].setPassingFee(3);
//                    }
//                    else if(pos == 18){         //전동킥보드 ( 한 턴 안쉬고 바로 선택 후 이동 )
//                        System.out.println("원하는 위치 받아야 함");
//                        int want = scan.nextInt();
//                        player1.updatePos(want);    // 한 칸씩 할지, 순간이동으로 할지 ( 구현이 가능한지 모르겠음 )
//                        bc[want].checkBoardOwner(player1, player2);
//                    }
//                }
//                else
//                    bc[pos].checkBoardOwner(player1, player2);
//                player1.setTurn(player1.getTurn()-1);                   //플레이어1의 턴을 1 감소
//            }
//
//            victory(player1, bc);
//
//            //후공(플레이어2)
//            player2.setTurn(player2.getTurn()+1);
//            pos = player2.getPos();
//            while(player2.getTurn() != 0){
//                int dice = 0;
//                if (player2.getAbilityNumber() >= 1 && player2.getAbilityNumber() <= 5) {
//                    if (player2.isCallAbility()) {
//                        if (player2.getAbilityNumber() == 1) {
//                            System.out.println("원하는 위치 받아야 함");
//                            int want = scan.nextInt();
//                            player2.teleport(want);
//                        }
//
//                        else if (player2.getAbilityNumber() == 2) {
//                            player2.doubleDice();
//                        }
//
//                        else if (player2.getAbilityNumber() == 3) {
//                            player2.goToLAB(player1);
//                            dice = player2.rollDice();
//                        }
//                        else if (player2.getAbilityNumber() == 4) {
//                            player2.setTurn(player2.getTurn()-1);
//                            break;
//                        }
//                        else if (player2.getAbilityNumber() == 5) {
//                            System.out.println("원하는 위치 받아야 함");
//                            int want = scan.nextInt();
//                            bc[want].setBooth(0);
//                            dice = player2.rollDice();
//                        }
//                        player2.setAbilityNumber(0);
//                    }
//                }
//                else if (player2.getAbilityNumber() != 10) {
//                    dice = player2.rollDice();
//                    if (player2.isCallAbility()){
//                        player2.setAbilityNumber(0);
//                    }
//                }
//                else dice = player2.rollDice();
//
//                if (pos == 0 || pos == 6 || pos == 12 || pos == 18 ) {     // 특수칸 도착 시,
//                    if(pos == 0){  player2.updateCoin(300000); }    // 출발점
//
//                    else if(pos == 6) { player2.setTurn(0); }       // 랩실
//
//                    else if(pos == 12){         //주류 판매
//                        System.out.println("원하는 위치 받아야 함");
//                        int want = scan.nextInt();
//                        bc[want].setPassingFee(3);
//                    }
//                    else if(pos == 18){         //전동킥보드 ( 한 턴 안쉬고 바로 선택 후 이동 )
//                        System.out.println("원하는 위치 받아야 함");
//                        int want = scan.nextInt();
//                        player2.updatePos(want);    // 한 칸씩 할지, 순간이동으로 할지 ( 구현이 가능한지 모르겠음 )
//                        bc[want].checkBoardOwner(player2, player1);
//                    }
//                }
//                else
//                    bc[pos].checkBoardOwner(player2, player1);
//
//                player2.setTurn(player2.getTurn()-1);
//            }
//            victory(player2, bc);
//        }
    }
}

