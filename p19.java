public class p19 {
    private static final int YEAR = 0;
    private static final int MONTH = 1;
    private static final int DAY = 2;
    private static final int DAYOFWEEK = 3; 
    

    public static boolean isLeapYear(int year){
        if(year % 100 == 0){
            return (year % 400) == 0;
        }else if (year % 4 == 0){
            return true;
        }
        return false;
    }

    public static int[] dateModulo(int[] d){

        if(d[DAY] > 30 && (d[MONTH]== 4 || d[MONTH]== 6 || d[MONTH]== 9 || d[MONTH]== 11)){
            d[MONTH]++;
            d[DAY] = 1;
        }else if(d[MONTH] == 2 && isLeapYear(d[YEAR]) && d[DAY]>29){
            //leap year
            d[MONTH]++;
            d[DAY] = 1;
        }else if(d[MONTH] == 2 && !isLeapYear(d[YEAR]) && d[DAY]>28) {
            //non leap year
            d[MONTH]++;
            d[DAY] = 1;
        }else if (d[DAY] > 31){
            //31 days
            d[MONTH]++;
            d[DAY] = 1;
        }

        if(d[MONTH] == 13){
            d[MONTH]=1;
            d[YEAR]++;
        }

        d[DAYOFWEEK] = d[DAYOFWEEK] % 7; 

        return d;
    }

    public static String dateToString(int[] d){
        String dayofweek = "";
        switch (d[DAYOFWEEK]) {
            case 0:
                dayofweek = "Monday";
                break;
            case 1:
                dayofweek = "Tuesday";
                break;
            case 2:
                dayofweek = "Wednesday";
                break;
            case 3:
                dayofweek = "Thursday";
                break;
            case 4:
                dayofweek = "Friday";
                break;
            case 5:
                dayofweek = "Saturday";
                break;
            case 6:
                dayofweek = "Sunday";
                break;
            default:
                dayofweek = "BLAH!";
                break;
        }

        return dayofweek + " " + d[YEAR] + "-" + d[MONTH] + "-" + d[DAY];
    }

    public static void main (String[] args){
        int current[] = {1901,1,1,1};
        int countDays = 0;

        while(current[YEAR]<2001){
            System.out.println(dateToString(current));
            if(current[DAYOFWEEK] == 6 && current[DAY]==1){
                countDays++;
            }
            current[DAY]++;
            current[DAYOFWEEK]++;
            current = dateModulo(current);
        }

        System.out.println(countDays);
        System.out.println(isLeapYear(2000));
        
    }
}