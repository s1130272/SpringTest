package springTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import springTest.initBeans.BeanConstrcuctor;

public class BeanFactoryTest {
	
	@Test
	public  void test(){
		
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		MyTestBean bean = (MyTestBean)bf.getBean("myTestBean");
		System.out.println(bean.getTestStr());
		assertEquals("testStr",bean.getTestStr());
		
	}
	
	@Test
	public  void testConsBean(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanConstrcuctor bean  =  (BeanConstrcuctor) ctx.getBean("consBean");
		bean.show();
		assertEquals(10,bean.getNum());
	}
	
	@Test
	public  void testConsBean2(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanConstrcuctor bean  =  (BeanConstrcuctor) ctx.getBean("consBean2");
		bean.show();
		assertEquals(20,bean.getNum());
	}

}
