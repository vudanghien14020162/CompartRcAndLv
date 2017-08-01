package com.example.hien.recycleviewandlistview.lv_face;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hien.recycleviewandlistview.R;
import com.example.hien.recycleviewandlistview.module.ItemFace;

/**
 * Created by hien on 8/1/17.
 */

public class LvAdapter extends BaseAdapter {

    private ILvAdapter mAdapter;

    public LvAdapter(ILvAdapter mAdapter) {

        this.mAdapter = mAdapter;
    }


    @Override
    public int getCount() {
        return mAdapter.getSizeLv();
    }

    @Override
    public Object getItem(int i) {
        return mAdapter.getItemLv(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewLVHolder viewLVHolder;

        if(view == null){

            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.item_face, viewGroup, false);

            viewLVHolder = new ViewLVHolder();

            viewLVHolder.imgFace = view.findViewById(R.id.img_face);
            viewLVHolder.tvFace = view.findViewById(R.id.tv_face);

            view.setTag(viewLVHolder);

        }else {

            viewLVHolder = (ViewLVHolder) view.getTag();

        }

        ItemFace itemFace = mAdapter.getItemLv(i);

        viewLVHolder.tvFace.setText(itemFace.getTextFace());

        viewLVHolder.imgFace.setImageResource(itemFace.getImageId());


        return view;
    }

    private class ViewLVHolder{
        private TextView tvFace;
        private ImageView imgFace;

        public ViewLVHolder() {

        }

    }

    public interface ILvAdapter{

        int getSizeLv();

        ItemFace getItemLv(int position);

    }
}
