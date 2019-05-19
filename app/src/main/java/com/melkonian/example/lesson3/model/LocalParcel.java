package com.melkonian.example.lesson3.model;

import java.io.Serializable;

public class LocalParcel implements Serializable {
  private String text;
  private int number;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
