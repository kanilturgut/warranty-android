package com.garanti.belgeleri.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.garanti.belgeleri.data.entity.Document;

import java.util.List;

@Dao
public interface DocumentDao {

    @Insert
    long insertDocument(Document document);

    @Query("SELECT * FROM documents")
    LiveData<List<Document>> getAllDocuments();
}
