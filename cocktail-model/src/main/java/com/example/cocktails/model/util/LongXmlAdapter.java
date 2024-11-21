package com.example.cocktails.model.util;

import jakarta.xml.bind.annotation.adapters.*;

public class LongXmlAdapter extends XmlAdapter<String, Long> {

    @Override
    public Long unmarshal(String v) throws Exception {
        if (v == null) return null;
        return Long.parseLong(v);
    }

    @Override
    public String marshal(Long v) throws Exception {
        if (v == null) return null;
        return v.toString();
    }
}