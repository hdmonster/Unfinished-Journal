package team.developer.official.dummyjurnal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import team.developer.official.dummyjurnal.Helper.SQLiteHelper;

public class AbsentActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button next;

    SQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absent);

        radioGroup = findViewById(R.id.radioGroup);

        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                String absen = radioButton.getText().toString();
                String TeacherId = "1244";
                String ab = "Hadir";

                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String insert = "INSERT INTO TbAbsent(TeacherId, Date, Attendance) values('" +
                        TeacherId + "','" +
                        date + "','" +
                        ab + "')";

                db.execSQL(insert);
                finish();
                Toast.makeText(AbsentActivity.this, "Successfully added!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        String absen = radioButton.getText().toString();
        Toast.makeText(AbsentActivity.this, "Pilihan: "+absen, Toast.LENGTH_SHORT).show();
    }
}
