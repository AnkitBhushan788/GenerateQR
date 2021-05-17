package com.ankit.QRbuild.decorator;

/**
 * Implement this interface to create custom decorators
 */
public interface Decorator<T> {

  T decorate(T qrcode);
}
