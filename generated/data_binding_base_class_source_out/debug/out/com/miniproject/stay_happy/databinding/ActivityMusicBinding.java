// Generated by view binder compiler. Do not edit!
package com.miniproject.stay_happy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.miniproject.stay_happy.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMusicBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageButton btnBm;

  @NonNull
  public final ImageButton btnCmp;

  @NonNull
  public final ImageButton btnHaps;

  @NonNull
  public final ImageButton btnLya;

  @NonNull
  public final ImageButton btnRt;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private ActivityMusicBinding(@NonNull ScrollView rootView, @NonNull ImageButton btnBm,
      @NonNull ImageButton btnCmp, @NonNull ImageButton btnHaps, @NonNull ImageButton btnLya,
      @NonNull ImageButton btnRt, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.btnBm = btnBm;
    this.btnCmp = btnCmp;
    this.btnHaps = btnHaps;
    this.btnLya = btnLya;
    this.btnRt = btnRt;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMusicBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMusicBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_music, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMusicBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_bm;
      ImageButton btnBm = ViewBindings.findChildViewById(rootView, id);
      if (btnBm == null) {
        break missingId;
      }

      id = R.id.btn_cmp;
      ImageButton btnCmp = ViewBindings.findChildViewById(rootView, id);
      if (btnCmp == null) {
        break missingId;
      }

      id = R.id.btn_haps;
      ImageButton btnHaps = ViewBindings.findChildViewById(rootView, id);
      if (btnHaps == null) {
        break missingId;
      }

      id = R.id.btn_lya;
      ImageButton btnLya = ViewBindings.findChildViewById(rootView, id);
      if (btnLya == null) {
        break missingId;
      }

      id = R.id.btn_rt;
      ImageButton btnRt = ViewBindings.findChildViewById(rootView, id);
      if (btnRt == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityMusicBinding((ScrollView) rootView, btnBm, btnCmp, btnHaps, btnLya, btnRt,
          linearLayout, linearLayout2, textView3, textView4, textView7, textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
