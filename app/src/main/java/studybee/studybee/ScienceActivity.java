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

public class ScienceActivity extends AppCompatActivity {
    public static String SCIENCE_IDEAS = "SCIENCE_IDEAS";
    public static String SCIENCE_RHETORIC = "SCIENCE_RHETORIC";
    public static String SCIENCE_SYNTHESIS = "SCIENCE_SYNTHESIS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        ImageView info = findViewById(R.id.info);
        ImageView pie_chart = findViewById(R.id.piechart);
        Button home = findViewById(R.id.homebutton);

        StudyBeeViewModel viewModel = new ViewModelProvider(this).get(StudyBeeViewModel.class);

        EditText ideasEditText = findViewById(R.id.et_ideas);
        EditText synthesisEditText = findViewById(R.id.et_synthesis);
        EditText rhetoricEditText = findViewById(R.id.et_rhetoric);

        ideasEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(SCIENCE_IDEAS, ideasEditText, viewModel));
        synthesisEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(SCIENCE_SYNTHESIS, synthesisEditText, viewModel));
        rhetoricEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(SCIENCE_RHETORIC, rhetoricEditText, viewModel));

        int ideasScore = viewModel.getScore(SCIENCE_IDEAS);
        int synthesisScore = viewModel.getScore(SCIENCE_SYNTHESIS);
        int rhetoricScore = viewModel.getScore(SCIENCE_RHETORIC);

        if (ideasScore != 0) {
            ideasEditText.setText(ideasScore + "");
        }
        if (synthesisScore != 0) {
            synthesisEditText.setText(synthesisScore + "");
        }
        if (rhetoricScore != 0) {
            rhetoricEditText.setText(rhetoricScore + "");
        }

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ScienceActivity.this);

                builder.setMessage("Information & Ideas: Textual evidence, central ideasEditText, and themes, summarizing, understanding relationships, and interpreting words and phrases in context\n\nRhetoric: Analyze word choice, text structure, point of view purpose, and arguments\n\nSynthesis: Analyze word choice, text structure, point of view purpose, and arguments");
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
                String synthesis = synthesisEditText.getText().toString();
                FragmentManager fm = getSupportFragmentManager();
                ChartDialog chartDialog = new ChartDialog(new String[]{"Info & Ideas", "Rhetoric", "Synthesis"}, new String[]{infoandideas, rhetoric, synthesis});
                chartDialog.show(fm, "ChartDialog");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScienceActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
