import java.util.Scanner;

class StudentGrades 
{

    public static void main(String[] args) 
	{
        int[] rollNumbers = {101, 102, 103};
        String[] names = {"Alice", "Bob", "Charlie"};

        int[][] marks = {
            {85, 90, 78},
            {55, 60, 58},
            {92, 88, 95}
        };

        System.out.println("Student Report Card:");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Roll No", "Name", "Total", "Average", "Grade", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < rollNumbers.length; i++) 
		{
            calculateAndDisplay(rollNumbers[i], names[i], marks[i]);
        }
    }

    public static void calculateAndDisplay(int roll, String name, int[] studentMarks) 
	{
        int total = 0;
        for (int mark : studentMarks) 
		{
            total += mark;
        }

        double average = total / (double) studentMarks.length;
        String grade;
        String status = "Pass";

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 75) {
            grade = "A";
        } else if (average >= 50) {
            grade = "B";
        } else {
            grade = "F";
            status = "Fail";
        }

        System.out.printf("%-10d %-10s %-10d %-10.2f %-10s %-10s\n", roll, name, total, average, grade, status);
    }
}