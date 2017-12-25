/*
 * Created on 11 Dec 2015 ( Time 17:35:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.web.listitem;

import org.trams.junggu.bean.Comment;
import org.trams.junggu.web.common.ListItem;

public class CommentListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public CommentListItem(Comment comment) {
		super();

		this.value = ""
			 + comment.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = comment.toString();
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