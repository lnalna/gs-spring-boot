package hello;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
public class BenchMarkTest {

    @Autowired
    static  ApplicationContext context;

    private HelloController helloController;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchMarkTest.class.getSimpleName())
                .timeUnit(TimeUnit.MILLISECONDS)
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(3)
                .mode(Mode.AverageTime)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public synchronized void initialize() {
        //  this.context = ContextLoader.getCurrentWebApplicationContext();
        try {
            /*String args = "";
            if (context == null) {
                context = SpringApplication.run(Application.class, args);
            }*/
            helloController = context.getBean(HelloController.class);
            System.out.println(helloController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public void helloControllerTest() throws InterruptedException {
    //   helloController = this.context.getBean(HelloController.class);
       /* try {
            helloController.index();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @TearDown
    public void tearDown() {
       // context.close();
    }
}
