package com.huan.administrator.petparadise.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.huan.administrator.petparadise.R;

/**
 * Created by Administrator on 2017/3/19 0019.
 */

public class ImageUtils {


    public static void getImagePart(Context context) {

    BitmapDrawable bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(R.drawable.ui_set_01);
    //BitmapDrawable bitmapDrawable=(BitmapDrawable)imageview1.getDrawable();
    int x = 1686, y = 495, width = 100, height = 100;
    Bitmap bitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap(), x, y, width, height);
    Drawable drawable = new BitmapDrawable(bitmap);
}

}
