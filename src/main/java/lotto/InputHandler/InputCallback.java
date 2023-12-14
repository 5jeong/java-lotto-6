package lotto.InputHandler;

@FunctionalInterface
public interface InputCallback<T> {
    T run() throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
}
