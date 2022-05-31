package net.fred.feedex.widget;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

public class ColorPickerDialogPreference
  extends DialogPreference
{
  private SeekBar a;
  private SeekBar b;
  private SeekBar c;
  private SeekBar d;
  private int e = 2080374784;
  
  public ColorPickerDialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected View onCreateDialogView()
  {
    View localView = super.onCreateDialogView();
    localView.setBackgroundColor(this.e);
    this.a = ((SeekBar)localView.findViewById(2131689577));
    this.b = ((SeekBar)localView.findViewById(2131689578));
    this.c = ((SeekBar)localView.findViewById(2131689579));
    this.d = ((SeekBar)localView.findViewById(2131689580));
    int i = this.e;
    this.d.setProgress(i / 16777216 * 100 / 255);
    i %= 16777216;
    this.a.setProgress(i / 65536 * 100 / 255);
    i %= 65536;
    this.b.setProgress(i / 256 * 100 / 255);
    this.c.setProgress(i % 256 * 100 / 255);
    ColorPickerDialogPreference.1 local1 = new ColorPickerDialogPreference.1(this, localView);
    this.a.setOnSeekBarChangeListener(local1);
    this.b.setOnSeekBarChangeListener(local1);
    this.c.setOnSeekBarChangeListener(local1);
    this.d.setOnSeekBarChangeListener(local1);
    return localView;
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    if (paramBoolean) {
      persistInt(this.e);
    }
    super.onDialogClosed(paramBoolean);
  }
}
