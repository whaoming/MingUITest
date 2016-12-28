package ming.wxxiaomi.com.minguitest.ui.search;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.ui.search.baseadapter.interfaces.OnLoadMoreListener;
import ming.wxxiaomi.com.minguitest.ui.search.myrecycle.pull2refreshreview.PullToRefreshRecyclerView;

public class SearchActivity extends AppCompatActivity {
    Toolbar toolbar;
    SearchView searchView;
    PullToRefreshRecyclerView listview;
    private CommonRefreshAdapter mAdapter;
    private View header;
    private TextView header_tv;
    private boolean isAddHeader = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        searchView = (SearchView) findViewById(R.id.searchView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        header = View.inflate(this,R.layout.search_act_search_tip,null);
        header_tv = (TextView) header.findViewById(R.id.tv);
        searchView.setIconifiedByDefault(true);//设置展开后图标的样式,这里只有两种,一种图标在搜索框外,一种在搜索框内
        searchView.onActionViewExpanded();// 写上此句后searchView初始是可以点击输入的状态，如果不写，那么就需要点击下放大镜，才能出现输入框,也就是设置为ToolBar的ActionView，默认展开
        searchView.requestFocus();//输入焦点
        searchView.setFocusable(true);//将控件设置成可获取焦点状态,默认是无法获取焦点的,只有设置成true,才能获取控件的点击事件
        searchView.setIconified(false);//输入框内icon不显示
        searchView.requestFocusFromTouch();//模拟焦点点击事件


        listview = (PullToRefreshRecyclerView) findViewById(R.id.listview);
        listview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CommonRefreshAdapter(this, null, true,listview);
        mAdapter.setLoadingView(R.layout.load_loading_layout);
        //设置加载更多触发的事件监听
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
//                loadMore();
                Log.i("wang","加载更多");
            }
        });
        View emptyView = LayoutInflater.from(this).inflate(R.layout.view_list_empty, (ViewGroup) listview.getParent(), false);
        mAdapter.setEmptyView(emptyView);
//        mAdapter.setLoadingView();
        listview.setAdapter(mAdapter);
        //延时3s刷新列表
        final View reloadLayout = LayoutInflater.from(this).inflate(R.layout.view_list_reload, (ViewGroup) listview.getParent(), false);
        final View reloadBtn = reloadLayout.findViewById(R.id.load_error_tip);
        final View reloadTip = reloadLayout.findViewById(R.id.reload_tip);
             reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.setLoading();
                reloadBtn.setVisibility(View.GONE);
                reloadTip.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> data = new ArrayList<>();
                        for (int i = 0; i < 12; i++) {
                            data.add("item--" + i);
                        }
                        //刷新数据
                        mAdapter.setNewData(data);
                    }
                }, 3000);
            }
        });
        mAdapter.setReloadView(reloadLayout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                List<String> data = new ArrayList<>();
//                for (int i = 0; i < 12; i++) {
//                    data.add("item--" + i);
//                }
//                Log.i("wang","数据有啦");
//                mAdapter = new CommonRefreshAdapter()
//                mAdapter.setNewData(data);
//                mAdapter.setLoadFail();

                List<String> data = new ArrayList<>();
                for (int i = 0; i < 12; i++) {
                    data.add("item--" + i);
                }
                //刷新数据
                mAdapter.setNewData(data);
                //刷新数据
//
            }
        }, 3000);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!isAddHeader){
                    isAddHeader=!isAddHeader;
                    listview.addHeaderView(header);
                }
                header_tv.setText(newText);
                if("".equals(newText)){
                    isAddHeader=!isAddHeader;
                    listview.removeHeader();
                }
                return false;
            }
        });
    }
}
