package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;

public class DrawableTypeRequest
  extends DrawableRequestBuilder
{
  private final ModelLoader g;
  private final ModelLoader h;
  private final RequestManager.OptionsApplier i;
  
  DrawableTypeRequest(Class paramClass, ModelLoader paramModelLoader1, ModelLoader paramModelLoader2, Context paramContext, Glide paramGlide, RequestTracker paramRequestTracker, Lifecycle paramLifecycle, RequestManager.OptionsApplier paramOptionsApplier)
  {
    super(paramContext, paramClass, a(paramGlide, paramModelLoader1, paramModelLoader2, GifBitmapWrapper.class, GlideDrawable.class, null), paramGlide, paramRequestTracker, paramLifecycle);
    this.g = paramModelLoader1;
    this.h = paramModelLoader2;
    this.i = paramOptionsApplier;
  }
  
  private static FixedLoadProvider a(Glide paramGlide, ModelLoader paramModelLoader1, ModelLoader paramModelLoader2, Class paramClass1, Class paramClass2, ResourceTranscoder paramResourceTranscoder)
  {
    if ((paramModelLoader1 == null) && (paramModelLoader2 == null)) {
      return null;
    }
    ResourceTranscoder localResourceTranscoder = paramResourceTranscoder;
    if (paramResourceTranscoder == null) {
      localResourceTranscoder = paramGlide.a(paramClass1, paramClass2);
    }
    paramGlide = paramGlide.b(ImageVideoWrapper.class, paramClass1);
    return new FixedLoadProvider(new ImageVideoModelLoader(paramModelLoader1, paramModelLoader2), localResourceTranscoder, paramGlide);
  }
}
