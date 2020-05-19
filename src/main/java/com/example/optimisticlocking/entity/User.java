package com.example.optimisticlocking.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;

  @NotBlank
  String name;
}
