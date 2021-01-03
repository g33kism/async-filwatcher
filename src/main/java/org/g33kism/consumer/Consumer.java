package org.g33kism.consumer;

import java.util.concurrent.Future;

public interface Consumer<T> {
    Future<Boolean> consume(T element);
}
