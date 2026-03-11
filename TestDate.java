class Date
{
	int day;
	int month;
	int year;
	static String monthname[]={"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	
	public Date()
	{
		day=1;
		month=1;
		year=2000;
	}
	
	public Date(int d,int m,int y)
	{
		day=d;
		month=m;
		year=y;
	}
	
	public int getday()
	{
		return day;
	}
	
	public int getmonth()
	{
		return month;
	}
	
	public int getyear()
	{
		return year;
	}
	
	void setday(int d)
	{
		day=d;
	}
	
	void setmonth(int m)
	{
		month=m;
	}
	
	void setyear(int y)
	{
		year=y;
	}
	
	void printdetails()
	{
		System.out.println(day+"/"+month+"/"+year);
	}
	
	public String toString()
	{
		return day+"/"+monthname[month]+"/"+year;
	}
}
class TestDate
{
	public static void main(String args[])
	{
		System.out.println(new Date());
		System.out.println(new Date(25,6,2024));
	}
}
