package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "GuessPricePrefs";
    private static final String KEY_LAST_GUESS_DATE = "last_guess_date";

    private static final int CORRECT_PRICE = 1562;
    private static final int PRICE_VARIATION = 500;
    private ImageView backgroundImage;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundImage = findViewById(R.id.background_image);
        handler = new Handler();

        // Show the background image for 2 seconds, then show the pop-up if the user hasn't guessed today
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (canGuessToday()) {
                    showGuessPricePopup();
                }
            }
        }, 2000); // 2 seconds delay
    }

    private boolean canGuessToday() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        long lastGuessDate = prefs.getLong(KEY_LAST_GUESS_DATE, 0);
        Calendar lastGuessCalendar = Calendar.getInstance();
        lastGuessCalendar.setTimeInMillis(lastGuessDate);

        Calendar today = Calendar.getInstance();
        return today.get(Calendar.DAY_OF_YEAR) != lastGuessCalendar.get(Calendar.DAY_OF_YEAR)
                || today.get(Calendar.YEAR) != lastGuessCalendar.get(Calendar.YEAR);
    }

    private void showGuessPricePopup() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.guess_popup_price);
        dialog.getWindow().setLayout((int)(getResources().getDisplayMetrics().widthPixels * 0.75),
                RadioGroup.LayoutParams.WRAP_CONTENT); // Adjust height to wrap content

        ImageView itemImage = dialog.findViewById(R.id.item_image);
        RadioGroup radioGroup = dialog.findViewById(R.id.radio_group);
        Button submitButton = dialog.findViewById(R.id.submit_button);

        List<Integer> prices = generatePriceOptions(CORRECT_PRICE, PRICE_VARIATION);

        // Assign prices to radio buttons
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            radioButton.setText("Rs " + prices.get(i));
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = dialog.findViewById(selectedId);
                    String selectedPrice = selectedRadioButton.getText().toString().replace("Rs ", "");

                    // Validate the guessed price
                    if (selectedPrice.equals(String.valueOf(CORRECT_PRICE))) {
                        showCustomToast("Correct! You've earned supercoins! \uD83D\uDCB0");
                        updateLastGuessDate();
                    } else {
                        showCustomToast("Incorrect guess. Try again tomorrow!");
                    }
                    dialog.dismiss();
                    showBackgroundImage();
                } else {
                    showCustomToast("Please select an option!");
                }
            }
        });

        dialog.show();
    }

    private List<Integer> generatePriceOptions(int correctPrice, int variation) {
        List<Integer> prices = new ArrayList<>();
        prices.add(correctPrice);

        Random random = new Random();
        while (prices.size() < 4) {
            int price = correctPrice + random.nextInt(2 * variation) - variation;
            if (!prices.contains(price) && price > 0) {
                prices.add(price);
            }
        }

        Collections.shuffle(prices);
        return prices;
    }

    private void updateLastGuessDate() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(KEY_LAST_GUESS_DATE, Calendar.getInstance().getTimeInMillis());
        editor.apply();
    }

    private void showBackgroundImage() {
        backgroundImage.setVisibility(View.VISIBLE);
    }

    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.toast_message);
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
