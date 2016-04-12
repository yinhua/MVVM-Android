package com.mvvm.android.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.mvvm.android.view.adapter.RecyclerAdapter;
import com.mvvm.android.viewmodel.bind.BindBoolean;
import com.mvvm.android.viewmodel.bind.BindString;
import com.mvvm.android.viewmodel.bind.BindTypeValue;

import java.util.List;

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

    @BindingAdapter({"bindAdapter"})
    public static void bindAdapter(RecyclerView recyclerView, RecyclerAdapter adapter) {
        List<BindTypeValue> bindListType = (List<BindTypeValue>) recyclerView.getTag(R.id.bind_tag);
        if (bindListType != null) {
            addDataToAdapter(bindListType, adapter);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()
                , LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"bindItems"})
    public static void bindItems(RecyclerView recyclerView , List<BindTypeValue> items) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        assert (adapter instanceof RecyclerAdapter);
        if (adapter != null) {
            RecyclerAdapter recyclerAdapter = (RecyclerAdapter) adapter;
            addDataToAdapter(items, recyclerAdapter);
            recyclerAdapter.notifyDataSetChanged();
        } else {
            recyclerView.setTag(R.id.bind_tag, items);
        }
    }

    private static void addDataToAdapter(List<BindTypeValue> items
            , RecyclerAdapter recyclerAdapter) {
        for (BindTypeValue bindTypeValue : items) {
            List valueList = bindTypeValue.getList();
            if (valueList != null) {
                recyclerAdapter.addDataList(valueList, bindTypeValue.getViewType());
            } else {
                recyclerAdapter.addData(bindTypeValue.get(), bindTypeValue.getViewType());
            }
        }
    }

    @BindingAdapter({"bindLayoutManager"})
    public static void bindLayoutManager(RecyclerView recyclerView
            , RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

}
