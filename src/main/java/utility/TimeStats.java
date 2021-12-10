package utility;
import java.util.*;

public class TimeStats {

    public String getDate(){
        java.util.Date date=new java.util.Date();        String datecsv=date.toString();
        String thedatecsv=date.toString();

        String[] field = datecsv.split(" ");

        StringBuilder outdata = new StringBuilder();

        outdata.append(field[0]).append(" ");
        outdata.append(field[1]).append(" ");
        outdata.append(field[2]).append(" ");
        outdata.append(field[5]).append(" ");

        return outdata.toString();

    }

}
