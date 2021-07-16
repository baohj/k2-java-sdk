package io.k2pool.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TokenBO {

    private String accessKey;

    //默认30分钟
    private long tokenExpires = 30;
}
