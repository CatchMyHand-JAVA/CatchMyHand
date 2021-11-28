import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;																						                //파일 입출력을 위한 불러오기

public class SignUp extends JFrame {
    private String id;
    private String pwd;
    private String nickname;

    public SignUp() {
        setTitle("굴러라! 코리아텍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JButton btn = new JButton();
        btn.setSize(275,75);
        btn.setLocation(584,724);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        c.add(btn);

        ImageIcon img = new ImageIcon("images/signup.jpg");
        JLabel imageLabel = new JLabel(img);

        imageLabel.setSize(1440,1024);
        imageLabel.setLocation(0,0);
        c.add(imageLabel);

        setSize(1440,1024);
        setVisible(true);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LogIn();
                setVisible(false); // 창 안보이게 하기
            }
        });
    }
    
    // 파일 내에 정보 저장
    public SignUp(String id, String pwd, String nickname) {												                //생성자를 통해 아이디, 패스워드, 닉네임 받아오기
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        File temp = new File("UserInfo.txt");															        //회원 정보 저장을 위한 텍스트 파일 생성

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("UserInfo.txt", true));			//파일입출력을 위한 버퍼 생성

            writer.write(String.format("%s,%s,%s\n",id,pwd,nickname ));									                //입력받은 아이디, 비밀번호, 닉네임을 텍스트파일에 저장

            writer.close();																				                //파일 쓰기 종료

        } catch (IOException e) {																		                //입력된 것이 없을 경우 예외 처리
            e.printStackTrace();
        }
    }

    public String getNickname(){            //닉네임을 반환하는 함수
        return nickname;
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
}




