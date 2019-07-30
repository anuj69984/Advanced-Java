package assignment_12;

/**
 * 
 * @author Anuj2.Kumar
 *
 *Task for this tutorial:
1. Write an abstract base class called MessageProcessor with one method processMessage (Message msg).
2. Make three classes SIPMessageProcessor, DIAMessageProcessor and XCAPMessageProcessor that extend this abstract class and they all implement the processMessage method.
3. Now write an interface called "Message". Let there be two methods in this interface: <return-type> getMessage() and setMessage(argument).
4. This interface needs to be implemented by three classes: SIPMessage, DIAMessage and XCAPMessage. Each class needs to have the following private data members - String messageName, String messageContent and their getters and setters.
5. Now we need a singleton factory class called MessageFactory which implements an interface - MessageInterceptor interface.There is one method of this interface called acceptMessage (Message msg).
6. Now there needs to be a class called MessageProducer which will contain our main ( ) method. This class needs to create objects of type "Message" (SIP, DIA and XCAP classes).
7. The MessageProducer will now get the singleton instance from the MessageFactory class and then call the acceptMessage( arg) method, and pass the argument to it.
8. based on which message is received by this singleton class MessageFactory (SIPMessage, DIAMessage or XCAPMessage), it will call the processMessage method of the appropriate class given in point two above.
9. In the processMessage method, print the messageName and messageContent by calling the getters
 */

class DIAMessage implements Message {

	String messageName;
	String 	messageContent;
	
	public void getMessage()
	{
		System.out.println("Name:"+this.messageName+"Conetnt:"+this.messageContent);
	}
	public void setMessage(String x,String y) {
		this.messageName=x;
		this.messageContent=y;
	}
}

class DIAMessageProcessor extends MessageProcessor{

	void processMessage (Message msg) {
		msg.setMessage("DIA", "DIA CLASS");
		msg.getMessage();
		}
}

interface Message {
	void getMessage();
	void setMessage(String x,String y);
}

class MessageFactory implements MessageInterceptor {
	private static MessageFactory s;
	private MessageFactory() {
		
	}
	
	public static MessageFactory getInstance() {
        if (s == null) {
            synchronized (MessageFactory.class) {
                s = new MessageFactory();
            }
            return s;
        }
        return null;
    }

	public void acceptMessage (Message msg) {
		if(msg instanceof SIPMessage) {
			SIPMessageProcessor o=new SIPMessageProcessor();
			o.processMessage(msg);
		}else if(msg instanceof XCAPMessageProcessor) {
			XCAPMessageProcessor o=new XCAPMessageProcessor();
			o.processMessage(msg);
		}else {
			DIAMessageProcessor o=new DIAMessageProcessor();
			o.processMessage(msg);
		}
	}
}

interface MessageInterceptor {

	 void acceptMessage (Message msg);
}

abstract class MessageProcessor {

	abstract void processMessage (Message msg);
}

class MessageProducer {

	public static void main(String[] args) {
		
		Message sip=new SIPMessage();
		Message xcap=new XCAPMessage();
		Message dia=new DIAMessage();
		
		MessageFactory ins=MessageFactory.getInstance();
		ins.acceptMessage(sip);
		ins.acceptMessage(xcap);
		ins.acceptMessage(dia);
	}

}

class SIPMessage implements Message {

	String messageName;
	String 	messageContent;
	
	public void getMessage()
	{
		System.out.println("Name:"+this.messageName+"Conetnt:"+this.messageContent);
	}
	public void setMessage(String x,String y) {
		this.messageName=x;
		this.messageContent=y;
	}
}

class SIPMessageProcessor extends MessageProcessor {

	void processMessage (Message msg) {
		msg.setMessage("SIP", "SIP CLASS");
		msg.getMessage();
	}
}

class XCAPMessage implements Message {

	String messageName;
	String 	messageContent;
	
	public void getMessage()
	{
		System.out.println("Name:"+this.messageName+"Conetnt:"+this.messageContent);
	}
	public void setMessage(String x,String y) {
		this.messageName=x;
		this.messageContent=y;
	}
}

class XCAPMessageProcessor extends MessageProcessor {
	void processMessage (Message msg) {
		msg.setMessage("XCAP", "XCAP CLASS");
		msg.getMessage();	
		}
}

