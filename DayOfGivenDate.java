public class DayOfGivenDate
{
    public static void main(String[] args)
    {
        System.out.println(Result.findDay(2,13,2010));
    }
}
class Result {

    public static boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100==0) {
                if (year % 400==0)
                    return true;
                else
                    return false;
            } else
                return true;
        } else
            return false;
    }

    public static String findDay(int month, int day, int year) {
        String dayr[] = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        int y = (((year - 1) % 400 - ((year - 1) % 400) % 100) / 100) * 5;
        int y1 = (((year - 1) % 400) % 100);
        int y2 = (y1 / 4) * 2 + (y1 - (y1 / 4));
        int netOddDayDueToYear = (y + y2) % 7;
        int netOddDayDueToDate = day % 7;
        int netOddDay;
        if (month == 1) {
            netOddDay = (netOddDayDueToYear + netOddDayDueToDate) % 7;
        } else {
            if (isLeap(year)) {
                int oddDayDueToMonth[] = {0, 3, 4, 7, 9, 12, 14, 17, 20, 22, 25, 27, 30};
                netOddDay = (oddDayDueToMonth[month - 1] + netOddDayDueToYear + netOddDayDueToDate) % 7;
            } else {
                int oddDayDueToMonth[] = {0, 3, 3, 6, 8, 11, 13, 16, 29, 21, 24, 26, 29};
                netOddDay = (oddDayDueToMonth[month - 1] + netOddDayDueToYear + netOddDayDueToDate) % 7;
            }
        }

        return dayr[netOddDay];
    }

}