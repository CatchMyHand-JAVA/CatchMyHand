import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//331, 646            //271, 69

public class LogIn extends JFrame implements ActionListener {
    JTextField id;
    JPasswordField pw;
    JButton loginButton, signUpButton;

    public LogIn() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setVisible(true);
        ImageIcon image=new ImageIcon("images/login.PNG");



        id = new JTextField();
        pw = new JPasswordField();

        loginButton=new JButton("로그인");
        signUpButton =new JButton("회원가입");

        id.setBounds(331, 646, 271, 69);
        pw.setBounds(848, 646, 271, 69);
        loginButton.setBounds(331, 746, 271, 69);
        signUpButton.setBounds(848, 746, 271, 69);

        JPanel p = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
            }
        };

        add(loginButton);
        add(signUpButton);
        add(id);
        add(pw);
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


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) { //로그인 버튼 클릭시
            String userId = id.getText(); //입력한 값을 갖고와서
            if (userId.trim().length() < 1) { //입력이 안됐다면
                JOptionPane.showMessageDialog(this, "ID를 입력하세요.");
                id.requestFocus(); //focus 올려줌
                return;
            }
            String userPw=String.copyValueOf(pw.getPassword());
            if (userPw.trim().length() < 1) { //입력이 안됐다면
                JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
                pw.requestFocus(); //focus 올려줌
                return;
            }

            BufferedReader reader = null;
            String str = null;
            try {
                reader = new BufferedReader(new FileReader("UserInfo.txt"));
                while((str = reader.readLine()) != null)  {
                    String[] userInfo = str.split("/");
                    System.out.println(userInfo[0] + " " + userInfo[1]);
                    //입력이 완료 → 처리
                    if (userId.equals(userInfo[0])) {   // ID가 같을 시,
                        if (userId.equals(userInfo[1])) {
                            JOptionPane.showMessageDialog(this, userInfo[3] +", " + userInfo[4] + "님 로그인 되었습니다.");
                            GamePage page = new GamePage();
                            setVisible(false);
                            break;
                        }
                        else{                           // PW가 다를 시,
                            JOptionPane.showMessageDialog(this, "패스워드가 틀립니다.");
//                            pw.setText("");
//                            pw.requestFocus();
                        }
                    }
                    else{                               // ID가 다를 시,
                        JOptionPane.showMessageDialog(this, "존재하지 않는 ID 입니다.");
                        id.setText("");
                        pw.setText("");
                        id.requestFocus();
                        break;
                    }
                }
                reader.close();
                }

            catch (Exception r) {
                r.printStackTrace();
            }

        }


    }

}
