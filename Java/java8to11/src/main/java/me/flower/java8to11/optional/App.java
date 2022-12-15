package me.flower.java8to11.optional;

import me.flower.java8to11.stream.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "spring api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        //Duration studyDuration = spring_boot.getProgress().getStudyDuration();
        //NullPointerException 발생
        //현재 studyDuration 이 초기화되지 않고 null 이기 때문에 null 반환
        //System.out.println(studyDuration);

        //고전적 해결 방안
        //Progress progress = spring_boot.getProgress();
//        if(progress != null){
//            System.out.println(progress.getStudyDuration());
//        }

        spring_boot.setProgress(null);

        //======================================================

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        boolean present = optional.isPresent();
        System.out.println(present);

        
        OnlineClass onlineClass = optional.get();
        System.out.println("onlineClass = " + onlineClass.getTitle());

        //없는 것을 꺼내겨로 할때 NoSuchElementException 발생
        Optional<OnlineClass> optional2 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jps"))
                .findFirst();
        OnlineClass onlineClass1 = optional2.get();
        System.out.println("onlineClass1.getTitle() = " + onlineClass1.getTitle());
        
        //확인 후 꺼내기
        if(optional2.isPresent()){
            OnlineClass onlineClass2 = optional2.get();
            System.out.println("onlineClass2.getTitle() = " + onlineClass2.getTitle());
        }

        //만약 존재하면 출력한다.
        optional2.ifPresent(oc->{
            System.out.println(oc.getTitle());
        });

        //orElse
        OnlineClass onlineClass2 = optional2.orElse(createNewClass());

        //orElseGet
        OnlineClass onlineClass3 = optional2.orElseGet(() -> createNewClass());
        OnlineClass onlineClass4 = optional2.orElseGet(App::createNewClass);

        //orElseThrow
        OnlineClass onlineClass5 = optional2.orElseThrow(() -> {
            return new IllegalArgumentException();
        });
        OnlineClass onlineClass6 = optional2.orElseThrow(IllegalArgumentException::new);

        Optional<OnlineClass> onlineClass7 = optional
                .filter(oc -> oc.getId() > 10);
        System.out.println(onlineClass7.isEmpty()); //true

        //map
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        //map으로 변환하는 타입이 Optional이라면 양파 까듯이 까줘야 함
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow();
        Progress progress3 = progress2.orElseThrow();

        //위와 같은 경우 flatMap을 사용하면 유용
        Optional<Progress> progress4 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "New class", false);
    }
}
