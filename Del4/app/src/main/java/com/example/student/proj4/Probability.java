package com.example.student.proj4;

/**
 * Created by Cracker0 on 22.3.2018.
 */

import android.widget.EditText;
import android.view.View;

public class Probability {
    private Die die = new Die();
    private float probability;
    private int triesLeft;
    private EditText nrOfTriesLeft;
    public int same;
    public int aux;

    public Probability() {

    }

    public float DiceProbability(Die d1, Die d2, Die d3) {
        if(d1.getNr() == d2.getNr() ||  d1.getNr() == d3.getNr() || d1.getNr() == d3.getNr()) {

        }
        if (d2.getNr() == d3.getNr()) {

        }
        return probability;
    }

    private EditText TriesLeft(View v) {
        nrOfTriesLeft = (EditText)v.findViewById(R.id.editText_saveNumber);
        return nrOfTriesLeft;
    }

    @Override
    public String toString() {
        return "Probability: "+probability;
    }
}
