public class Player {
    private String name;
    private int life;
    private int abilityNumber;
    private int coin;
    private int pos;
    private int turn;

    public Player() {}

    public int getCoin() {
        return coin;
    }

    public int getLife() {
        return life;
    }

    public int getTurn() {
        return turn;
    }

    public int getAbilityNumber() {
        return abilityNumber;
    }

    public String getName() {   // 클래스 다이어그램에는 없음, 근데 필요할듯?
        return name;
    }

    public int getPos() {   // 클래스 다이어그램에는 없음, 근데 필요할듯?
        return pos;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isCallAbility() {
        return true;
    }

    public void updateCoin(int coin) {
        this.coin = coin;
    }

    public void updatePos(int pos) {
        this.pos = pos;
    }

    


}
