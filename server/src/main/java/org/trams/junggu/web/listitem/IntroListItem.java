/*
 * Created on 11 Dec 2015 ( Time 17:35:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.web.listitem;

import org.trams.junggu.bean.Intro;
import org.trams.junggu.web.common.ListItem;

public class IntroListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public IntroListItem(Intro intro) {
		super();

		this.value = ""
			 + intro.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = intro.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
