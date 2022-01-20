import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.chrono.JapaneseDate;

class Main43 {
  public static void main(String[] args) {

    LocalDateTime currentTime = LocalDateTime.now();

    var formattedTime = DateTimeFormatter.ofPattern("u年MM月dd日(E)");
    var JapaneseFormattedTime = DateTimeFormatter.ofPattern("Gy年MM月dd日");

    System.out.println("今日");

    System.out.println(currentTime.format(formattedTime));
    JapaneseDate JapanCurrentTime = JapaneseDate.from(currentTime);
    System.out.println(JapanCurrentTime.format(JapaneseFormattedTime));
    
    LocalDateTime time = currentTime.minusDays(1000);
    System.out.println("1000日前");
    
    System.out.println(time.format(formattedTime));
    JapaneseDate JapanTime1 = JapaneseDate.from(time);
    System.out.println(JapanTime1.format(JapaneseFormattedTime));

    time = currentTime.minusDays(1095);
    System.out.println("1095日前");

    System.out.println(time.format(formattedTime));
    JapaneseDate JapanTime2 = JapaneseDate.from(time);
    System.out.println(JapanTime2.format(JapaneseFormattedTime));

    time = currentTime.minusYears(3);
    System.out.println("3年前");

    System.out.println(time.format(formattedTime));
    JapaneseDate JapanTime3 = JapaneseDate.from(time);
    System.out.println(JapanTime3.format(JapaneseFormattedTime));

    time = currentTime.plusMonths(1);
    System.out.println("１ヶ月後");

    System.out.println(time.format(formattedTime));
    JapaneseDate JapanTime4 = JapaneseDate.from(time);
    System.out.println(JapanTime4.format(JapaneseFormattedTime));
  }
}