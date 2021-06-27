package com.example.fancyui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "tag99";
    ArrayList<Note> notes;
    int selectedItem;
    ListView view;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_list_activity);

        view = findViewById(R.id.view);
        Intent intent = getIntent();
        notes = (ArrayList<Note>) intent.getSerializableExtra("notes");
        if (notes == null) {
            notes = new ArrayList<Note>();
        }
        createView();
    }

    private void createView() {
//        ListView view = new ListView(this);
//        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//        String[] array = new String[notes.size()];
//        for (int i = 0; i < notes.size(); i++) {
//            array[i] = notes.get(i).getContent();
//        }
//        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.item_for_simple_list,array);
        NoteListAdapter adapter = new NoteListAdapter(this, R.layout.item_for_note_list_adapter, notes);
        view.setAdapter(adapter);

        view.setOnItemClickListener((parent, view1, position, id) -> {
            Log.i(TAG, "createView: " + position);
            selectedItem = position;
            onBackPressed();
//            finish();
        });
//        setContentView(view);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("notes", notes);
        intent.putExtra("selectedItem", selectedItem);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }

}
