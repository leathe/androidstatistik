package del2.crackero.example.cracker0.del2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //public int buttonValue;
    int buttonValue_cat1_grp1;
    int buttonValue_cat2_grp1;
    int buttonValue_cat1_grp2;
    int buttonValue_cat2_grp2;
    TextView showResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showResult = (TextView) findViewById(R.id.textView_results);
    }

    public void onSave(View v) {

        EditText cat1 = (EditText)findViewById(R.id.text_category1);
        EditText cat2 = (EditText)findViewById(R.id.text_category2);
        EditText grp1 = (EditText)findViewById(R.id.text_group1);
        EditText grp2 = (EditText)findViewById(R.id.text_group2);

        TextView label_cat1 = (TextView)findViewById(R.id.labelOf_category1);
        TextView label_cat2 = (TextView)findViewById(R.id.labelOf_category2);
        TextView label_grp1 = (TextView)findViewById(R.id.labelOf_group1);
        TextView label_grp2 = (TextView)findViewById(R.id.labelOf_group2);

        label_cat1.setText(cat1.getText().toString());
        label_cat2.setText(cat2.getText().toString());
        label_grp1.setText(grp1.getText().toString());
        label_grp2.setText(grp2.getText().toString());

    }

    public void onButtonAction_Category1_Group1(View v) {
        buttonValue_cat1_grp1 += 1;
        Button button = (Button)findViewById(R.id.buttonAddTo_category1_group_1);
        button.setText("+ ("+String.valueOf(buttonValue_cat1_grp1)+")");
    }
    public void onButtonAction_Category2_Group1(View v) {
        buttonValue_cat2_grp1 += 1;
        Button button = (Button)findViewById(R.id.buttonAddTo_category2_group_1);
        button.setText("+ ("+String.valueOf(buttonValue_cat2_grp1)+")");
    }
    public void onButtonAction_Category1_Group2(View v) {
        buttonValue_cat1_grp2 += 1;
        Button button = (Button)findViewById(R.id.buttonAddTo_category1_group_2);
        button.setText("+ ("+String.valueOf(buttonValue_cat1_grp2)+")");
    }
    public void onButtonAction_Category2_Group2(View v) {
        buttonValue_cat2_grp2 += 1;
        Button button = (Button)findViewById(R.id.buttonAddTo_category2_group_2);
        button.setText("+ ("+String.valueOf(buttonValue_cat2_grp2)+")");
    }

    public void onButtonAction_button_chisquare(View v) {

        int[][] chiArray = new int[2][2];
        chiArray[0][0] = buttonValue_cat1_grp1;
        chiArray[0][1] = buttonValue_cat1_grp2;
        chiArray[1][0] = buttonValue_cat2_grp1;
        chiArray[1][1] = buttonValue_cat2_grp2;
        int df = ((chiArray.length - 1)*(chiArray[0].length -1));
//        Calculator calc = new Calculator(5000);
        showResult.setText("stat value: "+String.valueOf(Calculator.chiSquare(chiArray)) + "\n"+
        "p-value: "+String.valueOf("~"+Calculator.probTable(Calculator.chiSquare(chiArray))));
//        showResult.setText("ChiSquare statistic: "+String.valueOf(Calculator.chiSquare(chiArray)) +"\n"+
//                "p-value: "+String.valueOf(Calculator.getChiSqPValue(df, Calculator.chiSquare(chiArray)))+"\n"+
//                "ArrayLenght df: "+df+" .length: "+chiArray.length);
    }

}
