package ru.itpark;

public class MessageByeImpl implements Message {
  private String text;

  public MessageByeImpl(String text, String smile) {
    this.text = "Bye, " + text + " " + smile;
  }

  public MessageByeImpl(String text) {
    this.text = "Bye, " + text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setSuffix(String suffix) {
    this.text = text + " " + suffix;
  }
}
