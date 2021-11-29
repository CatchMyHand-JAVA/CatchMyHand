import javax.swing.*;
import java.util.Scanner;

public class Player extends JFrame {
    // 기본 필드
    private String name;
    private int abilityNumber;
    private int coin;
    private int pos;
    private int turn;

    /* 기본 메소드  */
    public Player(String name) {                       // 생성자
        this.name = name;
        abilityNumber = (int)(Math.random()*12) + 1;
        coin = 500000;
        pos = 0;
        turn = 0;
    }

    // 접근자
    public int getCoin() {                  // 재화 접근자
        return coin;
    }
    public int getTurn() {                  // 턴 접근자
        return turn;
    }
    public int getAbilityNumber() {         // 특수능력 난수 접근자
        return abilityNumber;
    }
    public String getName() {               // 이름 접근자
        return name;
    }
    public int getPos() {                   // 위치 접근자
        return pos;
    }

    // 설정자
    public void setAbilityNumber(int num) { this.abilityNumber = num; }
    public void setName(String name) {      // 이름 설정자
        this.name = name;
    }
    public void setTurn(int turn) {         // 턴 설정자
        this.turn = turn;
    }
    public void setPos(int pos) {         // 턴 설정자
        this.pos = pos;
    }
    public boolean isCallAbility() {        // 특수능력을 사용유무
        int choice = JOptionPane.showConfirmDialog(null, "특수능력을 사용하시겠습니까?"
                , "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "특수능력사용");
            abilityNumber = 0;
            return true;
        }
        else return false;
    }
    public void setCoin(int coin) {
        this.coin = coin;
    }
    public void updateCoin(int coin) {      // 재화 설정자
        this.coin += coin;
    }
    public void updatePos(int pos) {        // 위치 설정자
        for(int i = 1; i<=pos; i++) {
            ++this.pos;
            this.pos = this.pos % 24;
        }
    }

    public int rollDice() {
        int dice1 = (int)(Math.random()*6) + 1;
        int dice2 = (int)(Math.random()*6) + 1;
        if ( dice1 == dice2 ) setTurn(getTurn() + 1);
        JOptionPane.showMessageDialog(null, dice1+dice2);
        return dice1 + dice2;
    }

    /* 특수능력 메소드 */
    // 특수능력 호출 메소드

    void teleport(int wantPos)   {
        int move = 0;
        if (getPos() < wantPos) {
            move = wantPos - getPos();
        }
        else {
            move = 24 - getPos() + wantPos;
        }
        updatePos(move);
    }
    // 2 주사위 더블이 나옴, 생성된 난수로 updatePos()를 호출
    void doubleDice(){
        int dice;
        dice = (int)(Math.random()*6)+ 1;
        dice *= 2;
        updatePos(dice);
    }
    // 3 상대방을 랩실에 가둠
    void goToLAB(Player anotherPlayer) {
        int lab = 6;    // 랩실 인덱스
        int move = 0;
        if (anotherPlayer.getPos() < lab) {
            move = lab - anotherPlayer.getPos();
        }
        else {
            move = 24 - anotherPlayer.getPos() + lab;
        }
        anotherPlayer.updatePos(move);
    }
    // 4 한턴 쉼
    void restOneTime() {}
    // 5 선택 지역의 부스 파괴
    void destroyBooth()   {}
    void swapCoin(Player anotherPlayer) {               // 6 상대방과 자산을 바꾼다.                  O
        int temp = getCoin();
        setCoin(anotherPlayer.getCoin());
        anotherPlayer.setCoin(temp);
    }
    void stealCoin(Player anotherPlayer)  {             // 7 상대방 자산의 20%를 가져온다.
        updateCoin((int)(anotherPlayer.getCoin() * 0.2));
        anotherPlayer.setCoin((int) (anotherPlayer.getCoin() * 0.8));
    }
    void payPass() {}		                            // 9 해당 구역 통행료 면제                   O
    void oneMoreChance() {                              // 10 파산 시 50만원 지급 (life = 2로 시작)   O
        this.setAbilityNumber(0);
        this.updateCoin(500000);
    }
    void escapeLab() {}		                    // 11 랩실 탈출
    void feeXfour()	{}		                    // 12 주류 판매 시 4배




}
