package jan.org.ng.studentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "IMAGEMANAGER";
    private static final String TABLE_CONTACTS = "CONTACTS";
    private static final String KEY_ID = "ID";
    private static final String KEY_IMAGE = "NAME";
    private static final String KEY_DESCRIPTION = "DESCRIPTION";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = " CREATE TABLE " + TABLE_CONTACTS +   "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_IMAGE
                + " INTEGER, " + KEY_DESCRIPTION + " TEXT " + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.d("Message", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public  void AddContacts(Contactclass contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues myvalues = new ContentValues();
        myvalues.put(KEY_IMAGE,contact.getImg());
        myvalues.put(KEY_DESCRIPTION,contact.getDescription());
        db.insert(TABLE_CONTACTS,null,myvalues);
        db.close();
    }
    public Contactclass getContacts(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS,new String[]{KEY_ID,KEY_IMAGE,KEY_DESCRIPTION},KEY_ID +"=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Contactclass contactclass = new Contactclass(Integer.parseInt(cursor.getString(0)),(Integer.parseInt(cursor.getString(1))),
                cursor.getString(2));
        return contactclass;
    }
    public List<Contactclass> getAllContacts(){
        List<Contactclass> contactclassList = new ArrayList<Contactclass>();
        String selectQuery = "SELECT * FROM CONTACTS";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do{
                Contactclass contactclass = new Contactclass();
                contactclass.setId(Integer.parseInt(cursor.getString(0)));
                contactclass.setImg(Integer.parseInt(cursor.getString(1)));
                contactclass.setDescription(cursor.getString(2));
                contactclassList.add(contactclass);
            }while (cursor.moveToNext());
        }
        return contactclassList;
    }

    public int UpdateContact(Contactclass contactclass){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE,contactclass.getImg());
        values.put(KEY_DESCRIPTION,contactclass.getDescription());

        return db.update(TABLE_CONTACTS,values,KEY_ID + "=?", new String[]{String.valueOf(contactclass.getId())});
    }

    public void deleteContact(Contactclass contactclass){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS,KEY_ID + "=?", new String[]{String.valueOf(contactclass.getId())});
        db.close();
    }

    public int getContactsCount(){
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();

    }


    public void getdatabaseinstance(Context context){
        this.getAllContacts();
    }


}
