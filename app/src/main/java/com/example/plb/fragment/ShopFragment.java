package com.example.plb.fragment;

import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.example.plb.activity.DetailsActivity;
import com.example.plb.R;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhc on 2018/12/27.
 * 店铺
 */
public class ShopFragment extends Fragment{

    private View view;
    private Button button;
    private ListView listView;
    private ArrayAdapter<String> mAdapter;
    private List<String> datas= Arrays.asList("1号门店","2号门店","3号门店","4号门店","5号门店","6号门店","7号门店",
            "8号门店","9号门店","10号门店","11号门店");

    public static int mPosition;
    //gridview
    private GridView gridView;
    private List<Map<String,Object>> dataList;
    private SimpleAdapter simpleAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop,null);
        //跳转到详情页
        button = view.findViewById ( R.id.btntest );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getActivity (),DetailsActivity.class );
                startActivity ( intent );
            }
        } );
        listView=view.findViewById(R.id.list_view);
        mAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*if(position==0){
                    Toast.makeText(getContext(),"123", Toast.LENGTH_LONG).show();
                }*/
                String data = datas.get(position);
                Toast.makeText(getContext(),data, Toast.LENGTH_LONG).show();

            }
        });

        init();
        String[] from={"img","text"};
        int[] to={R.id.img,R.id.texts};
        simpleAdapter=new SimpleAdapter(getContext(),dataList,R.layout.gridview_item,from,to);
        gridView=view.findViewById(R.id.gridView);
        gridView.setAdapter(simpleAdapter);


        //


        return view;
    }

    public void init(){
        int icno[]={R.mipmap.bg,R.mipmap.bg,R.mipmap.bg,R.mipmap.bg,R.mipmap.bg,R.mipmap.bg};
        String name[]={"AD钙","霸王牛筋","方便面","火腿肠","阿尔卑斯","巧克力"};
        dataList=new ArrayList<Map<String, Object>>();
        for (int i=0;i<icno.length;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("img",icno[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
    }



}
