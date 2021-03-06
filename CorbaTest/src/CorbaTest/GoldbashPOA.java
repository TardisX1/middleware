package CorbaTest;


/**
 * Generated from IDL interface "Goldbash".
 *
 * @author JacORB IDL compiler V 3.8
 * @version generated at 2017-4-9 10:43:36
 */

public abstract class GoldbashPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, CorbaTest.GoldbashOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "checkNum", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:CorbaTest/Goldbash:1.0"};
	public CorbaTest.Goldbash _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		CorbaTest.Goldbash __r = CorbaTest.GoldbashHelper.narrow(__o);
		return __r;
	}
	public CorbaTest.Goldbash _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		CorbaTest.Goldbash __r = CorbaTest.GoldbashHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // checkNum
			{
				float _arg0=_input.read_float();
				_out = handler.createReply();
				java.lang.String tmpResult0 = checkNum(_arg0);
                  _out.write_string( tmpResult0 );
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
