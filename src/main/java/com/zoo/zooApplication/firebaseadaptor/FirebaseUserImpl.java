package com.zoo.zooApplication.firebaseadaptor;

import com.google.firebase.auth.UserRecord;

public class FirebaseUserImpl implements IFirebaseUser {

    private final UserRecord userRecord;

    public FirebaseUserImpl(UserRecord userRecord) {
        this.userRecord = userRecord;
    }

    @Override
    public String getUid() {
        return userRecord.getUid();
    }

    @Override
    public String getEmail() {
        return userRecord.getEmail();
    }

    @Override
    public String getPhoneNumber() {
        return userRecord.getPhoneNumber();
    }

    @Override
    public boolean isEmailVerified() {
        return userRecord.isEmailVerified();
    }

    @Override
    public String getDisplayName() {
        return userRecord.getDisplayName();
    }

    @Override
    public String getPhotoUrl() {
        return userRecord.getPhotoUrl();
    }

    @Override
    public boolean isDisabled() {
        return userRecord.isDisabled();
    }

    @Override
    public long getTokensValidAfterTimestamp() {
        return userRecord.getTokensValidAfterTimestamp();
    }
}
