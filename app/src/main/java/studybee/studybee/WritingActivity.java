package studybee.studybee;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WritingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

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

    }
}
