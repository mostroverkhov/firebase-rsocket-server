package com.github.mostroverkhov.firebase_rsocket.internal.codec;

/**
 * Created with IntelliJ IDEA.
 * Author: mostroverkhov
 */
public interface CodecAware {

    CodecAware setDataCodec(DataCodec dataCodec);
}
