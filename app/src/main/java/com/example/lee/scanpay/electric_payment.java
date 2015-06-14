package com.example.lee.scanpay;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class electric_payment extends ActionBarActivity {

    private TextView formatTxt, contentTxt;
    String scanFormat, scanContent;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_payment);
        button = (Button) findViewById(R.id.pay_button);
        Intent intent = getIntent();
        scanContent = intent.getStringExtra("scanContent");

        getSupportActionBar().hide();
        contentTxt = (TextView) findViewById(R.id.scan_content);

        String bill_no;
        String name;
        String due_date;
        String outstanding;

        String s[] = scanContent.split("\n");
        bill_no = s[0];
        name = s[1];
        due_date = s[2];
        outstanding = s[3];


        TextView textBillNo = (TextView) findViewById(R.id.bill_no);
        textBillNo.setText(bill_no);

        TextView textName = (TextView) findViewById(R.id.name);
        textName.setText(name);

        TextView textDue_Date = (TextView) findViewById(R.id.due_date);
        textDue_Date.setText(due_date);

        TextView textOutstanding = (TextView) findViewById(R.id.outstanding);
        textOutstanding.setText(outstanding);

    }

    public void goBank(View view){
        Intent intent = new Intent(this, bank_page.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_electric_payment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
