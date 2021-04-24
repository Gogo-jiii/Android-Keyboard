package com.example.keyboard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnShowKeyboard, btnHideKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowKeyboard = findViewById(R.id.btnShowKeyboard);
        btnHideKeyboard = findViewById(R.id.btnHideKeyboard);

        btnShowKeyboard.setOnClickListener(this);
        btnHideKeyboard.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowKeyboard:
                showKeyboard();
                break;
            case R.id.btnHideKeyboard:
                hideKeyboard(btnHideKeyboard);
                break;
        }
    }

    private void hideKeyboard(Button view) {
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void showKeyboard() {
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    @Override public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_A:
                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_B:
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}