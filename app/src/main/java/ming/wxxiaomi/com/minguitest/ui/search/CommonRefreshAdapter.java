package ming.wxxiaomi.com.minguitest.ui.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.ui.search.baseadapter.ViewHolder;
import ming.wxxiaomi.com.minguitest.ui.search.baseadapter.base.BaseAdapter;
import ming.wxxiaomi.com.minguitest.ui.search.baseadapter.base.CommonBaseAdapter;
import ming.wxxiaomi.com.minguitest.ui.search.myrecycle.pull2refreshreview.PullToRefreshRecyclerView;

/**
 * Author: Othershe
 * Time: 2016/8/29 15:40
 */
public class CommonRefreshAdapter extends CommonBaseAdapter<String> {
    PullToRefreshRecyclerView listview;
    public CommonRefreshAdapter(Context context, List<String> datas, boolean isLoadMore,PullToRefreshRecyclerView listview) {
        super(context, datas, isLoadMore);
        this.listview = listview;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        if(viewType== BaseAdapter.TYPE_LOADING_VIEW){
            listview.setRefreshing(true);
        }else{
            listview.setRefreshing(false);
            super.onBindViewHolder(holder, position);
        }

    }

    @Override
    protected void convert(ViewHolder holder, final String data) {
        holder.setText(R.id.item_title, data);
        holder.setOnClickListener(R.id.item_btn, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "我是" + data + "的button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_layout;
    }
}
