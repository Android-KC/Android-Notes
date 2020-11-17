package com.example.notes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)  // specifies entry point for all Daos to be used
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();  // get instance of dao
}
