/**
 * 
 */
package com.pankaj.bean;

import java.io.Serializable;

/**
 * @author kim
 *
 */
public class LabelValueBean implements IdNamePair<String, String>, Serializable, Comparable<LabelValueBean>
{
	private String value = null;
	private String label = null;
	private String group = null;


	public LabelValueBean() {
		
	}
	public LabelValueBean(String value, String label) {
		this.value = value;
		this.label = label;
	}

	/**
	 * @param value
	 * @param label
	 * @param group
	 */
	public LabelValueBean(String value, String label, String group) {
		this.value = value;
		this.label = label;
		this.group = group;
	}
	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
		
	@Override
	public String toString() {
		return "LabelValueBean [value=" + value + ", label=" + label
				+ ", group=" + group + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabelValueBean other = (LabelValueBean) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	public String getId() {
		return this.value;
	}
	
	public String getName() {
		return this.label;
	}
	
	public int compareTo(LabelValueBean o1) {
		if(this.label !=null && o1.label != null) {
			return this.label.compareTo(o1.label);
		}
		return 1;
	}
}
