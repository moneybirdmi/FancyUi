package com.example.fancyui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Note> notes;
    Note currentNote;
    EditText textArea;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textArea = (EditText) findViewById(R.id.text_area);
        notes = new ArrayList<Note>();
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
    private void newNote(){
        saveNote();
        textArea.setText("");
        currentNote = null;
    }
    private void listNotes(){
        String text = "Total " + notes.size() + " notes";
        Log.i("TAG99", "list notes "+text);
        for(int i=0;i<notes.size();i++)
        {
            Log.i("TAG99", "saveNote: "+notes.get(i).getContent());
        }
        Toast toast = Toast.makeText(this,text,Toast.LENGTH_SHORT);
        toast.show();
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
}