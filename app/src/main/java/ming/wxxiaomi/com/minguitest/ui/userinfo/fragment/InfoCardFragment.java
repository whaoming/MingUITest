package ming.wxxiaomi.com.minguitest.ui.userinfo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.ui.userinfo.pull2refreshreview.PullToRefreshRecyclerView;
import ming.wxxiaomi.com.minguitest.ui.userinfo.pull2refreshreview.footer.DefaultLoadMoreView;

/**
 * Created by Administrator on 2016/12/22.
 */

public class InfoCardFragment extends Fragment {
    private View view;
    private PullToRefreshRecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_card,container,false);
        mRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.mRecyclerView);
        initRefreshView();
        return view;
    }

    private void initRefreshView() {
        View header = View.inflate(getActivity(), R.layout.header_infocard, null);

        mRecyclerView.setSwipeEnable(false);
        mRecyclerView.setRefreshing(false);
        DefaultLoadMoreView defaultLoadMoreView = new DefaultLoadMoreView(getActivity(), mRecyclerView.getRecyclerView());
        defaultLoadMoreView.setLoadmoreString("加载更多");
        defaultLoadMoreView.setLoadMorePadding(100);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addHeaderView(header);
        mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                Log.i("wang", "onLoadMoreItems");
            }
        });
        mRecyclerView.setLoadMoreFooter(defaultLoadMoreView);
//        mRecyclerView.setRefreshing(true);
        ;
        mRecyclerView.setEmptyView(View.inflate(getActivity(), R.layout.item, null));
//        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
//            @Override
//            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                view = View.inflate(parent.getContext(), R.layout.item, null);
//                return new MyViewHolderv(view);
//            }
//
//            @Override
//            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//            }
//
//            @Override
//            public int getItemCount() {
//                return 15;
//            }
//        });
    }

    public class MyViewHolderv extends RecyclerView.ViewHolder{

        public MyViewHolderv(View itemView) {
            super(itemView);
        }
    }
}
