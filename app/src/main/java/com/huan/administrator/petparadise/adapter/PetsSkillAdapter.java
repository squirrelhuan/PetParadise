package com.huan.administrator.petparadise.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.huan.administrator.petparadise.R;
import com.huan.administrator.petparadise.bean.PetSkill;
import com.huan.administrator.petparadise.utils.FileUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public class PetsSkillAdapter extends BaseAdapter {

    List<PetSkill> mList;
    Context mContext;
    LayoutInflater mInflater;

    public PetsSkillAdapter(Context mContext, List<PetSkill> list_map) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mList = list_map;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder=new ViewHolder();

            convertView = mInflater.inflate(R.layout.item_pet_head, null);
            viewHolder.iv_head = (ImageView) convertView.findViewById(R.id.iv_head);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        PetSkill petSkill = mList.get(position);
        String petHeadName = "petskill/"+petSkill.getHeadImage();
        viewHolder.iv_head.setImageDrawable(FileUtils.loadImageFromAsserts(petHeadName));

        BitmapDrawable bitmapDrawable = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.ui_set_01);
        //BitmapDrawable bitmapDrawable=(BitmapDrawable)imageview1.getDrawable();
        int x = 1686,y = 495,width = 100,height = 100;
        Bitmap bitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap(),x,y,width,height);
        Drawable drawable = new BitmapDrawable(bitmap);
        viewHolder.iv_head.setBackgroundDrawable(drawable);

        return convertView;
    }

    class ViewHolder {
        ImageView iv_head;
    }
}
