package com.app.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // Says this is an entity (a table in db)
@Data // Provided by lombok. If not used, we need to manually make the getters and setters for each of the variables
public class Task {

  @Id // Treats id as the primary key of this entity
  @GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates the value of the id
  private long id;

  private String title;
  private boolean done;

  // We donot need this because we are using Lombok
  // public void setId(long id) {
  //   this.id = id;
  // }

  // public void setTitle(String title) {
  //   this.title = title;
  // }

  // public boolean isDone() {
  //   return done;
  // }

  // public long getId() {
  //   return id;
  // }

  // public String getTitle() {
  //   return title;
  // }

  // public void setDone(boolean done) {
  //   this.done = done;
  // }
}
