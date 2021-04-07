package ch11.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {

    PersonBean personBean;

    public NonOwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.getName().equals("setHotOrNotRating")) {
            throw new IllegalAccessException();
        }
        return method.invoke(personBean, args);
    }
}
