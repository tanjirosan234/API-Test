package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReaderEduflix {

	private Properties propertiesEduflix;
	private final String propertyFilePath = "Configs//ConfigurationEduflix.properties";

	public ConfigFileReaderEduflix() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			propertiesEduflix = new Properties();
			try {
				propertiesEduflix.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("ConfigurationEduflix.properties not found at " + propertyFilePath);
		}
	}

	// Global Get Functions
	public String getBrowserId() {
		String browserId = propertiesEduflix.getProperty("browserId");
		if (browserId != null)
			return browserId;
		else
			throw new RuntimeException("browserId not specified in the ConfigurationEduflix.properties file.");
	}

	public long getImplicitlyWait() {
		String ImplicitlyWait = propertiesEduflix.getProperty("ImplicitlyWait");
		if (ImplicitlyWait != null)
			return Long.parseLong(ImplicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the ConfigurationEduflix.properties file.");
	}

	public String getApplicationUrl() {
		String applicationUrl = propertiesEduflix.getProperty("applicationUrl");
		if (applicationUrl != null)
			return applicationUrl;
		else
			throw new RuntimeException("applicationUrl not specified in the ConfigurationEduflix.properties file.");
	}

	public long getSleepTime() {
		String sleepTime = propertiesEduflix.getProperty("sleepTime");
		if (sleepTime != null)
			return Long.parseLong(sleepTime);
		else
			throw new RuntimeException("sleepTime not specified in the ConfigurationEduflix.properties file.");
	}

	// Login local functions

	public String getLoginTitleText() {
		String loginTitleText = propertiesEduflix.getProperty("loginTitleText");
		if (loginTitleText != null)
			return loginTitleText;
		else
			throw new RuntimeException("loginTitleText not specified in the Configuration.properties file.");
	}

	public String getFieldRequiredText() {
		String fieldRequiredText = propertiesEduflix.getProperty("fieldRequiredText");
		if (fieldRequiredText != null)
			return fieldRequiredText;
		else
			throw new RuntimeException("fieldRequiredText not specified in the Configuration.properties file.");
	}

	public String getWrongUserText() {
		String wrongUserText = propertiesEduflix.getProperty("wrongUserText");
		if (wrongUserText != null)
			return wrongUserText;
		else
			throw new RuntimeException("wrongUserText not specified in the Configuration.properties file.");
	}

	public String getWrongPassText() {
		String wrongPassText = propertiesEduflix.getProperty("wrongPassText");
		if (wrongPassText != null)
			return wrongPassText;
		else
			throw new RuntimeException("wrongPassText not specified in the Configuration.properties file.");
	}

	public String getIncorrectUserPassMsgText() {
		String incorrectUserPassMsgText = propertiesEduflix.getProperty("incorrectUserPassMsgText");
		if (incorrectUserPassMsgText != null)
			return incorrectUserPassMsgText;
		else
			throw new RuntimeException("incorrectUserPassMsgText not specified in the Configuration.properties file.");
	}

	public String getCorrectUserText() {
		String correctUserText = propertiesEduflix.getProperty("correctUserText");
		if (correctUserText != null)
			return correctUserText;
		else
			throw new RuntimeException("correctUserText not specified in the Configuration.properties file.");
	}

	public String getCorrectPassText() {
		String correctPassText = propertiesEduflix.getProperty("correctPassText");
		if (correctPassText != null)
			return correctPassText;
		else
			throw new RuntimeException("correctPassText not specified in the Configuration.properties file.");
	}

	public String getLogoutText() {
		String logoutText = propertiesEduflix.getProperty("logoutText");
		if (logoutText != null)
			return logoutText;
		else
			throw new RuntimeException("logoutText not specified in the Configuration.properties file.");
	}

	public String getBadFormatedMailText() {
		String badFormatedMailText = propertiesEduflix.getProperty("badFormatedMailText");
		if (badFormatedMailText != null)
			return badFormatedMailText;
		else
			throw new RuntimeException("badFormatedMailText not specified in the Configuration.properties file.");
	}

	public String getNotValidMailText() {
		String notValidMailText = propertiesEduflix.getProperty("notValidMailText");
		if (notValidMailText != null)
			return notValidMailText;
		else
			throw new RuntimeException("notValidMailText not specified in the Configuration.properties file.");
	}

	public String getNotExistedMailText() {
		String notExistedMailText = propertiesEduflix.getProperty("notExistedMailText");
		if (notExistedMailText != null)
			return notExistedMailText;
		else
			throw new RuntimeException("notExistedMailText not specified in the Configuration.properties file.");
	}

	public String getIncorrectMailText() {
		String incorrectMailText = propertiesEduflix.getProperty("incorrectMailText");
		if (incorrectMailText != null)
			return incorrectMailText;
		else
			throw new RuntimeException("incorrectMailText not specified in the Configuration.properties file.");
	}

	public String getIncorrectMailMsgText() {
		String incorrectMailMsgText = propertiesEduflix.getProperty("incorrectMailMsgText");
		if (incorrectMailMsgText != null)
			return incorrectMailMsgText;
		else
			throw new RuntimeException("incorrectMailMsgText not specified in the Configuration.properties file.");
	}

	public String getGoodMail1() {
		String goodMail1 = propertiesEduflix.getProperty("goodMail1");
		if (goodMail1 != null)
			return goodMail1;
		else
			throw new RuntimeException("goodMail1 not specified in the Configuration.properties file.");
	}

	public String getGoodMail2() {
		String goodMail2 = propertiesEduflix.getProperty("goodMail2");
		if (goodMail2 != null)
			return goodMail2;
		else
			throw new RuntimeException("goodMail2 not specified in the Configuration.properties file.");
	}

	public String getNotMatchedMailText() {
		String notMatchedMailText = propertiesEduflix.getProperty("notMatchedMailText");
		if (notMatchedMailText != null)
			return notMatchedMailText;
		else
			throw new RuntimeException("notMatchedMailText not specified in the Configuration.properties file.");
	}

	public String getShortPass() {
		String shortPass = propertiesEduflix.getProperty("shortPass");
		if (shortPass != null)
			return shortPass;
		else
			throw new RuntimeException("shortPass not specified in the Configuration.properties file.");
	}

	public String getShortPassMsg() {
		String shortPassMsg = propertiesEduflix.getProperty("shortPassMsg");
		if (shortPassMsg != null)
			return shortPassMsg;
		else
			throw new RuntimeException("shortPassMsg not specified in the Configuration.properties file.");
	}

	public String getPassNotMatchedMsg() {
		String passNotMatchedMsg = propertiesEduflix.getProperty("passNotMatchedMsg");
		if (passNotMatchedMsg != null)
			return passNotMatchedMsg;
		else
			throw new RuntimeException("passNotMatchedMsg not specified in the Configuration.properties file.");
	}

	public String getExistedUserMsg() {
		String existedUserMsg = propertiesEduflix.getProperty("existedUserMsg");
		if (existedUserMsg != null)
			return existedUserMsg;
		else
			throw new RuntimeException("existedUserMsg not specified in the Configuration.properties file.");
	}

	public String getAutoMailExtText() {
		String autoMailExtText = propertiesEduflix.getProperty("autoMailExtText");
		if (autoMailExtText != null)
			return autoMailExtText;
		else
			throw new RuntimeException("autoMailExtText not specified in the Configuration.properties file.");
	}

	public String getUserFB() {
		String userFB = propertiesEduflix.getProperty("facebookEmail");
		if (userFB != null)
			return userFB;
		else
			throw new RuntimeException("userFB not specified in the Configuration.properties file.");
	}

	public String getPasswordFB() {
		String passwordFB = propertiesEduflix.getProperty("facebookPassword");
		if (passwordFB != null)
			return passwordFB;
		else
			throw new RuntimeException("passwordFB not specified in the Configuration.properties file.");
	}

	//////// New properties
	public String getFieldCheckBoxText() {
		String fieldRequiredCheckBox = propertiesEduflix.getProperty("fieldRequiredCheckBox");
		if (fieldRequiredCheckBox != null)
			return fieldRequiredCheckBox;
		else
			throw new RuntimeException("fieldRequiredCheckBox not specified in the Configuration.properties file.");
	}

	public String getFirstName() {
		String firstName = propertiesEduflix.getProperty("firstName");
		if (firstName != null)
			return firstName;
		else
			throw new RuntimeException("firstName not specified in the Configuration.properties file.");
	}

	public String getLastName() {
		String lastName = propertiesEduflix.getProperty("lastName");
		if (lastName != null)
			return lastName;
		else
			throw new RuntimeException("lastName not specified in the Configuration.properties file.");
	}

	public String getCorrectDate() {
		String correctDate = propertiesEduflix.getProperty("correctDate");
		if (correctDate != null)
			return correctDate;
		else
			throw new RuntimeException("correctDate not specified in the Configuration.properties file.");
	}

	public String getFutureDate() {
		String futureDate = propertiesEduflix.getProperty("futureDate");
		if (futureDate != null)
			return futureDate;
		else
			throw new RuntimeException("futureDate not specified in the Configuration.properties file.");
	}

	public String getDateNotValid() {
		String dateNotValid = propertiesEduflix.getProperty("dateNotValid");
		if (dateNotValid != null)
			return dateNotValid;
		else
			throw new RuntimeException("dateNotValid not specified in the Configuration.properties file.");
	}

	public String getFavoriteSPort() {
		String favoriteSport = propertiesEduflix.getProperty("favoriteSport");
		if (favoriteSport != null)
			return favoriteSport;
		else
			throw new RuntimeException("favoriteSport not specified in the Configuration.properties file.");
	}

	// Мy profile settings
	public String getPhoneNumber() {
		String phoneNumber = propertiesEduflix.getProperty("phoneNumber");
		if (phoneNumber != null)
			return phoneNumber;
		else
			throw new RuntimeException("phoneNumber not specified in the Configuration.properties file.");
	}

	// Field is required message
	public String getErrorMessage() {
		String fieldIsReqired = propertiesEduflix.getProperty("fieldIsReqired");
		if (fieldIsReqired != null)
			return fieldIsReqired;
		else
			throw new RuntimeException("fieldIsReqired not specified in the Configuration.properties file.");
	}

	// toast message- join the newsletter
	public String getToastTitle() {
		String toastTitle = propertiesEduflix.getProperty("toastTitle");
		if (toastTitle != null)
			return toastTitle;
		else
			throw new RuntimeException("toastTitle not specified in the Configuration.properties file.");
	}
}
