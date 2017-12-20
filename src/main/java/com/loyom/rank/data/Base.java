package com.loyom.rank.data;

import com.loyom.rank.common.JsonUtil;
import java.io.Serializable;

public abstract class Base implements Serializable {

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
