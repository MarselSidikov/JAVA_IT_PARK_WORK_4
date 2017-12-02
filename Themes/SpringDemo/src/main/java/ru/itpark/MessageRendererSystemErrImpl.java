package ru.itpark;

public class MessageRendererSystemErrImpl implements MessageRenderer {
  private Message message;

  public MessageRendererSystemErrImpl(Message message) {
    this.message = message;
  }

  public void render() {
    System.err.println(message.getText());
  }
}
