package team.developer.official.dummyjurnal;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import team.developer.official.dummyjurnal.Helper.SQLiteHelper;

public class JurnalActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    EditText edtKegiatan, edtInfo;
    Button btnSubmit, btnTime;
    SQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal);

        getSupportActionBar().setTitle("Your Journal");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLiteHelper(this);
        edtKegiatan = (EditText) findViewById(R.id.txtKegiatan);
        edtInfo = (EditText) findViewById(R.id.txtInfo);

        btnTime = (Button) findViewById(R.id.timePicker);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePicker();
                timePicker.show(getSupportFragmentManager(), "Time Picker");
            }
        });
        btnSubmit = (Button) findViewById(R.id.submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = btnTime.getText().toString();
                String TeacherId = "1244";
                String lesson = "QCB";
                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String insert = "INSERT INTO TbJournal(TeacherId, Date, Lesson, Time, Activity, Info) values('" +
                        TeacherId + "','" +
                        date + "','" +
                        lesson + "','" +
                        time + "','" +
                        edtKegiatan.getText().toString() + "','" +
                        edtInfo.getText().toString() + "')";

                db.execSQL(insert);
                Toast.makeText(getApplicationContext(), "Journal Submitted", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, minute);

        getTime(cal);
    }

    public void getTime(Calendar cal) {
        String alarmFinal = DateFormat.getTimeInstance(DateFormat.SHORT).format(cal.getTime());
        btnTime.setText(alarmFinal);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
