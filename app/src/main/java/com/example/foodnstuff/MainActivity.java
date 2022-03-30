package com.example.foodnstuff;

import androidx.appcompat.app.AppCompatActivity;
 Eric
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView foodList;
    List<String> names;
    List<Integer> images;
    FoodListAdaptor adaptor;

import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private TextView textViewUsername;
    private TextView textViewPassword;
    private Button opdialog;

 master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 Eric
        foodList = findViewById(R.id.food_list);

        names = new ArrayList<>();
        images = new ArrayList<>();

        names.add("one");
        names.add("two");
        names.add("three");
        names.add("four");
        names.add("four");
        names.add("four");
        names.add("four");
        names.add("four");

        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
        images.add(R.drawable.chicken);
//code for recyclerview
        adaptor = new FoodListAdaptor(this, names, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        foodList.setLayoutManager(gridLayoutManager);
        foodList.setAdapter(adaptor);

        textViewUsername = findViewById(R.id.textview_username);
        textViewPassword = findViewById(R.id.textview_password);

        LayoutInflater inflater = this.getLayoutInflater();


        opdialog = findViewById(R.id.open_dialog);
        opdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }


    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }


    @Override
    public void applyTexts2(String username, String password) {
        textViewUsername.setText(username);
        textViewPassword.setText(password);
 master
    }
}