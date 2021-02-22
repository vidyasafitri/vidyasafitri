package com.database;

import com.model.Users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

	Context context;
	String dbname;
	
	public SQLHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.dbname = name;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub 
       db.execSQL(new Users().CREATE_TABLE_USER);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(new Users().CREATE_TABLE_USER);
	}
	
	 public boolean insertContact (String name, String password, String email) {
	      SQLiteDatabase db = this.getWritableDatabase();
	      ContentValues contentValues = new ContentValues();
	      
	      contentValues.put(new Users().COLUMN_USERNAME_USER, name); 
	      contentValues.put(new Users().COLUMN_PASSWORD_USER, password); 
	      contentValues.put(new Users().COLUMN_TYPE_USER,email);
	      db.insert(new Users().TABLE_NAME, null, contentValues);
	      return true;
	   }
	 
	 public int checkAkun(String name){
		 //memasukkan 1 parameter jika nama yang dimasukkan memiliki kesamaan dengan data yang sudah disimpan 
		 //anti duplikasi
		 SQLiteDatabase db = this.getReadableDatabase();
	     Cursor res =  db.rawQuery(" select * from "+new Users().TABLE_NAME+"where="
		 +new Users().COLUMN_USERNAME_USER+"", null);
		 int result = 0;
		 if (res.getCount() == 0){
			 
		 }
		return result;
	 }
}
