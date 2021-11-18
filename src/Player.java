public class Player {
    // 기본 필드
    private String name;
    private int life;
    private int abilityNumber;
    private int coin;
    private int pos;
    private int turn;

    /* 기본 메소드  */
    public Player() {                       // 생성자

    }

    // 접근자
    public int getCoin() {                  // 재화 접근자
        return coin;
    }
    public int getLife() {                  // 생명 접근자
        return life;
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
    public void setName(String name) {      // 이름 설정자
        this.name = name;
    }
    public void setLife(int life) {         // 생명 설정자
        this.life = life;
    }
    public void setTurn(int turn) {         // 턴 설정자
        this.turn = turn;
    }
    public boolean isCallAbility() {        // 특수능력을 사용유무
        return true;
    }
    public void updateCoin(int coin) {      // 재화 설정자
        this.coin = coin;
    }
    public void updatePos(int pos) {        // 위치 설정자
        this.pos = pos;
    }


    /* 특수능력 메소드 */
    void callAbility(int abilityNumber)	{}	    // 특수능력 호출 메소드
    void swapCoin(Player anotherPlayer) {}	    // 상대방과 자산을 바꾼다.
    void stealCoin(Player anotherPlayer)  {}	// 상대방 자산의 20%를 가져온다.
    void buildbooth() {}                        // 후에 setBooth()를 호출
    void doubleDice(){}                         // 주사위 더블이 나옴, 생성된 난수로 updatePos()를 호출
    void teleport()	{}                          // 원하는 위치로 이동, 안에서 getIdx()를 통해 원하는 위치의 인덱스를 가져옴
    void destroyBooth()	{}	                    // 선택 지역의 부스 파괴
    void feeXfour()	{}		                    // 주류 판매 시 4배
    void oneMoreChance() {}	                    // 파산 시 50만원 지급 (life = 2로 시작)
    void goToLAB(Player anotherPlayer, int labIdx) {}  // 상대방을 랩실에 가둠
    void escapeLab() {}		                    // 랩실 탈출
    void restOneTime() {}		                // 한턴 쉼
    void payPass() {}		                    // 해당 구 역 통행료 면제


}
