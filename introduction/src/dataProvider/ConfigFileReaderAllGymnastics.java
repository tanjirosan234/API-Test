package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReaderAllGymnastics {
	
	private Properties propertiesAllGymnastics;
	private final String propertyFilePath = "Configs//ConfigurationAllGymnastics.properties";
	public ConfigFileReaderAllGymnastics() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			propertiesAllGymnastics = new Properties();
			try {
				propertiesAllGymnastics.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			  }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("ConfigurationAllGymnastics.properties not found at " + propertyFilePath);
		}
	}
	
	//Global Get Functions
			public String getBrowserId() {
				String browserId = propertiesAllGymnastics.getProperty("browserId");
				if(browserId != null) return browserId;
				else throw new RuntimeException("browserId not specified in the ConfigurationAllGymnastics.properties file.");
			}
			
			public long getImplicitlyWait() { 
				String ImplicitlyWait = propertiesAllGymnastics.getProperty("ImplicitlyWait");
				if(ImplicitlyWait != null) return Long.parseLong(ImplicitlyWait);
				else throw new RuntimeException("implicitlyWait not specified in the ConfigurationAllGymnastics.properties file."); 
			}
		
			public String getApplicationUrl() {
				String applicationUrl = propertiesAllGymnastics.getProperty("applicationUrl");
				if(applicationUrl != null) return applicationUrl;
				else throw new RuntimeException("applicationUrl not specified in the ConfigurationAllGymnastics.properties file.");
			}
			
			public long getSleepTime() { 
				String sleepTime = propertiesAllGymnastics.getProperty("sleepTime");
				if(sleepTime != null) return Long.parseLong(sleepTime);
				else throw new RuntimeException("sleepTime not specified in the ConfigurationAllGymnastics.properties file."); 
			}
			
	//Login local functions
	
			public String getLoginTitleText() {
				String loginTitleText = propertiesAllGymnastics.getProperty("loginTitleText");
				if(loginTitleText != null) return loginTitleText;
				else throw new RuntimeException("loginTitleText not specified in the Configuration.properties file.");
			}
			
			public String getFieldRequiredText() {
				String fieldRequiredText = propertiesAllGymnastics.getProperty("fieldRequiredText");
				if(fieldRequiredText != null) return fieldRequiredText;
				else throw new RuntimeException("fieldRequiredText not specified in the Configuration.properties file.");
			}
			
			public String getWrongUserText() {
				String wrongUserText = propertiesAllGymnastics.getProperty("wrongUserText");
				if(wrongUserText != null) return wrongUserText;
				else throw new RuntimeException("wrongUserText not specified in the Configuration.properties file.");
			}
			
			public String getWrongPassText() {
				String wrongPassText = propertiesAllGymnastics.getProperty("wrongPassText");
				if(wrongPassText != null) return wrongPassText;
				else throw new RuntimeException("wrongPassText not specified in the Configuration.properties file.");
			}
			
			public String getIncorrectUserPassMsgText() {
				String incorrectUserPassMsgText = propertiesAllGymnastics.getProperty("incorrectUserPassMsgText");
				if(incorrectUserPassMsgText != null) return incorrectUserPassMsgText;
				else throw new RuntimeException("incorrectUserPassMsgText not specified in the Configuration.properties file.");
			}
			
			public String getCorrectUserText() {
				String correctUserText = propertiesAllGymnastics.getProperty("correctUserText");
				if(correctUserText != null) return correctUserText;
				else throw new RuntimeException("correctUserText not specified in the Configuration.properties file.");
			}
			
			public String getCorrectPassText() {
				String correctPassText = propertiesAllGymnastics.getProperty("correctPassText");
				if(correctPassText != null) return correctPassText;
				else throw new RuntimeException("correctPassText not specified in the Configuration.properties file.");
			}
			
			public String getLogoutText() {
				String logoutText = propertiesAllGymnastics.getProperty("logoutText");
				if(logoutText != null) return logoutText;
				else throw new RuntimeException("logoutText not specified in the Configuration.properties file.");
			}
			
			public String getBadFormatedMailText() {
				String badFormatedMailText = propertiesAllGymnastics.getProperty("badFormatedMailText");
				if(badFormatedMailText != null) return badFormatedMailText;
				else throw new RuntimeException("badFormatedMailText not specified in the Configuration.properties file.");
			}
			
			public String getNotValidMailText() {
				String notValidMailText = propertiesAllGymnastics.getProperty("notValidMailText");
				if(notValidMailText != null) return notValidMailText;
				else throw new RuntimeException("notValidMailText not specified in the Configuration.properties file.");
			}
			
			public String getNotExistedMailText() {
				String notExistedMailText = propertiesAllGymnastics.getProperty("notExistedMailText");
				if(notExistedMailText != null) return notExistedMailText;
				else throw new RuntimeException("notExistedMailText not specified in the Configuration.properties file.");
			}
			
			public String getIncorrectMailText() {
				String incorrectMailText = propertiesAllGymnastics.getProperty("incorrectMailText");
				if(incorrectMailText != null) return incorrectMailText;
				else throw new RuntimeException("incorrectMailText not specified in the Configuration.properties file.");
			}
			
			public String getIncorrectMailMsgText() {
				String incorrectMailMsgText = propertiesAllGymnastics.getProperty("incorrectMailMsgText");
				if(incorrectMailMsgText != null) return incorrectMailMsgText;
				else throw new RuntimeException("incorrectMailMsgText not specified in the Configuration.properties file.");
			}
		
			public String getGoodMail1() {
				String goodMail1 = propertiesAllGymnastics.getProperty("goodMail1");
				if(goodMail1 != null) return goodMail1;
				else throw new RuntimeException("goodMail1 not specified in the Configuration.properties file.");
			}
			
			public String getGoodMail2() {
				String goodMail2 = propertiesAllGymnastics.getProperty("goodMail2");
				if(goodMail2 != null) return goodMail2;
				else throw new RuntimeException("goodMail2 not specified in the Configuration.properties file.");
			}
			
			public String getNotMatchedMailText() {
				String notMatchedMailText = propertiesAllGymnastics.getProperty("notMatchedMailText");
				if(notMatchedMailText != null) return notMatchedMailText;
				else throw new RuntimeException("notMatchedMailText not specified in the Configuration.properties file.");
			}
			
			public String getShortPass() {
				String shortPass = propertiesAllGymnastics.getProperty("shortPass");
				if(shortPass != null) return shortPass;
				else throw new RuntimeException("shortPass not specified in the Configuration.properties file.");
			}
			
			public String getShortPassMsg() {
				String shortPassMsg = propertiesAllGymnastics.getProperty("shortPassMsg");
				if(shortPassMsg != null) return shortPassMsg;
				else throw new RuntimeException("shortPassMsg not specified in the Configuration.properties file.");
			}
			
			public String getPassNotMatchedMsg() {
				String passNotMatchedMsg = propertiesAllGymnastics.getProperty("passNotMatchedMsg");
				if(passNotMatchedMsg != null) return passNotMatchedMsg;
				else throw new RuntimeException("passNotMatchedMsg not specified in the Configuration.properties file.");
			}
			
			public String getExistedUserMsg() {
				String existedUserMsg = propertiesAllGymnastics.getProperty("existedUserMsg");
				if(existedUserMsg != null) return existedUserMsg;
				else throw new RuntimeException("existedUserMsg not specified in the Configuration.properties file.");
			}
			
			public String getAutoMailExtText() {
				String autoMailExtText = propertiesAllGymnastics.getProperty("autoMailExtText");
				if(autoMailExtText != null) return autoMailExtText;
				else throw new RuntimeException("autoMailExtText not specified in the Configuration.properties file.");
			}
			
			public String getUserFB() {
				String userFB = propertiesAllGymnastics.getProperty("userFB");
				if(userFB != null) return userFB;
				else throw new RuntimeException("userFB not specified in the Configuration.properties file.");
			}
			
			public String getPasswordFB() {
				String passwordFB = propertiesAllGymnastics.getProperty("passwordFB");
				if(passwordFB != null) return passwordFB;
				else throw new RuntimeException("passwordFB not specified in the Configuration.properties file.");
			}
			
			////////New properties
			public String getFieldCheckBoxText() {
				String fieldRequiredCheckBox = propertiesAllGymnastics.getProperty("fieldRequiredCheckBox");
				if(fieldRequiredCheckBox != null) return fieldRequiredCheckBox;
				else throw new RuntimeException("fieldRequiredCheckBox not specified in the Configuration.properties file.");
			}
			
			public String getFirstName() {
				String firstName = propertiesAllGymnastics.getProperty("firstName");
				if(firstName != null) return firstName;
				else throw new RuntimeException("firstName not specified in the Configuration.properties file.");
			}
			
			public String getLastName() {
				String lastName = propertiesAllGymnastics.getProperty("lastName");
				if(lastName != null) return lastName;
				else throw new RuntimeException("lastName not specified in the Configuration.properties file.");
			}
			
			public String getCorrectDate() {
				String correctDate = propertiesAllGymnastics.getProperty("correctDate");
				if(correctDate != null) return correctDate;
				else throw new RuntimeException("correctDate not specified in the Configuration.properties file.");
			}
			
			public String getFutureDate() {
				String futureDate = propertiesAllGymnastics.getProperty("futureDate");
				if(futureDate != null) return futureDate;
				else throw new RuntimeException("futureDate not specified in the Configuration.properties file.");
			}
			
			public String getDateNotValid() {
				String dateNotValid = propertiesAllGymnastics.getProperty("dateNotValid");
				if(dateNotValid != null) return dateNotValid;
				else throw new RuntimeException("dateNotValid not specified in the Configuration.properties file.");
			}
			
			public String getFavoriteSPort() {
				String favoriteSport = propertiesAllGymnastics.getProperty("favoriteSport");
				if(favoriteSport != null) return favoriteSport;
				else throw new RuntimeException("favoriteSport not specified in the Configuration.properties file.");
			}
}