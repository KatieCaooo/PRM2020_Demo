package thu.ct.day07_tabfragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private List<Fragment> fragmentList = new ArrayList<>();
    private TabFragment1 tabFragment1;
    private TabFragment2 tabFragment2;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = bar.newTab();
        tab1.setText("Input");
        tab1.setTabListener(this);
        bar.addTab(tab1);

        ActionBar.Tab tab2 = bar.newTab();
        tab2.setText("Register");
        tab2.setTabListener(this);
        bar.addTab(tab2);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (tab.getPosition() == 0) {
            if (tabFragment1 == null) {
                tabFragment1 = new TabFragment1();
                Bundle bundle = new Bundle();
                bundle.putString("default", "AAA");
                tabFragment1.setArguments(bundle);
                fragmentList.add(tabFragment1);
            } else {
                tabFragment1 = (TabFragment1) fragmentList.get(tab.getPosition());
            }
            ft.replace(android.R.id.content, tabFragment1);
        } else {
            if (tabFragment2 == null) {
                tabFragment2 = new TabFragment2();
                Bundle bundle = new Bundle();
                bundle.putString("default", "BBB");
                fragmentList.add(tabFragment2);
            } else {
                tabFragment2 = (TabFragment2) fragmentList.get(tab.getPosition());
            }
            ft.replace(android.R.id.content, tabFragment2);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (tab.getPosition() == 0) {
            EditText edtUsername = findViewById(R.id.edtUsername);
            username = edtUsername.getText().toString();
        }
        ft.remove(fragmentList.get(tab.getPosition()));
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public void clickToRegister(View view) {
        EditText editRole = findViewById(R.id.edtRole);
        String role = editRole.getText().toString();


        String result = "Username: " + username + " - Role:" + role;

        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        tabFragment1.setArguments(bundle);

    }
}
