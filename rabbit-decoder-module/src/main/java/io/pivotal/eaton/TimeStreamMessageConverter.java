package io.pivotal.eaton;

import io.pivotal.eaton.proto.Mercury;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Message converter to convert time stream binary data into
 * comma separated values.
 * 
 * @author Brian Jimerson
 *
 */
public class TimeStreamMessageConverter implements MessageConverter {

	/**
	 * @see org.springframework.amqp.support.converter.MessageConverter
	 */
	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		
		Mercury.Msg mercuryMessage = null;
		
		try {
			mercuryMessage = Mercury.Msg.parseFrom(message.getBody());
		} catch (InvalidProtocolBufferException e) {
			throw new MessageConversionException(e.getLocalizedMessage());
		}
		
		return mercuryMessage.toString();
	}

	/**
	 * @see org.springframework.amqp.support.converter.MessageConverter
	 */
	@Override
	public Message toMessage(Object object, MessageProperties messageProperties)
			throws MessageConversionException {
		//Never used.
		return null;
	}

}
