package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et50,et20,et10,et5,et2,et1;
    TextView txt50000,txt20000, txt10000,txt5000,txt2000,txt1000;
    TextView rs50000,rs20000, rs10000,rs5000,rs2000,rs1000;
    TextView txtFinalCash, txtFinalCashInWords;
    Button btReset;
    ArrayList<Integer> fluctuateCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
        fluctuateCash = new ArrayList<>();

        et50.addTextChangedListener(new CashTextWatcher());
        et20.addTextChangedListener(new CashTextWatcher());
        et10.addTextChangedListener(new CashTextWatcher());
        et5.addTextChangedListener(new CashTextWatcher());
        et2.addTextChangedListener(new CashTextWatcher());
        et1.addTextChangedListener(new CashTextWatcher());

        txt50000.addTextChangedListener(new FinalCashTextWatcher());
        txt20000.addTextChangedListener(new FinalCashTextWatcher());
        txt10000.addTextChangedListener(new FinalCashTextWatcher());
        txt5000.addTextChangedListener(new FinalCashTextWatcher());
        txt2000.addTextChangedListener(new FinalCashTextWatcher());
        txt1000.addTextChangedListener(new FinalCashTextWatcher());
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
            }
        });
    }
    private void clearData(){
        txtFinalCashInWords.setText("zero");
        txtFinalCash.setText("0");
        txt50000.setText("0");
        txt20000.setText("0");
        txt10000.setText("0");
        txt5000.setText("0");
        txt2000.setText("0");
        txt1000.setText("0");

        et1.setText("");
        et2.setText("");
        et5.setText("");
        et10.setText("");
        et20.setText("");
        et50.setText("");

        rs50000.setText("0");
        rs20000.setText("0");
        rs10000.setText("0");
        rs5000.setText("0");
        rs2000.setText("0");
        rs1000.setText("0");
    }
    private void setUpUI(){
        btReset = findViewById(R.id.btnReset);
        txtFinalCash = findViewById(R.id.txtFinalCash);
        txtFinalCashInWords = findViewById(R.id.txtFinalCashInWords);
        et50 = findViewById(R.id.et50);
        et20 = findViewById(R.id.et20);
        et10 = findViewById(R.id.et10);
        et5 = findViewById(R.id.et5);
        et2 = findViewById(R.id.et2);
        et1 = findViewById(R.id.et1);

        txt50000 = findViewById(R.id.txt50000);
        txt20000 = findViewById(R.id.txt20000);
        txt10000 = findViewById(R.id.txt10000);
        txt5000 = findViewById(R.id.txt5000);
        txt2000 = findViewById(R.id.txt2000);
        txt1000 = findViewById(R.id.txt1000);

        rs50000 = findViewById(R.id.rs50000);
        rs20000 = findViewById(R.id.rs20000);
        rs10000 = findViewById(R.id.rs10000);
        rs5000 = findViewById(R.id.rs5000);
        rs2000 = findViewById(R.id.rs2000);
        rs1000 = findViewById(R.id.rs1000);
    }

    private class CashTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            CashCalculate();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    private void CashCalculate() {
        int row_value = 0;
            DecimalFormat df = new DecimalFormat("0");
            int num1 = 0;
            if (!et50.getText().toString().equals("")){
                num1 = Integer.parseInt(et50.getText().toString());
                row_value = num1 * 50000;
                rs50000.setText(df.format(row_value));
                fluctuateCash.add(row_value);
            }
        int num2 = 0;
        if (!et20.getText().toString().equals("")){
            num2 = Integer.parseInt(et20.getText().toString());
            row_value = num2 * 20000;
            rs20000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num3 = 0;
        if (!et10.getText().toString().equals("")){
            num3 = Integer.parseInt(et10.getText().toString());
            row_value = num3 * 10000;
            rs10000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num4 = 0;
        if (!et5.getText().toString().equals("")){
            num4 = Integer.parseInt(et5.getText().toString());
            row_value = num4 * 5000;
            rs5000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num5 = 0;
        if (!et2.getText().toString().equals("")){
            num1 = Integer.parseInt(et2.getText().toString());
            row_value = num5 * 2000;
            rs2000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num6 = 0;
        if (!et1.getText().toString().equals("")){
            num6 = Integer.parseInt(et1.getText().toString());
            row_value = num6 * 1000;
            rs1000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }

        if (et50.getText().toString().equals("")){
            txt50000.setText(df.format(0));
        }
        if (et20.getText().toString().equals("")){
            txt20000.setText(df.format(0));
        }
        if (et10.getText().toString().equals("")){
            txt10000.setText(df.format(0));
        }
        if (et5.getText().toString().equals("")){
            txt5000.setText(df.format(0));
        }
        if (et2.getText().toString().equals("")){
            txt2000.setText(df.format(0));
        }
        if (et1.getText().toString().equals("")){
            txt1000.setText(df.format(0));
        }
    }
    private class FinalCashTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            totalCash();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

    private void totalCash() {
        int totalCash=0;
        DecimalFormat df = new DecimalFormat("0");
        Main ob=new Main();
        if (txt50000.getText().toString().equals("") && txt20000.getText().toString().equals("")){
            if (txt10000.getText().toString().equals("") && txt5000.getText().toString().equals("")){
                if(!txt2000.getText().toString().equals("") && txt1000.getText().toString().equals("") ){
                    int num1 =0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 =0;
                    num1 = Integer.parseInt(txt50000.getText().toString());
                    num2 = Integer.parseInt(txt20000.getText().toString());
                    num3 = Integer.parseInt(txt5000.getText().toString());
                    num5 = Integer.parseInt(txt2000.getText().toString());
                    num6 = Integer.parseInt(txt1000.getText().toString());

                    totalCash = num1+num2+num3+num4+num5+num6;
                    txtFinalCash.setText("Total Cash: " +df.format(totalCash));
                    txtFinalCashInWords.setText(String.valueOf(ob.convertNumberToWords(totalCash)));
                }
            }
        }
    }
}