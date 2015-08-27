package com.zehao.first_test;

public class CustomEvent {

}
/*package com.tutorialspoint;
import org.springframework.context.ApplicationEvent;
public class CustomEvent extends ApplicationEvent{ 
   public CustomEvent(Object source) {
      super(source);
   }
   public String toString(){
      return "My Custom Event";
   }
}
下面是 CustomEventPublisher.java 文件的内容：

package com.tutorialspoint;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
public class CustomEventPublisher 
   implements ApplicationEventPublisherAware {
   private ApplicationEventPublisher publisher;
   public void setApplicationEventPublisher
              (ApplicationEventPublisher publisher){
      this.publisher = publisher;
   }
   public void publish() {
      CustomEvent ce = new CustomEvent(this);
      publisher.publishEvent(ce);
   }
}
下面是 CustomEventHandler.java 文件的内容：

package com.tutorialspoint;
import org.springframework.context.ApplicationListener;
public class CustomEventHandler 
   implements ApplicationListener<CustomEvent>{
   public void onApplicationEvent(CustomEvent event) {
      System.out.println(event.toString());
   }
}
下面是 MainApp.java 文件的内容：

package com.tutorialspoint;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
   public static void main(String[] args) {
      ConfigurableApplicationContext context = 
      new ClassPathXmlApplicationContext("Beans.xml");    
      CustomEventPublisher cvp = 
      (CustomEventPublisher) context.getBean("customEventPublisher");
      cvp.publish();  
      cvp.publish();
   }
}
下面是配置文件 Beans.xml：

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="customEventHandler" 
      class="com.tutorialspoint.CustomEventHandler"/>

   <bean id="customEventPublisher" 
      class="com.tutorialspoint.CustomEventPublisher"/>

</beans>*/