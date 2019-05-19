package com.melkonian.example.lesson3.utils;

public final class LifecycleStateSaver {
  private static LifecycleStateSaver thisInstance = null;

  private int counter;

  private LifecycleStateSaver() {
    counter = 0;
  }

  public void incrementCounter() {
    ++counter;
  }

  public int getCounter() {
    return counter;
  }

  public static LifecycleStateSaver getInstance() {
    if (thisInstance == null) {
      thisInstance = new LifecycleStateSaver();
    }
    return thisInstance;
  }
}
