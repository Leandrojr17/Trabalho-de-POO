package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    private static final NumberFormat FORMATO_VALORES = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double valor) {
        return FORMATO_VALORES.format(valor);
    }
}
