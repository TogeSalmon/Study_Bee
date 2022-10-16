package studybee.studybee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class SocialStudiesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialstudies);
        ImageView pie_chart = findViewById(R.id.piechart);
        ImageView info = findViewById(R.id.info);
        Button home = findViewById(R.id.homebutton);
        EditText incorrectanswerinfoandideas = findViewById(R.id.editTextIncorrectAnswerInfoandIdeas);
        EditText incorrectanswerrhetoric = findViewById(R.id.editTextIncorrectAnswerRhetoric);
        EditText incorrectanswersynthesis = findViewById(R.id.editTextIncorrectAnswerSynthesis);

        pie_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String infoandideas = incorrectanswerinfoandideas.getText().toString();
                String rhetoric = incorrectanswerrhetoric.getText().toString();
                String synthesis = incorrectanswersynthesis.getText().toString();
                FragmentManager fm = getSupportFragmentManager();
                ChartDialog chartDialog = new ChartDialog(new String[]{"Info & Ideas", "Rhetoric", "Synthesis"}, new int[]{new Integer(infoandideas),new Integer(rhetoric),new Integer(synthesis)});
                chartDialog.show(fm, "ChartDialog");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SocialStudiesActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SocialStudiesActivity.this);

                builder.setMessage("Information & Ideas: Textual evidence, central ideas, and themes, summarizing, understanding relationships, and interpreting words and phrases in context\n\nRhetoric: Analyze word choice, text structure, point of view purpose, and arguments\n\nSynthesis: Analyze word choice, text structure, point of view purpose, and arguments");
                builder.setTitle("Description");

                builder.setPositiveButton("Back", (DialogInterface.OnClickListener) (dialog, which) -> {
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


    }
}
