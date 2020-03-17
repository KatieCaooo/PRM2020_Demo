package thu.ct.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ReferenceActivity extends AppCompatActivity {
private EditText edtID, edtName, edtMark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtMark = findViewById(R.id.edtMark);
    }

    public void clickToLoad(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("thu.ct.final_database_preferences", MODE_PRIVATE);
        String id = sharedPreferences.getString("IDPref","");
        String name = sharedPreferences.getString("NamePref","");
        String mark = sharedPreferences.getString("MarkPref","");
        edtID.setText(id);
        edtName.setText(name);
        edtMark.setText(mark);
    }

    public void clickToCreate(View view) {
        Intent intent = new Intent(this, StudentPreferenceActivity.class);
        startActivity(intent);
    }

    public void clickToSave(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("thu.ct.final_database_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("IDPref", edtID.getText().toString());
        editor.putString("NamePref", edtName.getText().toString());
        editor.putString("MarkPref", edtMark.getText().toString());
        editor.commit();
    }
}
