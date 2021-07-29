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
        if (quantity >= 0) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /*
    this method is called when the decrement is clicked
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /*
    this method is called when the order button is clicked
     */
    public void sendMessage(View view) {
        int price = calculatePrice();
        String priceMessage = orderSummary(price);
        displayMessage(priceMessage);

    }

    /*
     *this method returns order summary
     */
    private String orderSummary(int price){
        String priceMessage = "Name:CH.Sai Kumar\n"+ "Quantity:"+ quantity + "\n" + "Total: $" + price + "\nThank you!";
        return  priceMessage;
    }

    /*
     * this method calculates the price
     */
    private int calculatePrice(){
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


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}