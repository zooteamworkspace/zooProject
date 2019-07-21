package com.zoo.zooApplication.firebaseadaptor;

public interface IFirebaseUser {

    String getUid();

    String getEmail();

    String getPhoneNumber();

    boolean isEmailVerified();

    String getDisplayName();

    String getPhotoUrl();

    boolean isDisabled();

    long getTokensValidAfterTimestamp();
}
