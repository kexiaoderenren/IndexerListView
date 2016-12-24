package com.test.kexiaoderenren.indexerlistview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.kexiaoderenren.indexerlistview.adapter.CategoryAdapter;
import com.test.kexiaoderenren.indexerlistview.adapter.IndexerAdapter;
import com.test.kexiaoderenren.indexerlistview.model.CategoryItemVo;
import com.test.kexiaoderenren.indexerlistview.model.CategoryVo;
import com.test.kexiaoderenren.indexerlistview.widget.IRecyclerItemClickListener;
import com.test.kexiaoderenren.indexerlistview.widget.recyclerview.DefaultDividerItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IRecyclerItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerIndexer,recyclerMain;
    private IndexerAdapter indexerAdapter;
    private CategoryAdapter categoryAdapter;
    private List<CategoryVo> lists;
    private List<CategoryItemVo> itemLists;
    private List<String> testGoodsShowingList;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }




    private void init() {
        lists = new ArrayList<>();
        itemLists = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(itemLists, this);
        indexerAdapter = new IndexerAdapter(lists, this);
        indexerAdapter.setItemClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerIndexer.setLayoutManager(new LinearLayoutManager(this));
        recyclerIndexer.addItemDecoration(new DefaultDividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerIndexer.setAdapter(indexerAdapter);

        recyclerMain.setLayoutManager(new LinearLayoutManager(this));
        recyclerMain.addItemDecoration(new DefaultDividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerMain.setAdapter(categoryAdapter);
        getData();
    }

    private void initView() {
        recyclerIndexer = (RecyclerView) findViewById(R.id.recyclerview_indexer);
        recyclerMain = (RecyclerView) findViewById(R.id.recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
    }

    @Override
    public void onItemClickListener(int position, View view) {
        switch (view.getId()) {
            case R.id.tv_text:
                if (indexerAdapter == null || lists == null || position >= lists.size()) { return; }
                indexerAdapter.changeCategoryChoice(view, position);
                itemLists.clear();
                //根据左侧标签索引，显示对应数据
                if (lists.get(position).getCat_list() != null || lists.get(position).getCat_list().size() > 0) {
                    //itemLists.addAll(lists.get(position).getCat_list());

                    CategoryItemVo categoryItemVo1 = new CategoryItemVo();
                    CategoryItemVo categoryItemVo2 = new CategoryItemVo();
                    CategoryItemVo categoryItemVo3 = new CategoryItemVo();
                    CategoryItemVo categoryItemVo4 = new CategoryItemVo();
                    CategoryItemVo categoryItemVo5 = new CategoryItemVo();
                    CategoryItemVo categoryItemVo6 = new CategoryItemVo();
                    categoryItemVo1.viewType = 0;
                    categoryItemVo1.lists = testGoodsShowingList;
                    categoryItemVo2.viewType = 1;
                    categoryItemVo2.lists = testGoodsShowingList;

                    categoryItemVo3.viewType = 1;
                    categoryItemVo3.lists = testGoodsShowingList;
                    categoryItemVo4.viewType = 2;
                    categoryItemVo4.lists = testGoodsShowingList;
                    categoryItemVo5.viewType = 2;
                    categoryItemVo5.lists = testGoodsShowingList;
                    categoryItemVo6.viewType = 1;
                    categoryItemVo6.lists = testGoodsShowingList;


                    itemLists.add(categoryItemVo1);
                    itemLists.add(categoryItemVo2);
                    itemLists.add(categoryItemVo3);
                    itemLists.add(categoryItemVo4);
                    itemLists.add(categoryItemVo5);
                    itemLists.add(categoryItemVo6);
                    categoryAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.img_ads:
                break;
        }

    }

    /**
     * 获取测试数据
     */
    private void getData() {
        testGoodsShowingList = new ArrayList<>();
        testGoodsShowingList.addAll(Arrays.asList(new String[]{"葡萄酒", "红葡萄酒", "长相思","1-199元","200-299元"}));
        String testData = "{\"code\":\"0\",\"message\":\"ok\",\"result\":{\"list\":[{\"cat_id\":0,\"cat_name\":\"\\u4e00\\u952e\\u9009\\u9152\",\"cat_type\":\"tag\",\"cat_list\":[{\"id\":47,\"cat_name\":\"\\u65b0\\u4eba\\u63a8\\u8350\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/01\\/fl\\/1-0000.jpg\"},{\"id\":74,\"cat_name\":\"\\u9001\\u793c\\u7cbe\\u9009\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/1\\/1-1.jpg\"},{\"id\":66,\"cat_name\":\"\\u54c1\\u724c\\u4e13\\u533a\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/1\\/1-10.jpg\"},{\"id\":113,\"cat_name\":\"\\u4e2d\\u7ea7\\u9152\\u5e84\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/01\\/fl\\/1-00000.jpg\"},{\"id\":71,\"cat_name\":\"\\u540d\\u5e84\\u4e13\\u533a\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/1\\/1-9.jpg\"},{\"id\":20,\"cat_name\":\"\\u5973\\u58eb\\u4e13\\u533a\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/1\\/1-6.jpg\"},{\"id\":34,\"cat_name\":\"\\u6574\\u7bb1\\u805a\\u4f1a\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/1\\/1-4.jpg\"},{\"id\":39,\"cat_name\":\"\\u5a5a\\u5e86\\u7528\\u9152\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/1\\/1-3.jpg\"}],\"prom_list\":[]},{\"cat_id\":72,\"cat_name\":\"\\u8461\\u8404\\u9152\",\"cat_type\":\"attrs\",\"cat_list\":[{\"id\":\"217-1\",\"cat_name\":\"\\u7ea2\\u8461\\u8404\\u9152\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/2\\/2-5.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/2\\/2-5.jpg\"},{\"id\":\"217-2\",\"cat_name\":\"\\u767d\\u8461\\u8404\\u9152\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/2\\/2-6.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/2\\/2-6.jpg\"},{\"id\":\"217-3\",\"cat_name\":\"\\u6843\\u7ea2\\u8461\\u8404\\u9152\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/2\\/2-7.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/2\\/2-7.jpg\"},{\"id\":\"217-5\",\"cat_name\":\"\\u8d77\\u6ce1\\u9152\\/\\u9999\\u69df\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/2\\/2-8.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/2\\/2-8.jpg\"},{\"id\":\"217-6\",\"cat_name\":\"\\u51b0\\u9152\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/2\\/2-9.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/2\\/2-9.jpg\"}],\"prom_list\":[]},{\"cat_id\":75,\"cat_name\":\"\\u5564\\u9152\",\"cat_type\":\"tag\",\"cat_list\":[{\"id\":105,\"cat_name\":\"8\\u542c\\u88c5\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/04\\/app\\/8t.png\"},{\"id\":107,\"cat_name\":\"12\\u542c\\u88c5\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/01\\/fl\\/p-22.jpg\"},{\"id\":106,\"cat_name\":\"24\\u542c\\u88c5\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/01\\/fl\\/p-33.jpg\"},{\"id\":108,\"cat_name\":\"5L\\u88c5\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/01\\/fl\\/p-44.jpg\"},{\"id\":114,\"cat_name\":\"\\u5c0f\\u9ea6\\u5564\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/04\\/app\\/xmp.png\"},{\"id\":115,\"cat_name\":\"\\u9ed1\\u5564\",\"cat_img\":\"\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2016\\/04\\/app\\/hp.png\"}]},{\"cat_id\":200,\"cat_name\":\"\\u9152\\u5177\",\"cat_type\":\"cat\",\"cat_list\":[{\"id\":370,\"cat_name\":\"\\u9152\\u676f\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/5\\/5-1.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/5\\/5-1.jpg\"},{\"id\":376,\"cat_name\":\"\\u9152\\u67dc\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/5\\/5-2.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/5\\/5-2.jpg\"},{\"id\":373,\"cat_name\":\"\\u9152\\u5200\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/5\\/5-3.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/5\\/5-3.jpg\"},{\"id\":198,\"cat_name\":\"\\u793c\\u76d2\",\"cat_img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/07\\/app\\/5\\/5-4.jpg\",\"img\":\"http:\\/\\/image13.wine9.com\\/activity\\/2015\\/08\\/app1\\/5\\/5-4.jpg\"}]}]}}";
        try {
            JSONArray jsonResult = new JSONObject(testData).getJSONObject("result").getJSONArray("list");
            if (jsonResult != null && jsonResult.length() > 0) {
                List<CategoryVo> ps = new Gson().fromJson(jsonResult.toString(), new TypeToken<List<CategoryVo>>(){}.getType());
                lists.addAll(ps);
                indexerAdapter.notifyDataSetChanged();
                categoryAdapter.notifyDataSetChanged();
                //默认显示将第一个标签
                if (lists.size() > 0 && lists.get(0).getCat_list() != null) {
                    itemLists.addAll(lists.get(0).getCat_list());
                    categoryAdapter.notifyDataSetChanged();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 500);

    }
}
