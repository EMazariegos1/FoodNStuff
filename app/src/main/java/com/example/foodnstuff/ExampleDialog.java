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

public class ExampleDialog extends AppCompatDialogFragment implements ExampleDialog.ExampleDialogListener{
   private EditText editTextUsername;
   private EditText expirationDate;
   private ExampleDialogListener listener;
   private TextView textView;
   private Button button;

   public ExampleDialog() {
   }

   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState) {
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

      LayoutInflater inflater = getActivity().getLayoutInflater();
      View view = inflater.inflate(R.layout.layout_dialog, null);
      builder.setView(view)
              .setTitle("New Item")
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
      textView = view.findViewById(R.id.textView);
      return builder.create();
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
//TODO Figured it out, use a listener in mainactivity to send data right here and set it to the text for date. WEEWOOOO.
   @Override
   public void applyTexts2(String calenderDate) {
      textView.setText(calenderDate);
   }

   public interface ExampleDialogListener {
      void applyTexts(String username, String date);
   }
}
