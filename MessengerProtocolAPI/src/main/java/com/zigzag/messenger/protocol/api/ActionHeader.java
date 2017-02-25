package com.zigzag.messenger.protocol.api;

import java.io.Serializable;

/**
 * Created by zigza on 23.02.2017.
 */
public interface ActionHeader extends Serializable {
    public String getUuid();

    public void setUuid(String uuid);

    public String getOriginUuid();

    public void setOriginUuid(String originUuid);

    public String getCommand();

    public void setCommand(String command);

    public String getType();

    public void setType(String type);

    public String getVersion();

    public void setVersion(String version);
}
