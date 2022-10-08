package studybee.studybee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.EditText;

public class PracticeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_activity_main);
        EditText edittext = findViewById(R.id.edittext);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.secondbutton);
        ImageView button3 = findViewById(R.id.home);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = edittext.getText().toString();
                Toast.makeText(PracticeMainActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticeMainActivity.this, PracticeSecondActivity.class);
                startActivity(intent);
            }
        });


    }
}