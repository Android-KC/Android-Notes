package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NotesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static NoteDatabase database;  // must be static

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(getApplicationContext(), NoteDatabase.class, "notes").allowMainThreadQueries().build();

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new NotesAdapter();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        FloatingActionButton button = findViewById(R.id.add_note_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database.noteDao().create();
                adapter.reload();
            }
        });
    }

    @Override
    protected void onResume() { // called whenever activity is brought to foreground to reload recycler view
        super.onResume();
        adapter.reload();  // called when app starts and when user comes back
    }
}