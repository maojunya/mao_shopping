
package com.online.shopping.beans;

import java.io.Serializable;


public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    private String stateCode;
    private String stateName;
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
    
   
    
}
