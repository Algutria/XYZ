package com.xyzmanillas.manillasxyz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText quantity;
    private TextView result;
    private Resources resources;
    private Spinner materialsSpinner,
                    pendantsSpinner,
                    metalTypesSpinner,
                    currencyTypesSpinner;
    private Button calculateButton, clearButton;
    private String materials[], pendants[], metalTypes[], currencyTypes[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        resources = this.getResources();
        quantity = findViewById(R.id.txtQuantity);
        result = findViewById(R.id.result);

        materialsSpinner = findViewById(R.id.materialsSpinner);
        pendantsSpinner = findViewById(R.id.pendantsSpinner);
        metalTypesSpinner = findViewById(R.id.metalTypesSpinner);
        currencyTypesSpinner = findViewById(R.id.currencyTypesSpinner);

        calculateButton = findViewById(R.id.calculateButton);
        clearButton= findViewById(R.id.clearButton);

        materials = resources.getStringArray(R.array.materials_list);
        pendants = resources.getStringArray(R.array.pendants_list);
        metalTypes = resources.getStringArray(R.array.metals_list);
        currencyTypes = resources.getStringArray(R.array.payment_methods_list);

        ArrayAdapter<String> materialsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, materials);
        materialsSpinner.setAdapter(materialsAdapter);

        ArrayAdapter<String> pendantsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pendants);
        pendantsSpinner.setAdapter(pendantsAdapter);

        ArrayAdapter<String> metalTypesAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, metalTypes);
        metalTypesSpinner.setAdapter(metalTypesAdapter);

        ArrayAdapter<String> currencyTypesAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyTypes);
        currencyTypesSpinner.setAdapter(currencyTypesAdapter);
    }

    public void calculate(View v){
        result.setText("HELLO THERE!");
    }
}
