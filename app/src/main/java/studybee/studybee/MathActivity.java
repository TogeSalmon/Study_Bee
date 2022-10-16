package studybee.studybee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

public class MathActivity extends AppCompatActivity{
    public static String HEART_OF_ALGEBRA = "HEART_OF_ALGEBRA";
    public static String PROBLEM_SOLVING = "PROBLEM_SOLVING";
    public static String PASSPORT_TO_ADVANCED_MATH = "PASSPORT_TO_ADVANCED_MATH";
    public static String ADDITIONAL_TOPICS_IN_MATH = "ADDITIONAL_TOPICS_IN_MATH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        ImageView info = findViewById(R.id.info);
        ImageView pie_chart = findViewById(R.id.piechart);
        Button home = findViewById(R.id.homebutton);

        StudyBeeViewModel viewModel = new ViewModelProvider(this).get(StudyBeeViewModel.class);

        EditText heartOfAlgebraEditText = findViewById(R.id.et_heartofalgebra);
        EditText problemSolvingEditText = findViewById(R.id.et_problemsolving);
        EditText passportToAdvancedMathEditText = findViewById(R.id.et_passporttoadvancedmath);
        EditText additionalTopicsInMathEditText = findViewById(R.id.et_additionaltopicsinmath);

        heartOfAlgebraEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(HEART_OF_ALGEBRA, heartOfAlgebraEditText, viewModel));
        problemSolvingEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(PROBLEM_SOLVING, problemSolvingEditText, viewModel));
        passportToAdvancedMathEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(PASSPORT_TO_ADVANCED_MATH, passportToAdvancedMathEditText, viewModel));
        additionalTopicsInMathEditText.addTextChangedListener(new IncorrectAnswerTextWatcher(ADDITIONAL_TOPICS_IN_MATH, additionalTopicsInMathEditText, viewModel));

        int heartOfAlgebraScore = viewModel.getScore(HEART_OF_ALGEBRA);
        int problemSolvingScore = viewModel.getScore(PROBLEM_SOLVING);
        int passportToAdvancedMathScore = viewModel.getScore(PASSPORT_TO_ADVANCED_MATH);
        int additionalTopicsInMathScore = viewModel.getScore(ADDITIONAL_TOPICS_IN_MATH);

        if (heartOfAlgebraScore != 0) {
            heartOfAlgebraEditText.setText(heartOfAlgebraScore + "");
        }
        if (problemSolvingScore != 0) {
            problemSolvingEditText.setText(problemSolvingScore + "");
        }
        if (passportToAdvancedMathScore != 0) {
            passportToAdvancedMathEditText.setText(passportToAdvancedMathScore + "");
        }
        if (additionalTopicsInMathScore != 0) {
            additionalTopicsInMathEditText.setText(additionalTopicsInMathScore + "");
        }

        pie_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heartOfAlgebra = heartOfAlgebraEditText.getText().toString();
                String problemSolving = problemSolvingEditText.getText().toString();
                String passportToAdvancedMath = passportToAdvancedMathEditText.getText().toString();
                String additionalTopicsInMath = additionalTopicsInMathEditText.getText().toString();

                FragmentManager fm = getSupportFragmentManager();
                ChartDialog chartDialog = new ChartDialog(
                        new String[]{"Heart of algebra", "Problem solving", "Passport to advanced math", "Additional topics in math"},
                        new String[]{heartOfAlgebra, problemSolving, passportToAdvancedMath, additionalTopicsInMath}
                );
                chartDialog.show(fm, "ChartDialog");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

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
