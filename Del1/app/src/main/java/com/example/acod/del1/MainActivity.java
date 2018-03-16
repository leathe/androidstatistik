package com.example.acod.del1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity{
    ArrayList<Person> persons;
    ArrayList<Float> values;
    TextView showResult;
    ListView showPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persons = new ArrayList();
        values = new ArrayList();

        showResult = (TextView) findViewById(R.id.resultText);
    }
    public void onSave(View v){
        EditText inputFName = (EditText)findViewById(R.id.addFirstName);
        EditText inputLName = (EditText)findViewById(R.id.addLastName);
        EditText inputAge = (EditText)findViewById(R.id.addAge);

        String addFirstName = inputFName.getText().toString();
        String addLastName = inputLName.getText().toString();
        float addAge = Float.valueOf(inputAge.getText().toString());
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
    public float[] listToArray(){
        float[] vals = new float[values.size()];
        for(int i = 0; i < vals.length; i++){
            vals[i] = values.get(i);
        }
        return vals;
    }

}