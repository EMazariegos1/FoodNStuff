package com.example.foodnstuff;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
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
                    listener.applyTexts2(username, date);
                 }
              });

      editTextUsername = view.findViewById(R.id.food_name);
      expirationDate = view.findViewById(R.id.ex_year);
      textView = view.findViewById(R.id.expirationTV);
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

   public interface ExampleDialogListener {
       void applyTexts2(String username, String date);
   }
}
