package app.fred.mycalculator;
/**
 * Created by u5553197 and u5542170 on 2016/4/23.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
    TextView input_expression;
    Button del, equal, openbrac, closebrac, square, root;
    Button log, sin, cos, tan, mod, divide, subtract, add, multiply;
    Button one, two, three, four, five, six, seven, eight, nine, dot, zero;
    Button fq;
    private String result;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        equal = (Button) findViewById(R.id.buttonEquals);
        del = (Button) findViewById(R.id.buttonClear);
        openbrac = (Button) findViewById(R.id.buttonOpenBracket);
        closebrac = (Button) findViewById(R.id.buttonCloseBracket);
        square = (Button) findViewById(R.id.buttonSquare);
        root = (Button) findViewById(R.id.buttonSquareRoot);
        log = (Button) findViewById(R.id.buttonLogarithm);
        sin = (Button) findViewById(R.id.buttonSine);
        cos = (Button) findViewById(R.id.buttonCosine);
        tan = (Button) findViewById(R.id.buttonTan);
        mod = (Button) findViewById(R.id.buttonPercent);
        divide = (Button) findViewById(R.id.buttonDivide);
        subtract = (Button) findViewById(R.id.buttonSubtract);
        add = (Button) findViewById(R.id.buttonAdd);
        multiply = (Button) findViewById(R.id.buttonMultiply);
        one = (Button) findViewById(R.id.button1);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        nine = (Button) findViewById(R.id.button9);
        dot = (Button) findViewById(R.id.buttonDecimalPoint);
        zero = (Button) findViewById(R.id.button0);
        fq = (Button)findViewById(R.id.button_faq);
        openbrac.setOnClickListener(this);
        closebrac.setOnClickListener(this);
        square.setOnClickListener(this);
        root.setOnClickListener(this);
        log.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        mod.setOnClickListener(this);
        divide.setOnClickListener(this);
        subtract.setOnClickListener(this);
        add.setOnClickListener(this);
        multiply.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        dot.setOnClickListener(this);

        input_expression = (TextView) findViewById(R.id.textView);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = CalcMethod.calc(input_expression.getText().toString());
                input_expression.setText(result);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_expression.setText("");
            }
        });

        fq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String introduction = "Introduction:" +"\n" +
                                    "1.Negative number must use (), eg: (-10)." + "\n" +
                                    "2.Trigonometric function and log function must use (), eg:(Sin3.14)" + "\n" +
                                    "3.Trigonometric function use radians" + "\n" +
                                    "4.Log function is based on 10.";
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("F&Q");
                alertDialog.setMessage(introduction);

                alertDialog.setButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Button b1 = (Button)v;
        input_expression.setText(input_expression.getText().toString()+b1.getText().toString());
    }
}

