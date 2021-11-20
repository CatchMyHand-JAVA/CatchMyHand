public class BoardContainer {
    private int idx;
    private int passingFee;
    private String ownPlayer;
    private int booth;

    public BoardContainer(int idx, int passingFee, int booth, String ownPlayer) {
        this.idx = idx;
        this.passingFee = passingFee;
        this.booth = booth;
        this.ownPlayer = ownPlayer;
    }

    public int getIdx() {
        return this.idx;
    }

    public String getOwnPlayer() {
        return this.ownPlayer;
    }

    public void setOwnPlayer(String ownPlayer) {
        this.ownPlayer = ownPlayer;
    }

    public void setPassingFee(int multiple) {
        passingFee = passingFee * multiple;
    }

    public void setBooth(int booth) {
        this.booth = booth;
    }

    public void calPassingFee(Player player) {

    }


}
