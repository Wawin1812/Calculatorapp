package app.fred.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by u5553197 and u5542170 on 2016/4/23.
 */
public class CalcMethod {
    private static final ArrayList<Character> OPERATIONS = new ArrayList<>(Arrays.asList('*', '/', '-', '+' , '^' , '%' , '√'));
    private static final int right = 1;
    private static final int left = -1;

    public static String calc(String expression) {
        int pos = 0;

        if (-1 != (pos = expression.indexOf("("))) {
            //check brace as first level of expression
            String subexpression = getSubexpression(expression, pos);
            expression = expression.replace("("+subexpression+")", calc(subexpression));

            return calc(expression);

        } else if(expression.indexOf("++") == 0 ||
                expression.indexOf("+-") == 0 ||
                expression.indexOf("-+") == 0 ||
                expression.indexOf("--") == 0 ){

            expression = expression.replace("++","+");
            expression = expression.replace("+-","-");
            expression = expression.replace("-+","-");
            expression = expression.replace("--","+");
            return calc(expression);

        } else if ((pos = expression.indexOf("*")) > 0 ||
                   (pos = expression.indexOf("/")) > 0 ||
                   (pos = expression.indexOf("%")) > 0 ||
                   (pos = expression.indexOf("^")) > 0 ||
                   (pos = expression.indexOf("√")) >= 0){

            if (expression.charAt(pos)=='√'){
                //special case of open square operation
                String rightNum = getNumber(expression, pos, right);

                expression = expression.replace('√'+rightNum,Double.toString(Math.sqrt(Double.parseDouble(rightNum))));

                return calc(expression);
            }else {
                //other operations
                char divider = expression.charAt(pos);

                String leftNum = getNumber(expression, pos, left);
                String rightNum = getNumber(expression, pos, right);

                expression = expression.replace(leftNum + divider + rightNum, resultOfOperation(leftNum, rightNum, divider));

                return calc(expression);
            }

        } else if((-1 != (pos = expression.indexOf("Sin")))||
                  (-1 != (pos = expression.indexOf("Cos")))||
                  (-1 != (pos = expression.indexOf("Tan")))||
                  (-1 != (pos = expression.indexOf("Log")))) {
            // case of triangle function and log function

            pos +=2;

            String number = getNumber(expression, pos, right);
            if(expression.charAt(pos-2) == 'S'){
                expression = expression.replace("Sin" + number, Double.toString(Math.sin(Double.parseDouble(number))));}
            if(expression.charAt(pos-2) == 'C'){
                expression = expression.replace("Cos" + number, Double.toString(Math.cos(Double.parseDouble(number))));}
            if(expression.charAt(pos-2) == 'T'){
                expression = expression.replace("Tan" + number, Double.toString(Math.tan(Double.parseDouble(number))));}
            if(expression.charAt(pos-2) == 'L'){
                expression = expression.replace("Log" + number, Double.toString(Math.log10(Double.parseDouble(number))));}

            return calc(expression);

        } else if ((pos = expression.indexOf("+")) > 0) {

            char divider = expression.charAt(pos);

            String leftNum = getNumber(expression, pos, left);
            String rightNum = getNumber(expression, pos, right);

            if (expression.charAt(0) == '-') {
                expression = expression.replace('-' + leftNum + divider + rightNum, resultOfOperation(rightNum, leftNum, '-'));
            }else {
                expression = expression.replace(leftNum+divider+rightNum, resultOfOperation(leftNum, rightNum, divider));
            }

            return calc(expression);

        } else if ((pos = expression.indexOf('-')) >= 0){
            if(pos == 0 && expression.substring(1).contains("-")){

                int minepos = expression.substring(1).indexOf('-');
                char divider = expression.charAt(minepos+1);
                String leftNum = getNumber(expression, minepos + 1, left);
                String rightNum = getNumber(expression, minepos + 1, right);
                expression = expression.replace('-'+leftNum+divider+rightNum,'-'+ resultOfOperation(leftNum, rightNum, '+'));
                return calc(expression);

            }else if(pos != 0){
                char divider = expression.charAt(pos);
                String leftNum = getNumber(expression, pos, left);
                String rightNum = getNumber(expression, pos, right);
                expression = expression.replace(leftNum + divider + rightNum, resultOfOperation(leftNum, rightNum, divider));
                return calc(expression);
            }else{
                return expression;
            }

        } else return expression;
    }

    private static String resultOfOperation(String leftNum, String rightNum, char divider) {
        switch (divider) {
            case '*':
                return Double.toString(Double.parseDouble(leftNum) * Double.parseDouble(rightNum));
            case '/':
                return Double.toString(Double.parseDouble(leftNum) / Double.parseDouble(rightNum));
            case '+':
                return Double.toString(Double.parseDouble(leftNum) + Double.parseDouble(rightNum));
            case '-':
                return Double.toString(Double.parseDouble(leftNum) - Double.parseDouble(rightNum));
            case '%':
                return Double.toString(Double.parseDouble(leftNum) % Double.parseDouble(rightNum));
            case '^':
                return Double.toString(Math.pow(Double.parseDouble(leftNum),Double.parseDouble(rightNum)));
            default:
                return "0";
        }

    }

    private static String getSubexpression(String expression, int pos) {
        int depth = 1;
        String subexpression="";

        for (int i = pos+1; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '(':
                    depth++;
                    subexpression += "(";
                    break;
                case ')':
                    depth--;
                    if (depth != 0) subexpression += ")";
                    break;
                default:
                    if (depth > 0) subexpression += expression.charAt(i);

            }
            if (depth == 0 && !subexpression.equals("")) return subexpression;
        }
        return "Expression error !";
    }

    public static String getNumber(String expression, int pos, int direction) {

        String resultNumber = "";
        int currPos = pos + direction;

        //special case for negative numbers
        if (expression.charAt(currPos) == '-') {
            resultNumber+=expression.charAt(currPos);
            currPos+=direction;
        }

        for (; currPos >= 0 &&
                currPos < expression.length() &&
                !OPERATIONS.contains(expression.charAt(currPos));
             currPos += direction) {
            resultNumber += expression.charAt(currPos);
        }

        if (direction== left) resultNumber = new StringBuilder(resultNumber).reverse().toString();

        return resultNumber;
    }



}
