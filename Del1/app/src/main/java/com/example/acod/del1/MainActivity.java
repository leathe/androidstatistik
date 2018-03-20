package com.example.acod.del1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import android.widget.ArrayAdapter;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    ArrayList<Person> persons;
    ArrayList<Float> values;
    TextView showResult;
    ListView showPersons;
    List<EditText> textFields;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persons = new ArrayList();
        values = new ArrayList();
        textFields = new ArrayList();
        showResult = (TextView) findViewById(R.id.resultText);
    }

    private List<EditText> getFieldInputs() {
        EditText inputFName = (EditText)findViewById(R.id.addFirstName);
        EditText inputLName = (EditText)findViewById(R.id.addLastName);
        EditText inputAge = (EditText)findViewById(R.id.addAge);
        textFields.addAll(Arrays.asList(inputFName, inputLName, inputAge));
        return textFields;
    }

    private void calculateData() {
        float addAge;
        String addFirstName = getFieldInputs().get(0).getText().toString();
        String addLastName = getFieldInputs().get(1).getText().toString();

        addAge = Float.valueOf(getFieldInputs().get(2).getText().toString());
        persons.add(new Person(addFirstName, addLastName, addAge));
        values.add(addAge);

        showPersons = (ListView) findViewById(R.id.allPersons);
        String[] stringArray = new String[persons.size()];
        for(int i=0;i<persons.size();i++){
            stringArray[i] = persons.get(i).getFirstN()+" "+persons.get(i).getLastN()+" "+String.valueOf(persons.get(i).getAge());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);
        showPersons.setAdapter(adapter);

        float[] valuesArray = listToArray();
        float median = Statistics.getMedian(valuesArray);
        float average = Statistics.getAverage(valuesArray);
        showResult.setText("Min: "+String.valueOf(Statistics.getMin(valuesArray))+
                ", Max: "+String.valueOf(Statistics.getMax(valuesArray))+
                ", Avg: "+String.valueOf(average)+
                ", StDev: "+String.valueOf(Statistics.getStdev(valuesArray))+
                ", Median: "+String.valueOf(median)+
                ", LQ: "+String.valueOf(Statistics.getLq(valuesArray))+
                ", UQ: "+String.valueOf(Statistics.getUq(valuesArray))+
                ", IQR: "+String.valueOf(Statistics.getIqr(valuesArray)));

    }

    public void onSave(View v) {
        if (getFieldInputs().get(2) == null || TextUtils.isEmpty(getFieldInputs().get(2).getText()) || getFieldInputs().get(2).getText() == null || getFieldInputs().get(2).getText().toString() == "") {
            AlertDialog errorDiag = new AlertDialog.Builder(MainActivity.this).create();
            errorDiag.setTitle("Warning: Missing Age");
            errorDiag.setMessage("No value was found in field Age. \nField is required.");
            errorDiag.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            errorDiag.show();
        } else {
            calculateData();
        }
    }
    public float[] listToArray(){
        float[] vals = new float[values.size()];
        for(int i = 0; i < vals.length; i++){
            vals[i] = values.get(i);
        }
        return vals;
    }

}