package thu.ct.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            StudentDAO dao = new StudentDAO();
            FileOutputStream fileOutputStream = openFileOutput("hahaha.txt", MODE_PRIVATE);
            InputStream inputStream = this.getResources().openRawResource(R.raw.database);
            List<StudentDTO> studentDTO = dao.loadFromRaw(inputStream);
            dao.saveToInternal(fileOutputStream,studentDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickToLoadFromRaw(View view) {
        Intent intent = new Intent(this, ListStudentActivity.class);
        StudentDAO studentDAO = new StudentDAO();
        InputStream inputStream = this.getResources().openRawResource(R.raw.database);
        List<StudentDTO> result = studentDAO.loadFromRaw(inputStream);
        intent.putExtra("INFO", (Serializable) result);
        startActivity(intent);
    }

    public void clickToLoadFromInternal(View view) {
        Intent intent = new Intent(this, ListStudentActivity.class);
        try {
            StudentDAO studentDAO = new StudentDAO();
            FileInputStream fileInputStream = openFileInput("hahaha.txt");
            List<StudentDTO> result = studentDAO.loadFromInternal(fileInputStream);
            intent.putExtra("INFO", (Serializable) result);
        }catch (Exception e){
            e.printStackTrace();
        }
        startActivity(intent);
    }

    public void clickToSaveSDCard(View view) {
        try {
            FileInputStream fileOutputStream = openFileInput("hahaha.txt");
            StudentDAO dao = new StudentDAO();
            List<StudentDTO> list = dao.loadFromInternal(fileOutputStream);
            if (dao.saveToExternal(list)){
                Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickToLoadSDCard(View view) {
        Intent intent = new Intent(this, ListStudentActivity.class);
        try {
            StudentDAO dao = new StudentDAO();
            List<StudentDTO> list = dao.loadFromExternal();
            intent.putExtra("INFO", (Serializable)list);
        }catch (Exception e){
            e.printStackTrace();
        }
        startActivity(intent);
    }

    public void clickToAccessPreference(View view) {
        Intent intent = new Intent(this, ReferenceActivity.class);
        startActivity(intent);
    }
}
