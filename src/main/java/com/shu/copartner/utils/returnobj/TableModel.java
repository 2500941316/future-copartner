package com.shu.copartner.utils.returnobj;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author cxy
 * @date 2020/12/6 14:18
 * @Description 统一返回类
 * @return
 */
@Data
public class TableModel<T> {
    private int code;
    private String msg;
    private int count;
    private Object data;


    public static TableModel success(Object data, int total) {
        TableModel tableModel = new TableModel();

        tableModel.setCode(200);
        tableModel.setMsg(null);
        tableModel.setCount(total);
        tableModel.setData(data);

        return tableModel;
    }

    public static TableModel tableSuccess(Object data, int total) {
        TableModel tableModel = new TableModel();

        tableModel.setCode(0);
        tableModel.setMsg(null);
        tableModel.setCount(total);
        tableModel.setData(data);

        return tableModel;
    }

    public static TableModel success() {
        TableModel tableModel = new TableModel();

        tableModel.setCode(200);
        tableModel.setCount(0);

        return tableModel;
    }

    public static TableModel error() {
        TableModel tableModel = new TableModel();
        tableModel.setCode(500);
        tableModel.setData(new ArrayList<>());
        tableModel.setCount(0);

        return tableModel;
    }

    public static TableModel error(Object data) {
        TableModel tableModel = new TableModel();
        tableModel.setCode(500);
        tableModel.setData(data);
        return tableModel;
    }

    public static TableModel error(Integer code, String msg) {
        TableModel tableModel = new TableModel();
        tableModel.setCode(code);
        tableModel.setMsg(msg);

        return tableModel;
    }
}
