package io.k2pool.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
//对外API-平台数据
public class ForeignPlatformVO {

    //平台累计出块奖励
    private BigDecimal totalBlockAward;

    //平台算力
    private BigDecimal power;

    //平台今日出块数
    private Long perDayBlocks;

    //平台活跃矿工
    private Long activeMiner;

}
