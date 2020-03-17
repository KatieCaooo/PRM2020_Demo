package thu.ct.day09_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MultipleListActivity extends ListActivity {
    private String[] listSubject;
    private List<String> listChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        listSubject = getResources().getStringArray(R.array.listSubject);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked, listSubject);
        setListAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listChoice = new ArrayList<>();
                for (int i = 0; i < parent.getCount(); i++) {
                    boolean check = listView.getCheckedItemPositions().get(i);
                    if (check){
                        String name = parent.getAdapter().getItem(i).toString();
                        listChoice.add(name);
                    }
                }
                Intent intent = new Intent(MultipleListActivity.this, DetailActivity.class);
                intent.putExtra("id", listChoice.toString());
                startActivity(intent);
            }
        });
    }


}
