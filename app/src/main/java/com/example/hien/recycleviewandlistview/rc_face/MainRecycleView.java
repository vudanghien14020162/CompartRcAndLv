package com.example.hien.recycleviewandlistview.rc_face;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.hien.recycleviewandlistview.R;
import com.example.hien.recycleviewandlistview.module.ItemFace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hien on 8/1/17.
 */

public class MainRecycleView extends AppCompatActivity implements AdapterRecycleView.IFRecycleView {

    private RecyclerView rcFace;
    private List<ItemFace> listItem;
    private AdapterRecycleView mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rc_layout);

        findViewByIds();

        initData();
        initComponents();
        setEvents();
    }

    private void initData() {
        listItem = new ArrayList<>();

        listItem.add(new ItemFace(R.drawable.beauty, "Beauty"));
        listItem.add(new ItemFace(R.drawable.boss, "Boss"));
        listItem.add(new ItemFace(R.drawable.doubt, "Doubt"));
        listItem.add(new ItemFace(R.drawable.choler, "Choler"));
        listItem.add(new ItemFace(R.drawable.love, "Love"));
        listItem.add(new ItemFace(R.drawable.too_sad, "Sad"));
        listItem.add(new ItemFace(R.drawable.dribble, "Dribble"));
        listItem.add(new ItemFace(R.drawable.what, "What"));
        listItem.add(new ItemFace(R.drawable.oh, "Oh"));
        listItem.add(new ItemFace(R.drawable.met, "Met"));
        listItem.add(new ItemFace(R.drawable.nhan, "Nhan"));
        listItem.add(new ItemFace(R.drawable.feel_good, "Feel good"));
        listItem.add(new ItemFace(R.drawable.presence_offline, "Presence"));
        listItem.add(new ItemFace(R.drawable.xanh, "Xanh"));


    }

    private void setEvents() {

    }

    private void initComponents() {
        mAdapter = new AdapterRecycleView(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        manager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        chieu ngang
////        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

//        //dang luoi chieu ngang
//        GridLayoutManager manager = new GridLayoutManager(this, 3,
//                LinearLayoutManager.HORIZONTAL, true);

//        //dang luoi duoi dang doc
//        GridLayoutManager manager = new GridLayoutManager(this, 2,
//                LinearLayoutManager.VERTICAL, true);

//        StaggeredGridLayoutManager manager =
//                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

//        StaggeredGridLayoutManager manager =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);

        rcFace.setLayoutManager(manager);
        rcFace.setAdapter(mAdapter);
    }

    private void findViewByIds() {

        rcFace = (RecyclerView) findViewById(R.id.rc_face);

    }

    @Override
    public int getSize() {
        return listItem.size();
    }

    @Override
    public ItemFace getItemRC(int position) {
        return listItem.get(position);
    }

    @Override
    public void clickItemView(int position) {


        String textFace = listItem.get(position).getTextFace();

        showMess("Click Item___" + textFace);

    }

    @Override
    public void clickImage(int position) {
        String textFace = listItem.get(position).getTextFace();
        showMess("Oh. Click Image!!" + textFace);
    }

    @Override
    public void clickText(int position) {

        String textFace = listItem.get(position).getTextFace();
        showMess("OZE. Click Text_" + textFace);


    }

    private void showMess(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
