package ming.wxxiaomi.com.minguitest.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import ming.wxxiaomi.com.minguitest.R;

/**
 * Created by Administrator on 2016/12/16.
 */
public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
        Preference preference =  getPreferenceManager().findPreference("demo");
        Log.i("wang",""+"");;
//        SharedPreferences sp = preference.getSharedPreferences();
//        sp.
//        preference.get
//        preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
//            @Override
//            public boolean onPreferenceChange(Preference preference, Object o) {
////                boolean checked = Boolean.valueOf(o.toString());
//                Log.i("wang","checked:"+o.toString());
//                return true;
//            }
//        });
    }
}
