package thu.ct.final_database;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

import java.util.prefs.Preferences;

public class StudentPreferenceActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.studentpreference);
        SharedPreferences sharedPreferences = getSharedPreferences("thu.ct.final_database_preferences", MODE_PRIVATE);
        for (int i = 0; i < getPreferenceScreen().getPreferenceCount(); i++) {
            initData(getPreferenceScreen().getPreference(i), sharedPreferences);

        }
    }

    private void initData(Preference p, SharedPreferences sharedPreferences) {
        if (p instanceof PreferenceCategory) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) p;
            for (int i = 0; i < preferenceCategory.getPreferenceCount(); i++) {
                initData(preferenceCategory.getPreference(i), sharedPreferences);
            }
        } else {
            updatePre(p, sharedPreferences);
        }
    }

    private void updatePre(Preference p, SharedPreferences sharedPreferences) {
        if (p instanceof EditTextPreference) {
            EditTextPreference editTextPreference = (EditTextPreference) p;
            p.setSummary(editTextPreference.getText());

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updatePre((findPreference(key)), sharedPreferences);

    }

}
