import java.util.Scanner;

public class Player {
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
        // Swing 구현 필수 (팝업 plz)
        Scanner scan = new Scanner(System.in);
        char user_choice = scan.next().charAt(0);
        if (user_choice == 'Y') {
            abilityNumber = 0;
            return true;
        }
        else return false;
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
        return dice1 + dice2;
    }

    /* 특수능력 메소드 */
    // 특수능력 호출 메소드
    void callAbility(int abilityNumber)	{
        switch(abilityNumber) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
        }
    }

    void teleport()	{}                          // 1 원하는 위치로 이동, 안에서 getIdx()를 통해 원하는 위치의 인덱스를 가져옴
    void doubleDice(){}                         // 2 주사위 더블이 나옴, 생성된 난수로 updatePos()를 호출
    void goToLAB(Player anotherPlayer, int labIdx) {}  // 3 상대방을 랩실에 가둠
    void restOneTime() {}		                // 4 한턴 쉼
    void destroyBooth()	{}	                    // 5 선택 지역의 부스 파괴
    void swapCoin(Player anotherPlayer) {}	    // 6 상대방과 자산을 바꾼다.
    void stealCoin(Player anotherPlayer)  {}	// 7 상대방 자산의 20%를 가져온다.
    void buildbooth() {}                        // 8 후에 setBooth()를 호출                 O
    void payPass() {}		                    // 9 해당 구역 통행료 면제
    void oneMoreChance() {                      // 10 파산 시 50만원 지급 (life = 2로 시작)   O
        this.setAbilityNumber(0);
        this.updateCoin(500000);
    }
    void escapeLab() {}		                    // 11 랩실 탈출
    void feeXfour()	{}		                    // 12 주류 판매 시 4배




}
