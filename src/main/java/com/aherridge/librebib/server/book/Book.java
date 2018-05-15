package com.aherridge.librebib.server.book;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  @Id
  private String id;

  private String title;

  private String[] authors;

  private String description;

  private String thumbnail;
}
