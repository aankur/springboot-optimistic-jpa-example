package com.example.optimisticlocking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  Long id;

  Long version;
  @NotBlank
  String name;
}
