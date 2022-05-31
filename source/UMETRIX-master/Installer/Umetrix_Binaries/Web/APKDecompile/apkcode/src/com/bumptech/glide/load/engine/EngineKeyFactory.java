package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

class EngineKeyFactory
{
  EngineKeyFactory() {}
  
  public EngineKey a(String paramString, Key paramKey, int paramInt1, int paramInt2, ResourceDecoder paramResourceDecoder1, ResourceDecoder paramResourceDecoder2, Transformation paramTransformation, ResourceEncoder paramResourceEncoder, ResourceTranscoder paramResourceTranscoder, Encoder paramEncoder)
  {
    return new EngineKey(paramString, paramKey, paramInt1, paramInt2, paramResourceDecoder1, paramResourceDecoder2, paramTransformation, paramResourceEncoder, paramResourceTranscoder, paramEncoder);
  }
}
