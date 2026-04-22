package com.im2ag.m1info.ndarray;
/**
 * <p>Exception utilisée pour les erreurs de dimensions
 * </p>
 */
public class IncorrectDimension extends RuntimeException {
    public IncorrectDimension(String message) {
        super(message);
    }
}
