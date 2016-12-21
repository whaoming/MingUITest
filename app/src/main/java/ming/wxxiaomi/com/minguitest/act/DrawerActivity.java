package ming.wxxiaomi.com.minguitest.act;

import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.weight.MsgActionProvider;


public class DrawerActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    private LinearLayout drawer;
    private DrawerLayout mDrawerLayout;
    private ImageView iv;
    private MsgActionProvider mActionProvider2;
    private MsgActionProvider mActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("");
//        toolbar.setNavigationIcon();
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true); // 设置返回键可用
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = (LinearLayout) findViewById(R.id.drawer);
//        drawer.setOnClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(this);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                mDrawerLayout.openDrawer(Gravity.LEFT);
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_pic);
        mActionProvider = (MsgActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mActionProvider.setOnClickListener(0, new MsgActionProvider.OnClickListener() {
            @Override
            public void onClick(int what) {

            }
        });// 设置点击监听。

        MenuItem menuItem2 = menu.findItem(R.id.menu_pic2);
        mActionProvider2 = (MsgActionProvider) MenuItemCompat.getActionProvider(menuItem2);
        mActionProvider2.setOnClickListener(0, new MsgActionProvider.OnClickListener() {
            @Override
            public void onClick(int what) {

            }
        });
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mActionProvider.setIcon(R.mipmap.ic_delete_white_24dp);
        mActionProvider.setBadge(0);
        mActionProvider2.setIcon(R.mipmap.ic_delete_white_24dp);
        mActionProvider2.setBadge(5);
    }
}
