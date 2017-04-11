package IdljTest;

/**
* IdljTest/GoldbashHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��IdljTest.idl
* 2017��4��11�� ���ڶ� ����05ʱ02��01�� CST
*/

public final class GoldbashHolder implements org.omg.CORBA.portable.Streamable
{
  public IdljTest.Goldbash value = null;

  public GoldbashHolder ()
  {
  }

  public GoldbashHolder (IdljTest.Goldbash initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = IdljTest.GoldbashHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    IdljTest.GoldbashHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return IdljTest.GoldbashHelper.type ();
  }

}
