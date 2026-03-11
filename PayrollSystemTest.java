// Payable Interface
interface Payable {
    double getPaymentAmount();
}

// ================= Invoice =================
class Invoice implements Payable {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription,
                   int quantity, double pricePerItem) {

        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    // Getters & Setters
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() { return partDescription; }
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = (quantity >= 0) ? quantity : 0;
    }

    public double getPricePerItem() { return pricePerItem; }
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem > 0) ? pricePerItem : 0.0;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return "Invoice\nPart Number: " + partNumber +
                "\nDescription: " + partDescription +
                "\nQuantity: " + quantity +
                "\nPrice Per Item: " + pricePerItem;
    }
}

// ================= Abstract Employee =================
abstract class Employee implements Payable {

    private String firstName;
    private String lastName;
    private String ssn;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    // Getters & Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() { return ssn; }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                "\nSSN: " + ssn;
    }
}

// ================= SalariedEmployee =================
class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName,
                            String ssn, double weeklySalary) {
        super(firstName, lastName, ssn);
        setWeeklySalary(weeklySalary);
    }

    public double getWeeklySalary() { return weeklySalary; }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = (weeklySalary > 0) ? weeklySalary : 0.0;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "Salaried Employee\n" +
                super.toString() +
                "\nWeekly Salary: " + weeklySalary;
    }
}

// ================= HourlyEmployee =================
class HourlyEmployee extends Employee {

    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName,
                          String ssn, double wage, double hours) {
        super(firstName, lastName, ssn);
        setWage(wage);
        setHours(hours);
    }

    public double getWage() { return wage; }
    public void setWage(double wage) {
        this.wage = (wage >= 0) ? wage : 0.0;
    }

    public double getHours() { return hours; }
    public void setHours(double hours) {
        this.hours = (hours >= 0 && hours <= 168) ? hours : 0.0;
    }

    @Override
    public double getPaymentAmount() {
        if (hours <= 40)
            return wage * hours;
        else
            return (40 * wage) + ((hours - 40) * wage * 1.5);
    }

    @Override
    public String toString() {
        return "Hourly Employee\n" +
                super.toString() +
                "\nWage: " + wage +
                "\nHours: " + hours;
    }
}

// ================= CommissionEmployee =================
class CommissionEmployee extends Employee {

    protected double grossSales;
    protected double commissionRate;

    public CommissionEmployee(String firstName, String lastName,
                              String ssn, double grossSales,
                              double commissionRate) {
        super(firstName, lastName, ssn);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    public double getGrossSales() { return grossSales; }
    public void setGrossSales(double grossSales) {
        this.grossSales = (grossSales >= 0) ? grossSales : 0.0;
    }

    public double getCommissionRate() { return commissionRate; }
    public void setCommissionRate(double commissionRate) {
        this.commissionRate =
                (commissionRate > 0 && commissionRate < 1)
                        ? commissionRate : 0.0;
    }

    @Override
    public double getPaymentAmount() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return "Commission Employee\n" +
                super.toString() +
                "\nGross Sales: " + grossSales +
                "\nCommission Rate: " + commissionRate;
    }
}

// ================= BasePlusCommissionEmployee =================
class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String ssn, double grossSales,
                                      double commissionRate,
                                      double baseSalary) {
        super(firstName, lastName, ssn, grossSales, commissionRate);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = (baseSalary >= 0) ? baseSalary : 0.0;
    }

    @Override
    public double getPaymentAmount() {
        return baseSalary + super.getPaymentAmount();
    }

    @Override
    public String toString() {
        return "Base Plus Commission Employee\n" +
                super.toString() +
                "\nBase Salary: " + baseSalary;
    }
}

// ================= Main Test Class =================
public class PayrollSystemTest {

    public static void main(String[] args) { 

        Payable[] payableObjects = new Payable[6];

        payableObjects[0] = new Invoice("P101", "Laptop", 2, 45000);
        payableObjects[1] = new Invoice("P102", "Mouse", 5, 500);

        payableObjects[2] = new SalariedEmployee("Milap", "Vora",
                "111-11-1111", 20000);

        payableObjects[3] = new HourlyEmployee("John", "Smith",
                "222-22-2222", 500, 45);

        payableObjects[4] = new CommissionEmployee("David", "Lee",
                "333-33-3333", 30000, 0.10);

        payableObjects[5] = new BasePlusCommissionEmployee("Emma", "Watson",
                "444-44-4444", 25000, 0.08, 10000);

        for (Payable current : payableObjects) {
            System.out.println("--------------------------------");
            System.out.println(current);
            System.out.println("Payment Amount: " +
                    current.getPaymentAmount());
        }
    }
}

//output:
/*D:\CLG FILE\Java>javac PayrollSystemTest.java

D:\CLG FILE\Java>java PayrollSystemTest
--------------------------------
Invoice
Part Number: P101
Description: Laptop
Quantity: 2
Price Per Item: 45000.0
Payment Amount: 90000.0
--------------------------------
Invoice
Part Number: P102
Description: Mouse
Quantity: 5
Price Per Item: 500.0
Payment Amount: 2500.0
--------------------------------
Salaried Employee
Milap Vora
SSN: 111-11-1111
Weekly Salary: 20000.0
Payment Amount: 20000.0
--------------------------------
Hourly Employee
John Smith
SSN: 222-22-2222
Wage: 500.0
Hours: 45.0
Payment Amount: 23750.0
--------------------------------
Commission Employee
David Lee
SSN: 333-33-3333
Gross Sales: 30000.0
Commission Rate: 0.1
Payment Amount: 3000.0
--------------------------------
Base Plus Commission Employee
Commission Employee
Emma Watson
SSN: 444-44-4444
Gross Sales: 25000.0
Commission Rate: 0.08
Base Salary: 10000.0
Payment Amount: 12000.0*/