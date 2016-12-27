package ming.wxxiaomi.com.minguitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ming.wxxiaomi.com.minguitest.ui.drawer.DrawerActivity;
import ming.wxxiaomi.com.minguitest.ui.footprint.FootPrintShowActivity;
import ming.wxxiaomi.com.minguitest.ui.register.EditTextActivity;
import ming.wxxiaomi.com.minguitest.ui.personal.PersonalActivity;
import ming.wxxiaomi.com.minguitest.ui.search.SearchActivity;
import ming.wxxiaomi.com.minguitest.ui.setting.SettingActivity;
import ming.wxxiaomi.com.minguitest.ui.userinfo.UserInfoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button edittext;
    private Button setting;
    private Button personal;
    private Button drawer;
    private Button tab;
    private Button footprint;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = (Button) findViewById(R.id.edittext);
        edittext.setOnClickListener(this);
        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(this);
        personal = (Button) findViewById(R.id.personal);
        personal.setOnClickListener(this);
        drawer = (Button) findViewById(R.id.drawer);
        drawer.setOnClickListener(this);
        tab = (Button) findViewById(R.id.tab);
        tab.setOnClickListener(this);
        footprint = (Button) findViewById(R.id.footprint);
        footprint.setOnClickListener(this);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.edittext:
                intent = new Intent(this,EditTextActivity.class);
                startActivity(intent);
                break;
            case R.id.setting:
                intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.personal:
                intent = new Intent(this,PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.drawer:
                intent = new Intent(this,DrawerActivity.class);
                startActivity(intent);
                break;
            case R.id.tab:
                intent = new Intent(this,UserInfoActivity.class);
                startActivity(intent);
                break;
            case R.id. footprint:
                intent = new Intent(this,FootPrintShowActivity.class);
                startActivity(intent);
                break;
            case R.id.search:
                intent = new Intent(this,SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
