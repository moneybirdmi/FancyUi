package com.example.fancyui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<Note> notes;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        notes = (ArrayList<Note>) intent.getSerializableExtra("list");
        if (notes == null) {
            notes = new ArrayList<Note>();
        }
        createView();
    }

    private void createView() {
        ListView view = new ListView(this);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
//        String[] array = new String[notes.size()];
//        for (int i = 0; i < notes.size(); i++) {
//            array[i] = notes.get(i).getContent();
//        }
//        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.item_for_simple_list,array);
        ArrayAdapter adapter = new NoteListAdapter(this, R.layout.item_for_note_list_adapter, notes);
        view.setAdapter(adapter);
        setContentView(view);
    }

}
