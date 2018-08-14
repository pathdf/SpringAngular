package com.pankaj.bean;

import java.io.Serializable;

public interface IdNamePair<I, N> {
	I getId();
	N getName();
}
