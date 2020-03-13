package com.example.day02_2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xts.greendaodemo.db.BeanDao;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private List<User.ResultsBean> list;
    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public RvAdapter(Context context, List<User.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_one, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, final int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        Glide.with(context).load(list.get(position).getUrl()).into(viewHolder.imagePath);
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeanDao beanDao = BaseApp.getInstance().getDaoSession().getBeanDao();
                beanDao.insertOrReplaceInTx(new Bean(null,list.get(position).getUrl(),list.get(position).getCheck()));
                Log.i("111", "onClick: 成功");
//                btn.setText("取消收藏");
            }
        });
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (mOnItemClickListener!=null)
              mOnItemClickListener.onItemClickListener(position);
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePath;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePath  = itemView.findViewById(R.id.imagePath);
            btn  = itemView.findViewById(R.id.btn);

        }
    }
    interface OnItemClickListener{
        void onItemClickListener(int position);
    }
}
