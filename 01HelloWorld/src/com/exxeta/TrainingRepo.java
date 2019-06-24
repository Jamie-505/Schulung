package com.exxeta;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@ApplicationScoped
public class TrainingRepo {
   public List<Training> findAll() {
      return LongStream.range(0,100)
              .mapToObj(i -> Training.builder().name("Training" + i).id(i).build())
              .collect(Collectors.toList());
   }
}
