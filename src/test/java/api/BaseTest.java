package api;

import org.junit.After;
import org.junit.Before;

public class BaseTest {
    @Before
    public void setUp(){
        //тут можно авторизовываться перед тестом и чекать что корзина пуста например
    }

    @After
    public void tearDown(){
        //почистить кэш и корзину
    }

}
