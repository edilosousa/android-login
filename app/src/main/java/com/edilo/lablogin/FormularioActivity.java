package com.edilo.lablogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    public static final String EXTRA_FNAME = "package com.edilo.lablogin.FNAME";
    public static final String EXTRA_LNAME = "package com.edilo.lablogin.LNAME";

    private EditText mFname;
    private EditText mLname;
    private Button mButtonSave;
    private Button mButtonDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        mFname  = findViewById(R.id.firstname);
        mLname  = findViewById(R.id.lastname);
        mButtonSave = findViewById(R.id.buttonsave);
        mButtonDisplay = findViewById(R.id.buttondisplay);

        mButtonSave.setEnabled(false);
        mLname.setEnabled(false);

        mFname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mLname.setEnabled(!editable.toString().isEmpty());
            }
        });

        mLname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mButtonSave.setEnabled(!editable.toString().isEmpty());
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fName = mFname.getText().toString();
                String lName = mLname.getText().toString();

                MyDataBaseHelper myDB = new MyDataBaseHelper(FormularioActivity.this);
                myDB.addPerson(fName.trim(), lName.trim());



            }
        });

        mButtonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDataBaseHelper myDB = new MyDataBaseHelper(FormularioActivity.this);

                Intent intent = new Intent(FormularioActivity.this, DisplayActivity.class);
                startActivity(intent);

            }
        });



    }
}