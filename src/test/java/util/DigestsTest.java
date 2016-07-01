package util;

import base.SpringTest;
import io.bvzx.service.util.encrypt.Digests;
import org.junit.Test;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 11:20
 * @Copyright (c) 2015-2020 by caitu99
 */
public class DigestsTest extends SpringTest {



    @Test
    public void md5Test(){
        LogUtils.println(Digests.MD5("1234567"));
    }

    @Test
    public void sha1Test(){
        LogUtils.println(Digests.SHA1("1234567"));
    }

}
