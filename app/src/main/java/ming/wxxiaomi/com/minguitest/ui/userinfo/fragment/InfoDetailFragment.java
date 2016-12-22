package ming.wxxiaomi.com.minguitest.ui.userinfo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.ui.userinfo.pull2refreshreview.PullToRefreshRecyclerView;

/**
 * Created by Administrator on 2016/12/22.
 */

public class InfoDetailFragment extends Fragment {
    private View view;
    private PullToRefreshRecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_detail,container,false);
//        mRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.mRecyclerView);
////        initRefreshView();
//        mRecyclerView.setRefreshing(false);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setNestedScrollingEnabled(true);
        return view;
    }
}
