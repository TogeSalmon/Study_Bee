package studybee.studybee;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class IncorrectAnswerTextWatcher implements TextWatcher {
    String key;
    EditText editText;
    StudyBeeViewModel studyBeeViewModel;

    public IncorrectAnswerTextWatcher(String key, EditText editText, StudyBeeViewModel studyBeeViewModel) {
        this.key = key;
        this.editText = editText;
        this.studyBeeViewModel = studyBeeViewModel;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        studyBeeViewModel.setScore(key, editText.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
