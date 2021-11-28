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
    public void setPassingFee(int booth) {          //부스 업그레이드 통행료
        if(booth != 0) {
            if(booth == 1) passingFee *= 1.1;
            else if(booth == 2) passingFee *= 1.5;
            else if(booth == 3) passingFee *= 2;
        }
        else passingFee *= 4;
    }

    public void setBooth(int booth_num) {               //특수능력 관련 부스를 제어하는 함수
        if(booth_num != 0)  booth = booth_num;
        else booth += booth_num;
    }

    public void calPassingFee(Player player1, Player player2) {         //통행료를 지불하는 함수
        if(player1.getName().equals(ownPlayer)) {                       //현재 지역의 소유주를 판단하여 지불
            player1.updateCoin(passingFee);
            player2.updateCoin(-passingFee);
        }
        else if (player2.getName().equals(ownPlayer)) {
            player1.updateCoin(-passingFee);
            player2.updateCoin(passingFee);
        }
    }
    public void buyBoard(Player player) {   //처음 도착 시 부스를 설치하는 함수
        int buy = 0;                        //임시 변수. 스윙으로 팝업창 제작 시 확인 버튼을 누르면 true 로 변경되게 하면 됨.
        if(buy == 1) {
            ownPlayer = player.getName();
            player.updateCoin(-passingFee);
            booth++;
        }
    }
    public void updateBooth(Player player) {    //부스가 이미 설치되어 있을 때 부스를 업그레이드 하는 함수
        int buy = 0;
        if(buy == 1) {
            if(booth == 1 || booth == 2) {          //이미 설치된 부스가 소형, 중형일 경우 부스를 업그레이드(부스 변수 1 증가)
                player.updateCoin(-passingFee);
                booth++;
            }
            else if(booth == 3) {                   //이미 설치된 부스가 대형일 경우 부스 업그레이드를 안함
                return;
            }
        }
    }


}
