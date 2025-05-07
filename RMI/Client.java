import java.rmi.*;
import java.util.*;

public class Client{
public static void main(String args[]){ 
Scanner sc =new Scanner(System.in);

try{
String serverURL="rmi://localhost/server";
ServerInterface serverintf = (ServerInterface) Naming.lookup(serverURL);
/* Naming.lookup checks whether serverURL present in rmiRegistry or not and stores its ref in serverintf*/

System.out.println("Enter first number:");
int num1 = sc.nextInt();

System.out.println("Enter second number:");
int num2 = sc.nextInt();

System.out.println("Enter string1:");
String str1 = sc.next();

System.out.println("Enter string2:");
String str2 = sc.next();

System.out.println("First number:"+num1);
System.out.println("Second number:"+num2);
System.out.println("String1:"+str1);
System.out.println("String2:"+str2);

System.out.println("Addition:"+serverintf.addition(num1,num2));
System.out.println("Subtraction:"+serverintf.subtraction(num1,num2));
System.out.println("Multiplication:"+serverintf.multiplication(num1,num2));
System.out.println("Division:"+serverintf.division(num1,num2));
System.out.println("Concatenation:"+serverintf.concatenation(str1,str2));
}
catch(Exception e){
System.out.println("Exception occured at client:"+e.getMessage());
}
}
}




/*

Terminal-1
sanika@sanika-VirtualBox:~/RMI$ javac *.java
sanika@sanika-VirtualBox:~/RMI$ rmiregistry

Terminal-2
sanika@sanika-VirtualBox:~/RMI$ java Server
Server Started....

Terminal-3
sanika@sanika-VirtualBox:~/RMI$ java Client
Enter first number:
100
Enter second number:
10
Enter string1:
Sanika
Enter string2:
Patil
First number:100
Second number:10
String1:Sanika
String2:Patil
Addition:110.0
Subtraction:90.0
Multiplication:1000.0
Division:10.0
Concatenation:SanikaPatil

*/
