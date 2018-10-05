/*  Project:  MyFirstClass
 *  Author:   Ms. Carlson
 *  Date:     June 25, 2014
 *  Purpose:  To show the basic anatomy of a Java Class.
 */
 
 // import statements go here if there are any
 
 // class header... name should match the NameOfTheFile.java
 public class MyFirstClass
 {
    // fields (variables accessible to all methods) go here or
    //    anywhere outside of the methods and constructors
    private int numberOfStudents;
    private String nameOfOneStudent;
    
    // Constructors: methods used to create objects ... no return type...
    //    Constructor names match the name of the class ...
    //    Constructors usually just initialize the field variable values
    public MyFirstClass()
    {
       numberOfStudents = 0;
       nameOfOneStudent = "John Doe";
    }
    
    public MyFirstClass(String name, int num)
    {
       nameOfOneStudent = name;
       numberOfStudents = num;
    }
    
    // accessor methods -- public methods that return 'private' field values
    public String getNameOfStudent()  {  return nameOfOneStudent;  }
    
    public int getNumStudents()  {  return numberOfStudents;  }
    
    // modifier methods  -- public methods that set 'private' field values
    public void setNameOfStudent( String nm ) { nameOfOneStudent = nm;  }
    
    public void setNumStudents( int num ) { numberOfStudents = num;  }
    
    // other various methods
    public String toString()
    {  return " Number of Students in class: " + numberOfStudents + " One student is: " + 
                  nameOfOneStudent;  
    }
    
    // if this class is an application use a main method/init method/ etc.
    public static void main(String[] args)
    {
       MyFirstClass mfc1 = new MyFirstClass();
       MyFirstClass mfc2 = new MyFirstClass("Jane Doe", 10);
       
       System.out.println(mfc1);  // calls mfc1's toString method
       System.out.println(mfc2);  // println automatically calls an objects toString method
       
    }
}


      