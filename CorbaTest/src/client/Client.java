package client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import CorbaTest.Goldbash;
import CorbaTest.GoldbashHelper;
import server.CorbaTestImpl;

public class Client {
	
	
	 static Goldbash corbaTestImpl;  
     
	    static {  
	        System.out.println("client开启连接server");  
	           
	      //初始化ip和端口号，-ORBInitialHost 127.0.0.1 -ORBInitialPort 900  
	        String args[] = new String[4];  
	        args[0] = "-ORBInitialHost";  
	      //server端的IP地址，在HelloServer中定义的 
	        args[1] = "127.0.0.1";  
	        args[2] = "-ORBInitialPort";  
	      //server端的端口，在HelloServer中定义的 
	        args[3] = "900";  
	          
	        
	           
	        //创建一个ORB实例  
	        ORB orb = ORB.init(args, null);  
	           
	     // 获取根名称上下文  
	        org.omg.CORBA.Object objRef = null;  
	        try {  
	        objRef = orb.resolve_initial_references("NameService");  
	        } catch (InvalidName e) {  
	            e.printStackTrace();  
	        }  
	        NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);  
	           
	        String name = "Hello";  
	        try {  
	        	
	              
	        	//通过ORB拿到了server实例化好的实现类  
	            corbaTestImpl = GoldbashHelper.narrow(neRef.resolve_str(name));  
	        } catch (NotFound e) {  
	            e.printStackTrace();  
	        } catch (CannotProceed e) {  
	            e.printStackTrace();  
	        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {  
	            e.printStackTrace();  
	        } 
	    }
	        
	         
	    public static void main(String args[]) throws Exception {  
	    	 float a=12;
	    	 String str = corbaTestImpl.checkNum(a);  
		        System.out.println(str);  
	    }  
}
