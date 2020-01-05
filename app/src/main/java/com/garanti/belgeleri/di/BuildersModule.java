package com.garanti.belgeleri.di;

import com.garanti.belgeleri.ui.NewDocumentActivity;
import com.garanti.belgeleri.ui.documents.DocumentsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = DocumentsActivityModule.class)
    abstract DocumentsActivity bindDocumentsActivity();

    @ContributesAndroidInjector(modules = NewDocumentActivityModule.class)
    abstract NewDocumentActivity bindNewDocumentActivity();
}
