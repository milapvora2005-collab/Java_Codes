import java.util.Scanner;
class StudentDetails
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter roll no.: ");
		int roll=sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("Enter Name: ");
		String name=sc.nextLine();
		
		System.out.print("Enter marks: ");
		float marks=sc.nextFloat();
		
		System.out.println("\n ----StudentDetails---- ");
		System.out.println("Roll no.: "+roll);
		System.out.println("Name: "+name);
		System.out.println("Marks: "+marks);
		
		sc.close();
	}
}