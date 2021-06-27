package com.example.fancyui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText textArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        createUi();
    }

    private void createUi(){
        LinearLayout outerLayout;
        outerLayout = new LinearLayout(this);
        outerLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        outerLayout.setOrientation(LinearLayout.VERTICAL);

        textArea = new EditText(this);
        textArea.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1f));
//        textArea.setBackgroundColor(Color.WHITE);
        textArea.setHint("Notes");
        textArea.setGravity(Gravity.TOP);
        outerLayout.addView(textArea);

        setContentView(outerLayout);
    }
}