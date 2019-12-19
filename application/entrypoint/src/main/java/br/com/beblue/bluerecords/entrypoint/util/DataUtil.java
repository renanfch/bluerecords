package br.com.beblue.bluerecords.entrypoint.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private DataUtil() {
    }

    public static boolean validarStringParaData(String data)
    {
        return data.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
    }

    public static LocalDate converteParaLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }
    public static String converteLocalDateParaString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.now().format(formatter);
    }
}
