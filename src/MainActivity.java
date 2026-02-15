
#package edu.northeastern.team12point5;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btn = findViewById(R.id.btnOpenQuakes);
        btn.setOnClickListener(v -> startactivity(new Intent(this, EarhtquakeActivity.class)));
    }
}
