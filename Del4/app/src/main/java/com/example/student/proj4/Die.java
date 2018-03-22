package com.example.student.proj4;

import android.media.Image;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by karlssoj on 19.3.2018.
 */

public class Die
{
    //Tärningens siffra
    private int nr;
    //Variabel som anger om tärningen är låst eller ej
    private boolean locked;
    //Variabel som berättar vad som ska stå i låsknappen ("lås" eller "lås upp")
    private String lockText;
    //En Random-variabel som vi använder senare för att generera slumptal
    private Random r;

    //Konstruktorn. Anropas när man från MainActivity skapar ett nytt objekt av Die med new
    public Die()
    {
        //När man skapar en  ny Die (tärning) ska:
        //- den inte vara låst
        locked = false;
        //- texten i låsknappen ska vara "lås"
        lockText = "lås";
        //- vi skapa ett nytt objekt av klassen Random för att kunna generera slumptal
        r = new Random();
        //- anropa metoden randomize() för att generera ett nytt slumptal (slumpa fram en ny sida för tärningen (1-6))
        randomize();
    }

    //Returnerar texten som ska visas i låsknappen för tärningen
    public String getLockText()
    {
        return lockText;
    }

    //Returnerar tärningens siffra
    public int getNr()
    {
        return nr;
    }

    //Returnerar värdet av locked-variabeln
    public boolean getLocked()
    {
        return locked;
    }

    //Hanterar vad som ska hända om man trycker på låsknappen för innevarande tärning. Denna metod
    //anropas från MainActivity från onLock-metoderna.
    public void handleLock()
    {
        //Om tärningen redan är låst ska vi låsa upp den
        if(locked == true)
        {
            locked = false;
            lockText = "lås";
        }

        //Om tärningen inte är låst ska vi låsa den.
        else
        {
            locked = true;
            lockText = "lås upp";
        }
    }

    public void unlockAll() {
        locked = false;
        lockText = "lås";
    }
    //Genererar ett slumptal mellan 1 och 6 (Simulerar att vi kastar tärningen)
    public void randomize()
    {
        nr = r.nextInt(6) + 1;
    }
}
