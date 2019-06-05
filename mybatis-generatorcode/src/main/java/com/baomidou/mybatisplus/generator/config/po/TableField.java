/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.generator.config.po;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * <p>
 * 表字段信息
 * </p>
 *
 * @author YangHu
 * @since 2016-12-03
 */
@Data
@Accessors(chain = true)
public class TableField {

    private boolean convert;
    private boolean keyFlag;
    /**
     * 主键是否为自增类型
     */
    private boolean keyIdentityFlag;
    private String name;
    private String type;
    private String propertyName;
    private IColumnType columnType;
    private String comment;
    //字段长度
    private Integer maxLength;
    //精度
    private Integer fraction;
    //是否数字类型标志
    private boolean numberFlag;
    //swagger2 example 属性
    private String example;

    private String fill;
    private boolean nullFlag;
    /**
     * 自定义查询字段列表
     */
    private Map<String, Object> customMap;

    public TableField setConvert(boolean convert) {
        this.convert = convert;
        return this;
    }

    protected TableField setConvert(StrategyConfig strategyConfig) {
        if (strategyConfig.isEntityTableFieldAnnotationEnable()) {
            this.convert = true;
            return this;
        }
        if (strategyConfig.isCapitalModeNaming(name)) {
            this.convert = false;
        } else {
            // 转换字段
            if (NamingStrategy.underline_to_camel == strategyConfig.getColumnNaming()) {
                // 包含大写处理
                if (StringUtils.containsUpperCase(name)) {
                    this.convert = true;
                }
            } else if (!name.equals(propertyName)) {
                this.convert = true;
            }
        }
        return this;
    }

    public TableField setPropertyName(StrategyConfig strategyConfig, String propertyName) {
        this.propertyName = propertyName;
        this.setConvert(strategyConfig);
        return this;
    }

    public String getPropertyType() {
        if (null != columnType) {
            return columnType.getType();
        }
        return null;
    }

    /**
     * 按JavaBean规则来生成get和set方法
     */
    public String getCapitalName() {
        if (propertyName.length() <= 1) {
            return propertyName.toUpperCase();
        }
        String setGetName = propertyName;
        if (DbColumnType.BASE_BOOLEAN.getType().equalsIgnoreCase(columnType.getType())) {
            setGetName = StringUtils.removeIsPrefixIfBoolean(setGetName, Boolean.class);
        }
        // 第一个字母 小写、 第二个字母 大写 ，特殊处理
        String firstChar = setGetName.substring(0, 1);
        if (Character.isLowerCase(firstChar.toCharArray()[0])
                && Character.isUpperCase(setGetName.substring(1, 2).toCharArray()[0])) {
            return firstChar.toLowerCase() + setGetName.substring(1);
        }
        return firstChar.toUpperCase() + setGetName.substring(1);
    }

    public String getLengthValidation() {
        if (this.columnType == DbColumnType.STRING) {
            return "@Size(max = " + maxLength + ")";
        }
        return "";
    }

    public void setLengthInfo(String lengthInfo) {
        if (StringUtils.isNotEmpty(lengthInfo)) {
            String[] arr = lengthInfo.split(",");
            this.maxLength = Integer.parseInt(arr[0]);
            if (arr.length > 1) {
                this.fraction = Integer.parseInt(arr[1]);
            }

            if (DbColumnType.SHORT == this.columnType ||
                    DbColumnType.INTEGER == this.columnType ||
                    DbColumnType.LONG == this.columnType ||
                    DbColumnType.FLOAT == this.columnType ||
                    DbColumnType.DOUBLE == this.columnType ||
                    DbColumnType.BASE_SHORT == this.columnType ||
                    DbColumnType.BASE_INT == this.columnType ||
                    DbColumnType.BASE_LONG == this.columnType ||
                    DbColumnType.BASE_FLOAT == this.columnType ||
                    DbColumnType.BASE_DOUBLE == this.columnType ||
                    DbColumnType.BIG_INTEGER == this.columnType ||
                    DbColumnType.BIG_DECIMAL == this.columnType) {
                this.numberFlag = true;
                if (this.fraction == null) {
                    this.fraction = 0;
                }
            }
        }

    }

    public void setExample() {

        if (DbColumnType.SHORT == this.columnType ||
                DbColumnType.INTEGER == this.columnType ||
                DbColumnType.LONG == this.columnType ||
                DbColumnType.FLOAT == this.columnType ||
                DbColumnType.DOUBLE == this.columnType ||
                DbColumnType.BASE_SHORT == this.columnType ||
                DbColumnType.BASE_INT == this.columnType ||
                DbColumnType.BASE_LONG == this.columnType ||
                DbColumnType.BASE_FLOAT == this.columnType ||
                DbColumnType.BASE_DOUBLE == this.columnType ||
                DbColumnType.BIG_INTEGER == this.columnType ||
                DbColumnType.BIG_DECIMAL == this.columnType) {
            this.example = "0";
        }

        if (DbColumnType.STRING == this.columnType) {
            this.example = "string";
            if(this.maxLength<6){
                StringBuilder sb = new StringBuilder(this.maxLength);
                for (int i = 0; i < this.maxLength; i++) {
                    sb.append("s");
                }
                this.example = sb.toString();
            }
        }

        if(DbColumnType.LOCAL_DATE == this.columnType){
            this.example = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        }

        if(DbColumnType.LOCAL_DATE_TIME == this.columnType){
            this.example = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        }


    }
}
