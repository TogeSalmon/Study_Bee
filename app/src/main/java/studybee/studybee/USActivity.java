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
import androidx.lifecycle.ViewModelProvider;

public class USActivity extends AppCompatActivity {
    public static String US_STUDIES_IDEAS = "US_STUDIES_IDEAS";
    public static String US_STUDIES_RHETORIC = "US_STUDIES_RHETORIC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usworld);
        ImageView info = findViewById(R.id.info);
        ImageView pie_chart = findViewById(R.id.piechart);
        Button home = findViewById(R.id.homebutton);

        StudyBeeViewModel viewModel = new ViewModelProvider(this).get(StudyBeeViewModel.class);

        EditText ideasEditText = findViewById(R.id.et_ideas);
        EditText rhetoricEditText = findViewById(R.id.et_rhetoric);

        ideasEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(US_STUDIES_IDEAS, ideasEditText, viewModel));
        rhetoricEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(US_STUDIES_RHETORIC, rhetoricEditText, viewModel));

        int ideasScore = viewModel.getScore(US_STUDIES_IDEAS);
        int rhetoricScore = viewModel.getScore(US_STUDIES_RHETORIC);

        if (ideasScore != 0) {
            ideasEditText.setText(ideasScore + "");
        }
        if (rhetoricScore != 0) {
            rhetoricEditText.setText(rhetoricScore + "");
        }

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(USActivity.this);

                builder.setMessage("Information & Ideas: Textual evidence, central ideasEditText, and themes, summarizing, understanding relationships, and interpreting words and phrases in context\n\nRhetoric: Analyze word choice, text structure, point of view purpose, and arguments");
                builder.setTitle("Description");

                builder.setPositiveButton("Back", (DialogInterface.OnClickListener) (dialog, which) -> {
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        pie_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String infoandideas = ideasEditText.getText().toString();
                String rhetoric = rhetoricEditText.getText().toString();
                FragmentManager fm = getSupportFragmentManager();
                ChartDialog chartDialog = new ChartDialog(new String[]{"Info & Ideas", "Rhetoric"}, new String[]{infoandideas, rhetoric});
                chartDialog.show(fm, "ChartDialog");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(USActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
