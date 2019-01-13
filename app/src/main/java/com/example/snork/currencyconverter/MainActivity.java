package com.example.snork.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //currency exchange rates as of 01/12/2019 5:20 PM
    double USDtoEuro = 0.872152;
    double USDtoPound = 0.778620;
    double USDtoRupee = 70.399353;
    double USDtoAustralia = 1.385441;
    double USDtoCA = 1.326494;
    double USDtoSingapore = 1.357358;
    double USDtoFranc = 0.983799;
    double USDtoRinggit = 4.096501;
    double USDtoYen = 108.512133;
    double USDtoYuan = 6.760737;
    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

    }



    public void convertCurrency(View view) {

        Map<String, Double> currencies = new HashMap<String, Double>() {{
            put("US Dollar", 1.00000);
            put("Euro", USDtoEuro);
            put("British Pound", USDtoPound);
            put("Indian Rupee", USDtoRupee);
            put("Australian Dollar", USDtoAustralia);
            put("CA Dollar", USDtoCA);
            put("Singapore Dollar", USDtoSingapore);
            put("Swiss Franc", USDtoFranc);
            put("Malaysian Ringgit", USDtoRinggit);
            put("Chinese Yuan Renminbi", USDtoYuan);
            put("Japanese Yen", USDtoYen);
        }};

        String val1 = (String) spinner.getSelectedItem();
        String val2 = (String) spinner.getSelectedItem();

        double dollars = 1.00000 / currencies.get(val1);
        double newCurrency = dollars * currencies.get(val2);

        Toast.makeText(this, val2, Toast.LENGTH_LONG).show();
    }

}
