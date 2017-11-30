package ru.itpark;

public class MessageRendererSystemOutImpl implements MessageRenderer{
  private Message message;

  public MessageRendererSystemOutImpl(Message message) {
    this.message = message;
  }

  public void render() {
    System.out.println(message.getText());
  }
}
