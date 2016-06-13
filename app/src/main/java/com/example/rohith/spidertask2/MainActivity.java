package com.example.rohith.spidertask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String name,roll;                   //used to store entered values for name and roll number
    EditText editname,editroll;
    Spinner dept;
    CheckBox algos,appdev,tronix,webdev;
    Switch mentor;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Initializing each and every views
         */
        editname = (EditText) findViewById(R.id.editName);
        editroll = (EditText) findViewById(R.id.editRoll);
        dept = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.dept,android.R.layout.simple_spinner_dropdown_item);
        dept.setAdapter(adapter);
        algos = (CheckBox) findViewById(R.id.checkBox);
        appdev = (CheckBox) findViewById(R.id.checkBox2);
        tronix = (CheckBox) findViewById(R.id.checkBox3);
        webdev = (CheckBox) findViewById(R.id.checkBox4);
        mentor = (Switch) findViewById(R.id.switchMentor);
        submit = (Button) findViewById(R.id.submit);
    }

    public void submitting( View v) {       //function for the button submit, this time using xml
        name = editname.getText().toString();
        roll = editroll.getText().toString();
        int flag = 0;
        if(name.length() == 0) {            //checking for emptiness of name field
            Toast toast = Toast.makeText(this,"Name field is empty ...",Toast.LENGTH_SHORT);
            toast.show();
            flag++;
        }
        if(roll.length() == 0) {            //checking for empitiness of roll number field
            Toast toast = Toast.makeText(this,"Roll Number field is empty ...",Toast.LENGTH_SHORT);
            toast.show();
            flag++;
        }
        else if(roll.length() < 9) {        //as number of digits in roll number should be 9
            Toast toast = Toast.makeText(this,"Invalid Roll Number ... It should be 9 digits long ...",Toast.LENGTH_SHORT);
            toast.show();
            flag++;
        }
        if(!algos.isChecked() && !appdev.isChecked() && !tronix.isChecked() && !webdev.isChecked()) { //checking for selecting profile
            Toast toast = Toast.makeText(this,"Select a Profile ...",Toast.LENGTH_SHORT);
            toast.show();
            flag++;
        }

        if(flag == 0) {     //transforming to second activity
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            Intent i = new Intent(this, Main2Activity.class);
            i.putExtra("time",currentDateTimeString);
            i.putExtra("name",name);
            startActivity(i);
        }
    }

    @Override
    protected void onRestart() {    //to reset the values once back button is pressed
        super.onRestart();
        editname.setText("");
        editroll.setText("");
        algos.setChecked(false);
        tronix.setChecked(false);
        appdev.setChecked(false);
        webdev.setChecked(false);
        mentor.setChecked(false);
    }
}
