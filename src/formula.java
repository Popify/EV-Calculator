import java.util.Scanner;

public class formula
{

    public static void main(String[] args)
    {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter your odds of winning: ");
        double winRate = Double.parseDouble(reader.nextLine());

        System.out.print("Enter your opponent's stake: ");
        double opponentStake = Double.parseDouble(reader.nextLine());

        System.out.print("Enter your minimum EV in %: ");
        double minEV = Double.parseDouble(reader.nextLine());

        double yourStake = expectedValue(winRate, minEV, opponentStake);

        System.out.println(yourStake);



    }

    private static double expectedValue(double winRate, double minEV, double opponentStake)
    {
        winRate = winRate / 100;
        minEV = minEV / 100;

        double yourStake = (winRate * opponentStake) / (minEV + (1 - winRate));

        return yourStake;

    }
}
