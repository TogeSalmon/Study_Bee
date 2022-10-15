package studybee.studybee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class SocialStudiesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialstudies);
        ImageView info = findViewById(R.id.info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                ChartDialog chartDialog = new ChartDialog(new String[]{"Math", "Reading", "Writing"}, new int[]{10,20,30});
                chartDialog.show(fm, "ChartDialog");
            }
        });

//        info.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(SocialStudiesActivity.this);
//
//                builder.setMessage("Information & Ideas: Textual evidence, central ideas, and themes, summarizing, understanding relationships, and interpreting words and phrases in context\n\nRhetoric: Analyze word choice, text structure, point of view purpose, and arguments\n\nSynthesis: Analyze word choice, text structure, point of view purpose, and arguments");
//                builder.setTitle("Description");
//
//                builder.setPositiveButton("Back", (DialogInterface.OnClickListener) (dialog, which) -> {
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//            }
//        });


    }
}
