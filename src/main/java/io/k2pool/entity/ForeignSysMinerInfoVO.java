package io.k2pool.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
* 对外API-矿工数据出参
*
* @description
* @author shangbin
* @date 2021/7/5 11:19
* @version v1.4.1
*/
@Data
//对外API-矿工数据出参
public class ForeignSysMinerInfoVO
{

    //有效算力, 单位B
    private BigDecimal powerAvailable;

    //扇区质押, 单位FIL
    private BigDecimal sectorPledge;

    //扇区大小,单位GB
    private Long sectorSize;

    //有效扇区、证明状态扇区数量
    private Integer sectorProving;

    //扇区总数、有效状态扇区数量
    private Integer sectorAvailable;

    //错误状态扇区数量
    private Integer sectorError;

    //扇区总数
    private Integer sectorTotal;

    //挖矿琐仓、锁仓收益, 单位FIL
    private BigDecimal lockAward;

    //累计出块奖励,单位FIL
    private BigDecimal totalBlockAward;

    //矿工可用余额,单位FIL
    private BigDecimal balanceMinerAvailable;

    //总资产、挖矿账户余额, 单位FIL
    private BigDecimal balanceMinerAccount;

    //Worker账户余额
    private BigDecimal balanceWorkerAccount;

    //当天出块份数
    private Long blocksPerDay;

    //累计出块份数
    private Long totalBlocks;

    //算力增速, 单位B
    private BigDecimal powerIncreasePerDay;

    //PoSt账户余额
    private BigDecimal postBalance;

}
