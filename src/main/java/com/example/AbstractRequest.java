package com.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Data
@EqualsAndHashCode
@ToString
public abstract class AbstractRequest {
  private final String id = UUID.randomUUID().toString();
}
