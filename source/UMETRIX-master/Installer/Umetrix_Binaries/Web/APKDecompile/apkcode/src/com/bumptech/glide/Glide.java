package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader.Factory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader.Factory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader.Factory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader.Factory;
import com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader.Factory;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader.Factory;
import com.bumptech.glide.load.model.stream.StreamFileLoader.Factory;
import com.bumptech.glide.load.model.stream.StreamResourceLoader.Factory;
import com.bumptech.glide.load.model.stream.StreamStringLoader.Factory;
import com.bumptech.glide.load.model.stream.StreamUriLoader.Factory;
import com.bumptech.glide.load.model.stream.StreamUrlLoader.Factory;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.file.StreamFileDataLoadProvider;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableLoadProvider;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.provider.DataLoadProviderRegistry;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Glide
{
  private static volatile Glide a;
  private final GenericLoaderFactory b;
  private final Engine c;
  private final BitmapPool d;
  private final MemoryCache e;
  private final DecodeFormat f;
  private final ImageViewTargetFactory g = new ImageViewTargetFactory();
  private final TranscoderRegistry h = new TranscoderRegistry();
  private final DataLoadProviderRegistry i;
  private final CenterCrop j;
  private final GifBitmapWrapperTransformation k;
  private final FitCenter l;
  private final GifBitmapWrapperTransformation m;
  private final Handler n;
  private final BitmapPreFiller o;
  
  Glide(Engine paramEngine, MemoryCache paramMemoryCache, BitmapPool paramBitmapPool, Context paramContext, DecodeFormat paramDecodeFormat)
  {
    this.c = paramEngine;
    this.d = paramBitmapPool;
    this.e = paramMemoryCache;
    this.f = paramDecodeFormat;
    this.b = new GenericLoaderFactory(paramContext);
    this.n = new Handler(Looper.getMainLooper());
    this.o = new BitmapPreFiller(paramMemoryCache, paramBitmapPool, paramDecodeFormat);
    this.i = new DataLoadProviderRegistry();
    paramEngine = new StreamBitmapDataLoadProvider(paramBitmapPool, paramDecodeFormat);
    this.i.a(InputStream.class, Bitmap.class, paramEngine);
    paramMemoryCache = new FileDescriptorBitmapDataLoadProvider(paramBitmapPool, paramDecodeFormat);
    this.i.a(ParcelFileDescriptor.class, Bitmap.class, paramMemoryCache);
    paramEngine = new ImageVideoDataLoadProvider(paramEngine, paramMemoryCache);
    this.i.a(ImageVideoWrapper.class, Bitmap.class, paramEngine);
    paramMemoryCache = new GifDrawableLoadProvider(paramContext, paramBitmapPool);
    this.i.a(InputStream.class, GifDrawable.class, paramMemoryCache);
    this.i.a(ImageVideoWrapper.class, GifBitmapWrapper.class, new ImageVideoGifDrawableLoadProvider(paramEngine, paramMemoryCache, paramBitmapPool));
    this.i.a(InputStream.class, File.class, new StreamFileDataLoadProvider());
    a(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.Factory());
    a(File.class, InputStream.class, new StreamFileLoader.Factory());
    a(Integer.TYPE, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
    a(Integer.TYPE, InputStream.class, new StreamResourceLoader.Factory());
    a(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
    a(Integer.class, InputStream.class, new StreamResourceLoader.Factory());
    a(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.Factory());
    a(String.class, InputStream.class, new StreamStringLoader.Factory());
    a(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.Factory());
    a(Uri.class, InputStream.class, new StreamUriLoader.Factory());
    a(URL.class, InputStream.class, new StreamUrlLoader.Factory());
    a(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
    a([B.class, InputStream.class, new StreamByteArrayLoader.Factory());
    this.h.a(Bitmap.class, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(paramContext.getResources(), paramBitmapPool));
    this.h.a(GifBitmapWrapper.class, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(paramContext.getResources(), paramBitmapPool)));
    this.j = new CenterCrop(paramBitmapPool);
    this.k = new GifBitmapWrapperTransformation(paramBitmapPool, this.j);
    this.l = new FitCenter(paramBitmapPool);
    this.m = new GifBitmapWrapperTransformation(paramBitmapPool, this.l);
  }
  
  public static Glide a(Context paramContext)
  {
    if (a == null)
    {
      try
      {
        if (a != null) {
          break label126;
        }
        paramContext = paramContext.getApplicationContext();
        localObject = new ManifestParser(paramContext).a();
        GlideBuilder localGlideBuilder = new GlideBuilder(paramContext);
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext()) {
          ((GlideModule)localIterator.next()).a(paramContext, localGlideBuilder);
        }
        a = localGlideBuilder.a();
      }
      finally {}
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GlideModule)((Iterator)localObject).next()).a(paramContext, a);
      }
    }
    label126:
    return a;
  }
  
  public static ModelLoader a(Class paramClass, Context paramContext)
  {
    return a(paramClass, InputStream.class, paramContext);
  }
  
  public static ModelLoader a(Class paramClass1, Class paramClass2, Context paramContext)
  {
    if (paramClass1 == null)
    {
      if (Log.isLoggable("Glide", 3)) {
        Log.d("Glide", "Unable to load null model, setting placeholder only");
      }
      return null;
    }
    return a(paramContext).f().a(paramClass1, paramClass2);
  }
  
  public static void a(View paramView)
  {
    a(new Glide.ClearTarget(paramView));
  }
  
  public static void a(Target paramTarget)
  {
    Util.a();
    Request localRequest = paramTarget.c();
    if (localRequest != null)
    {
      localRequest.d();
      paramTarget.a(null);
    }
  }
  
  public static RequestManager b(Context paramContext)
  {
    return RequestManagerRetriever.a().a(paramContext);
  }
  
  public static ModelLoader b(Class paramClass, Context paramContext)
  {
    return a(paramClass, ParcelFileDescriptor.class, paramContext);
  }
  
  private GenericLoaderFactory f()
  {
    return this.b;
  }
  
  public BitmapPool a()
  {
    return this.d;
  }
  
  ResourceTranscoder a(Class paramClass1, Class paramClass2)
  {
    return this.h.a(paramClass1, paramClass2);
  }
  
  Target a(ImageView paramImageView, Class paramClass)
  {
    return this.g.a(paramImageView, paramClass);
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt);
    this.e.a(paramInt);
  }
  
  public void a(Class paramClass1, Class paramClass2, ModelLoaderFactory paramModelLoaderFactory)
  {
    paramClass1 = this.b.a(paramClass1, paramClass2, paramModelLoaderFactory);
    if (paramClass1 != null) {
      paramClass1.a();
    }
  }
  
  Engine b()
  {
    return this.c;
  }
  
  DataLoadProvider b(Class paramClass1, Class paramClass2)
  {
    return this.i.a(paramClass1, paramClass2);
  }
  
  GifBitmapWrapperTransformation c()
  {
    return this.k;
  }
  
  GifBitmapWrapperTransformation d()
  {
    return this.m;
  }
  
  public void e()
  {
    this.d.a();
    this.e.a();
  }
}
