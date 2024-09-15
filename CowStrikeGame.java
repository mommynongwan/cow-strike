import java.util.Arrays;

public class CowStrikeGame {
    public static void main(String[] args) {
        CowModel whiteCow1 = new CowModel("White", "Cow 1");
        CowModel whiteCow2 = new CowModel("White", "Cow 2");
        CowModel whiteCow3 = new CowModel("White", "Cow 3");

        CowModel blackCow1 = new CowModel("Black", "Cow 1");
        CowModel blackCow2 = new CowModel("Black", "Cow 2");
        CowModel blackCow3 = new CowModel("Black", "Cow 3");

        CowModel brownCow1 = new CowModel("Brown", "Cow 1");
        CowModel brownCow2 = new CowModel("Brown", "Cow 2");
        CowModel brownCow3 = new CowModel("Brown", "Cow 3");

        CowView view = new CowView();
        CowController controller = new CowController(Arrays.asList(
            whiteCow1, whiteCow2, whiteCow3,
            blackCow1, blackCow2, blackCow3,
            brownCow1, brownCow2, brownCow3
        ), view);

        controller.playGame();
        controller.determineWinningTeam();
    }
}

