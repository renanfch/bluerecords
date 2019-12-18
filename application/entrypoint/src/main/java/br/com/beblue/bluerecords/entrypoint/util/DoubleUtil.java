package br.com.beblue.bluerecords.entrypoint.util;

import java.text.NumberFormat;

public class DoubleUtil {

    private DoubleUtil(){}

    public static Double parseDouble(Double value)
    {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return Double.valueOf(format.format(value));
    }
}
