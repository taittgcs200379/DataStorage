package com.example.stotedata_cw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void handleButtonClick(View v){
            saveDetails();
    }
    public void showList(View V){
        Intent t = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(t);
    }
    private void  saveDetails(){
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        EditText Name =(EditText) findViewById(R.id.editTextText);
        EditText Dob=(EditText) findViewById(R.id.editTextText2);
        EditText Email=(EditText) findViewById(R.id.editTextText3);


        String name = Name.getText().toString();
        String dob= Dob.getText().toString();
        String email = Email.getText().toString();





            long hikeId = dbHelper.insertDetails(name,dob,email);
            Toast.makeText(this, "Hiking trip has been created with id: " + hikeId, Toast.LENGTH_LONG).show();



    }
}