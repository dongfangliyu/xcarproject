package com.fintecher.sims.vo;

import com.fintecher.sims.util.ZWStringUtils;
import org.apache.commons.collections4.map.HashedMap;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @Author: jwdstef
 * @Description: 分页专用
 * @Date 2017/5/31
 */
public class PageParam {

    private Integer page;

    private Integer size;

    private String sort;

    public PageParam() {
    }

    public PageParam(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public PageParam(Integer page, Integer size, String sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public enum Direction{
        ASC("ASC"),DESC("DESC");
        private String value;
        Direction(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    public void setOrderBy(Example example){
        try {
            if(ZWStringUtils.isEmpty(this.sort)){
                return;
            }
            this.sort = this.sort.trim();
            List<Map<String,String>> sortList = new ArrayList<>();
            Map<String,String> sortMap = new HashedMap();
            List<String> paramList;
            if(this.sort.contains(",")){
                paramList = Arrays.asList(this.sort.split(","));
            }else {
                paramList = Arrays.asList(this.sort);
            }
            for (String s : paramList) {
                s = s.trim();
                String[] paramArray = s.split("\\s+");
                sortMap = new HashMap<>();
                if(paramArray.length == 2){
                    sortMap.put("field",paramArray[0]);
                    sortMap.put("direction",paramArray[1]);
                    sortList.add(sortMap);
                }else if(paramArray.length == 1){
                    sortMap.put("field",paramArray[0]);
                    sortMap.put("direction", Direction.ASC.getValue());
                    sortList.add(sortMap);
                }
            }

            if(!sortList.isEmpty()){
                for (Map<String, String> map : sortList) {
                    if(ZWStringUtils.isNotEmpty(map.get("direction")) && PageParam.Direction.DESC.getValue().equalsIgnoreCase(map.get("direction"))){
                        example.orderBy(map.get("field")).desc();
                    }else {
                        example.orderBy(map.get("field")).asc();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("排序参数传值错误",e);
        }

    }
}
