package com.eaton.px.twitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test suite for the Twitter outbound message adapter.  The Twitter
 * template defined in twitter-update.xml expects the application access 
 * credentials passed from Spring XD when run.  To set them manually when running 
 * tests, specify them as system properties when running the test suite:
 * 
 * 		-DconsumerKey=Ctg4SuUjDIKlCOIaXkJ8EVWeR
 *		-DconsumerSecret=sbx4Xj3oo2gt2xH9cAxJb672HQOCFZirBY90K6ymqtTMW6bb1f
 *		-DaccessToken=2890325044-7PH7oaJr996OwAfD4xZIN047ivukTSJl4KrmA4y
 *		-DaccessTokenSecret=Op4iNxoezVjHyZVq8uS67FAll8yE0DyFjuXXSamYuc8aa
 * 
 * @author Brian Jimerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:twitter-update.xml", "classpath:twitter-update-test.xml"})
public class TwitterOutboundAdapterTest {

	@Autowired
	TwitterTemplate twitterTemplate;
	
	@Test
	public void testTwitterMessage() {
		Assert.assertTrue(twitterTemplate.isAuthorized());
		SearchResults results = twitterTemplate.searchOperations().search("Cleveland Browns");
		Assert.assertNotNull("Expected to get search results.", results);
		Assert.assertTrue("Expected to get search results.", results.getTweets().size() > 0);
	}

}
