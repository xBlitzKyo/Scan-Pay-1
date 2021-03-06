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

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;


public class electricity_page extends ActionBarActivity {

    private Button scanBtn;
    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_page);
        scanBtn = (Button) findViewById(R.id.scan_button);
        getSupportActionBar().hide();
        contentTxt = (TextView) findViewById(R.id.scan_content);

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.scan_button){
                    IntentIntegrator scanIntegrator = new IntentIntegrator(electricity_page.this);
                    scanIntegrator.initiateScan();
                }
            }
        });
    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(scanningResult != null) {
            String scanContent = scanningResult.getContents();
            //String scanFormat = scanningResult.getFormatName();

            Intent intent2 = new Intent(this, electric_payment.class);

            intent2.putExtra("scanContent", scanContent);
            //intent2.putExtra("scanFormat", scanFormat);
            startActivity(intent2);

            //formatTxt.setText("Format: " + scanFormat);
            //contentTxt.setText("Content: " + scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data retrieved", Toast.LENGTH_SHORT);
            toast.show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_electricity_page, menu);
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
