package ming.wxxiaomi.com.minguitest.ui.register;

import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ming.wxxiaomi.com.minguitest.R;
import ming.wxxiaomi.com.minguitest.weight.MsgActionProvider;

public class EditTextActivity extends AppCompatActivity {
    Toolbar toolbar;
    private Button btn_register;
    private MsgActionProvider mActionProvider2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); // 设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActionProvider.setBadge(2);
            }
        });
    }

    private MsgActionProvider mActionProvider;

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
