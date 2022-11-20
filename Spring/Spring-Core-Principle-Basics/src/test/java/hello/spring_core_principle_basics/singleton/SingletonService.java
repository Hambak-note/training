package hello.spring_core_principle_basics.singleton;

public class SingletonService {

    /**
     * static 으로 자기 자신을 선언하여 사용하면
     * 클래스 레벨에 올라가기 때문에 단 하나만 존재하게 된다.
     */
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    /**
     * private 생성자로 외부에서 추가적으로 생성하는 것을 막늗다.
     */
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
