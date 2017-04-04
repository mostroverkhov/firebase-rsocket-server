package com.github.mostroverkhov.firebase_rsocket_data.common;

import io.reactivesocket.Payload;
import io.reactivesocket.util.PayloadImpl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * Author: mostroverkhov
 */
public final class Conversions {

    public static String bytesToString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("String encoding error", e);
        }
    }

    public static byte[] stringToBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("String encoding error", e);
        }
    }

    public static byte[] payloadToBytes(Payload payload) {
        ByteBuffer bb = payload.getData();
        byte[] b = new byte[bb.remaining()];
        bb.get(b);
        return b;
    }

    public static Payload bytesToPayload(byte[] bytes) {
        return new PayloadImpl(bytes);
    }

    public static BufferedReader bytesToReader(byte[] bytes) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
    }
}
