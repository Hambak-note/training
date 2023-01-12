package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 필드 동기화 적용을 위해 LogTrace 스프링 빈 등록
 */
@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){

//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }

}
