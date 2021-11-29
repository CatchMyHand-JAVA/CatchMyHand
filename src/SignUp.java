import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;																						                //파일 입출력을 위한 불러오기

public class SignUp extends JFrame implements ActionListener{
    private String id;
    private String pwd;
    private String nickname;

    JPanel p;
    JLabel lblid, lblpw, lblname, lblname2;
    JButton b1, b2;
    JTextField txtid, txtpw, txtname,txtname2;

    public SignUp(){
        setTitle("굴러라! 코리아텍");
        setSize(1440, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image=new ImageIcon("images/register.PNG");

        lblid = new JLabel("ID");
        lblpw = new JLabel("PW");
        lblname = new JLabel("NAME");
        lblname2 = new JLabel("NAME2");

        txtid = new JTextField(10);
        txtpw = new JTextField(10);
        txtname = new JTextField(10);
        txtname2 = new JTextField(10);

        b1 = new JButton("가입");
        b1.setOpaque(false);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.setFocusPainted(false);

        txtid.setBounds(159, 632, 271, 69);
        txtpw.setBounds(442, 632, 271, 69);
        txtname.setBounds(727, 632, 271, 69);
        txtname2.setBounds(1011, 632, 271, 69);
        b1.setBounds(584,724,271,69);

        p = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(image.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };

        add(lblid);
        add(txtid);
        add(lblpw);
        add(txtpw);
        add(lblname2);
        add(lblname);
        add(txtname);
        add(txtname2);
        add(b1);
        add(p);

        b1.addActionListener(this);


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        try{
            String s = null;
            boolean preHere = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));

            String id = txtid.getText();
            String pw = txtpw.getText();
            String name1 = txtname.getText();
            String name2 = txtname2.getText();


            if(e.getSource() == b1) {  // 회원가입 버튼 눌렀을 시,
                while((s = br.readLine()) != null) {
                    // 아이디 중복
                    String[] userInfo = (s.split("/"));
                    System.out.println(userInfo[0]);

                    if(userInfo[0].equals(id)){                         // id가 존재
                        System.out.println(1111111);
                        JOptionPane.showMessageDialog(null, "이미 존재하는 ID 입니다.");
                        preHere = true;         // id가 존재함
                        break;                  // 반복 종료
                    }
                    else {
                        if (userInfo[1].equals(pw)){                    // pw가 존재
                            JOptionPane.showMessageDialog(null, "이미 존재하는 PW 입니다.");
                            preHere = true;         // id가 존재함
                            break;                  // 반복 종료
                        }
                        else{
                            if (userInfo[2].equals(name1)){             // name1이 존재
                                JOptionPane.showMessageDialog(null, "이미 존재하는 NAME1 입니다.");
                                preHere = true;         // id가 존재함
                                break;                  // 반복 종료
                            }
                            else{
                                if (userInfo[3].equals(name2)){         // name2가 존재
                                    JOptionPane.showMessageDialog(null, "이미 존재하는 NAME2 입니다.");
                                    preHere = true;         // name2가 존재함
                                    break;                  // 반복 종료
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                }

                br.close();
                //정보 입력시 중복이 없으면 데이터 보냄
                if(!preHere) {                  // id가 UserInfo.txt파일에 없을 시,
                    bw.write(String.format("%s/%s/%s/%s\n", id, pw, name1, name2));
                    bw.close();

                    JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
                    new LogIn();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
                }

            }
//            else if(e.getSource() == b2) {
//                txtid.setText("");
//                txtpw.setText("");
//                txtname.setText("");
//                setVisible(false);
//            }
        }catch (IOException  ex){
            JOptionPane.showMessageDialog(null, "실패");
        }
    }


}







