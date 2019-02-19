package com.ye105.orderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class OderApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_app);




    }

    public void submitOrder(View view){
        EditText priceTextView = (EditText) findViewById(R.id.price_edit_view);
        TextView totalPriceTextView = (TextView) findViewById(R.id.total_order_text_view);
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox_Chocolate);
        String quantity = quantityTextView.getText().toString();
        CardView cardView = (CardView) findViewById(R.id.card_view_report);
        int num1 = Integer.parseInt(quantity);

        if (priceTextView.getText().length()>1){
            ArrayList items = new ArrayList();
            String price = priceTextView.getText().toString();
            double num2 = Double.parseDouble(price);
            double total = num1 * num2;
            String totalPrice = Double.toString(total);
            if (whippedCream.isChecked()){
                items.add("Whipped Cream");
                }
            if (chocolate.isChecked()){
                items.add("Chocolate");
            }
            cardView.setVisibility(View.VISIBLE);
            totalPriceTextView.setVisibility(View.VISIBLE);
            if (items.isEmpty()){

                totalPriceTextView.setText("Your totoal price is: "+totalPrice );
            }else{
//                String item = (",",items);
            totalPriceTextView.setText("Your total price is: "+totalPrice + "\n Your topping is: \n" + items);
            }
        }else{
            Toast.makeText(this,"Please enter price per item", Toast.LENGTH_SHORT).show();
        }
        String message = totalPriceTextView.getText().toString();
//        private void sendMail(){
//            EditText address = (EditText) findViewById(R.id.email_address);
//            String mailAddress = address.getText().toString();

        }

        public  void topping(View view){
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkbox_whipped_cream);


        }


    public void minus(View view){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String quantity = quantityTextView.getText().toString();
        int num1 = Integer.parseInt(quantity);
        if (num1 <=1){
            num1 =1;
        }else{
        num1 = num1 - 1;
        }
        quantity = Integer.toString(num1);
        quantityTextView.setText(quantity);
    }
    public void plus(View view){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String quantity = quantityTextView.getText().toString();
        int num1 = Integer.parseInt(quantity);
        num1 = num1 + 1;
        quantity = Integer.toString(num1);
        quantityTextView.setText(quantity);
    }

}
