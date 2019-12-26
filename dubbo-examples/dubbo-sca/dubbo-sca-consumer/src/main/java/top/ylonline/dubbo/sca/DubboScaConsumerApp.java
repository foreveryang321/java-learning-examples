package top.ylonline.dubbo.sca;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import top.ylonline.dubbo.sca.api.DubboService;

/**
 * @author YL
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "top.ylonline.dubbo.sca")
@EnableDiscoveryClient
public class DubboScaConsumerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboScaConsumerApp.class)
                .properties("spring.profiles.active=zk")
                .run(args);
    }

    @Reference
    private DubboService dubboService;
    // @Reference
    // private RestService restService;

    // @Bean
    // @LoadBalanced
    // @DubboTransported
    // public RestTemplate restTemplate() {
    //     return new RestTemplate();
    // }

    // @Resource
    // @Lazy
    // private FeignRestService feignRestService;
    //
    // @Resource
    // @Lazy
    // private DubboFeignRestService dubboFeignRestService;
    //
    // @Value("${provider.application.name}")
    // private String providerApplicationName;

    // @Resource
    // @LoadBalanced
    // private RestTemplate restTemplate;

    // @FeignClient("${provider.application.name}")
    // public interface FeignRestService {
    //
    //     @GetMapping(value = "/param")
    //     String param(@RequestParam("param") String param);
    //
    //     @PostMapping("/params")
    //     public String params(@RequestParam("b") String b, @RequestParam("a") int a);
    //
    //     @PostMapping(value = "/request/body/map", produces = APPLICATION_JSON_UTF8_VALUE)
    //     User requestBody(@RequestParam("param") String param, @RequestBody Map<String, Object> data);
    //
    //     @GetMapping("/headers")
    //     public String headers(@RequestHeader("h2") String header2,
    //                           @RequestHeader("h") String header,
    //                           @RequestParam("v") Integer value);
    //
    //     @GetMapping("/path-variables/{p1}/{p2}")
    //     public String pathVariables(@PathVariable("p2") String path2,
    //                                 @PathVariable("p1") String path1,
    //                                 @RequestParam("v") String param);
    // }
    //
    // @FeignClient("${provider.application.name}")
    // @DubboTransported(protocol = "dubbo")
    // public interface DubboFeignRestService {
    //
    //     @GetMapping(value = "/param")
    //     String param(@RequestParam("param") String param);
    //
    //     @PostMapping("/params")
    //     String params(@RequestParam("b") String paramB, @RequestParam("a") int paramA);
    //
    //     @PostMapping(value = "/request/body/map", produces = APPLICATION_JSON_UTF8_VALUE)
    //     User requestBody(@RequestParam("param") String param, @RequestBody Map<String, Object> data);
    //
    //     @GetMapping("/headers")
    //     public String headers(@RequestHeader("h2") String header2,
    //                           @RequestParam("v") Integer value,
    //                           @RequestHeader("h") String header);
    //
    //     @GetMapping("/path-variables/{p1}/{p2}")
    //     public String pathVariables(@RequestParam("v") String param,
    //                                 @PathVariable("p2") String path2,
    //                                 @PathVariable("p1") String path1);
    // }

    @Bean
    public ApplicationRunner userServiceRunner() {
        return arguments -> {
            System.out.printf("DubboService.echo(%s)", dubboService.echo("test"));
            // System.out.printf("RestService.getName(%s)", restService.getName(1L));
        };
    }
}
