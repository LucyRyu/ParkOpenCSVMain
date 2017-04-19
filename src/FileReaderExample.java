import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by danawacomputer on 2017-04-10.
 * 문제1, List<Park>로 변환
 * 문제2, 국가가 US가 아닌 볼파크 수는?
 * 문제3, alias가 있는 볼파크 수는?
 * 문제4, 볼파크 이름의 글자수 평균은?
 */
public class FileReaderExample {

    public static void main(String[] args) throws Exception {
        //throws Exception: 예외를 처리하지 않고 프로그램을 실행하겠다는 의미

        FileReader fr = new FileReader("src\\Parks.csv");
        BufferedReader br = new BufferedReader(fr);
        //BufferedReader(fr)을 데코레이션이라고 한다.

        List<KindOfPark> list = new ArrayList<>();

        br.readLine();
        //기본 form은 제거
        //두번째 라인부터 읽는다는 의미
        //파일입력 및 출력 방법1

        String line = "";
        while ((line = br.readLine()) != null) {

            String[] splitted = line.split(",");

            List<String> splitted1 = Arrays.asList(line.split(","));
            // 자르자마자 바로 List로 하는 법

            //System.out.println(splitted[0] +" "+ splitted[1]);

            //Todo: * 문제1, List<Park>로 변환

            //KindOfPark park = new KindOfPark(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5]);
            //list.add(park);

            KindOfPark park = new KindOfPark();
            park.setParkKey(splitted[0]);
            park.setParkName(splitted[1]);
            park.setParkAlias(splitted[2]);
            park.setCity(splitted[3]);
            park.setState(splitted[4]);
            park.setCountry(splitted[5]);

            list.add(park);

            //System.out.println(list);
            /*for(KindOfPark e: list){
                System.out.println(e.getCity());
            }*/

        }

        ParkService service = new ParkService();
        service.howManyHaveUSContry(list);
        service.howManyHaveAlias(list);
        service.CountStringLength(list);
        service.getParkIncludeAlias(list);

       // list.sort((Comparator<? super KindOfPark>) list);
        //System.out.println(list);

        List data = list;
        Collections.sort(data,new ParkState());
        //System.out.println(data);

        for(KindOfPark e:list){
            System.out.printf("%s/ ",e.getState());
        }
        System.out.println("\n\n**********************\n");

        Collections.sort(data,new ParkCity());

        for(KindOfPark e:list){
            System.out.printf("%s/ ",e.getCity());
        }

        /*
        //파일입력 및 출력 방법2
        while(true) {
            String line = br.readLine();
            //한 줄씩 읽어서 String으로 리턴
            String[] splitted = line.split(",");
            for(String s : splitted) {
                System.out.println(s);
            }

            if(br.readLine()==null){
                break;
            }
            System.out.println(line);
        }
        */

    }

}