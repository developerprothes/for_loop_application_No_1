package com.prothes.evenoddnumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText minValue,maxValue;
    private AppCompatButton submitBtn;
    private TextView displayPlain,displayEven,displayOdd,displayPrime,display1,display2,display3,display4;
    public static String s = "Min Num is big Than Max Num" + "\n" + "Please Solve it";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        minValue = findViewById(R.id.minValue);
        maxValue = findViewById(R.id.maxValue);
        submitBtn = findViewById(R.id.submitBtn);
        displayPlain = findViewById(R.id.displayPlain);
        displayEven = findViewById(R.id.displayEven);
        displayOdd = findViewById(R.id.displayOdd);
        displayPrime = findViewById(R.id.displayPrime);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
        display3 = findViewById(R.id.display3);
        display4 = findViewById(R.id.display4);




        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getValue1 = minValue.getText().toString();
                String getValue2 = maxValue.getText().toString();

                if (getValue1.length()>0 && getValue2.length()>0){
                    int minNum = Integer.parseInt(getValue1);
                    int maxNum = Integer.parseInt(getValue2);
                    if (minNum<maxNum){
                        int count;
                        displayPlain.setText(null);
                        displayEven.setText(null);
                        displayOdd.setText(null);
                        StringBuilder stringBuilder1 = new StringBuilder();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        StringBuilder stringBuilder3 = new StringBuilder();
                        StringBuilder stringBuilder4 = new StringBuilder();
                        for (int i=minNum; i<=maxNum; i++){
                            stringBuilder1.append(i+" ");
                            if (i%2==0){
                                stringBuilder2.append(i+" ");
                            }else{
                                stringBuilder3.append(i+" ");
                            }

                            count = 0;
                            for (int j=2; j<=i/2; j++){
                                if (i%j == 0){
                                    count++;
                                    break;
                                }
                            }
                            if (count == 0 && i != 1){
                                stringBuilder4.append(i+" ");
                            }

                        }
                        displayPlain.setText(stringBuilder1);
                        displayEven.setText(stringBuilder2);
                        displayOdd.setText(stringBuilder3);
                        displayPrime.setText(stringBuilder4);
                        display1.setText(""+minNum+" to "+maxNum+" print");
                        display2.setText("Even Num");
                        display3.setText("Odd Num");
                        display4.setText("Print Prime Number");
                        CustomToast("Success");
                    }else{
                        CustomToast(s);
                        displayPlain.setText(""+s);
                        displayEven.setText(""+s);
                        displayOdd.setText(""+s);
                    }

                }else if (getValue1.length()>0) {
                    minValue.setError(null);
                    if (getValue2.length()>0){
                        maxValue.setError(null);
                    }else{
                        maxValue.setError("Empty");
                        displayEven.setText(null);
                        displayOdd.setText(null);
                        displayEven.setText(null);
                    }
                }else if (getValue2.length()>0) {
                    maxValue.setError(null);
                    if (getValue1.length()>0){
                        minValue.setError(null);
                    }else{
                        minValue.setError("Empty");
                        displayEven.setText(null);
                        displayOdd.setText(null);
                        displayEven.setText(null);
                    }
                }else{
                    minValue.setError("Empty");
                    maxValue.setError("Empty");
                    displayEven.setText(null);
                    displayOdd.setText(null);
                    displayEven.setText(null);
                }
            }
        });

    }


    public void CustomToast(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }


    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Warning !!!!")
                    .setMessage("Do you want exit this app ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.sky));
        }else{
            super.onBackPressed();
        }
    }
}