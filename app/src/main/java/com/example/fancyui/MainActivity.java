package com.example.fancyui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Note> notes;
    Note currentNote;
    EditText textArea;
    String TAG="TAG99";
    final int REQUEST_CODE = 1;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textArea = (EditText) findViewById(R.id.text_area);
        notes = new ArrayList<Note>();
        notes.add(new Note("Assalamo Alaikum"));
        notes.add(new Note("1"));
        notes.add(new Note("2"));
        notes.add(new Note("3"));
        notes.add(new Note("4"));
        notes.add(new Note("5"));
        notes.add(new Note("6"));
        notes.add(new Note("7"));
        notes.add(new Note("8"));
        notes.add(new Note("9"));
        notes.add(new Note("10"));
        notes.add(new Note("11"));
        notes.add(new Note("12"));
        notes.add(new Note("13"));
        notes.add(new Note("14"));
        notes.add(new Note("15"));
        notes.add(new Note("16"));
        notes.add(new Note("17"));
    }

    private void saveNote(){
        String content = textArea.getText().toString();
        if(!content.isEmpty()) {
            if (currentNote == null) {
                currentNote = new Note(content);
                notes.add(currentNote);
            }
            currentNote.setContent(content);
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                notes = (ArrayList<Note>) data.getSerializableExtra("list");
            }
        }
    }
    private void newNote(){
        saveNote();
        textArea.setText("");
        currentNote = null;
    }
    private void listNotes() {
        newNote();
        String text = "Total " + notes.size() + " notes";
        Log.i("TAG99", "list notes " + text);
        for (int i = 0; i < notes.size(); i++) {
            Log.i("TAG99", "saveNote: " + notes.get(i).getContent());
        }
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("list", notes);
        startActivityForResult(intent,REQUEST_CODE);
    }
    public void buttonClick(View v){
        if(v.getId() == R.id.button_save){
            saveNote();
        } else if(v.getId() == R.id.button_new){
            newNote();
        } else if(v.getId() == R.id.button_list){
            listNotes();
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        Log.i(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(savedInstanceState);
        try{
            savedInstanceState.putSerializable("listNotes",notes);
            savedInstanceState.putSerializable("currentNote",currentNote);
        }
        catch(Exception ex){ }
    }
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        Log.i(TAG, "onRestoreInstanceState: ");
        super.onRestoreInstanceState(savedInstanceState);
        try{
            notes = (ArrayList<Note>) savedInstanceState.getSerializable("listNotes");
            currentNote = (Note) savedInstanceState.getSerializable("currentNote");
        }
        catch(Exception ex){ }
    }
}