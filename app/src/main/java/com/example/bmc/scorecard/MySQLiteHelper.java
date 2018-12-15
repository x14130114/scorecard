package com.example.bmc.scorecard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "GolfScores1";
    private static final String TABLE_NAME = "OverallTable";
    //private static final String TABLE_NAMESTEP = "OverallStep";
    private static final String KEY_ID = "id";
    private static final String KEY_COURSE = "course";
    private static final String KEY_PLAYER1 = "player1";
    private static final String KEY_PLAYER2 = "player2";
    private static final String KEY_RESULT = "result";
    private static final String KEY_RESULT2 = "result2";
    private static final String[] COLUMNS = {KEY_ID, KEY_PLAYER1, KEY_PLAYER2, KEY_RESULT, KEY_RESULT2, KEY_COURSE};

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " ( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_PLAYER1 + " TEXT, "
                + KEY_PLAYER2 + " TEXT, "
                + KEY_RESULT + " TEXT, "
                + KEY_RESULT2 + " TEXT, "
                + KEY_COURSE + " TEXT )";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_TABLE_IF_EXISTS);
        this.onCreate(sqLiteDatabase);
    }

    public void addOverall(Overall overall) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_PLAYER1, overall.getPlayer1());
        contentValues.put(KEY_PLAYER2, overall.getPlayer2());
        contentValues.put(KEY_RESULT, overall.getResult());
        contentValues.put(KEY_RESULT2, overall.getResult2());
        contentValues.put(KEY_COURSE, overall.getCourse());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<Overall> getAllScores() {
        List<Overall> scores = new LinkedList<Overall>();
        String getAllScoresStatement = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(getAllScoresStatement,null);
        Overall overal1 = null;
        if(cursor.moveToFirst()) {
            do {
                overal1 = new Overall();
                overal1.setId(Integer.parseInt(cursor.getString(0)));
                overal1.setPlayer1(cursor.getString(1));
                overal1.setPlayer2(cursor.getString(2));
                overal1.setResult(cursor.getString(3));
                overal1.setResult2(cursor.getString(4));
                overal1.setCourse(cursor.getString(5));
                scores.add(overal1);
            } while (cursor.moveToNext());
        }
        db.close();
        return scores;
    }

    public void deleteAllScores() {
        String DELETE_ALL_SCORES_STATEMENT = "DELETE FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DELETE_ALL_SCORES_STATEMENT);
    }

}

