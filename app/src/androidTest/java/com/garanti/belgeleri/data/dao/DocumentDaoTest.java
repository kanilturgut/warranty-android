package com.garanti.belgeleri.data.dao;

import android.content.Context;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.garanti.belgeleri.data.AppDatabase;
import com.garanti.belgeleri.data.entity.Document;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class DocumentDaoTest {

    private AppDatabase database;
    private DocumentDao documentDao;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries().build();
        documentDao = database.documentDao();
    }

    @After
    public void tearDown() {
        database.close();
    }

    @Test
    public void testAddingAndRetrievingData() {
        List<Document> pre = documentDao.getAllDocuments().getValue();

        Document document = new Document();
        document.setCreatedAt(new Date().getTime());
        document.setMarket("Vatan Bilgisayar");
        document.setProduct("Samsugn Galaxy Note5");
        document.setExpiredAt(new Date(123423783L).getTime());

        documentDao.insertDocument(document);

        List<Document> post = documentDao.getAllDocuments().getValue();

        int diff = post.size() - pre.size();
        Assert.assertEquals(1, diff);
    }
}