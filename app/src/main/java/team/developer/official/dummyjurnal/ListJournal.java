package team.developer.official.dummyjurnal;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import team.developer.official.dummyjurnal.Helper.SQLiteHelper;

public class ListJournal extends AppCompatActivity {

    String[] listJournal;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    SQLiteHelper dbcenter;
    public static ListJournal lj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_journal);

        lj = this;
        dbcenter = new SQLiteHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM TbJournal", null);
        listJournal = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            listJournal[cc] = cursor.getString(4).toString();
        }
        ListView01 = (ListView) findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, listJournal));
        ListView01.setSelected(true);

        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}
