import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParkService {

    // Todo: * 문제2, 국가가 US가 아닌 볼파크 수는?
    public int howManyHaveUSContry(List<KindOfPark> list) {

        int count = 0;
        for (KindOfPark e : list) {
            if (!(e.getCountry().equals("US")))
                count++;
        }
        System.out.println("국가가 US가 아닌 볼파크 수는?: " + count);
        return count;
    }

    // Todo:  * 문제3, alias가 있는 볼파크 수는?
    public int howManyHaveAlias(List<KindOfPark> list) {
        int count = 0;
        for (KindOfPark e : list) {
            if (!(e.getParkAlias().isEmpty()))
                count++;
        }
        System.out.println("alias가 있는 볼파크 수는?: " + count);
        return count;
    }

    // Todo:  * 문제3-1, alias가 있는 볼파크 리스트는?
    public List<KindOfPark> getParkIncludeAlias(List<KindOfPark> parklist) {
        int i = 0;
        System.out.println("*****   alias가 있는 볼파크 리스트   *****");
        for (KindOfPark e : parklist) {
            if (!(e.getParkAlias().isEmpty())) {
                i++;
                System.out.printf("%d: %s\n", i, e.getParkAlias());
            }
        }
        return null;
    }

    // Todo:  * 문제4, 볼파크 이름의 글자수 평균은?
    public double CountStringLength(List<KindOfPark> list) {
        double sum = 0;
        for (KindOfPark e : list) {
            sum = sum + e.getParkName().length();
        }
        System.out.printf("볼파크 이름의 글자수의 평균: %1.1f\n", sum / list.size());

        return sum / list.size();
    }




}