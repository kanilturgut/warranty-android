package com.garanti.belgeleri.ui.documents;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.garanti.belgeleri.DocumentListAdapter;
import com.garanti.belgeleri.R;
import com.garanti.belgeleri.databinding.ActivityDocumentsBinding;
import com.garanti.belgeleri.ui.NewDocumentActivity;

public class DocumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDocumentsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_documents);
        DocumentsViewModel documentsViewModel = ViewModelProviders.of(this).get(DocumentsViewModel.class);

        final DocumentListAdapter adapter = new DocumentListAdapter(this);
        binding.recyclerViewDocuments.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewDocuments.setAdapter(adapter);

        documentsViewModel.documents.observe(this, adapter::setDocuments);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_documents_acitivity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.new_document) {
            NewDocumentActivity.start(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
