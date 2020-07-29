public class PersonDemo 
{

    public static void main(String[] args) 
    {
        //create a normal person
        Person person = new Person("Janelle", "4824 Millner Way, Elk Grove, CA 95757", "9166853958", "jchan@gmail.com");
        System.out.println(person.toString());

        //create a student
        Person student = new Student("Alex", "6530 Candy Lane", "310-567-9045", "alexxx@gmail.com", 4);
        System.out.println(student.toString());

        //create date
        MyDate date = new MyDate(01, 16, 17);

        //create Employee
        Person employee = new Employee("Jason", "2359 Brownie Land", "501-455-9068", "jasonnn@gmail.com", "Pinkberry", date, 10000);
        System.out.println(employee.toString());

        //create Faculty
        Person faculty = new Faculty("Yvonne", "3434 Marshmallow Way", "401-225-9538", "yvonnem@gmail.com", "Cisco", date, 5000, "9am - 5pm", 5);
        System.out.println(faculty.toString());

        //create Staff
        Person staff = new Staff("Bonnie", "4578 Peppermint Lane", "210-989-4567", "bonnienclyde@gmail.com", "Motorcycle Babes", date, 5500, "Sales Representative");
        System.out.println(staff.toString());

        
    }
    
}
//Main class: person class
class Person
{
    private String name;
    private String address;
    private String phoneNum;
    private String email;

    public Person(String n, String a, String num, String mail)
    {
        name = n;
        address = a;
        phoneNum = num;
        email = mail;
    }

    //returns the name of the person
    public String getName()
    {
        return name;
    }

    //returns the person's address
    public String getAddress()
    {
        return address;
    }

    //returns the person's phone number
    public String getNum()
    {
        return phoneNum;
    }

    //returns the person's email
    public String getEmail()
    {
        return email;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setAddress(String newAdd)
    {
        address = newAdd;
    }

    public void setNum(String newNum)
    {
        phoneNum = newNum;
    }

    public void setEmail(String newEmail)
    {
        email = newEmail;
    }

    //override the toString method to only return name person's name and class
    public String toString()
    {
        return getClass().getName() + "\n" +name;
    }
}

//Student class: subclass of person
class Student extends Person
{
    //declare class status
    public static int FRESHMEN = 1;
    public static int SOPHOMORE = 2;
    public static int JUNIOR = 3;
    public static int SENIOR = 4;

    private int status;

    //sets a new value to student's status
    public Student(String n, String a, String num, String mail, int newStat)
    {
        super(n, a, num, mail);
        status = newStat;
    }

    //return the student's class status
    public int getStatus()
    {
        return status;
    }

}

//Employee class: subclass of person
class Employee extends Person
{
    //declare variables needed
    private String office;
    private MyDate dateHired;
    private int salary;

    public Employee(String n, String a, String num, String mail,String newOffice, MyDate newDate, int newSalary)
    {
        super(n, a, num, mail);
        office = newOffice;
        dateHired = newDate;
        salary = newSalary;
    }

    //get methods
    //return which office the employee is in
    public String getOffice()
    {
        return office;
    }

    //return the date the employee was hired
    public MyDate getDate()
    {
        return dateHired;
    }

    //return the employee's salary
    public int getSalary()
    {
        return salary;
    }

    //Set methods
    //set a new value to employee's office
    public void setOffice(String newOffice)
    {
        office = newOffice;
    }

    //sets a new value to the employee's salary
    public void setSalary(int newSalary)
    {
        salary = newSalary;
    }

}

//Faculty class: subclass of Employee
class Faculty extends Employee
{
    private String officeHours;
    private int rank;
    
    public Faculty(String n, String a, String num, String mail,String newOffice, MyDate newDate, int newSalary, String newHours, int newRank)
    {
        super(n, a, num, mail, newOffice, newDate, newSalary);
        newHours = officeHours;
        newRank = rank;
        
    }

    public String getHours()
    {
        return officeHours;
    }

    public int getRank()
    {
        return rank;
    }

    public void setHours(String newHours)
    {
        officeHours = newHours;
    }

    public void setRank(int newRank)
    {
        rank = newRank;
    }

}

//staff class: subclass of Employee
class Staff extends Employee
{
    private String title;
    
    public Staff(String n, String a, String num, String mail,String newOffice, MyDate newDate, int newSalary, String newTitle)
    {
        super(n, a, num, mail, newOffice, newDate, newSalary);
        title = newTitle;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

}

//MyDate class: dateHired in Employee class
class MyDate
{
    private int month;
    private int day;
    private int year;

    public MyDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }

    public void setMonth(int m)
    {
        month = m;
    }

    public void setDay(int d)
    {
        day = d;
    }

    public void setYear(int y)
    {
        year = y;
    }
}