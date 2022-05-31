package net.fred.feedex.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileUtils
{
  public static void a(File paramFile1, File paramFile2)
  {
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    FileChannel localFileChannel1 = paramFile1.getChannel();
    FileChannel localFileChannel2 = paramFile2.getChannel();
    localFileChannel1.transferTo(0L, localFileChannel1.size(), localFileChannel2);
    paramFile1.close();
    paramFile2.close();
  }
}
