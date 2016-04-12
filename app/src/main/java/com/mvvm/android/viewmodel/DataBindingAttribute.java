package com.mvvm.android.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.mvvm.android.R;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/4/8 上午10:34
 */
@SuppressWarnings("unused")
public class DataBindingAttribute {
    private static final String TAG = DataBindingAttribute.class.getSimpleName();

    @BindingConversion
    public static String convertBindString(final BindString value) {
        Log.i(TAG, "convertBindString " + " get=" + value.get());
        return value.get();
    }

    @BindingConversion
    public static boolean convertBindBoolean(BindBoolean bindBoolean) {
        return bindBoolean.get();
    }

    @BindingAdapter({"bindEditChanged"})
    public static void bindEditTextChanged(EditText editText, final BindString value) {
        Log.i(TAG, "bindTextChanged edit:" + editText.toString() + " value=" + value.get());
        if (editText.getTag(R.id.bind_tag) == null) {
            editText.setTag(R.id.bind_tag, value);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    value.set(s.toString());
                }
            });
        }
        if (!editText.getText().toString().equals(value.toString())) {
            editText.setText(value.get());
            Selection.setSelection(editText.getText(), editText.length());
        }
    }

    @BindingAdapter({"bindCheckboxChanged"})
    public static void bindCheckboxChanged(CheckBox checkBox, final BindBoolean value) {
        Log.i(TAG, "bindCheckboxChanged edit:" + checkBox.toString() + " value" + value.get());
        if (checkBox.getTag(R.id.bind_tag) != value) {
            checkBox.setTag(R.id.bind_tag, value);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    value.set(isChecked);
                }
            });
        }
        if (checkBox.isChecked() != value.get()) {
            checkBox.setChecked(value.get());
        }
    }

    @BindingAdapter({"bindRadioChanged"})
    public static void bindRadioChanged(RadioButton radioButton, final BindBoolean value) {
        Log.i(TAG, "bindRadioChanged edit:" + radioButton.toString() + " value" + value.get());
        if (radioButton.getTag(R.id.bind_tag) != value) {
            radioButton.setTag(R.id.bind_tag, value);
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    value.set(isChecked);
                }
            });
        }
        if (radioButton.isChecked() != value.get()) {
            radioButton.setChecked(value.get());
        }
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    @BindingAdapter({"image_url","place_holder"})
    public static void imageDrawableLoad(ImageView imageView, String url, Drawable drawable) {
      Log.i(TAG, "image drawable load :" + imageView.toString()
              + " url = " + url + " drawable=" + drawable );
        imageView.setImageResource(R.drawable.img_splash_background);
    }

    @BindingAdapter({"image_url"})
    public static void imageLoad(ImageView imageView, String url) {
        Log.i(TAG, "image load :" + imageView.toString() + " url = " + url);
    }
}
