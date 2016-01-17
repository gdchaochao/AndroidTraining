package com.example.mysqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FeedReaderDbExcutor {
	FeedReaderDbHelper mDbHelper = null;

	public FeedReaderDbExcutor(Context context) {
		if (context != null) {
			mDbHelper = new FeedReaderDbHelper(context);
		}
	}
	
	public long insertData(String id, String title, String content) {
		if (mDbHelper == null) {
			return -1;
		}
		
		// Gets the data repository in write mode
		SQLiteDatabase db = mDbHelper.getWritableDatabase();

		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, id);
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CONTENT, content);

		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
		         FeedReaderContract.FeedEntry.TABLE_NAME,
		         FeedReaderContract.FeedEntry.COLUMN_NAME_NULLABLE,
		         values);
		db.close();
		return newRowId;
	}
	
	public String getTitleData(int rowIndex) {
		SQLiteDatabase db = mDbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
		    FeedReaderContract.FeedEntry._ID,
		    FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
		    FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID,
		    };
		
		String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
		String[] selectionArgs = {rowIndex + ""};

		// How you want the results sorted in the resulting Cursor
		String sortOrder =
		    FeedReaderContract.FeedEntry._ID + " DESC";

		Cursor cursor = db.query(
		    FeedReaderContract.FeedEntry.TABLE_NAME,  // The table to query
		    projection,                               // The columns to return
		    selection,                                // The columns for the WHERE clause
		    selectionArgs,                            // The values for the WHERE clause
		    null,                                     // don't group the rows
		    null,                                     // don't filter by row groups
		    sortOrder                                 // The sort order
		    );
		
		
		if (cursor.getCount() == 0) {
			db.close();
			return "null";
		}
		cursor.moveToFirst();
		String title = cursor.getString(
				cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE)
		);
		db.close();
		return title;
	}
	
	public int deleteData(int rowId) {
		SQLiteDatabase db = mDbHelper.getReadableDatabase();
		// Define 'where' part of query.
		String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
		// Specify arguments in placeholder order.
		String[] selelectionArgs = {String.valueOf(rowId)};
		// Issue SQL statement.
		int deleteRow = db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection, selelectionArgs);
		db.close();
		return deleteRow;
	}
	
	public int updateData(int rowId, String title) {
		SQLiteDatabase db = mDbHelper.getReadableDatabase();

		// New value for one column
		ContentValues values = new ContentValues();
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);

		// Which row to update, based on the ID
		String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
		String[] selectionArgs = { String.valueOf(rowId) };

		int count = db.update(
			FeedReaderContract.FeedEntry.TABLE_NAME,
		    values,
		    selection,
		    selectionArgs);
		db.close();
		
		return count;
	}
	
}
