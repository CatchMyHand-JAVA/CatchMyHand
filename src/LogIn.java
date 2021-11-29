import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

//331, 646            //271, 69

public class LogIn extends JFrame implements ActionListener {

    JTextField tf;
    JPasswordField pf;
    JButton loginButton, signUpButton;

    public LogIn() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setVisible(true);
        ImageIcon image=new ImageIcon("images/login.jpg");

        tf=new JTextField();
        pf=new JPasswordField();

        loginButton=new JButton();
        signUpButton =new JButton();

        tf.setBounds(328, 644, 271, 70);
        pf.setBounds(848, 644, 271, 70);
        loginButton.setBounds(328, 722, 271, 70);
        signUpButton.setBounds(848, 722, 271, 70);

        loginButton.setOpaque(false);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);

        signUpButton.setOpaque(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setFocusPainted(false);


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
                            GamePage page = new GamePage();
                            setVisible(false);
//                            new Game();
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





//
//    JLabel Id,Pw;
//    JTextField Tf;
//    JPasswordField Pf;
//    JLabel poster =new JLabel();
//    private Font f1, f2;
//
//    final String ID ="admin";
//    final String PWD = "1234";
//
//
//    public LogIn() {
//        setTitle("굴러라! 코리아텍");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(1440,1024);
//        setVisible(true);
//        f1 = new Font("DungGeunMo.woff",Font.PLAIN, 15);
//        Container c = getContentPane();  //프레임의 컨텐트팬을 알아낸다.
//        c.setLayout(null);
//
//
//
//
////        //배경 이미지
////        ImageIcon img = new ImageIcon("images/login.PNG");
////        JLabel imageLabel = new JLabel(img);
////
////        imageLabel.setSize(1440,1024);
////        imageLabel.setLocation(0,0);
////        c.add(imageLabel);
//
//
//        Id=new JLabel("ID");
//        Pw=new JLabel("PW");
//        Id.setFont(f1);
//
//        Tf =new JTextField();
//        Pf = new JPasswordField();
//        Id.setBounds(10,15,30,30);
//        Tf.setBounds(45,15,150,30);
//        Pw.setBounds(10,50,30,30);
//        Pf.setBounds(45,50,150,30);
//
//        //로그인 버튼
//        JButton login = new JButton();
//        login.setSize(275,75);
//        login.setLocation(328,724);
//        login.setBackground(Color.white);
////        login.setBorderPainted(false);
////        login.setContentAreaFilled(false);
//        c.add(login);
//
//        //회원가입 버튼
//        JButton signUp = new JButton("회원가입");
//        signUp.setSize(275,75);
//        signUp.setLocation(848,724);
//        signUp.setBackground(Color.white);
////        signUp.setBorderPainted(false);
////        signUp.setContentAreaFilled(false);
//        c.add(signUp);
//
//
//
//        JPanel p=new JPanel();
//        p.add(login);
//        p.setBounds(10,90,195,35);
//        add(Id);
//        add(Tf);
//        add(Pw);
//        add(Pf);
//        add(p);
//        poster.setBounds(50,125,300,250); //setBounds(x, y, width, height)
//        add(poster);
//        setSize(1024,768);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE); //창 종료시 계속실행 끔(빨간□)
//        //Integer.MAX_VALUE; //21억 4천얼마 → 상수
//        login.addActionListener((ActionListener) this); //로그인
//
//
//        signUp.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new SignUp();
//                setVisible(false);
//            }
//        });
//
//        login.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new Game();
//                setVisible(false);
//            }
//        });
//    }
//}
//
//
