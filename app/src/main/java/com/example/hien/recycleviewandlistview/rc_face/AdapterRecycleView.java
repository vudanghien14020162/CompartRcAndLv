package com.example.hien.recycleviewandlistview.rc_face;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hien.recycleviewandlistview.R;
import com.example.hien.recycleviewandlistview.module.ItemFace;

/**
 * Created by hien on 8/1/17.
 */

public class AdapterRecycleView extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private IFRecycleView mIF;

    public AdapterRecycleView(IFRecycleView mIF) {
        this.mIF = mIF;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_face, parent, false);

        ViewHolderFace holderFace = new ViewHolderFace(view, this);

        return holderFace;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemFace itemFace = mIF.getItemRC(position);

        ViewHolderFace viewHolderFace = (ViewHolderFace) holder;

        viewHolderFace.tvFace.setText(itemFace.getTextFace());
        viewHolderFace.imgFace.setImageResource(itemFace.getImageId());

    }

    @Override
    public int getItemCount() {
        return mIF.getSize();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_face:
                IGetPosition iGet = (IGetPosition) view.getTag();
                int position = iGet.getPosition();
                mIF.clickImage(position);
                break;
            case R.id.tv_face:
                iGet = (IGetPosition) view.getTag();
                position = iGet.getPosition();
                mIF.clickText(position);
                break;
            default:
                iGet = (IGetPosition) view.getTag();
                position = iGet.getPosition();
                mIF.clickItemView(position);
                break;
        }
    }

    private class ViewHolderFace extends RecyclerView.ViewHolder{

        private ImageView imgFace;
        private TextView tvFace;

        public ViewHolderFace(View itemView, View.OnClickListener click) {

            super(itemView);

            imgFace = itemView.findViewById(R.id.img_face);

            tvFace = itemView.findViewById(R.id.tv_face);

            IGetPosition iGet = new IGetPosition() {
                @Override
                public int getPosition() {
                    return getAdapterPosition();
                }
            };

            imgFace.setTag(iGet);
            tvFace.setTag(iGet);
            itemView.setTag(iGet);

            imgFace.setOnClickListener(click);
            tvFace.setOnClickListener(click);
            itemView.setOnClickListener(click);
        }

    }

    public interface IFRecycleView{
        int getSize();

        ItemFace getItemRC(int position);

        void clickItemView(int position);
        void clickImage(int position);
        void clickText(int position);
    }


}
