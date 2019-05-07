package com.wei.responsibility.webchain.chain;

import com.wei.responsibility.webchain.Request;
import com.wei.responsibility.webchain.Response;
import com.wei.responsibility.webchain.chain.filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{

    private int index;

    private List<Filter> filters = new ArrayList<Filter>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }


    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        if (index == filters.size()) {
            return;
        } else {
            filters.get(index++).doFilter(request, response, this);
        }
    }
}
