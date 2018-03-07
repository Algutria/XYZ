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

import java.text.NumberFormat;
import java.util.Locale;

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
        clearButton = findViewById(R.id.clearButton);

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

    public void calculate(View v) {
        result.setText("");

        if (validQuantity()) {
            double cant = Double.parseDouble(quantity.getText().toString());
            double totalValue = 0;
            int selectedMaterial, selectedPendant, selectedMetal, paymentMethod;

            selectedMaterial = materialsSpinner.getSelectedItemPosition();
            selectedPendant = pendantsSpinner.getSelectedItemPosition();
            selectedMetal = metalTypesSpinner.getSelectedItemPosition();
            paymentMethod = currencyTypesSpinner.getSelectedItemPosition();

            switch (selectedMaterial) {
                case 0: // For leather
                    switch (selectedPendant) {
                        case 0: // For hammer
                            switch (selectedMetal) {
                                case 0: // For gold and pink gold
                                case 1:
                                    totalValue = Methods.calculatePrice(100, cant, paymentMethod);
                                    break;
                                case 2: // For silver
                                    totalValue = Methods.calculatePrice(80, cant, paymentMethod);
                                    break;
                                case 3: // For nickel
                                    totalValue = Methods.calculatePrice(70, cant, paymentMethod);
                                    break;
                            }

                            break;
                        case 1: // For anchor
                            switch (selectedMetal) {
                                case 0: // For gold and pink gold
                                case 1:
                                    totalValue = Methods.calculatePrice(120, cant, paymentMethod);
                                    break;
                                case 2: // For silver
                                    totalValue = Methods.calculatePrice(100, cant, paymentMethod);
                                    break;
                                case 3: // For nickel
                                    totalValue = Methods.calculatePrice(90, cant, paymentMethod);
                                    break;
                            }

                            break;
                    }

                    break;
                case 1: // For rope
                    switch (selectedPendant) {
                        case 0: // For hammer
                            switch (selectedMetal) {
                                case 0: // For gold and pink gold
                                case 1:
                                    totalValue = Methods.calculatePrice(90, cant, paymentMethod);
                                    break;
                                case 2: // For silver
                                    totalValue = Methods.calculatePrice(70, cant, paymentMethod);
                                    break;
                                case 3: // For nickel
                                    totalValue = Methods.calculatePrice(50, cant, paymentMethod);
                                    break;
                            }

                            break;
                        case 1: // For anchor
                            switch (selectedMetal) {
                                case 0: // For gold and pink gold
                                case 1:
                                    totalValue = Methods.calculatePrice(110, cant, paymentMethod);
                                    break;
                                case 2: // For silver
                                    totalValue = Methods.calculatePrice(90, cant, paymentMethod);
                                    break;
                                case 3: // For nickel
                                    totalValue = Methods.calculatePrice(80, cant, paymentMethod);
                                    break;
                            }

                            break;
                    }

                    break;
            }

            result.setText("$" + NumberFormat.getNumberInstance().format(totalValue));
        }
    }

    public boolean validQuantity() {
        if (quantity.getText().toString().trim().isEmpty()) {
            quantity.requestFocus();
            quantity.setError(resources.getString(R.string.blank_quantity));
            return false;
        }

        return true;
    }

    public void clear(View v) {
        quantity.setText("");
        quantity.requestFocus();
        result.setText("");
        materialsSpinner.setSelection(0);
        pendantsSpinner.setSelection(0);
        metalTypesSpinner.setSelection(0);
        currencyTypesSpinner.setSelection(0);
    }
}
