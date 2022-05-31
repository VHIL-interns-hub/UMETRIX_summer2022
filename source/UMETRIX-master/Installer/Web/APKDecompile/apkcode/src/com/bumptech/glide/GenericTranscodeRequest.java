package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;

public class GenericTranscodeRequest
  extends GenericRequestBuilder
{
  private final ModelLoader g;
  private final Class h;
  private final Class i;
  private final RequestManager.OptionsApplier j;
  
  GenericTranscodeRequest(Context paramContext, Glide paramGlide, Class paramClass1, ModelLoader paramModelLoader, Class paramClass2, Class paramClass3, RequestTracker paramRequestTracker, Lifecycle paramLifecycle, RequestManager.OptionsApplier paramOptionsApplier)
  {
    super(paramContext, paramClass1, a(paramGlide, paramModelLoader, paramClass2, paramClass3, UnitTranscoder.b()), paramClass3, paramGlide, paramRequestTracker, paramLifecycle);
    this.g = paramModelLoader;
    this.h = paramClass2;
    this.i = paramClass3;
    this.j = paramOptionsApplier;
  }
  
  private static LoadProvider a(Glide paramGlide, ModelLoader paramModelLoader, Class paramClass1, Class paramClass2, ResourceTranscoder paramResourceTranscoder)
  {
    return new FixedLoadProvider(paramModelLoader, paramResourceTranscoder, paramGlide.b(paramClass1, paramClass2));
  }
}
