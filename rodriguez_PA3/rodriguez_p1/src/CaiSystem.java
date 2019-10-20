import java.security.SecureRandom;
import java.util.Scanner;

public class CaiSystem
{
    public static void main(String[] args)
    {
        int range, totalCorrect, type;
        double average;
        boolean session = true;

        Scanner scan = new Scanner(System.in);
        // Allows a new session to be created
        while(session)
        {
            System.out.println("New Session Start");
            range = difficultySelect();
            type = questionType();
            totalCorrect = 0;

            // Asks ten random questions per session
            for (int i = 0; i < 10; i++)
            {
                totalCorrect = totalCorrect + randomQuestion(range, type);
            }

            finalResults(totalCorrect);
            System.out.println();

            // Asks user for new session
            System.out.println("Would you like to run a new session?");
            String newSession = scan.next();
            if(newSession.equalsIgnoreCase("no"))
            {
                System.out.println("Session ending...");
                session = false;
            }
        }
    }

    // Prompts for the question type
    public static int questionType()
    {
        int type;
        Scanner scan = new Scanner(System.in);

        System.out.println("What problem type would you like to practice? (1, 2, 3, 4, 5): ");
        type = scan.nextInt();

        return type;
    }

    // Calculates the question average and prints the results
    public static void finalResults(int totalCorrect)
    {
        double average;

        average = (double)totalCorrect / 10;
        System.out.println("Correct: " + totalCorrect);
        System.out.println("Incorrect: " + (10 - totalCorrect));
        if(average > 0.75)
        {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else
        {
            System.out.println("Please ask your teacher for extra help.");
        }
    }

    // Prompts for the difficulty selection
    public static int difficultySelect()
    {
        int result;
        Scanner scan;
        scan = new Scanner(System.in);

        System.out.println("Please select your difficulty. (1, 2, 3, 4): ");
        result = scan.nextInt();
        return result;
    }

    // Generates a random question based on the range and type
    public static int randomQuestion(int range, int type)
    {
        double response, answer;
        int result;
        boolean correctResponse;
        Scanner scan = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        int[] randNums = randomGenerator(range, type);

        // Generates a random type when type is 5
        if(type == 5)
        {
            type = 1 + random.nextInt(4);
        }

        // Conducts the operation that was selected
        answer = resultOperation(type, randNums);
        System.out.println("How much is " + randNums[0] + stringOperation(type) + randNums[1] + "?");
        response = scan.nextDouble();

        if (Math.abs(answer - response) < .0001)
        {
            correctResponse = true;
            result = 1;
        }
        else
        {
            correctResponse = false;
            result = 0;
        }

        responseGenerator(correctResponse);
        return result;
    }

    // Ensures that the operation string used in the print statement in random question
    // is correct
    public static String stringOperation(int type)
    {
        String result = "";
        switch(type)
        {
            case 1:
                result = " plus ";
                break;
            case 2:
                result = " times ";
                break;
            case 3:
                result = " minus ";
                break;
            case 4:
                result = " divided by ";
                break;
        }
        return result;
    }

    // Conducts the correct operation based on the practice that the user wants
    public static double resultOperation(int type, int[] randNums)
    {
        double result = 0;
        switch(type)
        {
            case 1:
                result = randNums[0] + randNums[1];
                break;
            case 2:
                result = randNums[0] * randNums[1];
                break;
            case 3:
                result = randNums[0] - randNums[1];
                break;
            case 4:
                result = randNums[0] / randNums[1];
                break;
        }
        return result;
    }

    // Prints a response based on whether the user got the question correct
    public static void responseGenerator(boolean correct)
    {
        int answer;

        SecureRandom random = new SecureRandom();
        answer = random.nextInt(4);

        if(correct)
        {
            switch(answer)
            {
                case 0:
                    System.out.println("Very good!");
                    break;
                case 1:
                    System.out.println("Excellent!");
                    break;
                case 2:
                    System.out.println("Nice work!");
                    break;
                case 3:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else
        {
            switch(answer)
            {
                case 0:
                    System.out.println("No. Please try again.");
                    break;
                case 1:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 2:
                    System.out.println("Don’t give up!");
                    break;
                case 3:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }

    }

    // Generates two random numbers to be used in a math question
    public static int[] randomGenerator(int range, int type)
    {
        SecureRandom random = new SecureRandom();
        int bound = (int)Math.pow(10, range);
        int[] randNum = new int[2];
        randNum[0] = random.nextInt(bound);
        randNum[1] = random.nextInt(bound);
        while(randNum[1] == 0 && type >= 4)
        {
            randNum[1] = random.nextInt(bound);

        }

        return randNum;
    }
}
