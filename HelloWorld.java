import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;  
import java.util.List;  
import java.util.stream.Collectors;

class BonusTask {

    public static void main(String args[]){
        printBonusDatesBetween(2010, 2030);
    }

    public static void printBonusDatesBetween(int startdate, int enddate){
        LocalDate startDate = LocalDate.parse(String.valueOf(startdate + "-01-01"));
        LocalDate endDate = LocalDate.parse(String.valueOf(enddate + "-01-01"));

        List<LocalDate> datesBetween = startDate.datesUntil(endDate).collect(Collectors.toList());
        
        for(LocalDate temp : datesBetween){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String string = temp.format(formatter);
            String year = string.substring(0, 4);
            StringBuffer sb = new StringBuffer(string.substring(4)).reverse();
            String mirror = sb.toString();
            if(year.equals(mirror)){
                System.out.println(temp);
            }
        }
    }
}