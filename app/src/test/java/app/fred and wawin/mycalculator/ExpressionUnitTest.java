package app.fred.mycalculator;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by u5553197 on 15/05/16.
 */
public class ExpressionUnitTest {
    @Test
    public void operationsTest() throws Exception{
        assertEquals(Double.parseDouble(CalcMethod.calc("1+1")),2.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("2-1")),1.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("2*2")),4.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("4/2")),2.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("√4")),2.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("2^2")),4.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("4%3")),1.00,0.01);
    }

    @Test
    public void negativeText() throws Exception{
        assertEquals(Double.parseDouble(CalcMethod.calc("(-1)-2")),-3.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("(-1)+2")),1.00,0.01);
    }

    @Test
    public void operationLevelTest() throws Exception{
        assertEquals(Double.parseDouble(CalcMethod.calc("2+2*2")),6.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("2+10/5+10*2")),24.00,0.01);
    }

    @Test
    public void logTest() throws Exception{
        assertEquals(Double.parseDouble(CalcMethod.calc("Log2")),0.30,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("Log10")),1.00,0.01);
    }

    @Test
    public void triTest() throws Exception{
        assertEquals(Double.parseDouble(CalcMethod.calc("Sin1")),0.84,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("Cos1")),0.54,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("Tan1")),1.56,0.01);
    }

    @Test
    public void braceTest() throws Exception{
        assertEquals(Double.parseDouble(CalcMethod.calc("3*(1+2)")),9.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("(5^2)/(6-1)")),5.00,0.01);
        assertEquals(Double.parseDouble(CalcMethod.calc("10-(1+(2*3))")),3.00,0.01);
    }

}
