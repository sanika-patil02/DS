import java.rmi.*;
import java.rmi.server.*;

public class ServerInterfaceimpl extends UnicastRemoteObject implements ServerInterface{

public ServerInterfaceimpl() throws RemoteException{

}

public double addition(double num1,double num2) throws RemoteException{
return num1+num2;
}

public double subtraction(double num1,double num2) throws RemoteException{
return num1-num2;
}

public double multiplication(double num1,double num2) throws RemoteException{
return num1*num2;
}
public double division(double num1,double num2) throws RemoteException{
return num1/num2;
}

public String concatenation(String str1,String str2) throws RemoteException{
return str1+str2;
}
}
