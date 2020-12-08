package com.wei.responsibility.simplechain.chain;

import com.wei.responsibility.simplechain.chain.filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class MsgFilterChain {

    private List<Filter> filters = new ArrayList<Filter>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public String doFilter(String msg) {
        for (Filter filter : filters) {
            msg = filter.doFilter(msg);
        }
        return msg;
    }
}
