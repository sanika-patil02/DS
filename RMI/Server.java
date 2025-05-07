import java.rmi.*;

public class Server{
public static void main(String args[]){
try{
ServerInterfaceimpl serverimpl = new ServerInterfaceimpl();
Naming.rebind("server",serverimpl);
/* serverimpl object is saved in rmi registry with name "server" */

System.out.println("Server Started....");
}
catch(Exception e){
System.out.println("Exception occured at server"+e.getMessage());
}

}
}
