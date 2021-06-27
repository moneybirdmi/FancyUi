package com.example.fancyui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteListAdapter extends ArrayAdapter<Note> {
    private static final String TAG = "TAG99";
    private ArrayList<Note> notes;
    private int layout;

    public NoteListAdapter(Context context, int layout, ArrayList<Note> notes) {
        super(context, 0, notes);

        this.notes = notes;
        this.layout = layout;
    }

    public View getView(int position, View view, ViewGroup parent) {
        Note note = getItem(position);

        // to see redrawing of data
        // view bar bar create nahi karta, usi ko use karleta hai.
        if (view == null) Log.i(TAG, " no view");
        else {
            TextView text = (TextView) view.findViewById(R.id.note_list_item_text);
            Log.i(TAG, "old text: " + text.getText());
            Log.i(TAG, "new text: " + note.getContent());
        }
        Log.i(TAG, "created text: " + note.getContent());

        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(layout, parent, false);

            view = getItemView();
        }

        TextView text = (TextView) view.findViewById(R.id.note_list_item_text);
        text.setText(note.getContent());

        Button button = (Button) view.findViewById(R.id.note_list_item_button);
        button.setText("" + position);
        button.setTag(position);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Integer index = (Integer) v.getTag();
                notes.remove(index.intValue());
                notifyDataSetChanged();
            }
        });
        return view;
    }

    private LinearLayout getItemView() {
        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);

        TextView text = new TextView(getContext());
        text.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT,1f));
        text.setId(R.id.note_list_item_text);

        Button button = new Button(getContext());
        button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        button.setId(R.id.note_list_item_button);

        layout.addView(text);
        layout.addView(button);
        return layout;
    }


    //todo ctl alt l all files
}
