package page.teste.scroller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import page.teste.scroller.details.CourseDetailActivity;

/**
 * Created by Dreamz on 30-08-2018.
 */

public class HorizontalRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mDataList;
    private int mRowIndex = -1;
    Context mContext;
    public HorizontalRVAdapter() {

    }

    public void setData(List<String> data) {
        if (mDataList != data) {
            mDataList = data;
            notifyDataSetChanged();
        }
    }

    public void setRowIndex(int index) {
        mRowIndex = index;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public ItemViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.horizontal_item_text);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        mContext = context;
        View itemView = LayoutInflater.from(context).inflate(R.layout.courses_horizontal_item, parent, false);
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder rawHolder, int position) {
        ItemViewHolder holder = (ItemViewHolder) rawHolder;
        holder.text.setText(mDataList.get(position));
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContext!=null) {
                    mContext.startActivity(new Intent(mContext, CourseDetailActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}