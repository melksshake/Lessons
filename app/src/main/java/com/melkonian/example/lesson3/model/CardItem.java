package com.melkonian.example.lesson3.model;

public class CardItem {
  private String description;
  private int picture;
  private boolean like;

  public CardItem(String description, int picture, boolean like) {
    this.description = description;
    this.picture = picture;
    this.like = like;
  }

  public String getDescription() {
    return description;
  }

  public int getPicture() {
    return picture;
  }

  public boolean getLike() {
    return like;
  }
}
