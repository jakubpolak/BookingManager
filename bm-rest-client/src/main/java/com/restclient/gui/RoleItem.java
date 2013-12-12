package com.restclient.gui;

/**
 * @author Jan Hrubeš
 */
public class RoleItem
{
    private Long key;
    private String label;

    public RoleItem(Long key, String label) {
        this.key = key;
        this.label = label;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
