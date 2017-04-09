package server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;
import org.omg.PortableServer.POAPackage.InvalidPolicy;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import CorbaTest.Goldbash;
import CorbaTest.GoldbashHelper;

public class Server {

	public static void main(String[] args)throws ServantNotActive, WrongPolicy, InvalidName, AdapterInactive, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed, org.omg.CORBA.ORBPackage.InvalidName, AdapterAlreadyExists, InvalidPolicy, ServantAlreadyActive, ObjectAlreadyActive {
		
		 //指定ORB的端口号 -ORBInitialPort 900 
		args=new String[2];
		args[0]="-ORBInitialPort";
		args[1]="900";
		
		 //创建一个ORB实例  
        ORB orb = ORB.init(args, null);  
         
        //拿到RootPOA的引用，并激活POAManager，相当于启动了server  
        org.omg.CORBA.Object obj=orb.resolve_initial_references("RootPOA");  
        POA rootpoa = POAHelper.narrow(obj);  
        rootpoa.the_POAManager().activate();  
           
      //创建一个HelloWorldImpl实例
        CorbaTestImpl corbatestImpl = new CorbaTestImpl();  
          
      //从服务中得到对象的引用，并注册到服务中 
        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(corbatestImpl);  
        Goldbash href = GoldbashHelper.narrow(ref);  
           
      //得到一个根名称的上下文 
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);  
          
        //在命名上下文中绑定这个对象 
        String name = "Hello";  
        NameComponent path[] = ncRef.to_name(name);  
        ncRef.rebind(path, href);  
        
        
        //启动线程服务，等待客户端调用 
        orb.run();  
  
     }  
				
}

