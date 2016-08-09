package io.bvzx.util.http;

import org.apache.http.HttpResponse;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 15:24
 * @Copyright (c) 2015-2020 by caitu99
 */
public interface ResponseHandler {


   void handleResponse(HttpResponse resp);

}
