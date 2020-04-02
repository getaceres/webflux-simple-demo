package com.example.webfluxsimpledemo;


import java.util.stream.IntStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink.OverflowStrategy;

@RestController
@RequestMapping("/numbers")
public class WebfluxController {

  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<Integer> getIntegers() {
    return Flux.<Integer>create(
            flowable -> {
              IntStream.range(0, 10)
                  .forEach(
                      number -> {
                        flowable.next(number);
                        try {
                          Thread.sleep(1000);
                        } catch (InterruptedException e) {
                          flowable.error(e);
                        }
                      });
              flowable.complete();
            },
            OverflowStrategy.BUFFER);
  }

}
