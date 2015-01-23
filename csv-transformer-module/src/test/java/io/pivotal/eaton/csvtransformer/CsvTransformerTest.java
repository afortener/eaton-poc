package io.pivotal.eaton.csvtransformer;

import io.pivotal.eaton.csvtransformer.CsvTransformer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test suite for the CSV transformer.
 * @author Brian Jimerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/csv-transformer.xml", "classpath:csv-transformer-test.xml"})
public class CsvTransformerTest {

	
	/**
	 * Test for the transform method.
	 */
	@Test
	public void testTransform() {
		String csv = "site, publisher, time, min, max, avg, actual\n" +
				"1, 74dcbbfc-09bf-4cf4-b8c3-ccab062f9808, 100, 1420088400, 81.932060, " +
				"91.932060, 86.932060, 87.932060";
		
		CsvTransformer transformer = new CsvTransformer();
		String json = transformer.transform(csv);
		Assert.assertNotNull("JSON shouldn't be null.", json);
		Assert.assertTrue("JSON should contain site field.", json.indexOf("site") > -1);
	}

}
