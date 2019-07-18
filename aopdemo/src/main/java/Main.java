import com.ianw.advice.CountingAfterReturningAdvice;
import com.ianw.advice.CountingBeforeAdvice;
import com.ianw.advice.DebugInterceptor;
import com.ianw.advice.RemoteThrowsAdvice;
import com.ianw.pojo.Person;
import com.ianw.service.PersonService;
import com.ianw.service.impl.PersonServiceimpl;
import org.springframework.aop.framework.ProxyFactory;


public class Main {
    public static void main(String[] args) {
        PersonServiceimpl personService = new PersonServiceimpl();
        //System.out.println("地址是："+personService);
        ProxyFactory factory=new ProxyFactory();


        factory.setTarget(personService);
        factory.setInterfaces(PersonService.class);

        factory.addAdvice(new CountingBeforeAdvice());
        factory.addAdvice(new DebugInterceptor ());
        factory.addAdvice(new CountingAfterReturningAdvice());
        factory.addAdvice(new RemoteThrowsAdvice ());

        PersonService proxyPersonService = (PersonService) factory.getProxy();
        //System.out.println("地址是："+proxyPersonService);
        proxyPersonService.addPerson(123);

    }
}
