package ming.wxxiaomi.com.minguitest.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ming.wxxiaomi.com.minguitest.R;

public class SettingActivity extends AppCompatActivity {
private Toolbar toolbar_preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbar_preference = (Toolbar) findViewById(R.id.toolbar_preference);
        toolbar_preference.setTitle("asdasd");
        setSupportActionBar(toolbar_preference);
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new SettingFragment()).commit();
    }


}
