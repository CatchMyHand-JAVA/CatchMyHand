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

        b1 = new JButton();
        b2 = new JButton("취소");
        b1.setOpaque(false);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.setFocusPainted(false);
        txtid.setBounds(159, 632, 271, 69);
        txtpw.setBounds(442, 632, 271, 69);
        txtname.setBounds(727, 632, 271, 69);
        txtname2.setBounds(1011, 632, 271, 69);
        b1.setBounds(584,724,271,69);

        JPanel p = new JPanel(){
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
        add(b2);

        add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void Login(String id, String pwd) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("UserInfo.txt"));			                // 파일 입출력을 위한 버퍼 생성

            String line = "";
            while ((line = reader.readLine()) != null) { 												                // reader에서 라인을 읽은 값이 null일 때(메모장의 마지막 줄일때)
                String[] temp = line.split(","); 													                // 구분자로 "," 를 사용
                System.out.printf("%s\t%s\t%s\n", temp[0], temp[1], temp[2]);
                if(id.equals(temp[0]) && pwd.equals(temp[1])){          //전달받은 id와 pwd가 일치하면
                    nickname = temp[2];         //nickname에 파일에서 읽어온 이름을 저장
                    break;          //while문 멈춤
                }
            }
            System.out.println("아이디와 비밀번호를 확인해주세요");            //파일의 끝까지 탐색했지만 일치하는 경우가 없을 때
            reader.close();																				                // 파일 읽기 종료
        } catch (Exception e) {																			                // 읽어 온 것이 없을 때 예외 처리
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        try{
            String s = null;
            boolean isOk = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo.txt", true));
            BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));


            if(e.getSource() == b1) {
//                while((s = br.readLine()) != null) {
//
//                    // 아이디 중복
//                    String[] array = s.split("/");
//                    if(array[0].equals(txtid.getText())){
//                        isOk = true;
//                        break;
//                    }
//                }
                //정보 입력시 중복이 없으면 데이터 보냄
                if(!isOk) {
                    bw.write(txtid.getText() + "/");
                    bw.write(txtpw.getText() + "/");
                    bw.write(txtname.getText() + "/");
                    bw.write(txtname2.getText() + "\n");
                    bw.close();

                    JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
                    new LogIn();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
                }

            }else if(e.getSource() == b2) {
                txtid.setText("");
                txtpw.setText("");
                txtname.setText("");
            }
        }catch (IOException  ex){
            JOptionPane.showMessageDialog(null, "실패");
        }
    }


}







