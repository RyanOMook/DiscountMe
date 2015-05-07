package ryanmullings.discountme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class main extends Activity {
    //Variables
    double discountRate = 0; //discount value selected
    int id = 0; //Radio id number
    double totalB;//final value before taxes
    double totalA;//final value after taxes
    String message= "Please Enter a number in the box above"; //Toast message
    String sNum; //string version of the number
    double cost = 0; //Value user enters into the edit text box

    public void setValues(double a, double b){
        TextView ans = (TextView)this.findViewById(R.id.bValue); //creates a text view
        String sAns = Double.toString(a); //change the answer to a string
        ans.setText("$"+sAns);

        TextView ans2 = (TextView)this.findViewById(R.id.aValue);
        sAns = Double.toString(b);
        ans2.setText("$"+sAns);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculate = (Button)this.findViewById(R.id.calc); //Create button
        RadioGroup set = (RadioGroup) findViewById(R.id.grouped); //Creates radio group

        //When a radio button in the radio group gets pressed
        set.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedid) {
            // checkedId is the RadioButton selected
                id = checkedid;
                System.out.println(checkedid);
                //Depending on what the ID of the radio button is. The discount rate will change
                if(id == 2131230726){
                    discountRate = 0.05;
                }
                else if(id == 2131230727){
                    discountRate = 0.10;
                }
                else if(id == 2131230729){
                    discountRate = 0.15;
                }
                else if(id == 2131230728){
                    discountRate = 0.20;
                }
                else if(id == 2131230730){
                    discountRate = 0.25;
                }
                else if(id == 2131230731){
                    discountRate = 0.30;
                }
                else if(id == 2131230732){
                    discountRate = 0.35;
                }
                else if(id == 2131230733){
                    discountRate = 0.40;
                }
                else if(id == 2131230734){
                    discountRate = 0.45;
                }
                else if(id == 2131230735){
                    discountRate = 0.50;
                }
                else if(id == 2131230736){
                    discountRate = 0.55;
                }
                else if(id == 2131230737){
                    discountRate = 0.60;
                }
                else if(id == 2131230738){
                    discountRate = 0.65;
                }
                else if(id == 2131230739){
                    discountRate = 0.70;
                }
                else if(id == 2131230740){
                    discountRate = 0.75;
                }
                else if(id == 2131230741){
                    discountRate = 0.80;
                }
                else if(id == 2131230742){
                    discountRate = 0.85;
                }
                else if(id == 2131230743){
                    discountRate = 0.90;
                }
        }
        });

        //WHEN THE BUTTON ITS SELF IS ACTUALLY CLICKED
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //When clicked
                EditText num = (EditText) findViewById(R.id.numb); //Gets the value that was entered
                sNum = num.getText().toString();
                //If the user did not enter an item price. Show toast message
                if(sNum.matches("")){
                    Toast.makeText(main.this,message,Toast.LENGTH_SHORT).show();
                }
                //If the user did enter an item price. Calculate values before / after taxes
                else {
                    cost = Double.parseDouble(num.getText().toString()); //sets the cost variable to the entered value
                    totalB = 100*(cost - (cost * discountRate)); //Calculate the total before taxes and round to 2 decimal places
                    totalB = Math.round(totalB);
                    totalB = totalB / 100;
                    totalA = 100*(1.13*(cost - (cost * discountRate))); //Calculate the total after taxes and round to 2 decimal places
                    totalA =Math.round(totalA);
                    totalA = totalA / 100;

                    setValues(totalB, totalA);
                }
            }
        });
    }
}
