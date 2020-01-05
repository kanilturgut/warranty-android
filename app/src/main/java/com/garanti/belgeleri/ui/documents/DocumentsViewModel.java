package com.garanti.belgeleri.ui.documents;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.garanti.belgeleri.data.AppDatabase;
import com.garanti.belgeleri.data.entity.Document;
import com.garanti.belgeleri.data.repository.DocumentRepository;

import java.util.List;

public class DocumentsViewModel extends AndroidViewModel {

    private final DocumentRepository documentRepository;

    public LiveData<List<Document>> documents;

    public DocumentsViewModel(@NonNull Application application) {
        super(application);

        documentRepository = new DocumentRepository(AppDatabase.getInstance(application).documentDao());
        loadDocuments();
    }

    private void loadDocuments() {
        documents = documentRepository.getDocuments();
    }

}
