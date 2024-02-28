package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/example")
public class ExampleController {
  @Post
  public String examplePost(@Body ExampleRequest request) {
    return "OK";
  }
}
