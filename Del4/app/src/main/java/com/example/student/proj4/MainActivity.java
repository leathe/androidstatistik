package com.example.student.proj4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    //Deklararer tre variabler av typen Die (en egen klass som definierar egenskaper för en tärning)
    Die d1; //Första tärningen
    Die d2; //Andra tärningen
    Die d3; //Tredje tärningen

    //Deklarerar tre variabler av typen ImageView som vi senare kopplar ihop med de tärnings-imagivien som
    //vi "draggat" in i spelvyn
    ImageView iv1; //Första tärningen
    ImageView iv2; //Andra tärningen
    ImageView iv3; //Tredje tärningen

    //Deklarerar tre variabler av typen Button som vi senare kopplar ihop med knapparna under tärningarna
    //som vi använder för att låsa tärningarna med
    Button b1; //Första låsknappen
    Button b2; //Andra låsknappen
    Button b3; //Tredje låsknappen
    DataPoint dp;
    Button bThrow;
    GraphView graph;
    EditText nrOfTries;
    TextView textView_probability;

    int clickCounter = 0;
    @Override
    //Denna metod anropas när appen startar

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Skapar nya instanser av varje Die-variabel (detta anropar konstruktorn inne i Dia-klassen)
        d1 = new Die();
        d2 = new Die();
        d3 = new Die();

        //Kopplar ihop ImageView-variablerna med ImageView komponenterna för tärningarna i appens vy
        iv1 = findViewById(R.id.tarning1);
        iv2 = findViewById(R.id.tarning2);
        iv3 = findViewById(R.id.tarning3);

        //Kopplar ihop Button-variablerna med Button-komponenterna för låsknapparna i appens vy
        b1 = findViewById(R.id.lock1);
        b2 = findViewById(R.id.lock2);
        b3 = findViewById(R.id.lock3);
        textView_probability = findViewById(R.id.textView_probability);
        bThrow = findViewById(R.id.throwButton);
        //När spelet startas kastar vi automatiskt tärningarna (utan att manuellt klicka på "KASTA"

        //onThrow(findViewById(R.id.throwButton));
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        bThrow.setEnabled(false);
    }

    //Anropas när man trycker på knappen "KASTA!"
    public void onThrow(View v)
    {
        if(clickCounter < Integer.parseInt(nrOfTries.getText().toString())) {
            //Ställer in bilden för den första tärningen enligt egenskaperna i Die-objektet d1
            setImage(iv1, d1);

            //Ställer in bilden för den första tärningen enligt egenskaperna i Die-objektet d2
            setImage(iv2, d2);

            //Ställer in bilden för den första tärningen enligt egenskaperna i Die-objektet d3
            setImage(iv3, d3);
            //(setImage är en egen metod definierad lägre ner
        }

        clickCounter++;

        if (clickCounter >= Integer.parseInt(nrOfTries.getText().toString())) {
            bThrow.setEnabled(false);
//            System.out.print("Exceeded number of tries.");
        }
        showProbability();
    }

    //Anropas när man trycker på den första låsknappen
    public void onLock1 (View v)
    {
        d1.handleLock();
        b1.setText(d1.getLockText());
    }

    //Anropas när man trycker på den andra låsknappen
    public void onLock2 (View v)
    {
        d2.handleLock();
        b2.setText(d2.getLockText());
    }

    //Anropas när man trycker på den tredje låsknappen
    public void onLock3 (View v)
    {
        d3.handleLock();
        b3.setText(d3.getLockText());
    }

    //Slumpar ut en ny siffra (1-6) och ställer in bilden på tärnignen enligt siffran
    public void setImage(ImageView iv, Die d)
    {
        //Vi slumpar ut en ny siffra och byter bild ENDAST om tärningen inte är låst!
        if(d.getLocked() == false)
        {
            //Gerererar ett nytt slumptal för tärningen
            d.randomize();

            //Bygger upp "resourceID" enligt vad tärningens nya siffra blev, om siffran exempelvis blev 2 ska
            //resourceID vara d2 eftersom bilden för en 1:a heter d1, bilden för en 2:a heter d2 osv...
            String imgIdStr = "d" + String.valueOf(d.getNr());
            int resourceID = getResources().getIdentifier(imgIdStr, "drawable", getPackageName());

            //Ställer in bilden för tärningen enligt "resourceID"
            iv.setImageResource(resourceID);
        }
    }

    public void resetDice() {
        d1.unlockAll();
        b1.setText("lås");
        d2.unlockAll();
        b2.setText("lås");
        d3.unlockAll();
        b3.setText("lås");
        setImage(iv1, d1);
        setImage(iv2, d2);
        setImage(iv3, d3);
        textView_probability.setText("");
    }

    public void button_saveNumber(View v) {
        resetDice();
        nrOfTries = (EditText)findViewById(R.id.editText_saveNumber);
        bThrow.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        clickCounter = 0;
    }

    public void showProbability() {

        float prob = 0f;
        // Ingen låst tärning.
        if (!d1.getLocked() && !d2.getLocked() && !d3.getLocked()) {
            prob = 1 - ((float)Math.pow((((35f/36f))),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }

        // En låst tärning.
        else if (d1.getLocked() && !d2.getLocked() && !d3.getLocked()) {
            prob = 1 - ((float)Math.pow((((35f/36f))),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }
        else if (!d1.getLocked() && d2.getLocked() && !d3.getLocked()) {
            prob = 1 - ((float)Math.pow((((35f/36f))),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }
        else if (!d1.getLocked() && !d2.getLocked() && d3.getLocked()) {
            prob = 1 - ((float)Math.pow((((35f/36f))),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }

        // Två låsta tärningar.
        else if (!d1.getLocked() && d2.getLocked() && d3.getLocked()) {
            prob = 1 - ((float)Math.pow(((5f/6f)),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }
        else if (d1.getLocked() && !d2.getLocked() && d3.getLocked()) {
            prob = 1 - ((float)Math.pow(((5f/6f)),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }
        else if (d1.getLocked() && d2.getLocked() && !d3.getLocked()) {
            prob = 1 - ((float)Math.pow(((5f/6f)),Integer.parseInt(nrOfTries.getText().toString()) - clickCounter));
        }
        // Alla låsta.
        else {
            prob = 0f;
        }
        textView_probability.setText("Sannolikhet: " + prob * 100+"%");

        if (d1.getNr() == d2.getNr() && d1.getNr() == d3.getNr()) {
            textView_probability.setText("Du lyckades! Alla tärningar visar " + d1.getNr()+"!"+"\n"+
            "Det tog "+ clickCounter +"/"+ Integer.parseInt(nrOfTries.getText().toString()) +" försök.");
            bThrow.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
        }
    }
}
