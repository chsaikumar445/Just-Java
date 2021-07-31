package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
   creates a global variable and assigns value 2
    */
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        if (quantity <= 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /*
    this method is called when the decrement is clicked
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /*
    this method is called when the order button is clicked
     */
    public void sendMessage(View view) {
        int price = calculatePrice();
        CheckBox cream = findViewById(R.id.cream);
        boolean cream_status = cream.isChecked();
        CheckBox chocolate = findViewById(R.id.chocolate_check_box_view);
        boolean chocolate_status = chocolate.isChecked();
        EditText name = findViewById(R.id.name_edit_text_view);
        String name_text = name.getText().toString();
        String priceMessage = orderSummary(name_text, price, cream_status, chocolate_status);

        //create a mail intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order summary for "+name_text);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /*
     *this method returns order summary
     */
    private String orderSummary(String name_text, int price, boolean cream_status, boolean chocolate_status) {
        if (cream_status) {
            price = price + quantity * 1;
        }
        if (chocolate_status) {
            price = price + quantity * 2;
        }
        String priceMessage = "Name:" + name_text + "\nHas Whipped Cream?" + cream_status + "\nHas chocolate?" + chocolate_status + "\nQuantity:" + quantity + "\n" + "Total: $" + price + "\nThank you!";
        return priceMessage;
    }

    /*
     * this method calculates the price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}