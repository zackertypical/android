package com.example.zackerzhuang.bacao_ver2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ContentActivity extends BaseActivity {


    public static final String CONTENT_TITLE = "content_title";
    public static final String CONTENT_IMAGE_ID = "content_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Intent intent = getIntent();
        String contentname = intent.getStringExtra(CONTENT_TITLE);
        int contentId = intent.getIntExtra(CONTENT_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbal);
        CollapsingToolbarLayout collapsingTool= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.content_image_view);
        TextView textView = (TextView) findViewById(R.id.content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingTool.setTitle(contentname);
        Glide.with(this).load(contentId).into(imageView);
        String contentText = generateContent(contentname);
        textView.setText(contentText);
    }


    private String generateContent(String name){
        StringBuilder content = new StringBuilder();
        for (int i = 0;i < 500;i++){
            content.append(name);
        }
        return content.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
