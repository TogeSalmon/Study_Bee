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

public class WritingActivity extends AppCompatActivity {
    public static String DEVELOPMENT = "DEVELOPMENT";
    public static String ORGANIZATION = "ORGANIZATION";
    public static String EFFECTIVE_LANGUAGE_USE = "EFFECTIVE_LANGUAGE_USE";
    public static String SENTENCE_STRUCTURE = "SENTENCE_STRUCTURE";
    public static String CONVENTIONS_OF_USAGE = "CONVENTIONS_OF_USAGE";
    public static String CONVENTIONS_OF_PUNCTUATION = "CONVENTIONS_OF_PUNCTUATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        ImageView pie_chart = findViewById(R.id.piechart);
        Button home = findViewById(R.id.homebutton);

        StudyBeeViewModel viewModel = new ViewModelProvider(this).get(StudyBeeViewModel.class);

        EditText developmentEditText = findViewById(R.id.et_development);
        EditText organizationEditText = findViewById(R.id.et_organization);
        EditText effectiveLanguageUseEditText = findViewById(R.id.et_effectivelanguageuse);
        EditText sentenceStructureEditText = findViewById(R.id.et_sentencestructure);
        EditText conventionsOfUsageEditText = findViewById(R.id.et_conventionsofusage);
        EditText conventionsOfPunctuationEditText = findViewById(R.id.et_conventionsofpunctuation);

        developmentEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(DEVELOPMENT, developmentEditText, viewModel));
        organizationEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(ORGANIZATION, organizationEditText, viewModel));
        effectiveLanguageUseEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(EFFECTIVE_LANGUAGE_USE, effectiveLanguageUseEditText, viewModel));
        sentenceStructureEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(SENTENCE_STRUCTURE, sentenceStructureEditText, viewModel));
        conventionsOfUsageEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(CONVENTIONS_OF_USAGE, conventionsOfUsageEditText, viewModel));
        conventionsOfPunctuationEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(CONVENTIONS_OF_PUNCTUATION, conventionsOfPunctuationEditText, viewModel));

        int developmentScore = viewModel.getScore(DEVELOPMENT);
        int organizationScore = viewModel.getScore(ORGANIZATION);
        int effectiveLanguageUseScore = viewModel.getScore(EFFECTIVE_LANGUAGE_USE);
        int sentenceStructureScore = viewModel.getScore(SENTENCE_STRUCTURE);
        int conventionsOfUsageScore = viewModel.getScore(CONVENTIONS_OF_USAGE);
        int conventionsOfPunctuationScore = viewModel.getScore(CONVENTIONS_OF_PUNCTUATION);

        if (developmentScore != 0) {
            developmentEditText.setText(developmentScore + "");
        }
        if (organizationScore != 0) {
            organizationEditText.setText(organizationScore + "");
        }
        if (effectiveLanguageUseScore != 0) {
            effectiveLanguageUseEditText.setText(effectiveLanguageUseScore + "");
        }
        if (sentenceStructureScore != 0) {
            sentenceStructureEditText.setText(sentenceStructureScore + "");
        }
        if (conventionsOfUsageScore != 0) {
            conventionsOfUsageEditText.setText(conventionsOfUsageScore + "");
        }
        if (conventionsOfPunctuationScore != 0) {
            conventionsOfPunctuationEditText.setText(conventionsOfPunctuationScore + "");
        }

        ImageView info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WritingActivity.this);

                builder.setMessage("Development: Refining the content of a passage to achieve the writer’s purpose\n\nOrganization: Improving the structure of a passage to enhance logic and cohesion\n\nEffective language use: Revising text to improve written expression and to achieve the writer’s purpose\n\nSentence structure: Making whole sentences and avoiding run-ons, joining sentences with conjunctions, matching sentence structure, where to put descriptive phrases, matching verbs, matching nouns\n\nConventions of usage: Clear pronouns, making possessives, pronoun agreement, verb agreement, noun agreement, confusing agreement, comparing agreement, appropriate prepositions\n\nConventions of punctuation: End-of-sentence punctuation, within-sentence punctuation, possessive nouns and pronouns, commas and semicolons, nonrestrictive and parenthetical elements, unnecessary punctuation");
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
                String development = developmentEditText.getText().toString();
                String organization = organizationEditText.getText().toString();
                String effectiveLanguageUse = effectiveLanguageUseEditText.getText().toString();
                String sentenceStructure = sentenceStructureEditText.getText().toString();
                String conventionsOfUsage = conventionsOfUsageEditText.getText().toString();
                String conventionsOfPunctuation = conventionsOfPunctuationEditText.getText().toString();
                FragmentManager fm = getSupportFragmentManager();
                ChartDialog chartDialog = new ChartDialog(
                        new String[]{"Development", "Organization", "Effective language use", "Sentence structure", "Conventions of usage", "Conventions of punctuation"},
                        new String[]{development, organization, effectiveLanguageUse, sentenceStructure, conventionsOfUsage, conventionsOfPunctuation});
                chartDialog.show(fm, "ChartDialog");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WritingActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
