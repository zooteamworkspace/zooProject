package com.zoo.zooApplication.converter;

import com.zoo.zooApplication.dao.model.PriceChartDO;
import com.zoo.zooApplication.response.PriceChart;
import com.zoo.zooApplication.util.DateTimeUtil;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
public class PriceChartDOToResponseConverter {
    public PriceChart convert(@NotNull final PriceChartDO priceChartDO){
        Objects.requireNonNull(priceChartDO);

        return PriceChart
                .builder()
                .id(priceChartDO.getId())
                .priceAmount(priceChartDO.getPriceAmount())
                .timeStart(DateTimeUtil.FormatISOTimeToString(priceChartDO.getTimeStart()))
                .timeEnd(DateTimeUtil.FormatISOTimeToString(priceChartDO.getTimeEnd()))
                .build();
    }
}
