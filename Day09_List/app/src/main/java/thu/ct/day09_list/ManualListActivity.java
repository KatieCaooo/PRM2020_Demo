package thu.ct.day09_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ManualListActivity extends AppCompatActivity {
    private String[] listSubject;
    private List<String> listChoice;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_list);
        listView = findViewById(R.id.listViewABC);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listSubject = getResources().getStringArray(R.array.listSubject);
        listView.setTextFilterEnabled(true);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listSubject);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listChoice = new ArrayList<>();
                for (int i = 0; i < parent.getCount(); i++) {
                    boolean check = listView.getCheckedItemPositions().get(i);
                    if (check) {
                        String name = parent.getAdapter().getItem(i).toString();
                        listChoice.add(name);
                    }
                }

            }
        });

    }

    public void clickToSave(View view) {
        Intent intent = new Intent(ManualListActivity.this, DetailActivity.class);
        intent.putExtra("id", listChoice.toString());
        startActivity(intent);
    }
}
