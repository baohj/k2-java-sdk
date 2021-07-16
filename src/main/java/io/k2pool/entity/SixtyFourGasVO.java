package io.k2pool.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
//64G扇区gas封装成本
public class SixtyFourGasVO {

    //gas费用
    private BigDecimal gas;

    //总成本
    private BigDecimal cost;

   //质押费
    private BigDecimal pledge;
}
