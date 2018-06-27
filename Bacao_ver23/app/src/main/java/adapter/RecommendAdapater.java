package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zackerzhuang.bacao_ver2.ContentActivity;
import com.example.zackerzhuang.bacao_ver2.R;

import java.util.List;

import model.Recommend;

/**
 * Created by zackerzhuang on 2018/6/12.
 */

public class RecommendAdapater extends RecyclerView.Adapter<RecommendAdapater.ViewHolder> {
    private Context mContext;
    private List<Recommend> recommendList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            imageView = (ImageView) view.findViewById(R.id.recommend_image);
            textView = (TextView) view.findViewById(R.id.recommend_name);
        }

    }



    public RecommendAdapater(List<Recommend> list){
        recommendList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.recommend_item,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Recommend recommend = recommendList.get(position);
                Intent intent = new Intent(mContext, ContentActivity.class);
                intent.putExtra(ContentActivity.CONTENT_TITLE,recommend.getName());
                intent.putExtra(ContentActivity.CONTENT_IMAGE_ID,recommend.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Recommend recommend = recommendList.get(position);
        holder.textView.setText(recommend.getName());
        Glide.with(mContext).load(recommend.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount(){
        return recommendList.size();
    }
}
