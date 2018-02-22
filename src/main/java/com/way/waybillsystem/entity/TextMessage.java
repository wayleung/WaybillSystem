package com.way.waybillsystem.entity;



/**
 * Created by DELL on 2017/9/12.
 */
public class TextMessage extends BaseMessage {
    private String Content;
    private Long MsgId;



    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
