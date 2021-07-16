package io.k2pool.entity;

import lombok.Data;

/**
 * 对外API-全网数据
 *
 * @author shangbin
 * @version v1.0.0
 * @date 2021/7/3 17:31
 **/
@Data
public class ForeignNetworkVO {


    //全网数据
    private NetWordDataVo netWordData;

    //32G扇区封装成本
    private ThirtyTwoGasVO thirtyTwoGasVO;

    //64G扇区封装成本
    private SixtyFourGasVO sixtyFourGasVO;

}
