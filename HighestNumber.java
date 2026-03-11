import java.util.Scanner;

class HighestNumber 
{
    public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter third number: ");
        int num3 = input.nextInt();

        int highest = findHighest(num1, num2, num3);

        System.out.println("\nThe highest number is: " + highest);
        
        input.close();
    }

    public static int findHighest(int a, int b, int c) 
	{
        int result = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        
        return result;
    }
}