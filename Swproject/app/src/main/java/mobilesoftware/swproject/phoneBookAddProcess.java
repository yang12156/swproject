package mobilesoftware.swproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class phoneBookAddProcess extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        String number = intent.getStringExtra("phoneNumber");
        String name = intent.getStringExtra("phoneName");
        writeCheck(number, name);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void writeCheck(String number, String name) {
        if(isBothNullTest(number, name)){
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

    public boolean isBothNullTest(String number, String name){
        if(number == null || name == null){
            Toast.makeText(getApplicationContext(), "빈칸을 채워주세요.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(number == null) {
            Toast.makeText(getApplicationContext(), "번호를 작성해주세요.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(name == null) {
            Toast.makeText(getApplicationContext(), "이름을 작성해주세요.", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
