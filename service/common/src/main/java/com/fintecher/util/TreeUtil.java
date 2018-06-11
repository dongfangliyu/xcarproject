package com.fintecher.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 把一个list集合,里面的bean含有 parentId 转为树形式
 * Created by jwdstef on 2017/3/6.
 */
public class TreeUtil {
    /**
     * @param @param  list
     * @param @param  ns
     * @param @return 设定文件
     * @return List<TreeObject>    返回类型
     * @throws
     * @Title: getChildTreeObjectList
     * @Description: 将菜单下的操作遍历为树形结构
     */
    public List<TreeObject> getChildTreeObjectList(List<TreeObject> list, List<TreeObject> ns) {
        for (TreeObject tree : list) {
            for (Iterator<TreeObject> iterator = ns.iterator(); iterator.hasNext(); ) {
                TreeObject t = (TreeObject) iterator.next();
                System.out.println(t.getId() + "****" + t.getName() + tree.getParentId() + "*****" + tree.getParentName() + "*****" + tree.getName());
                if (t.getId() == tree.getParentId()) {
                    t.getChildren().add(tree);
                } else {
                    returnTreeList(t.getChildren(), tree);
                }
            }
        }
        return ns;
    }

    /**
     * @param @param  list
     * @param @param  t
     * @param @return 设定文件
     * @return List<TreeObject>    返回类型
     * @throws
     * @Title: returnTreeList
     * @Description: 将菜单下的操作遍历为树形结构(递归)
     */
    public List<TreeObject> returnTreeList(List<TreeObject> list, TreeObject t) {
        for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext(); ) {
            TreeObject m = (TreeObject) iterator.next();
            if (m.getId() == t.getParentId()) {
                m.getChildren().add(t);
                break;
            } else {
                returnTreeList(m.getChildren(), t);
            }
        }
        return list;
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list   分类表
     * @param typeId 传入的父节点ID
     * @return String
     */
    public List<TreeObject> getChildTreeObjects(List<TreeObject> list, int parentId) {
        List<TreeObject> returnList = new ArrayList<TreeObject>();
        for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext(); ) {
            TreeObject t = (TreeObject) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                System.out.println(t.getParentId() + "*********" + t.getParentName());
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param TreeObject
     * @author zqb
     * Email:
     * @date
     */
    public void recursionFn(List<TreeObject> list, TreeObject t) {
        List<TreeObject> childList = getChildList(list, t);// 得到子节点列表
        t.setChildren(childList);
        for (TreeObject tChild : childList) {
            if (hasChild(list, tChild)) {// 判断是否有子节点
                //returnList.add(TreeObject);
                Iterator<TreeObject> it = childList.iterator();
                while (it.hasNext()) {
                    TreeObject n = (TreeObject) it.next();
                    System.out.println(n.getParentId() + "*********" + n.getParentName());
                    recursionFn(list, n);
                }
            }
        }
    }


    // 得到子节点列表
    private List<TreeObject> getChildList(List<TreeObject> list, TreeObject t) {

        List<TreeObject> tlist = new ArrayList<TreeObject>();
        Iterator<TreeObject> it = list.iterator();
        while (it.hasNext()) {
            TreeObject n = (TreeObject) it.next();
            if (n.getParentId() == t.getId()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    List<TreeObject> returnList = new ArrayList<TreeObject>();

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list   分类表
     * @param typeId 传入的父节点ID
     * @param prefix 子节点前缀
     */
    public List<TreeObject> getChildTreeObjects(List<TreeObject> list, int typeId, String prefix) {
        if (list == null) return null;
        for (Iterator<TreeObject> iterator = list.iterator(); iterator.hasNext(); ) {
            TreeObject node = (TreeObject) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() == typeId) {
                recursionFn(list, node, prefix);
            }
            // 二、遍历所有的父节点下的所有子节点
            /*if (node.getParentId()==0) {
                recursionFn(list, node);
            }*/
        }
        return returnList;
    }

    private void recursionFn(List<TreeObject> list, TreeObject node, String p) {
        // 得到子节点列表
        List<TreeObject> childList = getChildList(list, node);
        // 判断是否有子节点
        if (hasChild(list, node)) {
            returnList.add(node);
            Iterator<TreeObject> it = childList.iterator();
            while (it.hasNext()) {
                TreeObject n = (TreeObject) it.next();
                n.setName(p + n.getName());
                recursionFn(list, n, p + p);
            }
        } else {
            returnList.add(node);
        }
    }

    // 判断是否有子节点
    private boolean hasChild(List<TreeObject> list, TreeObject t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }

    // 本地模拟数据测试
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<TreeObject> TreeObjectList = new ArrayList<TreeObject>();
        /*******************自己组装list*****************/
        TreeUtil mt = new TreeUtil();
        List<TreeObject> ns = mt.getChildTreeObjects(TreeObjectList, 0);
        for (TreeObject m : ns) {
            System.out.println(m.getName());
            System.out.println(m.getChildren());
        }
        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end - start) + "ms");
    }

}
