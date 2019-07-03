package cn.summit;

import cn.summit.customAnot.Custom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayRequestDto {

    /**
     * 支付完成时间
     **/
    @NotEmpty(message = "支付完成时间不能空")
    @Size(max = 14, message = "支付完成时间长度不能超过{max}位")
    private String payTime;

    /**
     * 状态
     **/
    @Pattern(regexp = "0[0123]", message = "状态只能为00或01或02或03")
    private String status;

    @Null(message = "该值zhi能为null")
    private String nullTest;

    @NotNull(message = "该值不能为null")
    private String notNullTest;


    @AssertTrue(message = "该值必须为true")
    private Boolean assertTest;

    @AssertFalse(message = "该值必须为false")
    private Boolean assertFalseTest;

    @Min(value = 4, message = "该值最小为{value}")
    private String minTest;

    @Max(value = 5, message = "该值最大为{value}")
    private String maxTest;

    @DecimalMin(value = "10", message = "该值一定小于{value}")
    private double number;

    @DecimalMax(value = "8", message = "该值一定大于{value}")
    private String number1;

    @Size(max = 5, min = 3, message = "该值在{max}和{min}之间")
    private String number3;

    @Digits(integer = 2, fraction = 1)
    private BigDecimal digits;

    @Length(max = 3, min = 2)
    private String lengthTest;

    @Custom
    private String customTest;
}