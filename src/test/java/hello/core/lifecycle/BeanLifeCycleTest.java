package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean//(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            System.out.println("set실행전");
            networkClient.setUrl("http://hello-spring.dev");
            System.out.println("set실행후");
            return networkClient;
        }

    }

}
