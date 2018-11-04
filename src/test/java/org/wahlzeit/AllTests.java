package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.handlers.TellFriendTest.class,
	org.wahlzeit.model.AccessRightsTest.class,
	org.wahlzeit.model.CoordinateTest.class,
	org.wahlzeit.model.FlagReasonTest.class,
	org.wahlzeit.model.GenderTest.class,
	org.wahlzeit.model.GuestTest.class,
	org.wahlzeit.model.LocationTest.class,
	org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
	org.wahlzeit.model.PhotoFilterTest.class,
	org.wahlzeit.model.TagsTest.class,
	org.wahlzeit.model.UserStatusTest.class,
	org.wahlzeit.model.ValueTest.class,
	org.wahlzeit.services.EmailAddressTest.class,
	org.wahlzeit.services.LogBuilderTest.class,
	org.wahlzeit.utils.StringUtilTest.class,
	org.wahlzeit.utils.VersionTest.class,
	org.wahlzeit.services.mailing.EmailServiceSuite.class
})

public class AllTests {
}
