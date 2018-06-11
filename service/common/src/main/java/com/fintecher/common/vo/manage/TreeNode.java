package com.fintecher.common.vo.manage;

/**'
 * 树对象
 * @author jwdstef
 */
public class TreeNode implements java.io.Serializable{
    private Long id;
    private Long parentId;
    private String name;
    private Boolean open = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
