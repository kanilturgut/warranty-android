package com.garanti.belgeleri.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.garanti.belgeleri.data.converter.DateConverter;
import com.garanti.belgeleri.data.dao.DocumentDao;
import com.garanti.belgeleri.data.entity.Document;

@Database(entities = {Document.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "documents";
    private static AppDatabase sInstance;

    public abstract DocumentDao documentDao();

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {

                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();

            }
        }
        return sInstance;
    }

}
