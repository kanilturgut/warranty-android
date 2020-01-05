package com.garanti.belgeleri.data.repository;

import androidx.lifecycle.LiveData;

import com.garanti.belgeleri.data.AppExecutors;
import com.garanti.belgeleri.data.dao.DocumentDao;
import com.garanti.belgeleri.data.entity.Document;

import java.util.List;

public class DocumentRepository {

    private DocumentDao documentDao;

    public DocumentRepository(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public LiveData<List<Document>> getDocuments() {
        return this.documentDao.getAllDocuments();
    }

    public void insertDocument(final Document document) {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                documentDao.insertDocument(document);
            }
        });
    }
}
