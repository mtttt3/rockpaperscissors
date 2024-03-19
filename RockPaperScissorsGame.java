import java.util.Random;     // need this for the random function
import java.util.Scanner;    // need this for the user input function
import java.util.concurrent.TimeUnit;

enum AttackType
{
    ROCK,
    PAPER,
    SCISSORS
}

public class RockPaperScissorsGame
{
    public void run()
    {
        boolean keepPlaying = true;

        while (keepPlaying)
        {
            // Code for the game goes here.
            // 
            // You can call the functions 'getRandomInt', 'getUserInt', and 'intToAttackType'
            // to help run the program. You may also want to define your own functions.
            //
            // Note: Since those functions are defined in this class, and we are using them
            // in this class, we can label them 'private'. If that's confusing, then just label
            // all of them 'public' for now. We will learn about private vs. public later.



            // <code>

            System.out.println("Rock Paper Scissors Game");
            wait(1000);
            
            System.out.print("its currently your turn: \n 0 - rock \n 1 - paper \n 2 - scissors");

            boolean g = true;
            while(g)
            {
                Scanner i = new Scanner(System.in);
                int user_int = i.nextInt();

                if (user_int == 0)
                {
                    System.out.println("you chose rock" + AttackType.ROCK);
                    wait(750);
                    System.out.println(intToAttackType(botMove()));
                    matchResult(user_int);
                    g = false;
                    
                }
                else if (user_int == 1)
                {
                    System.out.println("you chose paper" + AttackType.PAPER);
                    wait(750);
                    System.out.println(intToAttackType(botMove()));
                    matchResult(user_int);
                    g = false;
                }
                else if (user_int == 2)
                {
                    System.out.println("you chose scissors " + AttackType.SCISSORS);
                    wait(750);
                    System.out.println(intToAttackType(botMove()));
                    matchResult(user_int);
                    g = false;
                }
                

            }

            

            

            System.out.println("Do you want to play again?");
            System.out.print("0->yes  1->no. Enter a number: ");
            int keepPlayingInt = getUserInt(0, 1);
            if (keepPlayingInt == 1)
            {
                keepPlaying = false;
            }
        }
    }
    

            

    private int botMove()
    {
        return getRandomInt(0, 3);
        
    }

    private void matchResult(int user_int)
    {
        String x = "";
        if (user_int == 0 & botMove() == 0)
            x = "tie";
        else if (user_int == 0 & botMove() == 1)
            x =  "you lose"; 
        else if (user_int == 0 & botMove() == 1)
        x = "you win";
        else if (user_int == 1 & botMove() == 1)
        x = "tie";
        else if (user_int == 1 & botMove() == 0)
        x = "you win";
        else if (user_int == 1 & botMove() == 2)
        x = "you win";
        else if (user_int == 2 & botMove() == 2)
        x = "tie";
        else if (user_int == 2 & botMove() == 0)
        x = "you lose";
        else if (user_int == 2 & botMove() == 1)
        x = "you win";
        System.out.println(x);
    }

    

    // 'getRandomInt' returns a random integer that is at least 'min' and at most 'max'.
    private int getRandomInt(int min, int max)
    {
        Random rand = new Random();
        return min + rand.nextInt(max - min + 1);
    }

    // 'getUserInt' loops until a valid integer has been submitted by the user that is at least 'min' and at most 'max'.
    // The function returns the valid integer that the user typed in.
    private int getUserInt(int min, int max)
    {
        Scanner scn = new Scanner(System.in);
        
        int userNumber = min - 1; // Set userNumber to be less than min, so that we enter the loop.
        String prompt = "Enter an integer between " + min + " and " + max + ": ";
        boolean repeat = false;

        while (userNumber < min || userNumber > max) // Note: || means or
        {
            // Modify the prompt based on whether we are repeating or not.
            if (repeat)
            {
                System.out.println("Number must be at least " + min + " and at most " + max + ".\n");
                System.out.print(prompt);
            }
            else
            {
                repeat = true;
                System.out.print(prompt);
            }
            
            // Loop as long as an integer has NOT been inputted.
            while (!scn.hasNextInt())
            {
                System.out.println("That is not an integer.\n");
                System.out.print(prompt);
                scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
            }

            // There is a valid integer, so grab that and store it in userNumber.
            userNumber = scn.nextInt();
        }

        return userNumber;
    }

    // 'intToAttackType' converts an integer to an AttackType, where AttackType is an enum.
    // The function returns the AttackType.
    // number 0 --> Rock
    // number 1 --> Paper
    // number 2 --> Scissors
    private AttackType intToAttackType(int number)
    {
        if (number == 0) { return AttackType.ROCK; }
        else if (number == 1) { return AttackType.PAPER; }
        else { return AttackType.SCISSORS; }
    }

    public static void wait(int ms)
    {
    try
    {
        Thread.sleep(ms);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    }
}