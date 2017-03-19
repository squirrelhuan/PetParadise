package com.huan.administrator.petparadise.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huan.administrator.petparadise.R;
import com.huan.administrator.petparadise.bean.Pet;
import com.huan.administrator.petparadise.utils.FileUtils;
import com.huan.administrator.petparadise.utils.PetUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public class PetsAdapter extends BaseAdapter {

    List<Pet> mList;
    Context mContext;
    LayoutInflater mInflater;

    public PetsAdapter(Context mContext, List<Pet> list_map) {
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

        Pet pet = mList.get(position);
        String petHeadName = "pet/"+pet.getHeadImage();
        viewHolder.iv_head.setImageDrawable(FileUtils.loadImageFromAsserts(petHeadName));

        return convertView;
    }

    class ViewHolder {
        ImageView iv_head;
    }
}
