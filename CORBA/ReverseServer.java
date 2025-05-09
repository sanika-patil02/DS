import ReverseModule.Reverse;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseServer {
    public static void main(String[] args) {
        try {
            // initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // initialize the BOA/POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // creating the reverse object
            ReverseImpl rvr = new ReverseImpl();

            // get the object reference from the servant class
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);
            System.out.println("Step1");
            Reverse h_ref = ReverseModule.ReverseHelper.narrow(ref);
            System.out.println("Step2");
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            System.out.println("Step3");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            System.out.println("Step4");
            String name = "Reverse";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);
            System.out.println("Reverse Server reading and waiting....");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    /*  terminal 1
    
    sanika@sanika-VirtualBox:~/DS$ idlj -fall ReverseModule.idl
sanika@sanika-VirtualBox:~/DS$ javac *.java ReverseModule/*.java
ReverseModule/_ReverseStub.java:46: warning: IORCheckImpl is internal proprietary API and may be removed in a future release
     com.sun.corba.se.impl.orbutil.IORCheckImpl.check(str, "ReverseModule._ReverseStub");
                                  ^
Note: ReverseModule/ReversePOA.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 warning
sanika@sanika-VirtualBox:~/DS$ sudo update-alternatives --config java
[sudo] password for akanksha: 
There are 2 choices for the alternative java (providing /usr/bin/java).

  Selection    Path                                            Priority   Status
------------------------------------------------------------
  0            /usr/lib/jvm/java-11-openjdk-amd64/bin/java      1111      auto mode
  1            /usr/lib/jvm/java-11-openjdk-amd64/bin/java      1111      manual mode
* 2            /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java   1081      manual mode

Press <enter> to keep the current choice[*], or type selection number: 
sanika@sanika-VirtualBox:~/DS$ orbd -ORBInitialPort 1050&
[3] 7797

    
   sanika@sanika-VirtualBox:~/DS$ java ReverseServer -ORBInitialPort 1050& -ORBInitialHost localhost&
[3] 7820
[4] 7821
sanika@sanika-VirtualBox:~/DS$ Reverse Object Created
Step1
Step2
Step3
Step4
Reverse Server reading and waiting....
-ORBInitialHost: command not found

*/



/* Terminal 2

sanika@sanika-VirtualBox:~/DS$ java ReverseClient -ORBInitialPort 1050 -ORBInitialHost localhost
Enter String=
sanika
Server Send akinas

*/

}
