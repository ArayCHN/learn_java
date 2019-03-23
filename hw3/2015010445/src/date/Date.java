package date;

public class Date {
    int year, month, day;
    Date(String a) {
        switch (a.substring(0, 4)) {
            case "Jan.": month = 1; break;
            case "Feb.": month = 2; break;
            case "Mar.": month = 3; break;
            case "Apr.": month = 4; break;
            case "May.": month = 5; break;
            case "Jun.": month = 6; break;
            case "Jul.": month = 7; break;
            case "Aug.": month = 8; break;
            case "Sept": month = 9; break;
            case "Oct.": month = 10; break;
            case "Nov.": month = 11; break;
            case "Dec.": month = 12; break;
        }
        if (month == 9) {
            if (a.charAt(7) == ',') {
                day = Integer.parseInt(a.substring(6, 7));
                year = Integer.parseInt(a.substring(9, 13));
            }
            else {
                day = Integer.parseInt(a.substring(6, 8));
                year = Integer.parseInt(a.substring(10, 14));
            }
        }
        else {
            if (a.charAt(6) == ',') {
                day = Integer.parseInt(a.substring(5, 6));
                year = Integer.parseInt(a.substring(8, 12));
            }
            else {
                day = Integer.parseInt(a.substring(5, 7));
                year = Integer.parseInt(a.substring(9, 13));
            }
        }
    }
    Date(String a, int day_in, int year_in) {
        switch (a) {
            case "Jan.": month = 1; break;
            case "Feb.": month = 2; break;
            case "Mar.": month = 3; break;
            case "Apr.": month = 4; break;
            case "May.": month = 5; break;
            case "Jun.": month = 6; break;
            case "Jul.": month = 7; break;
            case "Aug.": month = 8; break;
            case "Sept.": month = 9; break;
            case "Oct.": month = 10; break;
            case "Nov.": month = 11; break;
            case "Dec.": month = 12; break;
        }
        day = day_in;
        year = year_in;
    }
    Date(int year_in, int month_in, int day_in) {
        year = year_in;
        month = month_in;
        day = day_in;
    }
    public String print() {
        return Integer.toString(year)+'/'+Integer.toString(month)+'/'+Integer.toString(day);
    }
}