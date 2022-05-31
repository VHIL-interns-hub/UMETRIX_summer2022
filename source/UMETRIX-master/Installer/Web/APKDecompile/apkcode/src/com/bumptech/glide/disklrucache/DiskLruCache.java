package com.bumptech.glide.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache
  implements Closeable
{
  final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File b;
  private final File c;
  private final File d;
  private final File e;
  private final int f;
  private long g;
  private final int h;
  private long i = 0L;
  private Writer j;
  private final LinkedHashMap k = new LinkedHashMap(0, 0.75F, true);
  private int l;
  private long m = 0L;
  private final Callable n = new DiskLruCache.1(this);
  
  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramFile;
    this.f = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.e = new File(paramFile, "journal.bkp");
    this.h = paramInt2;
    this.g = paramLong;
  }
  
  private DiskLruCache.Editor a(String paramString, long paramLong)
  {
    for (;;)
    {
      DiskLruCache.Editor localEditor;
      try
      {
        f();
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.k.get(paramString);
        if (paramLong != -1L) {
          if (localEntry != null)
          {
            long l1 = DiskLruCache.Entry.e(localEntry);
            if (l1 == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localEntry == null)
        {
          localEntry = new DiskLruCache.Entry(this, paramString, null);
          this.k.put(paramString, localEntry);
          localEditor = new DiskLruCache.Editor(this, localEntry, null);
          DiskLruCache.Entry.a(localEntry, localEditor);
          this.j.append("DIRTY");
          this.j.append(' ');
          this.j.append(paramString);
          this.j.append('\n');
          this.j.flush();
          paramString = localEditor;
          continue;
        }
        localEditor = DiskLruCache.Entry.a(localEntry);
      }
      finally {}
      if (localEditor != null) {
        paramString = null;
      }
    }
  }
  
  public static DiskLruCache a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label113;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
      if (!((DiskLruCache)localObject).c.exists()) {
        break label174;
      }
      try
      {
        ((DiskLruCache)localObject).b();
        ((DiskLruCache)localObject).c();
        return localObject;
      }
      catch (IOException localIOException)
      {
        label113:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((DiskLruCache)localObject).a();
      }
      a((File)localObject, localFile, false);
    }
    label174:
    paramFile.mkdirs();
    paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.d();
    return paramFile;
  }
  
  private void a(DiskLruCache.Editor paramEditor, boolean paramBoolean)
  {
    int i3 = 0;
    DiskLruCache.Entry localEntry;
    try
    {
      localEntry = DiskLruCache.Editor.a(paramEditor);
      if (DiskLruCache.Entry.a(localEntry) != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!DiskLruCache.Entry.d(localEntry))
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.h) {
            break;
          }
          if (DiskLruCache.Editor.b(paramEditor)[i1] == 0)
          {
            paramEditor.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!localEntry.b(i1).exists())
          {
            paramEditor.b();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.h)
      {
        paramEditor = localEntry.b(i2);
        if (paramBoolean)
        {
          if (paramEditor.exists())
          {
            File localFile = localEntry.a(i2);
            paramEditor.renameTo(localFile);
            l1 = DiskLruCache.Entry.b(localEntry)[i2];
            long l2 = localFile.length();
            DiskLruCache.Entry.b(localEntry)[i2] = l2;
            this.i = (this.i - l1 + l2);
          }
        }
        else {
          a(paramEditor);
        }
      }
      else
      {
        this.l += 1;
        DiskLruCache.Entry.a(localEntry, null);
        if ((DiskLruCache.Entry.d(localEntry) | paramBoolean))
        {
          DiskLruCache.Entry.a(localEntry, true);
          this.j.append("CLEAN");
          this.j.append(' ');
          this.j.append(DiskLruCache.Entry.c(localEntry));
          this.j.append(localEntry.a());
          this.j.append('\n');
          if (paramBoolean)
          {
            l1 = this.m;
            this.m = (1L + l1);
            DiskLruCache.Entry.a(localEntry, l1);
          }
        }
        for (;;)
        {
          this.j.flush();
          if ((this.i <= this.g) && (!e())) {
            break;
          }
          this.a.submit(this.n);
          break;
          this.k.remove(DiskLruCache.Entry.c(localEntry));
          this.j.append("REMOVE");
          this.j.append(' ');
          this.j.append(DiskLruCache.Entry.c(localEntry));
          this.j.append('\n');
        }
      }
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void b()
  {
    StrictLineReader localStrictLineReader = new StrictLineReader(new FileInputStream(this.c), Util.a);
    label234:
    try
    {
      String str1 = localStrictLineReader.a();
      String str2 = localStrictLineReader.a();
      String str3 = localStrictLineReader.a();
      String str4 = localStrictLineReader.a();
      String str5 = localStrictLineReader.a();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.f).equals(str3)) || (!Integer.toString(this.h).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      Util.a(localStrictLineReader);
      throw localObject;
      int i1 = 0;
      try
      {
        for (;;)
        {
          d(localStrictLineReader.a());
          i1 += 1;
        }
        d();
      }
      catch (EOFException localEOFException)
      {
        this.l = (i1 - this.k.size());
        if (!localStrictLineReader.b()) {
          break label234;
        }
      }
      Util.a(localStrictLineReader);
      return;
    }
  }
  
  private void c()
  {
    a(this.d);
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext())
    {
      DiskLruCache.Entry localEntry = (DiskLruCache.Entry)localIterator.next();
      int i1;
      if (DiskLruCache.Entry.a(localEntry) == null)
      {
        i1 = 0;
        while (i1 < this.h)
        {
          this.i += DiskLruCache.Entry.b(localEntry)[i1];
          i1 += 1;
        }
      }
      else
      {
        DiskLruCache.Entry.a(localEntry, null);
        i1 = 0;
        while (i1 < this.h)
        {
          a(localEntry.a(i1));
          a(localEntry.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        if (this.j != null) {
          this.j.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), Util.a));
        DiskLruCache.Entry localEntry;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.f));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.h));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.k.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (DiskLruCache.Entry)localIterator.next();
          if (DiskLruCache.Entry.a(localEntry) != null)
          {
            localBufferedWriter.write("DIRTY " + DiskLruCache.Entry.c(localEntry) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        localObject1.write("CLEAN " + DiskLruCache.Entry.c(localEntry) + localEntry.a() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.c.exists()) {
      a(this.c, this.e, true);
    }
    a(this.d, this.c, false);
    this.e.delete();
    this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), Util.a));
  }
  
  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str;
    if (i3 == -1)
    {
      str = paramString.substring(i2);
      if ((i1 == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.k.remove(str);
      }
    }
    else
    {
      str = paramString.substring(i2, i3);
    }
    for (;;)
    {
      DiskLruCache.Entry localEntry2 = (DiskLruCache.Entry)this.k.get(str);
      DiskLruCache.Entry localEntry1 = localEntry2;
      if (localEntry2 == null)
      {
        localEntry1 = new DiskLruCache.Entry(this, str, null);
        this.k.put(str, localEntry1);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        DiskLruCache.Entry.a(localEntry1, true);
        DiskLruCache.Entry.a(localEntry1, null);
        DiskLruCache.Entry.a(localEntry1, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        DiskLruCache.Entry.a(localEntry1, new DiskLruCache.Editor(this, localEntry1, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private boolean e()
  {
    return (this.l >= 2000) && (this.l >= this.k.size());
  }
  
  private void f()
  {
    if (this.j == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void g()
  {
    while (this.i > this.g) {
      c((String)((Map.Entry)this.k.entrySet().iterator().next()).getKey());
    }
  }
  
  /* Error */
  public DiskLruCache.Value a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 101	com/bumptech/glide/disklrucache/DiskLruCache:f	()V
    //   9: aload_0
    //   10: getfield 42	com/bumptech/glide/disklrucache/DiskLruCache:k	Ljava/util/LinkedHashMap;
    //   13: aload_1
    //   14: invokevirtual 105	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 107	com/bumptech/glide/disklrucache/DiskLruCache$Entry
    //   20: astore 6
    //   22: aload 6
    //   24: ifnonnull +12 -> 36
    //   27: aload 5
    //   29: astore 4
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 4
    //   35: areturn
    //   36: aload 5
    //   38: astore 4
    //   40: aload 6
    //   42: invokestatic 225	com/bumptech/glide/disklrucache/DiskLruCache$Entry:d	(Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)Z
    //   45: ifeq -14 -> 31
    //   48: aload 6
    //   50: getfield 443	com/bumptech/glide/disklrucache/DiskLruCache$Entry:a	[Ljava/io/File;
    //   53: astore 7
    //   55: aload 7
    //   57: arraylength
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpge +24 -> 87
    //   66: aload 5
    //   68: astore 4
    //   70: aload 7
    //   72: iload_2
    //   73: aaload
    //   74: invokevirtual 162	java/io/File:exists	()Z
    //   77: ifeq -46 -> 31
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: istore_2
    //   84: goto -23 -> 61
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 98	com/bumptech/glide/disklrucache/DiskLruCache:l	I
    //   92: iconst_1
    //   93: iadd
    //   94: putfield 98	com/bumptech/glide/disklrucache/DiskLruCache:l	I
    //   97: aload_0
    //   98: getfield 129	com/bumptech/glide/disklrucache/DiskLruCache:j	Ljava/io/Writer;
    //   101: ldc_w 421
    //   104: invokevirtual 137	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   107: pop
    //   108: aload_0
    //   109: getfield 129	com/bumptech/glide/disklrucache/DiskLruCache:j	Ljava/io/Writer;
    //   112: bipush 32
    //   114: invokevirtual 140	java/io/Writer:append	(C)Ljava/io/Writer;
    //   117: pop
    //   118: aload_0
    //   119: getfield 129	com/bumptech/glide/disklrucache/DiskLruCache:j	Ljava/io/Writer;
    //   122: aload_1
    //   123: invokevirtual 137	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   126: pop
    //   127: aload_0
    //   128: getfield 129	com/bumptech/glide/disklrucache/DiskLruCache:j	Ljava/io/Writer;
    //   131: bipush 10
    //   133: invokevirtual 140	java/io/Writer:append	(C)Ljava/io/Writer;
    //   136: pop
    //   137: aload_0
    //   138: invokespecial 269	com/bumptech/glide/disklrucache/DiskLruCache:e	()Z
    //   141: ifeq +15 -> 156
    //   144: aload_0
    //   145: getfield 62	com/bumptech/glide/disklrucache/DiskLruCache:a	Ljava/util/concurrent/ThreadPoolExecutor;
    //   148: aload_0
    //   149: getfield 69	com/bumptech/glide/disklrucache/DiskLruCache:n	Ljava/util/concurrent/Callable;
    //   152: invokevirtual 273	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   155: pop
    //   156: new 445	com/bumptech/glide/disklrucache/DiskLruCache$Value
    //   159: dup
    //   160: aload_0
    //   161: aload_1
    //   162: aload 6
    //   164: invokestatic 112	com/bumptech/glide/disklrucache/DiskLruCache$Entry:e	(Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)J
    //   167: aload 6
    //   169: getfield 443	com/bumptech/glide/disklrucache/DiskLruCache$Entry:a	[Ljava/io/File;
    //   172: aload 6
    //   174: invokestatic 247	com/bumptech/glide/disklrucache/DiskLruCache$Entry:b	(Lcom/bumptech/glide/disklrucache/DiskLruCache$Entry;)[J
    //   177: aconst_null
    //   178: invokespecial 448	com/bumptech/glide/disklrucache/DiskLruCache$Value:<init>	(Lcom/bumptech/glide/disklrucache/DiskLruCache;Ljava/lang/String;J[Ljava/io/File;[JLcom/bumptech/glide/disklrucache/DiskLruCache$1;)V
    //   181: astore 4
    //   183: goto -152 -> 31
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	DiskLruCache
    //   0	191	1	paramString	String
    //   60	24	2	i1	int
    //   58	6	3	i2	int
    //   29	153	4	localObject1	Object
    //   1	66	5	localObject2	Object
    //   20	153	6	localEntry	DiskLruCache.Entry
    //   53	18	7	arrayOfFile	File[]
    // Exception table:
    //   from	to	target	type
    //   5	22	186	finally
    //   40	59	186	finally
    //   70	80	186	finally
    //   87	156	186	finally
    //   156	183	186	finally
  }
  
  public void a()
  {
    close();
    Util.a(this.b);
  }
  
  public DiskLruCache.Editor b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        f();
        DiskLruCache.Entry localEntry = (DiskLruCache.Entry)this.k.get(paramString);
        Object localObject;
        if (localEntry != null)
        {
          localObject = DiskLruCache.Entry.a(localEntry);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.i -= DiskLruCache.Entry.b(localEntry)[i1];
          DiskLruCache.Entry.b(localEntry)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.h)
        {
          localObject = localEntry.a(i1);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.l += 1;
      this.j.append("REMOVE");
      this.j.append(' ');
      this.j.append(paramString);
      this.j.append('\n');
      this.k.remove(paramString);
      if (e()) {
        this.a.submit(this.n);
      }
      boolean bool = true;
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.j;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.k.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          DiskLruCache.Entry localEntry = (DiskLruCache.Entry)((Iterator)localObject1).next();
          if (DiskLruCache.Entry.a(localEntry) == null) {
            continue;
          }
          DiskLruCache.Entry.a(localEntry).b();
          continue;
        }
        g();
      }
      finally {}
      this.j.close();
      this.j = null;
    }
  }
}
