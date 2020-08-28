package com.gsd.sreenidhi.arachnid.model.formatter;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public interface ObjectFormatter<T> {

    T format(String raw) throws Exception;

    Class<T> clazz();

    void initParam(String[] extra);

}
