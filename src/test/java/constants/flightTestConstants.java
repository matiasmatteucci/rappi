package constants;

/**
 * Created by Matias on 15/07/2015.
 */
public class flightTestConstants {
    //credentials
    public static String URL = "http://newtours.demoaut.com";
    public static String USERNAME = "tutorial";
    public static String PASSWORD = "tutorial";

    //Page Objects
    public static String USERNAME_PROMPT = "input[name=userName][type=text]";
    public static String PASSWORD_PROMPT = "input[name=password][type=password]";
    public static String LOGIN_BUTTON = "input[name=login]";

    public static String DESTINATION_DROPDOWN = "select[name=toPort]";
    public static String DESTINATION_VALUE = "London";
    public static String SERVICE_CLASS_FIRST = "input[name=servClass][value=First";
    public static String FLIGHT_FINDER_CONTINUE_BUTTON = "input[name=findFlights";

    public static String FIRST_LIST_SECOND_FLIGHT = "input[name=outFlight][value='Blue Skies Airlines$361$271$7:10']";
    public static String SECOND_LIST_THIRD_FLIGHT = "input[name=inFlight][value='Pangea Airlines$632$282$16:37'";
    public static String SELECT_FLIGHT_CONTINUE_BUTTON = "input[name=reserveFlights";

    public static String CARD_NUMBER = "input[name=creditnumber][type=text";
    public static String EXPIRATION_MONTH = "select[name=cc_exp_dt_mn]";
    public static String EXPIRATION_YEAR = "select[name=cc_exp_dt_yr]";
    public static String CC_FIRST_NAME = "input[name=cc_frst_name]";
    public static String CC_MIDDLE_NAME = "input[name=cc_mid_name]";
    public static String CC_LAST_NAME = "input[name=cc_last_name]";
    public static String SECURE_PURCHASE_BUTTON = "input[name=buyFlights]";
}
