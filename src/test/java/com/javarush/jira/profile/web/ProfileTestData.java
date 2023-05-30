package com.javarush.jira.profile.web;

import com.javarush.jira.MatcherFactory;
import com.javarush.jira.profile.ProfileTo;
import com.javarush.jira.profile.internal.Contact;
import com.javarush.jira.profile.internal.Profile;

import java.util.HashSet;
import java.util.Set;

public class ProfileTestData {
    public static final MatcherFactory.Matcher<ProfileTo> PROFILE_TO_MATCHER = MatcherFactory.usingEqualsComparator(
            ProfileTo.class);
    public static final MatcherFactory.Matcher<ProfileTo> PROFILE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(
            ProfileTo.class, "contacts");
    public static final String USER_MAIL = "user@gmail.com";
    public static final long USER_ID = 1;
    public static final Profile USER_PROFILE = new Profile(USER_ID);
    private static final Contact USER_MOBILE;
    private static final Contact USER_WEBSITE;
    private static final Contact USER_SKYPE;
    private static final Set<Contact> USER_CONTACTS;
    private static final long MAIL_NOTIFICATIONS = 49L;

    static {
        USER_MOBILE = new Contact(USER_ID, "mobile", "+01234567890");
        USER_WEBSITE = new Contact(USER_ID, "website", "user.com");
        USER_SKYPE = new Contact(USER_ID, "skype", "userSkype");
        USER_CONTACTS = new HashSet<>();
        USER_CONTACTS.add(USER_MOBILE);
        USER_CONTACTS.add(USER_WEBSITE);
        USER_CONTACTS.add(USER_SKYPE);
        USER_PROFILE.setContacts(USER_CONTACTS);
        USER_PROFILE.setMailNotifications(MAIL_NOTIFICATIONS);
    }

    public static Profile getUpdated() {
        Profile updatedProfile = new Profile(USER_ID);
        updatedProfile.setContacts(USER_CONTACTS);
        updatedProfile.setMailNotifications(6L);
        return updatedProfile;
    }
}
