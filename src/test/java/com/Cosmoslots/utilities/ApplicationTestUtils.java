package com.Cosmoslots.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;
import org.joda.time.DateTime;


/**
 * The <code>ApplicationTestUtils</code> class contains all the utility methods
 * required across <b>AtomicTestSuite</b> application.
 *
 * @author APEXX Fintech
 */
public class ApplicationTestUtils {

	private ApplicationTestUtils() {
	}

	/**
	 * This method <code>isNotEmpty</code> is used for check the String whether is
	 * not empty or not null.
	 *
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(final String s) {

		return s != null && !s.isEmpty();
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the String
	 * value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final String param) {

		return param == null || param.trim().length() <= 0;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the Long
	 * value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final Long param) {

		return param == null || param <= 0L;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the Integer
	 * value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final Integer param) {

		return param == null || param <= 0;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the Double
	 * value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final Double param) {

		return param == null || param <= 0;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the String
	 * Array passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final String[] param) {

		return param == null || param.length == 0;
	}

	/**
	 * This <code>isBoolean</code> method is responsible to check whether the String
	 * is boolean or not.
	 *
	 * @param value
	 * @return
	 */
	public static boolean isBoolean(final String value) {

		return !isEmpty(value) && (value.equalsIgnoreCase(Boolean.TRUE.toString())
				|| value.equalsIgnoreCase(Boolean.FALSE.toString()));
	}

	/**
	 * This method <code>isValid</code> is used for check the Collection whether is
	 * not empty or not null.
	 *
	 * @param collection
	 * @return
	 */
	public static boolean isValid(final Collection<?> collection) {

		return collection != null && !collection.isEmpty();
	}

	/**
	 * This <code>getPropertyFile</code> method will be used to get the property
	 * file.
	 *
	 * @param fileName
	 * @return
	 */
	public static Properties getPropertyFile(final String fileName) {

		// logger.info(" ==> Method : getPropertyFile ==> Called");

		InputStream inputStream = null;
		final Properties properties = new Properties();

		try {

			inputStream = ApplicationTestUtils.class.getClassLoader().getResourceAsStream(fileName);

			// Load a properties file from class path, inside static method
			properties.load(inputStream);

		} catch (final IOException io) {
			// logger.info(" ==> Method : getPropertyFile ==> IOException : " + io);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (final IOException e) {
					// logger.error(" ==> Method : getPropertyFile ==> IOException : " + e);
				}
			}
		}

		return properties;
	}

	/**
	 * This <code>getIncrementOrDecrementedYear</code> method will
	 * increment/decrement year based on parameter.
	 * 
	 * @param incrementYear
	 * @param decrementYear
	 * @return
	 */
	public static int getIncrementOrDecrementedYear(int incrementYear, int decrementYear) {

		Date dt = new Date();
		DateTime dateTime = new DateTime(dt);

		if (incrementYear > 0) {

			dateTime = dateTime.plusYears(incrementYear);

		} else if (decrementYear > 0) {

			dateTime = dateTime.minusYears(decrementYear);
		}

		return dateTime.getYear();
	}

	/**
	 * This <code>getIncrementOrDecrementedMonth</code> method will
	 * increment/decrement month based on parameter.
	 * 
	 * @param incrementMonth
	 * @param decrementMonth
	 * @return
	 */
	public static int getIncrementOrDecrementedMonth(int incrementMonth, int decrementMonth) {

		Date dt = new Date();
		DateTime dateTime = new DateTime(dt);

		if (incrementMonth > 0) {

			dateTime = dateTime.plusMonths(incrementMonth);

		} else if (decrementMonth > 0) {

			dateTime = dateTime.minusMonths(decrementMonth);
		}

		return dateTime.getMonthOfYear();
	}

	/**
	 * This <code>generateUtf16String</code> will return UTF-16 String
	 * 
	 * @return
	 */
	public static String generateUtf16String() {

		try {

			String invalidLabel = "invalid";
			return new String(invalidLabel.getBytes(), "UTF-16");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * This <code>isEmptySheet</code> method is responsible to check whether the
	 * Integer value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmptySheet(final Integer param) {
		return param == null || param < 0;
	}

}
