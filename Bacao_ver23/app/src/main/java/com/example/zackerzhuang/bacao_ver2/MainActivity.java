package com.example.zackerzhuang.bacao_ver2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import adapter.RecommendAdapater;
import helper.BottomNavigationViewHelper;
import model.Recommend;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private LinearLayout mLinearLayout;//对应于主布局中用来添加子布局的View
    private LinearLayout homeLayout;
    private View mGridView;// 子Layout要以view的形式加入到主Layout
    private Recommend[] recommends = {

            new Recommend("no1",R.drawable.img_20170215_125705),
            new Recommend("no2",R.drawable.img_20170401_162424),
            new Recommend("no3",R.drawable.img_20170401_191300),
            new Recommend("no4",R.drawable.img_20170527_193055),
            new Recommend("no5",R.drawable.img_20170715_115004),
            new Recommend("no6",R.drawable.img_20170715_144649),
            new Recommend("no7",R.drawable.img_20170710_201224),
            new Recommend("no8",R.drawable.img_20170527_214631),
            new Recommend("no9",R.drawable.img_20170527_214631),

    };//设置推荐路线的card
    private List<Recommend> recommendList= new ArrayList<>();
    private RecommendAdapater recommendAdapater;


    private void initRecommend(){
        recommendList.clear();
        for(int i = 0;i < 100;i++){
            Random random = new Random();
            int index = random.nextInt(recommends.length);
            recommendList.add(recommends[index]);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //todo：优化此处，每次点击的时候保存上次的浏览位置！
                    if(mLinearLayout!=null)
                        mLinearLayout.removeAllViews();
                    mGridView = View.inflate(getApplicationContext(),R.layout.recommend_recyclerview,null);
                    mLinearLayout = (LinearLayout)findViewById(R.id.box);
                    mLinearLayout.addView(mGridView);
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recommend_recycler_view);
                    GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
                    recommendAdapater=new RecommendAdapater(recommendList);
                    recyclerView.setAdapter(recommendAdapater);
                    recyclerView.setLayoutManager(layoutManager);
                    return true;
                case R.id.navigation_destination:
                    if(mLinearLayout!=null)
                        mLinearLayout.removeAllViews();
                    return true;
                case R.id.navigation_shop:
                    if(mLinearLayout!=null)
                        mLinearLayout.removeAllViews();
                    return true;
                case R.id.navigation_find:
                    if(mLinearLayout!=null)
                        mLinearLayout.removeAllViews();
                    return true;
                case R.id.navigation_me:
                    if(mLinearLayout!=null)
                        mLinearLayout.removeAllViews();
                    return true;
            }
            return false;
        }

    };

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbal);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initRecommend();
        mGridView = View.inflate(getApplicationContext(),R.layout.recommend_recyclerview,null);
        mLinearLayout = (LinearLayout)findViewById(R.id.box);
        mLinearLayout.addView(mGridView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recommend_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recommendAdapater=new RecommendAdapater(recommendList);
        recyclerView.setAdapter(recommendAdapater);
        recyclerView.setLayoutManager(layoutManager);


/*        mGridView = View.inflate(this,R.layout.recommend_recyclerview,null);
        mLinearLayout = (LinearLayout)findViewById(R.id.box);
        mLinearLayout.addView(mGridView);
        initRecommend();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recommend_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recommendAdapater=new RecommendAdapater(recommendList);
        recyclerView.setAdapter(recommendAdapater);
        recyclerView.setLayoutManager(layoutManager);*/


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.search_button:
                Search_activity.actionStart(getApplicationContext());
                Toast.makeText(MainActivity.this,"search",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
