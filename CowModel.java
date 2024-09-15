import java.util.Random;

public class CowModel {
    private String team; //เก้บทีม
    private String name; //เก้บชื่อ
    private int score; //เก้บคะแนน
    private Random random; //ใช้สุ่ม

    public CowModel(String team, String name) {
        this.team = team;
        this.name = name;
        this.score = 0;
        this.random = new Random();
    }
    //เก้ตเตอร์
    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    //เซ้ตเตอร์เก้บคะแนน
    public void setScore(int score) {
        this.score = score;
    }

    //จำลองการโยนโบว์ด้วยการสุ่ม
    public int throwBall(int remainingPins) {
        return random.nextInt(remainingPins + 1);  
    }

    // จำลองวัวตามทีม
    public boolean isLying() {
        if (team.equals("Black")) {
            return random.nextInt(100) < 20; 
        } else if (team.equals("White")) {
            return random.nextInt(100) < 10; 
        }
        return false;
    }

    // แก้ตามพินที่ล้ม
    public int adjustFalseReport(int reportedPins, int actualPins) {
        if (team.equals("Black") && reportedPins == 10 && actualPins < 10) {
            return 0;
        } else if (team.equals("White") && reportedPins == 0 && actualPins > 0) {
            return actualPins == 10 ? 10 : actualPins;
        }
        return reportedPins;
    }
}

