package jp.techacademy.erika.takenoue.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import java.math.BigDecimal;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        String str1 = mEditText1.getText().toString();
        String str2 = mEditText2.getText().toString();

        try {
            double d1 = Double.parseDouble(str1);
            double d2 = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "数値を入力してください", Toast.LENGTH_LONG).show();
            return;
        }

        BigDecimal big1 = new BigDecimal(str1);
        BigDecimal big2 = new BigDecimal(str2);


        if (v.getId() == R.id.button1) {
            intent.putExtra("VALUE1", big1.add(big2));
        } else if (v.getId() == R.id.button2) {
            intent.putExtra("VALUE1", big1.subtract(big2));
        } else if (v.getId() == R.id.button3) {
            intent.putExtra("VALUE1", big1.multiply(big2));
        } else if ((v.getId() == R.id.button4) && (big2.signum()>0)) {
            intent.putExtra("VALUE1", big1.divide(big2, 5, BigDecimal.ROUND_HALF_UP));
        } else if ((v.getId() == R.id.button4) && (big2.signum()==0)) {
            Toast.makeText(this, "0では割れません", Toast.LENGTH_LONG).show();
            return;
        }
        startActivity(intent);
    }
}
