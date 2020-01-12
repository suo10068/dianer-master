package com.dianer.bigdata.config;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class MyPathFilter implements PathFilter {

    private String reg;

    public MyPathFilter(String reg) {
        this.reg = reg;
    }

    @Override
    public boolean accept(Path path) {
        if (path.toString().matches(reg)) {
            return false;
        }
        return true;
    }
}
