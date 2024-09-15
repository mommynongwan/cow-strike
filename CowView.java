import java.util.List;

public class CowView {
    //แสดงผลการโยน
    public void showCowThrow(String cowName, int throwResult) {
        System.out.println(cowName + " knocked down " + throwResult + " pins.");
    }
    //แสดงผลเริ่มรอบใหม่
    public void showRoundStart(int round) {
        System.out.println("\n--- Round " + round + " ---");
    }
    //แสดงผลรอบท้ายมีการแสดงคะแนนแต่ละตัว
    public void showFinalResults(List<CowModel> cows) {
        System.out.println("\n--- Final Results ---");
        cows.sort((c1, c2) -> c2.getScore() - c1.getScore());  // Sort by score descending
        for (int i = 0; i < cows.size(); i++) {
            CowModel cow = cows.get(i);
            System.out.println((i + 1) + ". " + cow.getName() + " from team " + cow.getTeam() + " scored: " + cow.getScore());
        }
    }
    //แดสงทีมชนะ
    public void showWinningTeam(String teamName) {
        System.out.println("\nThe winning team is: " + teamName);
    }
}
