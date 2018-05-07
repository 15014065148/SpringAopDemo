package com.example.demo2;

import com.example.demo2.service.Service1Impl;
import com.example.demo2.service.Service2Impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopDemo2ApplicationTests {
	@Autowired
	Service1Impl service1 ;
	@Autowired
	Service2Impl service2 ;
	private static final Logger logger = LoggerFactory.getLogger(SpringAopDemo2ApplicationTests.class);

	@Test
	public void logservice()  {
		try {
			service1.logMethod(" 打印日志1");
			service1.exceptionMethod();
		} catch (Exception e) {
		}
		try {
			service2.logMethod(" 打印日志1");
			service2.exceptionMethod();
		} catch (Exception e) {
		}
	}
}
