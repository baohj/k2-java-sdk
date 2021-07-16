package io.k2pool.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class NetWordDataVo {

    //全网累计出块奖励
    private BigDecimal totalBlockAward;

    //全网算力
    private BigDecimal power;

    //全网今日出块数
    private Long perDayBlocks;

    //全网活跃矿工
    private Long activeMiner;

}
