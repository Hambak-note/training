package codemanipulation.thejava;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MasulsaAgent {

    public static void premain(String agentArgs, Instrumentation inst){

        /**
         * 기본 빌더를 가져와서
         * 어떤 타입을 조작할 거냐면 아무거나 가져와서 변경을한다.(transform)
         * 변경을 한 것을 inst에 적용을 한다.(installOn)
         */

        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, ProtectionDomain protectionDomain) {
                        return builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"));
                    }
                }).installOn(inst);
    }


}
