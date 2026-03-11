import java.util.Scanner;
class Person1
{
	private String firstName;
	private String lastName;
	private int age;
	
	public Person1() 
	{
		firstName="";
		lastName="";
		age=0;
	}
	public Person1(String fn, String ln, int a)
	{
		firstName=fn;
		lastName=ln;
		age=a;
	}
	public String getfirstName()
	{
		return firstName;
	}
	public String getlastName()
	{
		return lastName;
	}
	public int getage()
	{
		return age;
	}
	void setfirstName(String fn)
	{
		firstName=fn;
	}
	void setlastName(String ln)
	{
		lastName=ln;
	}
	void setage(int a)
	{
		age=a;
	}
	public String toString()
	{
		return("First name: "+ firstName+ "Last name: " +lastName+ "\nAge: " +age );
	}
}
class Student extends Person1
{
	private String Department;
	private int rollno;
	private int subj1;
	private int subj2;
	private int subj3;
	
	public Student()
	{
		Department="";
		rollno=0;
		subj1=0;
		subj2=0;
		subj3=0;
	}
	public Student (String fn,String ln,int a,String dept,int rollno,int subj1,int subj2,int subj3)
	{
		super(fn,ln,a);
		Department=dept;
		this.rollno=rollno;
		this.subj1=subj1;
		this.subj2=subj2;
		this.subj3=subj3;
	}
	public String getDepartment()
	{
		return Department;
	} 
	public int getrollno()
	{
		return rollno;
	}
	public int getsubj1()
	{
		return subj1;
	}
    public int getsubj2()
	{
		return subj2;
	}
	public int getsubj3()
	{
		return subj3;
	}
	void setDepartment(String dept)
	{
		Department=dept;
	}
	void setrollno(int roll)
	{
		rollno=roll;
	}
	void setsubj1(int s1)
	{
		subj1=s1;
	}
	void setsubj2(int s2)
	{
		subj2=s2;
	}
	void setsubj3(int s3)
	{
		subj3=s3;
	}
	public double calculateAvg()
	{
		return (subj1+subj2+subj3)/3.0;
	}
	public char Grade()
	{
		double avg= calculateAvg();
		if (avg>=90)
			return 'A';
		if (avg>=75)
			return 'B';
		if (avg>=50)
			return 'C';
		if (avg>=45)
			return 'D';
		return 'F';
	}
	
	public String toString() 
	{
      return super.toString() + 
        "\nDept: " + Department + " | Roll No: " + rollno + 
        "\nAverage: " + calculateAvg() + " | Grade: " + Grade() +
        "\n----------------------------------------";
	}
	
}

public class TestStudent1 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int count = sc.nextInt();
        sc.nextLine(); 

        Student highestScorer = null;

        for (int i = 1; i <= count; i++) 
		{
            System.out.println("\n--- Entering details for Student " + i + " ---");
            
            System.out.print("First Name: ");
            String fn = sc.nextLine();
            
            System.out.print("Last Name: ");
            String ln = sc.nextLine();
            
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Department: ");
            String dept = sc.nextLine();
            
            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            
            System.out.print("Marks for Subject 1: ");
            int s1 = sc.nextInt();
            
            System.out.print("Marks for Subject 2: ");
            int s2 = sc.nextInt();
            
            System.out.print("Marks for Subject 3: ");
            int s3 = sc.nextInt();
            sc.nextLine(); 

            Student currentStudent = new Student(fn, ln, age, dept, roll, s1, s2, s3);

            if (highestScorer == null || currentStudent.calculateAvg() > highestScorer.calculateAvg()) 
			{
                highestScorer = currentStudent;
            }

            System.out.println("\nStudent Added Successfully:");
            System.out.println(currentStudent);
        }

        if (highestScorer != null) 
		{
            System.out.println("\n==============================");
            System.out.println("      HIGHEST SCORER        ");
            System.out.println("==============================");
            System.out.println(highestScorer);
        }

        sc.close();
	}
}