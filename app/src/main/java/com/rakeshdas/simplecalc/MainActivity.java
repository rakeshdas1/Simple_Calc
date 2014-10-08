package com.rakeshdas.simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText num1;
        final EditText num2;
        final TextView ans;
        final Spinner oper;
        final Button btn;
        num1 =(EditText) findViewById(R.id.num1EditText);
        num2 = (EditText) findViewById(R.id.num2EditText);
        ans = (TextView) findViewById(R.id.textView);
        oper = (Spinner) findViewById(R.id.spinner);
        btn = (Button) findViewById(R.id.calc);
        oper.setOnItemSelectedListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int num1N = Integer.parseInt(num1.getText().toString());
                final int num2N = Integer.parseInt(num2.getText().toString());
                int ansN = 0;
                final String operN = (String) oper.getSelectedItem();
                ans.setText(operN);
                if(operN.equals("+")){
                    ansN = num1N+num2N;
                }
                else if (operN.equals("-")){
                    ansN = num1N-num2N;
                }
                else if (operN.equals("*")){
                    ansN = num1N*num2N;
                }
                else if (operN.equals("/")){
                    ansN = num1N/num2N;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(ansN);
                String ansNS = sb.toString();
                ans.setText("Your answer is" + ansNS);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
