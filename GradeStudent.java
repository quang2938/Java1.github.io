import java.util.Scanner;

public class GradeStudent {
    static int weight;
    static int weight1;
    static int weight2;
    static double weightedScore;
    static double weightedScore1;
    static double weightedScore2;
    static double shiftedAmount;
    static double shiftedAmount1;
    public static void main(String[] args){
        begin();
        midTerm();
        finalTerm();
        homework();
        report();
    }
    public static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade\n");
    }
    public static void midTerm(){
        Scanner sc = new Scanner(System.in);
        int score;
        int shifted;
        double total;
        System.out.println("Midterm:");
        do {
            System.out.print("Weight (1-100): ");
                weight = sc.nextInt();
        }while(weight > 100);
        System.out.print("Score earned: ");
            score = sc.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no) ");
            shifted = sc.nextInt();
            if(shifted == 1){
                System.out.print("Shift amount: ");
                    shiftedAmount = sc.nextInt();
            }
        total = (score + shiftedAmount);
        weightedScore = total/100 * weight;
        if(total <= 100) {
            System.out.println("Total points = " + Math.round(total) + "/100");
            System.out.printf("Weighted score = %.2f", weightedScore);
            System.out.println("/" + weight);
        }else {
            System.out.println("Total points = " + 100 + "/100");
            System.out.println("Weighted score = " + weight + "/" + weight);
        }
    }
    public static void finalTerm(){
        Scanner sc = new Scanner(System.in);
        int score;
        int shifted;
        double total;
        System.out.println("\nFinal:");
        do {
            System.out.print("Weight (1-100): ");
            weight1 = sc.nextInt();
        }while((weight + weight1) >= 100);
        System.out.print("Score earned: ");
            score = sc.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no) ");
            shifted = sc.nextInt();
        if(shifted == 1){
            System.out.print("Shift amount: ");
            shiftedAmount1 = sc.nextInt();
        }
        total = (score + shiftedAmount1);
        weightedScore1 = total/100 * weight1;
        if(total <= 100) {
            System.out.println("Total points = " + Math.round(total) + "/100");
            System.out.printf("Weighted score = %.2f", weightedScore1);
            System.out.println("/" + weight2);
        }else {
            System.out.println("Total points = " + 100 + "/100");
            System.out.println("Weighted score = " + weight1 + "/" + weight1);
        }
    }
    public static void homework(){
        Scanner sc = new Scanner(System.in);
        double asm1;
        double asmMax1;
        double asm2;
        double asmMax2;
        double asm3;
        double asmMax3;
        int attend;
        int sectionPoint;
        double MaxPoint;
        double totalPoints;
        System.out.println("\nHomework:");
        weight2 = 100 - (weight1 + weight2);
        System.out.println("Weight (1-100): " + weight2);
        do{
            System.out.print("Assignment 1 score and max? ");
                asm1 = sc.nextDouble();
                asmMax1 = sc.nextDouble();
        }while(asm1 > asmMax1);

        do {
            System.out.print("Assignment 2 score and max? ");
                asm2 = sc.nextDouble();
                asmMax2 = sc.nextDouble();
        }while(asm2 > asmMax2);

        do {
            System.out.print("Assignment 3 score and max? ");
                asm3 = sc.nextDouble();
                asmMax3 = sc.nextDouble();
        }while(asm3 > asmMax3);
        do {
            System.out.print("How many sections did you attend? ");
            attend = sc.nextInt();
        }while(attend > 6);
        sectionPoint = attend * 5;
        System.out.println("Section points = " + sectionPoint + "/" + 30);
        MaxPoint = (asmMax1 + asmMax2 + asmMax3 + sectionPoint);
        totalPoints = (asm1 + asm2 + asm3 + sectionPoint);
        weightedScore2 = totalPoints/MaxPoint * weight2;
        System.out.println("Total points = " + Math.round(totalPoints) + "/" + Math.round(MaxPoint));
        System.out.println("Weighted score = " + Math.round(weightedScore2) + "/" + weight2);
    }
    public static void report(){
        double overall = weightedScore + weightedScore1 + weightedScore2;
        System.out.printf("\nOverall percentage = %.2f\n", overall);
        if(overall >= 85) {
            System.out.println("Your grade will be at least: " + 3);
        }else if(overall < 85 && overall >=75){
            System.out.println("Your grade will be at least: " + 2);
        }else if(overall < 75 && overall >= 60){
            System.out.println("Your grade will be at least: " + 0.7);
        }else{
            System.out.println("Your grade will be at least: " + 0);
        }
        System.out.println("<< your custom grade message here >>");
    }
}
