package org.trams.junggu.rest.sqlite.bean;

public interface Sqlite<E, B> {
	public void parserBean(B b);
	public void parserEntity(E b);
}