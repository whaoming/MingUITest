package ming.wxxiaomi.com.minguitest.ui.userinfo;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.ui.userinfo.adapter.IndexFragmentTabAdapter;
import ming.wxxiaomi.com.minguitest.ui.userinfo.fragment.InfoCardFragment;
import ming.wxxiaomi.com.minguitest.ui.userinfo.fragment.InfoDetailFragment;

public class UserInfoActivity extends AppCompatActivity {

    List<Fragment> fragments;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private List<String> titles;
    private IndexFragmentTabAdapter fAdapter;
    private CollapsingToolbarLayout collapsing_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);
        tabLayout = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);
        toolbar = (Toolbar) this.findViewById(R.id.toolbar1);
        toolbar.setTitle("wang");
        collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitleEnabled(false);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragments = new ArrayList<Fragment>();
        fragments.add(new InfoCardFragment());
        fragments.add(new InfoDetailFragment());
        titles = new ArrayList<String>();
        titles.add("个人主页");
        titles.add("详细信息");
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        fAdapter = new IndexFragmentTabAdapter(getSupportFragmentManager(),
                fragments, titles);
        viewPager.setAdapter(fAdapter);
        viewPager.requestDisallowInterceptTouchEvent(true);
        tabLayout.setupWithViewPager(viewPager);

    }
}
