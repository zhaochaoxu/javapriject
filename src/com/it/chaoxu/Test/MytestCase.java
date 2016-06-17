package com.it.chaoxu.Test;

import org.junit.Test;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by dell on 2016/6/14.
 */
public class MytestCase {

    @Test
    public void testuuid(){
        String token= UUID.randomUUID().toString();
        System.out.println(token);
    }

    @Test
    public void testchara() throws Exception {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(67, 78, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

       /* RandomWordFactory rw = new RandomWordFactory();
        rw.setMaxLength(5);
        rw.setMinLength(3);
        rw.setCharacters("123456789poqfdnfkjauyugfpajfjadslknakjfiugdsiabgabdadshfasfkjdahopiy");
        cs.setWordFactory(rw);*/

        FileOutputStream outputStream = new FileOutputStream("E:/picture.png");
        EncoderHelper.getChallangeAndWriteImage(cs,"png",outputStream);
        outputStream.flush();
        outputStream.close();



    }
}
