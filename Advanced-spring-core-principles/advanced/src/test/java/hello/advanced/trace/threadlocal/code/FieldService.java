package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 파라미터로 넘어온 name을 필드인 nameStore에 저장
 * 1초간 쉰 다음 필드에 저장된 nameStore를 반환
 */
@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name){
        log.info("저장 name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore={}", nameStore);
        return nameStore;
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
