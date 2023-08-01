package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IPersonaConsumerImpl implements IPersonaConsumer<String>{

	private static final Logger LOGGER = LoggerFactory.getLogger(IPersonaConsumerImpl.class);
	@Override
	public void accept(String arg) {
		// TODO Auto-generated method stub
		LOGGER.info(arg);
	}

}
