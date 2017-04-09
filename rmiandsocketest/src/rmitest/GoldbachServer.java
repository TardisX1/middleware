package rmitest;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class GoldbachServer {


	public static void main(String args[])throws RemoteException,MalformedURLException,AlreadyBoundException{
		GoldbachDefine goldbach;
		goldbach=new GoldbachDefineImp();
		
		//Զ�̶���ע���ʵ��
        LocateRegistry.createRegistry(8888);
        //��Զ�̶���ע�ᵽRMIע���������
        Naming.bind("rmi://localhost:8888/Goldbach", goldbach);
        System.out.println("server:����󶨳ɹ���");
		
	}
	
}
