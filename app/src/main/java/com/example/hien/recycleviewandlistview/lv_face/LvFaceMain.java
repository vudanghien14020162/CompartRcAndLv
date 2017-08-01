package com.example.hien.recycleviewandlistview.lv_face;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hien.recycleviewandlistview.R;
import com.example.hien.recycleviewandlistview.module.ItemFace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hien on 8/1/17.
 */

public class LvFaceMain extends AppCompatActivity implements LvAdapter.ILvAdapter, AdapterView.OnItemClickListener {

    private ListView lvFace;

    private List<ItemFace> listItem;

    private LvAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lv_face);

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

        mAdapter = new LvAdapter(this);

        lvFace.setAdapter(mAdapter);

        lvFace.setOnItemClickListener(this);

    }

    private void findViewByIds() {

        lvFace = (ListView) findViewById(R.id.lv_face);

    }

    @Override
    public int getSizeLv() {
        return listItem.size();
    }

    @Override
    public ItemFace getItemLv(int position) {
        return listItem.get(position);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view,
                            int i, long l) {

        ItemFace itemFace = listItem.get(i);
        String nameFace = itemFace.getTextFace();

        showMsg("Click: " + nameFace);


    }

    private void showMsg(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
