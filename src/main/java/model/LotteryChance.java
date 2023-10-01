package model;

import java.text.DecimalFormat;

public class LotteryChance {

    int sumNum = 90;
    int tipNum = 5;
    long combination = calcCombination(sumNum, tipNum);
    double chance = 1.0 / combination; // // Calculate the chance based on the combination
    int numberOfTicket = 1000000;

    double probabilityOfNotWinningWithOneTicket = (double) (combination - 1) / combination;
    double probabilityOfNotWinning = Math.pow(probabilityOfNotWinningWithOneTicket, numberOfTicket);
    double probabilityOfWinning = 1 - probabilityOfNotWinning;


    private long calcCombination(int sumNum, int tipNum) {
        if (tipNum > sumNum - tipNum) {
            tipNum = sumNum - tipNum;
        }

        long res = 1;

        for (int i = 1; i <= tipNum; i++) {
            res *= sumNum - tipNum + i;
            res /= i;
        }

        return res;
    }

    public void printChance() {
        String formattedChance = String.format("%.10f", chance);
        // Format the probability as a percentage
        DecimalFormat df = new DecimalFormat("0.00%");
        String formattedProbability = df.format(probabilityOfWinning);
        System.out.println("Az ötös lottó eltalálásának esélye: " + chance);
        System.out.println("Az ötös lottó eltalálásának esélye: " + formattedChance + " %");
        System.out.println("The probability of winning with " + numberOfTicket + " tickets is: " + formattedProbability);
    }
}
