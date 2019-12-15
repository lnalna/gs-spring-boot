package hello;

import org.openjdk.jmh.runner.RunnerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BenchMarkController {

    @GetMapping("/benchmark")
    public String index() throws RunnerException {
        BenchMarkTest.main(new String[1]);
        return "Ok benchmark";
    }
}
