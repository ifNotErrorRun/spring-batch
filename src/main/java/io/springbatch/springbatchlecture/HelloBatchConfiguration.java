package io.springbatch.springbatchlecture;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class HelloBatchConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job helloJob() {
    return jobBuilderFactory.get("helloJob")
        .start(helloStep())
        .next(helloStep2())
        .next(helloStep3())
        .build();
  }

  @Bean
  public Step helloStep() {
    return stepBuilderFactory.get("helloStep")
        .tasklet((contribution, chuckContext) -> {
          log.info("Hello Spring Batch");
          return RepeatStatus.FINISHED;
        })
        .build();
  }

  @Bean
  public Step helloStep2() {
    return stepBuilderFactory.get("helloStep2")
        .tasklet((contribution, chunkContext) -> {
          log.info("hello Spring World!!!! 2222");
          return RepeatStatus.FINISHED;
        })
        .build();
  }

  @Bean
  public Step helloStep3() {
    return stepBuilderFactory.get("helloStep3")
        .tasklet(tasklet)
        .build();
  }


  Tasklet tasklet = (contribution, chunkContext) -> {
    log.warn("HELLOOOOOOO!!!!");
    return RepeatStatus.FINISHED;
  };
}
