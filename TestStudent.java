class Person
{
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() //Default Constructor
	{
		firstName="";
		lastName="";
		age=0;
	}
	public Person(String fn, String ln, int a) //Parameterized Constructor
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
class Student extends Person
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
public class TestStudent
{
	public static void main(String[] args)
	{
		Student std1=new Student();
		Student std2=new Student("Milap", "Vora", 19,"CS",28,88,95,75);
		Student std3=new Student("Vinit", "Mehta", 18,"CS",25,84,74,68);
		Student highestScorer = std1;

        if (std2.calculateAvg() > highestScorer.calculateAvg()) {
            highestScorer = std2;
        }
        if (std3.calculateAvg() > highestScorer.calculateAvg()) {
            highestScorer = std3;
        }

        System.out.println(std1);
        System.out.println(std2);
        System.out.println(std3);

        System.out.println("\n*** HIGHEST SCORER ***");
        System.out.println(highestScorer);
    }
}