package com.fintecher.contract.vo;

import lombok.Data;
import net.sf.json.JSONObject;

/**
 * @Author wxc
 * @Data 2018/2/2 11:41
 * @Description 结果
 */
@Data
public class ResultJson {
    private String code;	// 返回code
    private String info;	// 返回信息
    private JSONObject resultJson;	// 返回数据集
}
