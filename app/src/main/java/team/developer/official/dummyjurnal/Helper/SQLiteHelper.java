package team.developer.official.dummyjurnal.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Haydar Dzaky S on 9/9/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DB_SQLite";
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TbMaster = "CREATE TABLE TbJournal(id INTEGER PRIMARY KEY AUTOINCREMENT, TeacherId VARCHAR,Date DATE, Lesson VARCHAR, Time TIME, " +
                "Activity TEXT, Info TEXT);";
        String TbTeacher = "CREATE TABLE TbTeacher(id INTEGER PRIMARY KEY AUTOINCREMENT, TeacherId VARCHAR, TeacherName VARCHAR, " +
                "Lesson VARCHAR);";
        String TbSchedule = "CREATE TABLE TbSchedule(id INTEGER PRIMARY KEY AUTOINCREMENT, TeacherId VARCHAR, Lesson VARCHAR, " +
                "Day VARCHAR);";
        String TbAbsent = "CREATE TABLE TbAbsent(id INTEGER PRIMARY KEY AUTOINCREMENT, TeacherId VARCHAR, Date DATE, Attendance VARCHAR);";

        Log.d("Data", "onCreate:" +TbMaster);
        db.execSQL(TbMaster);
        Log.d("Data", "onCreate:" +TbTeacher);
        db.execSQL(TbTeacher);
        Log.d("Data", "onCreate:" +TbSchedule);
        db.execSQL(TbSchedule);
        Log.d("Data", "onCreate:" +TbAbsent);
        db.execSQL(TbAbsent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {}
}
