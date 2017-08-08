package com.madhouse.ssp.util;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * Created by Sunxiang on 2017-07-28 13:34.
 */
public class ZKStringSerializer implements ZkSerializer {
    private String charset = "UTF-8";

    public ZKStringSerializer() {

    }

    public ZKStringSerializer(String charset) {
        this.charset = charset;
    }

    public byte[] serialize(Object data) throws ZkMarshallingError {
        try {
            byte[] bytes = String.valueOf(data).getBytes(charset);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new ZkMarshallingError("Wrong Charset:" + charset);
        }
    }

    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        String result = null;
        try {
            result = new String(bytes, charset);
        } catch (UnsupportedEncodingException e) {
            throw new ZkMarshallingError("Wrong Charset:" + charset);
        }
        return result;
    }
}
