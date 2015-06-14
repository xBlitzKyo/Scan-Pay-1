package com.example.lee.scanpay;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class bank_page extends ActionBarActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_page);
        button = (Button) findViewById(R.id.continue_button);
        getSupportActionBar().hide();

        Spinner spinnerBank = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter <CharSequence> adapterBank = ArrayAdapter.createFromResource(this, R.array.bankArray, android.R.layout.simple_spinner_item);
        spinnerBank.setAdapter(adapterBank);


    }

    public void success(View view){
        Intent intent = new Intent(this, success_page.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bank_page, menu);
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
