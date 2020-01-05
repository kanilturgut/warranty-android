package com.garanti.belgeleri.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.garanti.belgeleri.data.converter.DateConverter;

import java.util.Locale;

@Entity(tableName = "documents")
public class Document {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "market")
    private String market;

    @ColumnInfo(name = "product")
    private String product;

    @ColumnInfo(name = "created_at")
    @TypeConverters(DateConverter.class)
    private long createdAt;

    @ColumnInfo(name = "expired_at")
    @TypeConverters(DateConverter.class)
    private long expiredAt;

    @ColumnInfo(name = "sync_pending")
    private boolean syncPending;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public boolean isSyncPending() {
        return syncPending;
    }


    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("tr-TR"), "Document id %d, market %s, product %s, syncPending %s", id, market, product, syncPending);
    }
}
