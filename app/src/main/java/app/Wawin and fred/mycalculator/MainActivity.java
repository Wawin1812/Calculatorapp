package app.fred.mycalculator;
/**
 * Created by u5553197 and u5542170 on 2016/4/23.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button about;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about = (Button)findViewById(R.id.about_button);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("About");
                alertDialog.setMessage("MyCalculator is an expression calculator that developed by Yuheng and Wawin, press start button to use it.");

                alertDialog.setButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

    }

    public void startCalc(View view){
        Intent intent = new Intent(MainActivity.this,CalcActivity.class);
        startActivity(intent);
    }
}

