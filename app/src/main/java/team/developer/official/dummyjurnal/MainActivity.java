package team.developer.official.dummyjurnal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import team.developer.official.dummyjurnal.Helper.SQLiteHelper;

public class MainActivity extends AppCompatActivity {

    Button insert, list, delete;
    SQLiteHelper dbcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbcenter = new SQLiteHelper(this);
        insert = (Button) findViewById(R.id.insert);
        list = (Button) findViewById(R.id.journal);
        delete = (Button) findViewById(R.id.delete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, JurnalActivity.class);
                startActivity(i);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListJournal.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                String delete = "delete from TbJournal";
                db.execSQL(delete);
                Toast.makeText(MainActivity.this, "All records deleted!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
