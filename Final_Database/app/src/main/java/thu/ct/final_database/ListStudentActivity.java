package thu.ct.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListStudentActivity extends AppCompatActivity {
    private ListView listStudent;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        final Intent intent = this.getIntent();
        List<StudentDTO> result = (List<StudentDTO>) intent.getSerializableExtra("INFO");
        studentAdapter = new StudentAdapter();
        studentAdapter.setStudentDTOList(result);
        listStudent = findViewById(R.id.listStudent);
        listStudent.setAdapter(studentAdapter);
        listStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentDTO dto = (StudentDTO) listStudent.getItemAtPosition(position);
                Intent intentDetail = new Intent(ListStudentActivity.this, StudentDetailActivity.class);
                intentDetail.putExtra("DTO", dto);
                startActivity(intentDetail);
            }
        });
    }
}
