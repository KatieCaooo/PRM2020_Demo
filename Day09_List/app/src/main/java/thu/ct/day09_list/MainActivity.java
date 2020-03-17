package thu.ct.day09_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSingleList(View view) {
        Intent intent = new Intent(this, SingleListActivity.class);
        startActivity(intent);
    }

    public void clickToMultipleList(View view) {
        Intent intent = new Intent(this, MultipleListActivity.class);
        startActivity(intent);
    }

    public void clickToMultipleListManual(View view) {
        Intent intent = new Intent(this, ManualListActivity.class);
        startActivity(intent);
    }
}
