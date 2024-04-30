
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alan
 */
public class main {

    public static void main(String args[]) {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, 11, 31); // hay que recordad que los meses van del 0 al 11

        String fechaPrestamo = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println(fechaPrestamo);

        cal.add(Calendar.DATE, 3);

        if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
            cal.add(Calendar.DATE, 2);
        }
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            cal.add(Calendar.DATE, 1);
        }

        String fechaDevolucion = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        System.out.println(fechaDevolucion);
    }
}
