import java.util.Scanner;
import java.util.Arrays;
class Array2 {
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) 
		{
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        System.out.println("\nElements in the array are: " + Arrays.toString(arr));
        
        sc.close();
    }
}