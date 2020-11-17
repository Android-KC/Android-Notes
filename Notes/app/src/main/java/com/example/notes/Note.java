package com.example.notes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")  // tag indicates that class represents a table in the SQLlite DB
public class Note {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "contents")
    public String contents;
}
