package thu.ct.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailActivity extends AppCompatActivity {
    private TextView txtID, txtName, txtMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        txtID = findViewById(R.id.txtID);
        txtName = findViewById(R.id.txtName);
        txtMark = findViewById(R.id.txtMark);
        Intent intent = this.getIntent();
        StudentDTO dto = (StudentDTO) intent.getSerializableExtra("DTO");
        txtID.setText(dto.getId());
        txtName.setText(dto.getName());
        txtMark.setText(dto.getMark() + "");
    }
}
