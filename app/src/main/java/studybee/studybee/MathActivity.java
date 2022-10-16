package studybee.studybee;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MathActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        ImageView info = findViewById(R.id.info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MathActivity.this);

                builder.setMessage("Hear of algebra: #Analyzing and fluently solving linear equations and systems of linear equations Creating linear equations and inequalities to represent relationships between quantities and to solve problems #Understanding and using the relationship between linear equations and inequalities their graphs to solve problems\n\nProblem solving & Data analysis: #Creating and analyzing relationships using ratios, proportional relationships, percentages, and units #Representing and analyzing quantitative data #Finding and applying probabilities in context\n\nPassport to advanced math: #Identifying and creating equivalent algebraic expressions #Creating, analyzing, and fluently solving quadratic and other nonlinear equations #Creating, using, and graphing exponential, quadratic, and other nonlinear functions\n\nAdditional topics in math: #Solving problems related to area and volume #Applying definitions and theorems related to lines, angles, triangles, and circles #Working with right triangles, the unit circles, and trigonometric functions");
                builder.setTitle("Description");

                builder.setPositiveButton("Back", (DialogInterface.OnClickListener) (dialog, which) -> {
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
