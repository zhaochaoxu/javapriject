package com.it.chaoxu.Test;

//import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dell on 2016/6/13.
 */
public class log4jtestCase {
    @Test
    public void testlog(){
        String name="赵朝旭";
        String book = "《水浒传》";
        Logger logger = LoggerFactory.getLogger(log4jtestCase.class);
        //Logger.getLogger(log4jtestCase.class);
        logger.trace("trance message");
        logger.debug("debug message");
        logger.info("{}借阅了：{}",name,book);
        logger.warn("warn message");
        logger.error("error message");
        //logger.fatal("fatal message");
    }
}
