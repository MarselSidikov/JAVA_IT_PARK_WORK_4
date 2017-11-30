package ru.itpark;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ComponentsFactory {
  private Properties properties;

  public ComponentsFactory() {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("application.properties"));
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }
  }

  public Message getMessage() {
    String messageClassName = properties.getProperty("message.component.class");
    String text = properties.getProperty("message.text");
    try {
      Class<Message> messageClass = (Class<Message>)Class.forName(messageClassName);
      Constructor<Message> messageConstructor = messageClass.getConstructor(String.class);
      Message messageInstance = messageConstructor.newInstance(text);
      return messageInstance;
    } catch (ReflectiveOperationException e) {
      throw new IllegalArgumentException(e);
    }
  }

  public MessageRenderer messageRenderer() {
    String messageRendererClassName = properties.getProperty("message-renderer.component.class");
    try {
      Class<MessageRenderer> messageRendererClass = (Class<MessageRenderer>)Class.forName(messageRendererClassName);
      Constructor<MessageRenderer> messageRendererConstructor = messageRendererClass.getConstructor(Message.class);
      MessageRenderer messageRendererInstance = messageRendererConstructor.newInstance(getMessage());
      return messageRendererInstance;
    } catch (ReflectiveOperationException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
