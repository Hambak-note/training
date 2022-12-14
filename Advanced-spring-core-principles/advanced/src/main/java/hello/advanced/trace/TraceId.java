package hello.advanced.trace;

import java.util.UUID;

/**
 * 로그 추적기는 트랜잭션 ID와 깊이를 표현하는 방법 필요
 * 트랜잭션 ID와 깊이를 표현하는 level을 묶은 클래스
 */
public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId(){
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId(){
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLevel(){
        return level==0;
    }

    public String getId(){
        return id;
    }

    public int getLevel() {
        return level;
    }

}
