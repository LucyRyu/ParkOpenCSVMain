import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * todo: 1. sort : parkName의 글자수
 * todo: 2. filtering : 국가가 US가 아닌것 X
 * todo: 3. 출력 forEach(...)
 */
public class ParkOpenCSVMain {
    public static void main(String[] args) {

        try {
            CSVReader reader = new CSVReader(
                    new FileReader("src\\Parks.csv"));

            List<KindOfPark> list = new ArrayList<>();

            reader.readNext();
            String[] spl = null;
            while ((spl = reader.readNext()) != null) {
                list.add(new KindOfPark(spl[0], spl[1], spl[2], spl[3], spl[4], spl[5]));

            }


            Collections.sort(list, (a, b) -> a.getState().compareTo(b.getState()));


            // 특정 element 제거하기
//            Predicate<Park> p = new Predicate<Park>() {
//                @Override
//                public boolean test(Park park) {
//                    return park.getParkAlias() == null || park.getParkAlias().equals("");
//                }
//            };

            list.removeIf(p -> p.getParkAlias() == null || p.getParkAlias().equals(""));

            list.forEach(x -> System.out.println(x));

        // todo: 1. sort : parkName의 글자수
            Collections.sort(list
                    , (a, b) -> (a.getState().compareTo(b.getState())));
            list.forEach(x -> System.out.println(x));

        // todo: 2. filtering : 국가가 US가 아닌것 X

            list.removeIf(p -> p.getCity().equals("US"));

            list.forEach(x -> System.out.println(x));

        // todo: 3. 출력 forEach(...)

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
