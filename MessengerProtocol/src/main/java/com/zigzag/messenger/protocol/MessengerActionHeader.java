package com.zigzag.messenger.protocol;

import com.zigzag.messenger.protocol.api.ActionHeader;

/**
 * Created by zigza on 23.02.2017.
 */
public class MessengerActionHeader implements ActionHeader {
    private String uuid;
    private String originUuid;
    private String command;
    private String type;
    private String version;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOriginUuid() {
        return originUuid;
    }

    public void setOriginUuid(String originUuid) {
        this.originUuid = originUuid;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
