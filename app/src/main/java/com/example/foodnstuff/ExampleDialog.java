package com.example.foodnstuff;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class ExampleDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener{
   private EditText editTextUsername;
   private EditText expirationDate;
   private ExampleDialogListener listener;

   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState) {
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

      LayoutInflater inflater = getActivity().getLayoutInflater();
      View view = inflater.inflate(R.layout.layout_dialog, null);

      builder.setView(view)
              .setTitle("Login")
              .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {

                 }
              })
              .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    String username = editTextUsername.getText().toString();
                    String date = expirationDate.getText().toString();
                    listener.applyTexts(username, date);
                 }
              });

      editTextUsername = view.findViewById(R.id.food_name);
      expirationDate = view.findViewById(R.id.editTextDate);
      Button button = view.findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
         }
      });

      return builder.create();
   }

   @Override
   public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
      Calendar c = Calendar.getInstance();
      c.set(Calendar.YEAR, year);
      c.set(Calendar.MONTH, month);
      c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
      String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

      TextView textView = view.findViewById(R.id.textView);
      textView.setText(currentDateString);
   }

   @Override
   public void onAttach(Context context) {
      super.onAttach(context);

      try {
         listener = (ExampleDialogListener) context;
      } catch (ClassCastException e) {
         throw new ClassCastException(context.toString() +
                 "must implement ExampleDialogListener");
      }
   }

   public interface ExampleDialogListener {
      void applyTexts(String username, String date);
   }
}
