package com.example;

import io.micronaut.core.util.SupplierUtil;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.function.Supplier;


@MicronautTest
class ExampleControllerTest {

  @Inject
  EmbeddedServer server;

  Supplier<HttpClient> client = SupplierUtil.memoizedNonEmpty(() ->
      server.getApplicationContext().createBean(HttpClient.class, server.getURL()));


  @Test
  void examplePost() {
    HttpResponse<String> response = client.get().toBlocking().exchange(HttpRequest.POST(URI.create("/example"), ExampleRequest.builder().name("test").build()), String.class);

    assert "OK".equals(response.body());
  }
}