package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentManager
{
  public FragmentManager() {}
  
  public abstract Fragment a(String paramString);
  
  public abstract FragmentTransaction a();
  
  public abstract void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean b();
}
