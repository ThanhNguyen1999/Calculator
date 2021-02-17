package com.example.maytinhtien;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumer;
    private TextView tvResult;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;
    private final String TAG = getClass().getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }
    public void initWidget(){
        edtNumer = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);

        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);

        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
        btnResult = (Button) findViewById(R.id.btnResult);
    }
    public void setEventClickViews() {
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnResult.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNumber0:
                //TO DO
                edtNumer.append("0");
                break;
            case R.id.btnNumber1:
                //TO DO
                edtNumer.append("1");
                break;
            case R.id.btnNumber2:
                //TO DO
                edtNumer.append("2");
                break;
            case R.id.btnNumber3:
                edtNumer.append("3");
                //TO DO
                break;
            case R.id.btnNumber4:
                //TO DO
                edtNumer.append("4");
                break;
            case R.id.btnNumber5:
                //TO DO
                edtNumer.append("5");
                break;
            case R.id.btnNumber6:
                //TO DO
                edtNumer.append("6");
                break;
            case R.id.btnNumber7:
                //TO DO
                edtNumer.append("7");
                break;
            case R.id.btnNumber8:
                //TO DO
                edtNumer.append("8");
                break;
            case R.id.btnNumber9:
                //TO DO
                edtNumer.append("9");
                break;
            case R.id.btnCong:
                //TO DO
                edtNumer.append("+");
                break;
            case R.id.btnTru:
                //TO DO
                edtNumer.append("-");
                break;
            case R.id.btnNhan:
                //TO DO
                edtNumer.append("*");
                break;
            case R.id.btnChia:
                //TO DO
                edtNumer.append("/");
                break;

            case R.id.btnPoint:
                //TO DO
                edtNumer.append(".");
                break;
            case R.id.btnClear:
                //TO DO
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumer, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnClearAll:
                //TO DO
                edtNumer.setText("");
                tvResult.setText("");
                break;
            case R.id.btnResult:
                // To do
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(edtNumer.getText().toString());
                addNumber(edtNumer.getText().toString());
                if(arrOperation.size()>=arrNumber.size() || arrOperation.size()<1){
                    tvResult.setText("error");
                }else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }

                    tvResult.setText(df.format(result) + "");
                    edtNumer.setText(df.format(result) + "");
                }
        }
    }
    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addNumber (String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher;
        matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}


