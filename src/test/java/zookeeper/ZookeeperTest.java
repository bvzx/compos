package zookeeper;

import base.SpringTest;
import org.apache.zookeeper.*;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月08日 16:41
 * @Copyright (c) 2015-2020 by caitu99
 */
public class ZookeeperTest  implements Watcher {


    //缓存时间
    private static final int SESSION_TIME   = 2000;
    private static ZooKeeper zooKeeper;

    @Test
    public void measure() throws IOException, KeeperException, InterruptedException {
        zooKeeper=new ZooKeeper("127.0.0.1",SESSION_TIME,this);
        zooKeeper.create("/bvzx","wugaoda".getBytes("UTF-8"),null, CreateMode.PERSISTENT);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
