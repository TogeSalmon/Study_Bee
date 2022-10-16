package studybee.studybee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnglishActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        Button reading = findViewById(R.id.reading);
        Button writing = findViewById(R.id.writing);

        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(EnglishActivity.this, ReadingActivity.class);
                startActivity(intent);
            }
        });

        writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(EnglishActivity.this, WritingActivity.class);
                startActivity(intent);
            }
        });
    }
}
