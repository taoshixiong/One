package com.taosx.one.Util.BaseAdapter.RecyclerAdapter.helper;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public interface DataHelper<T> {

    boolean addAll(List<T> list);

    boolean addAll(int position, List<T> list);

    void add(T data);

    void add(int position, T data);

    void clear();

    boolean contains(T data);

    T getData(int index);

    void modify(T oldData, T newData);

    void modify(int index, T newData);

    boolean remove(T data);

    void remove(int index);

}
