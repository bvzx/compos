package io.bvzx.core.nosql.mongdb.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年06月22日 17:17
 * @Copyright (c) 2015-2020 by caitu99
 */
@Document(collection = "match_comment")
public class MatchComment {
    @Field
    private String content;
    @Field
    private int creatTime;
    @Field
    private MatchComment reply;
    @Field
    private long userId;
    @Field
    private long matchId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(int creatTime) {
        this.creatTime = creatTime;
    }

    public MatchComment getReply() {
        return reply;
    }

    public void setReply(MatchComment reply) {
        this.reply = reply;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }
}
