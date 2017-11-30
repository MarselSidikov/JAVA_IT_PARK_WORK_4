package ru.itpark;

public class Main {

    public static void main(String[] args) {
      Message messageHello = new MessageHelloImpl("Marsel");
      Message messageBye = new MessageByeImpl("Ruslan");

      MessageRenderer rendererSystemOut =
          new MessageRendererSystemOutImpl(messageBye);

      MessageRenderer rendererSystemErr =
          new MessageRendererSystemErrImpl(messageHello);

      rendererSystemOut.render();
      rendererSystemErr.render();
    }
}
