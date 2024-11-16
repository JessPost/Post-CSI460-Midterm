package com.example.postmidtermphonebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateContactActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText fNameEdt, lNameEdt, phoneEdt, addressEdt;
    private Button updateContactBtn, deleteContactBtn;
    private DBHandler dbHandler;
    String contactFirstName, contactLastName, contactPhone, contactAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        // initializing all our variables.
        fNameEdt = findViewById(R.id.idEdtFirstName);
        lNameEdt = findViewById(R.id.idEdtLastName);
        phoneEdt = findViewById(R.id.idEdtPhoneNumber);
        addressEdt = findViewById(R.id.idEdtAddress);
        updateContactBtn = findViewById(R.id.idBtnUpdateContact);
        deleteContactBtn = findViewById(R.id.idBtnDeleteContact);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateContactActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        contactFirstName = getIntent().getStringExtra("fname");
        contactLastName = getIntent().getStringExtra("lname");
        contactPhone = getIntent().getStringExtra("phone");
        contactAddress = getIntent().getStringExtra("address");

        // setting data to edit text
        // of our update activity.
        fNameEdt.setText(contactFirstName);
        lNameEdt.setText(contactLastName);
        phoneEdt.setText(contactPhone);
        addressEdt.setText(contactAddress);

        // adding on click listener to our update contact button.
        updateContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update contact
                // method and passing all our edit text values.
                dbHandler.updateContact(contactFirstName, fNameEdt.getText().toString(), lNameEdt.getText().toString(), phoneEdt.getText().toString(), addressEdt.getText().toString());

                // displaying a toast message that our contact has been updated.
                Toast.makeText(UpdateContactActivity.this, "Contact Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateContactActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our contact.
        deleteContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our contact.
                dbHandler.deleteContact(contactFirstName);
                Toast.makeText(UpdateContactActivity.this, "Deleted the contact", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateContactActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
