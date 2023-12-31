package io.springbatch.springbatchlecture;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
@RequiredArgsConstructor
public class DBJobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job job() {
    return jobBuilderFactory.get("Job")
        .start(step1())
        .next(step2())
        .build();
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("Step1")
        .tasklet((stepContribution, chunkContext) -> {
          log.info("Step1 was executed");
          return RepeatStatus.FINISHED;
        })
        .build();
  }

  @Bean
  public Step step2() {
    return stepBuilderFactory.get("Step2")
        .tasklet((stepContribution, chunkContext) -> {
          log.info("Step2 was executed");
          return RepeatStatus.FINISHED;
        })
        .build();
  }
}
