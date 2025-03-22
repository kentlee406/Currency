package com.home.currency;

import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;
    private TextView jp, us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();

    }

    private void findViewById() {
        ntd= findViewById(R.id.ntd);
        jp=findViewById(R.id.jp);
        us=findViewById(R.id.us);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calculate(View view) {
        if(ntd.getText().toString().equals("")){
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount.")
                    .setPositiveButton("OK", null)
                    .show();
        }else{
            double ntd_val=Double.parseDouble(ntd.getText().toString());
            double jp_rate = 4.53;
            double us_rate = 1/30.9;
            double jp_result = ntd_val*jp_rate;
            double us_result = ntd_val*us_rate;
            jp.setText(String.format("%.3f",jp_result));
            us.setText(String.format("%.3f",us_result));

            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is "+String.format("%.3f",us_result))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ntd.setText("");
                        }
                    })
                    .show();

        }
    }
}