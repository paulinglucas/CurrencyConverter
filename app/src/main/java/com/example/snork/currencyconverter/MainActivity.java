package com.example.snork.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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



    //function called on button click
    public void convertCurrency(View view) {

        //HashMap of currency type and rates for easy access
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

        //HashMap of currencies and their symbols
        Map<String, String> symbols = new HashMap<String, String>() {{
            put("US Dollar", "$");
            put("Euro", "€");
            put("British Pound", "£");
            put("Indian Rupee", "₹");
            put("Australian Dollar", "AU$");
            put("CA Dollar", "$");
            put("Singapore Dollar", "$");
            put("Swiss Franc", "Fr.");
            put("Malaysian Ringgit", "RM");
            put("Chinese Yuan Renminbi", "¥");
            put("Japanese Yen", "¥");
        }};

        //used to access HashMap key/value pairs
        String val1 = (String) spinner.getSelectedItem();
        String val2 = (String) spinner2.getSelectedItem();

        //actual converting
        EditText amountText = (EditText) findViewById(R.id.editText);
        String amount = amountText.getText().toString();
        double money = Double.parseDouble(amount);
        double toDollars = (1.00000 / currencies.get(val1)) * money;
        double newCurrency = toDollars * currencies.get(val2);
        String newCurrencyString = String.format("%.2f", newCurrency);

        Toast.makeText(this, "Converted amount: " + symbols.get(val2) + newCurrencyString, Toast.LENGTH_LONG).show();
    }

}
