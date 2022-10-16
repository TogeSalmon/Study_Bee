package studybee.studybee;

import static android.content.Context.MODE_PRIVATE;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class StudyBeeViewModel extends AndroidViewModel {

    public StudyBeeViewModel(@NonNull Application application) {
        super(application);
    }

    public int getScore(String subject) {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("MySharedPref",MODE_PRIVATE);
        return sharedPreferences.getInt(subject, 0);
    }

    public void setScore(String subject, String valueText) {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        int value = 0;
        if (!valueText.equals("")) {
            value = new Integer(valueText);
        }
        myEdit.putInt(subject, value);
        myEdit.apply();
    }

    public static final String READING = "reading";
    public static final String WRITING = "writing";
}
