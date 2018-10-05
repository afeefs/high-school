public class Student
{
 private String name;
 private int id;
 private double gpa;
 
 public Student()
 {
  name  = "John Doe";
  id = 0;
  gpa = 1.0;
  
 }
 
 public Student(String n, int idd, double gpanew)
 {
  name = n;
  //n = name; is a not correct and is an error
  //or could use this.name = name; and uses 
  //the current constructor
  id = idd;
  gpa = gpanew;
 }
 
 public String getName() {return name;}
 public int getID() {return id;}
 public double getGPA() {return gpa;}
 
 public void setName (String n) {name = n;}
 public void setID(int idd) {id = idd;}
 public void setGPA(double g){gpa = g;}

 public String toString()
 {
   return" "+name+ " " +id+ " " +gpa;
 }
 
 //Main Method
 public static void main(String [] args)
 {
 Student austin = new Student("Austin Atkins", 10,4.2);
 Student aleah = new Student("Aleah Talley", 11,4.3);
 Student chris = new Student("Chris Barrows", 12, 4.4);
 Student x = new Student();
 
 System.out.println(austin);
 
 austin.setName("Austin Powers");
 //Changing names
 System.out.println(aleah);
 System.out.println(chris);
 System.out.println(x);
 }
}