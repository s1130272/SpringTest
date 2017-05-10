package springTry.beans;

import springTry.anotations.MyQualifier;

public class AutowiredBeanFactory {

	// @Autowired  用在属性上
	private MyTestBean myTestBean;

	//@Autowired   用在set方法上
	public void setMyTestBean(MyTestBean myTestBean) {
		this.myTestBean = myTestBean;
	}

	//@Autowired   //用在自定义方法上
	@MyQualifier
	public void simpleSetBean(MyTestBean myTestBean) {
		 this.myTestBean = myTestBean;
	}

	public MyTestBean getMyTestBean() {
		return myTestBean;
	}
	
	

}
