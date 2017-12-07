package jp.techacademy.erika.takenoue.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import java.math.BigDecimal;

public class SecondActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        BigDecimal a = (BigDecimal)intent.getSerializableExtra("VALUE1");

        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(String.valueOf(a));
    }
}
