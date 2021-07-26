package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
   creates a global variable and assigns value 2
    */
    int quantity =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        if (quantity >= 0) {
            quantity = quantity + 1;
            display(quantity);
        }
    }

    /*
    this method is called when the decrement is clicked
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
        }
    }
/*
this method is called when the order button is clicked
 */
    public void sendMessage(View view) {
        displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(
                R.id.price_text_view   );
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}