package io.springbatch.springbatchlecture;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBatchApplicationTests {

  @Test
  void contextLoads() {
    int i = 1;
    Assertions.assertThat(i).isEqualTo(1);
  }

}
