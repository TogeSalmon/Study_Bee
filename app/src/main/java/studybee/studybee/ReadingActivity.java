package studybee.studybee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        Button us = findViewById(R.id.us);
        Button ss = findViewById(R.id.ss);
        Button science = findViewById(R.id.science);

        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ReadingActivity.this, USActivity.class);
                startActivity(intent);
            }
        });

        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ReadingActivity.this, SocialStudiesActivity.class);
                startActivity(intent);
            }
        });

    }
}
