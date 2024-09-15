import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CowController {
    private List<CowModel> cows; //วัวทั้งหมด
    private CowView view; //ดูผุ้ใช้
    private Random random;

    public CowController(List<CowModel> cows, CowView view) {
        this.cows = cows;
        this.view = view;
        this.random = new Random();
    }
    //ต้องเล่นครบ10รอบ
    public void playGame() {
        for (int round = 1; round <= 10; round++) {
            view.showRoundStart(round); //แสดงว่าเริ่ม

            for (CowModel cow : cows) {
                int remainingPins = 10; //เร่ิ่มด้วย10พิน
                int firstThrow = cow.throwBall(remainingPins); //โยนครั้งแรก
                view.showCowThrow(cow.getName(), firstThrow); //แสดงผมโยนครั้งแรก
                //ตรวจสอบวัวและแสดงผล
                if (cow.isLying()) {
                    firstThrow = cow.adjustFalseReport(firstThrow, remainingPins);
                }

                remainingPins -= firstThrow; //อัปเดตพิมที่เหลือ
                int secondThrow = cow.throwBall(remainingPins); //โยนครั้งสองถ้าไม่สไตร้ท
                //ถ้าโยนครั้งแรกยังเหลือพิน
                if (remainingPins > 0) {
                    view.showCowThrow(cow.getName(), secondThrow); //แสดงผลโยนรอบสอง
                    if (cow.isLying()) {
                        secondThrow = cow.adjustFalseReport(secondThrow, remainingPins);
                    }
                }

                int roundScore = firstThrow + secondThrow; //คะแนนรวมปจบ
                cow.setScore(cow.getScore() + roundScore);  //อัปเดตคะแนน
            }
        }
        view.showFinalResults(cows); //แสดงผลรอบท้าย
    }

    // ตัดสินทีมชนะจากคะแนนรวม
    public void determineWinningTeam() {
        int whiteScore = 0, blackScore = 0, brownScore = 0;
        //คะแนนวัวแยกตามทีม
        for (CowModel cow : cows) {
            switch (cow.getTeam()) {
                case "White":
                    whiteScore += cow.getScore();
                    break;
                case "Black":
                    blackScore += cow.getScore();
                    break;
                case "Brown":
                    brownScore += cow.getScore();
                    break;
            }
        }
        //ดูว่าทีมไหนคะแนนเยอะสุด
        String winningTeam = whiteScore > blackScore && whiteScore > brownScore ? "White" :
                             blackScore > whiteScore && blackScore > brownScore ? "Black" :
                             "Brown";
        view.showWinningTeam(winningTeam); //แสดงทีมชนะ
    }
}
