package com.example.kingslibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kingslibrary.Model.Book;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Bookmark.db";
    private static final int DATABASE_VERSION = 4;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE bookmark (id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER, title TEXT, publisher TEXT, year INTEGER, isbn TEXT UNIQUE, pages INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bookmark");
        onCreate(db);
    }

    public ArrayList<Book> getBookmarked() {
        ArrayList<Book> bookmarkeds = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("bookmark", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                int bookId = cursor.getInt(cursor.getColumnIndexOrThrow("book_id"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String publisher = cursor.getString(cursor.getColumnIndexOrThrow("publisher"));
                int year = cursor.getInt(cursor.getColumnIndexOrThrow("year"));
                String isbn = cursor.getString(cursor.getColumnIndexOrThrow("isbn"));
                int pages = cursor.getInt(cursor.getColumnIndexOrThrow("pages"));
                bookmarkeds.add(new Book(id, year, title, publisher,isbn, pages));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return bookmarkeds;
    }

    public void insertBookmark(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("book_id", book.getId());
        values.put("year", book.getYear());
        values.put("title", book.getTitle());
        values.put("publisher", book.getPublisher());
        values.put("isbn", book.getISBN());
        values.put("pages", book.getPages());

        db.insert("bookmark", null, values);
        db.close();
    }

    public void removeBookmark(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("bookmark", "book_id = ?", new String[]{String.valueOf(book.getId())});
        db.close();
    }

    public void removeBookmarkByBookmark(int book_id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("bookmark", "book_id = ?", new String[]{String.valueOf(book_id)});
        db.close();
    }

    public boolean isBookBookmarked(int bookId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("bookmark", null, "book_id = ?", new String[]{String.valueOf(bookId)}, null, null, null);
        boolean bookmarked = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return bookmarked;
    }

    public int getBookIdFromBookmarkToUseItOnBookmarkAdapterWhichShowedOnBookmarkFragment(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT book_id FROM bookmark WHERE id = ? LIMIT 1", new String[]{String.valueOf(id)});
        int book_id = 0;
        if (cursor.moveToFirst()) {
            book_id = cursor.getInt(cursor.getColumnIndexOrThrow("book_id"));
        }
        cursor.close();
        db.close();
        return book_id;
    }
}
