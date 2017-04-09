package rmitest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GoldbachClient {

	public static void main(String args[])throws MalformedURLException,RemoteException,NotBoundException{	
		//��RMIע����в���ָ������
		GoldbachDefine goldbach =  (GoldbachDefine) Naming.lookup("rmi://localhost:8888/Goldbach");
        //����Զ�̶��󷽷�
        System.out.println("client:");
        System.out.println(goldbach.checkNum(8));
		
	}
}
